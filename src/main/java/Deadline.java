import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
    private final LocalDate by;

    /**
     * Public constructor for the Deadline object.
     * @param description the task name
     * @param by the deadline which the task needs to be completed by
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return String.format("[D]%1$s (by: %2$s)", super.toString(), by.format(dateTimeFormatter));
    }

    @Override
    public String toOutputFormat() {
        return String.format("D / %1$s / %2$s", super.toOutputFormat(), by.format(dateTimeFormatter));
    }
}
