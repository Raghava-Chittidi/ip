package tasks;

public class ToDo extends Task {
    public ToDo(String name) {
        super(name);
    }

    @Override
    public String toFileString() {
        return "T " + super.toFileString();
    }

    @Override
    public String toString() {
        return String.format("[T] %s", super.toString());
    }
}
