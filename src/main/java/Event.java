import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
    private final LocalDate at;

    /**
     * Public constructor for the Event object.
     * @param description the task name
     * @param at the duration in which the event takes place
     */
    public Event(String description, LocalDate at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return String.format("[E]%1$s (at: %2$s)", super.toString(), at.format(dateTimeFormatter));
    }

    @Override
    public String toOutputFormat() {
        return String.format("E / %1$s / %2$s", super.toOutputFormat(), at.format(dateTimeFormatter));
    }
}
