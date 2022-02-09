package task;

/**
 * Represents a Task, containing its relevant fields
 * and methods.
 */
public class Task {

    /**
     * Name of Task.
     */
    protected String description;

    /**
     * Status to indicate if the Task is done or not.
     */
    protected boolean isDone;

    /**
     * Creates Task as per description entered, initializing the
     * task as undone.
     *
     * @param description Name of Task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns String representation of the Task status.
     * X if done and an empty space otherwise.
     *
     * @return Task status
     */
    public String getStatusIcon() {
        return this.isDone ? "X" : " ";
    }

    /**
     * Returns String representation of Task description.
     *
     * @return String representation of Task description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Mark the Task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Mark the Task as undone.
     */
    public void markAsUnDone() {
        this.isDone = false;
    }

    /**
     * Returns the string representation with details
     * on the mark status and description.
     *
     * @return String representation of Task to save.
     */
    public String toSave() {
        String status = this.isDone ? " : 1 : " : " : 0 : ";
        return status + this.description;
    }

    /**
     * Returns the string representation with details
     * on the mark status and description.
     *
     * @return String representation of Task to display.
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "]" + " " + this.description;
    }

}
