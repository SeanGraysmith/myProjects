package iterator;
/**
 * @author Sean Graysmith
 * @version 2/22/2026
 * 
 * A course which has assignments.
 * Depends on iterator AssignmentIterator, Assignment.
 */
public class Course {
    /* fields */
    private Assignment[] assignments;
    private int count;
    private String name;
    private String title;

    /**
     * Create a new Course. 
     * Has a list of assignments. 
     * @param name  The name of this Course
     * @param title The title of this course.
     */
    public Course(String name, String title) {
        this.name = name;
        this.title = title;

        this.count = 0;
        this.assignments = new Assignment[1]; // starting size 0 since we have grow method
    }

    /* methods */

    /**
     * Add an assignment to this course.
     * Added assignments are added to the assignments array.
     * 
     * Depends on growArray to increase the size. 
     * 
     * When count (the number of courses) reaches the size of the array, the array size is grown. 
     */
    public void addAssignment(String title, String description, Topic topic){
        if (count == assignments.length) { assignments = growArray(assignments); } // adding empty spot to end of array

        assignments[assignments.length - 1] = new Assignment(title, description, topic);
        count++;
    }

    /**
     * Create an iterator for a specific topic of this course. 
     * 
     * @param topic The topic (ALL,PROJECT,DESIGN_PATTERN,GIT)
     * @return  Returns the AssignmentIterator.
     */
    public AssignmentIterator createIterator(Topic topic){
        return new AssignmentIterator(assignments, topic);
    }

    /**
     * Converts this course to a string in the form:
     * <<name>>: <<title>>
     * 
     * @return returns the name and title of this course
     */
    @Override
    public String toString() {
        return name + ": " + title;
    }

    /**
     * Grows the given array of Assignments. 
     * Helper method for addAssignment that increases the size of the array by one.
     *  
     * @param first The original array.
     * @return  Returns the new array with the old vaues in the same position.
     */
    private Assignment[] growArray(Assignment[] first) {
        Assignment[] second = new Assignment[first.length + 1];

        // assigning old values to new array
        for(int i = 0; i < first.length; i++){
            second[i] = first[i];
        }
        return second;
    }
}
