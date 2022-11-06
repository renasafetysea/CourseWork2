import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Dispatcher {
    TaskService service = new TaskService();

    public void inputTask(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Укажите повторяемость:\n1 - однократная\n2 - ежедневная\n3 - еженедельная\n" +
                "4 - ежемесячная\n5 - ежегодная\n");
        int repeatability = Integer.parseInt(scanner.nextLine());
        Task task;
        String name = createName(scanner);
        String descr = createDescription(scanner);
        LocalDateTime dateTime = createDateTime(scanner);
        boolean type = createType(scanner);
        switch (repeatability) {
            case 1:
                task = new SingleTask(name, descr, dateTime, type);
                break;
            case 2:
                task = new DailyTask(name, descr, dateTime, type);
                break;
            case 3:
                task = new WeeklyTask(name, descr, dateTime, type);
                break;
            case 4:
                task = new MonthlyTask(name, descr, dateTime, type);
                break;
            case 5:
                task = new AnnualTask(name, descr, dateTime, type);
                break;
            default:
                throw new IllegalArgumentException("Неверная повторяемость");
        }
        service.addTask(task);
    }

    private String createName(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.nextLine();
        if (taskName == null || taskName.isBlank()) {
            throw new IllegalArgumentException("Пустое название задачи");
        }
        return taskName;
    }

    private String createDescription(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.nextLine();
        if (taskDescription == null || taskDescription.isBlank()) {
            throw new IllegalArgumentException("Пустое описание задачи");
        }
        return taskDescription;
    }

    public LocalDateTime createDateTime(Scanner scanner) {
        System.out.print("Введите время и дату :\nвремя в формате чч:мм:");
        LocalTime localTime = LocalTime.parse(scanner.nextLine());
        return createDate(scanner).atTime(localTime);
    }

    public LocalDate createDate(Scanner scanner) {
        System.out.print("Введите дату в формате гггг-мм-дд:");
        return LocalDate.parse(scanner.nextLine());
    }

    public boolean createType(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Выберите тип задачи:\n1 - личная\n2 - рабочая\n");
        int type = Integer.parseInt(scanner.nextLine());
        if (type == 1) {
            return true;
        } else if (type == 2) {
            return false;
        } else throw new IllegalArgumentException("Неверно введен тип задачи");
    }

    public void deleteTask(Scanner scanner) throws Exception {
        service.deleteTask(requestId(scanner));
    }

    public int requestId(Scanner scanner) throws IllegalArgumentException {
        System.out.println("Введите ID задачи, которую нужно удалить");
        int id;
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
        } else {
            throw new IllegalArgumentException("Некорректный ID");
        }
        return id;
    }

    public void getTasksForDay(Scanner scanner) throws IllegalArgumentException {
        System.out.println("Введите дату:");
        service.printTodoListForDay(createDate(scanner));
    }
}