import java.time.DateTimeException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var planner = new Dispatcher();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                label:
                while (true) {
                    printMenu();
                    System.out.print("Выберите пункт меню: ");
                    int menu = Integer.parseInt(scanner.nextLine());
                    switch (menu) {
                        case 1:
                            planner.inputTask(scanner);
                            break;
                        case 2:
                            planner.deleteTask(scanner);
                            break;
                        case 3:
                            planner.getTasksForDay(scanner);
                            break;
                        case 0:
                            break label;
                    }
                }
            } catch (IncorrectArgumentException incorrectArgumentException) {
                System.out.println("Введите дату и время в правильном формате чч:мм гггг-мм-дд");
            } catch (TaskNotFoundException taskNotFoundException) {
                scanner.nextLine();
                System.out.println(taskNotFoundException.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу\n2.  Удалить задач\n3. Получить задачи на день\n"+
                        " \n0. Выход ");
    }
}