import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskService <S extends Task > {
    private final Map<Integer, S> service = new HashMap<>();
    private final Map<Integer, S> removedTasks = new HashMap<>();


    public void addTask(S task) {
        service.put(task.getId(), task);
    }
    public void deleteTask(int id) throws TaskNotFoundException {
        if (removedTasks.containsKey(id)){
            throw new TaskNotFoundException("Задача с id " +
                    id + " не найдена.");
        } else {service.remove(id);
            System.out.println("Задача с id " + id + " удалена.");
        }
    }
    public void getAllByDate (LocalDate dateForChecking) {
        LocalDate localDate = LocalDate.from(dateForChecking);
        System.out.println("Задачи на " + localDate + ":");
        for (Map.Entry<Integer, S> taskEntry : service.entrySet()) {
            if (taskEntry.getValue().appearsIn(localDate)) {
                System.out.println("id=" + taskEntry.getKey() + " \"" + taskEntry.getValue().getTitle()
                        + taskEntry.getValue().getCategory() + "\"");
        }
    }
}
}

