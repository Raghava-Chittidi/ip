package atlas.tasks;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * @param tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     *
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * @return
     */
    public String listAllTasks() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.tasks.size(); i++) {
            output.append(String.format("%d: ", i + 1)).append(this.tasks.get(i));
            if (i < this.tasks.size() - 1) {
                output.append('\n');
            }
        }

        return output.toString();
    }

    /**
     * @param index
     * @return
     */
    public Task mark(int index) {
        Task task = this.tasks.get(index);
        task.setIsDone();
        return task;
    }

    /**
     * @param index
     * @return
     */
    public Task unmark(int index) {
        Task task = this.tasks.get(index);
        task.setIsNotDone();
        return task;
    }

    /**
     * @param task
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * @param index
     * @return
     */
    public Task delete(int index) {
        Task task = this.tasks.get(index);
        tasks.remove(index);
        return task;
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return this.tasks.isEmpty();
    }

    /**
     * @return
     */
    public int size() {
        return this.tasks.size();
    }
}
