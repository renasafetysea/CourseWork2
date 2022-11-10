import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idCounter = 0;
    private final Integer id = idCounter++;
    private String title;
    private String category;
    private final LocalDateTime dateTime;
    private final Boolean isPersonalTask;

    public Task(String title, String category, LocalDateTime dateTime,
                Boolean isPersonalTask) {
        setTitle(title);
        setCategory(category);
        this.dateTime = dateTime;
        this.isPersonalTask = isPersonalTask;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public Integer getId() {
        return id;
    }

    protected LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public abstract boolean appearsIn(LocalDate dateForChecking);


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
