public class ToDo extends Task {
    /**
     * Public constructor for the ToDo object.
     * @param description the task name
     */
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }

    @Override
    public String toOutputFormat() {
        return String.format("T / %s", super.toOutputFormat());
    }
}
