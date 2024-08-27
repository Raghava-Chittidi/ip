package tasks;

public class Event extends Task {
    private final String startTime;
    private final String endTime;

    public Event(String name, String startTime, String endTime) {
        super(name);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toFileString() {
        return String.format("E %s | %s-%s", super.toFileString(), this.startTime, this.endTime);
    }

    @Override
    public String toString() {
        return String.format("[E] %s (from: %s to: %s)", super.toString(), this.startTime, this.endTime);
    }
}
