package iterator;
/**
 * @author Sean Graysmith
 * @version 2/22/2026
 * 
 * An Assignment for a course. 
 * Has a title, description, and topic.
 */
public class Assignment {
    /* fields */
    private String title;
    private String description;
    private Topic topic;

    /**
     * Create a new Assignment.
     * @param title The title of this assignment.
     * @param description   The description of this assignment
     * @param topic The topic of this assignment (ALL,PROJECT,DESIGN_PATTERN,GIT)
     */
    public Assignment(String title, String description, Topic topic){
        this.title = title;
        this.description = description;
        this.topic = topic;
    }

    /* methods */

    /**
     * Determines whether the assignment has a given topic.
     * If the specified topic is all, any assignment will return true.
     * 
     * @param topic The topic to check for. 
     * @return  Returns whether the assignment has the topic or not. 
     */
    public boolean hasTopic(Topic topic) {
        if (topic == Topic.ALL || topic == this.topic) {
            return true;
        }
        return false;
    }

    /**
     * Converts this assignment to a string in the form:
     * <<title>>: <<description>>
     * @return returns a string.
     */
    @Override
    public String toString() {
        return title + ": " + description;
    }
}
