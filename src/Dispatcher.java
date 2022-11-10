import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Dispatcher {
    private final TaskService service = new TaskService();

    public void inputTask(Scanner scanner) throws IncorrectArgumentException, TaskNotFoundException {
        System.out.print("Укажите повторяемость:\n1 - однократная\n2 - ежедневная\n3 - еженедельная\n" +
                "4 - ежемесячная\n5 - ежегодная\n");
        int repeatability = Integer.parseInt(scanner.nextLine());
        Task task;
        String name = createName(scanner);
        String descr = createDescription(scanner);
        LocalDateTime deadline = createDateTime(scanner);
        boolean type = createType(scanner);
        switch (repeatability) {
            case 1:
                task = new SingleTask(name, descr, deadline, type);
                break;
            case 2:
                task = new DailyTask(name, descr, deadline, type);
                break;
            case 3:
                task = new WeeklyTask(name, descr, deadline, type);
                break;
            case 4:
                task = new MonthlyTask(name, descr, deadline, type);
                break;
            case 5:
                task = new AnnualTask(name, descr, deadline, type);
                break;
            default:
                throw new IncorrectArgumentException("Неверная повторяемость");
        }
        service.addTask(task);
    }

    public String createName(Scanner scanner) throws IncorrectArgumentException {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.nextLine();
        if (taskName == null || taskName.isBlank()) {
            throw new IncorrectArgumentException("Пустое название задачи");
        }
        return taskName;
    }

    public String createDescription(Scanner scanner) throws IncorrectArgumentException {
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.nextLine();
        if (taskDescription == null || taskDescription.isBlank()) {
            throw new IncorrectArgumentException("Пустое описание задачи");
        }
        return taskDescription;
    }

    public LocalDateTime createDateTime(Scanner scanner) {
        System.out.print("Введите время и дату выполнения:\nвремя в формате чч:мм:");
        LocalTime localTime = LocalTime.parse(scanner.nextLine());
        return createDate(scanner).atTime(localTime);
    }

    public LocalDate createDate(Scanner scanner) {
        System.out.print("Введите дату выполнения в формате гггг-мм-дд:");
        return LocalDate.parse(scanner.nextLine());
    }

    public boolean createType(Scanner scanner) throws TaskNotFoundException {
        System.out.print("Выберите тип задачи:\n1 - личная\n2 - рабочая\n");
        int type = Integer.parseInt(scanner.nextLine());
        if (type == 1) {
            return true;
        } else if (type == 2) {
            return false;
        } else throw new TaskNotFoundException("Неверно введен тип задачи");
    }

    public void deleteTask(Scanner scanner) throws TaskNotFoundException {
        service.deleteTask(requestId(scanner));
    }

    public int requestId(Scanner scanner) throws TaskNotFoundException {
        System.out.println("Введите ID задачи, которую хотите удалить");
        int id;
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
        } else {
            throw new TaskNotFoundException("Некорректный ID");
        }
        return id;
    }

    public void getTasksForDay(Scanner scanner) throws TaskNotFoundException {
        System.out.println("Введите дату:");
        service.getAllByDate(createDate(scanner));
    }
}