import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private static int idCounter = 0;
    private final Integer id = idCounter++;
    private String title;
    private String category;
    private final LocalDateTime deadline;
    private final Boolean isPersonalTask;

    public Task(String title, String category, LocalDateTime deadline,
                Boolean isPersonalTask) {
        setTitle(title);
        setCategory(category);
        this.deadline = deadline;
        this.isPersonalTask = isPersonalTask;
    }

    public Integer getId() {
        return id;
    }

    protected LocalDateTime getDeadline() {
        return deadline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(task.id,id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String s = "личная";
        if (!isPersonalTask) s = "рабочая";
        return id + "   " + title + ": " + category + "\n Тип задачи: " + s;
    }
}
