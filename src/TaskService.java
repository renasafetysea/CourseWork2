import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskService <S extends Task & Repetable> {
    private final Map<Integer, S> service = new HashMap<>();
    private final Map<Integer, S> removedTasks = new HashMap<>();


    public void addTask(S task) {
        service.put(task.getId(), task);
    }
    public void deleteTask(int id) {
        removedTasks.put(id, service.get(id));
        service.remove(id);
    }
    public void printTodoListForDay(LocalDate date) {
        for (S value : service.values()) {
            if (value.getNextTask() != null && value.getNextTask().toLocalDate().equals(date)) {
                System.out.println(value);
            }
        }
    }

}
