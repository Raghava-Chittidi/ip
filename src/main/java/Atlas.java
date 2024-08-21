import java.util.ArrayList;
import java.util.Scanner;

public class Atlas {
    public static final String LINE = "____________________________________________________________";
    public static void main(String[] args) {
        // @@author patorjk.com
        // Reused from https://patorjk.com/software/taag/#p=display&f=Isometric1&t=Atlas
        // with minor modifications
        String logo = """
                      ___           ___           ___       ___           ___    \s
                     /\\  \\         /\\  \\         /\\__\\     /\\  \\         /\\  \\   \s
                    /::\\  \\        \\:\\  \\       /:/  /    /::\\  \\       /::\\  \\  \s
                   /:/\\:\\  \\        \\:\\  \\     /:/  /    /:/\\:\\  \\     /:/\\ \\  \\ \s
                  /::\\~\\:\\  \\       /::\\  \\   /:/  /    /::\\~\\:\\  \\   _\\:\\~\\ \\  \\\s
                 /:/\\:\\ \\:\\__\\     /:/\\:\\__\\ /:/__/    /:/\\:\\ \\:\\__\\ /\\ \\:\\ \\ \\__\\
                 \\/__\\:\\/:/  /    /:/  \\/__/ \\:\\  \\    \\/__\\:\\/:/  / \\:\\ \\:\\ \\/__/
                      \\::/  /    /:/  /       \\:\\  \\        \\::/  /   \\:\\ \\:\\__\\ \s
                      /:/  /     \\/__/         \\:\\  \\       /:/  /     \\:\\/:/  / \s
                     /:/  /                     \\:\\__\\     /:/  /       \\::/  /  \s
                     \\/__/                       \\/__/     \\/__/         \\/__/   \s
                """;

        System.out.println("Hello from\n" + logo);
        Atlas.greet();

        ArrayList<Task> taskList = new ArrayList<Task>();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command) {
                case "bye":
                    Atlas.exit();
                    return;
                case "list":
                    StringBuilder listOutput = new StringBuilder();
                    for (int i = 0; i < taskList.size(); i++) {
                        listOutput.append(String.format("%d: ", i + 1)).append(taskList.get(i));
                        if (i < taskList.size() - 1) {
                            listOutput.append('\n');
                        }
                    }
                    Atlas.print(listOutput.toString());
                    break;
                case "mark":
                    int markIndex = Integer.parseInt(scanner.next()) - 1;
                    Task taskToBeMarked = taskList.get(markIndex);
                    taskToBeMarked.setIsDone();
                    Atlas.print(String.format("Nice! I've marked this task as done:\n\t %s", taskToBeMarked));
                    break;
                case "unmark":
                    int unmarkIndex = Integer.parseInt(scanner.next()) - 1;
                    Task taskToBeUnmarked = taskList.get(unmarkIndex);
                    taskToBeUnmarked.setIsDone();
                    taskList.get(unmarkIndex).setIsNotDone();
                    Atlas.print(String.format("OK, I've marked this task as not done yet:\n\t %s", taskToBeUnmarked));
                    break;
                default:
                    taskList.add(new Task(command));
                    Atlas.print(String.format("added: %s", command));
                    break;
            }
        }
    }

    // Prints messages with lines underneath them
    public static void print(String message) {
        System.out.println('\n' + Atlas.LINE);
        System.out.println(message);
        System.out.println(Atlas.LINE + '\n');
    }

    public static void greet() {
        Atlas.print("Hello! I'm Atlas \n" + "What can I do for you?");
    }

    public static void exit() {
        Atlas.print("Bye. Hope to see you again soon!");
    }
}
