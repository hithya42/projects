import java.util.*;

public class ToDoListApp {
    static class Task {
        int id;
        String description;
        boolean isDone;

        Task(int id, String description) {
            this.id = id;
            this.description = description;
            this.isDone = false;
        }

        @Override
        public String toString() {
            String status = isDone ? "[✔]" : "[ ]";
            return status + " (ID: " + id + ") " + description;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> toDoList = new ArrayList<>();
        int choice = 0;
        int taskIdCounter = 1;

        while (choice != 5) {
            System.out.println("\n📝 === Simple To-Do List ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task Complete/Incomplete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    String taskDesc = scanner.nextLine();
                    toDoList.add(new Task(taskIdCounter++, taskDesc));
                    System.out.println("✅ Task added!");
                    break;
                case 2:
                    if (toDoList.isEmpty()) {
                        System.out.println("📭 No tasks found.");
                    } else {
                        System.out.println("📋 Your Tasks:");
                        for (Task t : toDoList) {
                            System.out.println(t);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    boolean removed = toDoList.removeIf(t -> t.id == deleteId);
                    if (removed) {
                        System.out.println("🗑️ Task deleted.");
                    } else {
                        System.out.println("❌ Task ID not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter task ID to toggle complete: ");
                    int toggleId = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (Task t : toDoList) {
                        if (t.id == toggleId) {
                            t.isDone = !t.isDone;
                            System.out.println("🔁 Task status updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ Task ID not found.");
                    }
                    break;
                case 5:
                    System.out.println("👋 Exiting... Have a productive day!");
                    break;
                default:
                    System.out.println("❗ Invalid choice.");
            }
        }

        scanner.close();
    }
}
