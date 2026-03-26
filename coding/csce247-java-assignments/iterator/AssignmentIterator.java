package iterator;
import java.util.Iterator;
/**
 * @author Sean Graysmith
 * @version 2/22/2026
 * 
 * An AssignmentIterator. 
 * Allows for iteration through arrays of assignments.
 * hasNext and next can be used to loop through values.
 * 
 * Implements java.util.Iterator.
 */
public class AssignmentIterator implements Iterator{
    /* fields */
    private Assignment[] assignments;
    private int position;
    private Topic topic;

    /**
     * Create a new AssignmentIterator.
     * @param assignments   The list of assignments to iterate through.
     * @param topic The topic to filter by.
     */
    public AssignmentIterator(Assignment[] assignments, Topic topic) {
        this.assignments = assignments;
        this.position = 0;
        this.topic = topic;
    }

    /* methods */

    /**
     * Determines whether there is a next index in the array.
     * Uses position compared to the length of the array.
     * 
     * Skips over assignments that do not match the specified topic. 
     * Depends on Assignment.hasTopic
     * 
     * @return Returns whether there is a valid next index as boolean.
     */
    public boolean hasNext() {
        // since we have a specific topic, we need to skip by assignments that have it
        while (position < assignments.length && assignments[position] != null && !assignments[position].hasTopic(topic)){
            position++;
        }
        return position < assignments.length && assignments[position] != null;
    }

    /**
     * Returns the next valid Assignment in the array.
     * 
     * @return an Assignment that matches the specified topic.
     */
    public Assignment next() {
        return assignments[position++]; // post increment
    }
}