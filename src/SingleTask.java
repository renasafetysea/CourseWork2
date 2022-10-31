import java.time.LocalDateTime;

public class SingleTask extends Task implements Repetable{
    public SingleTask(String title, String category, LocalDateTime deadline, Boolean isPersonalTask) {
        super(title, category, deadline, isPersonalTask);
    }

    @Override
    public LocalDateTime getNextTask() {
        if (LocalDateTime.now().isBefore(getDeadline())) {
            return getDeadline();
        } else return null;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Время выполнения: " + getNextTask() + '\n';
    }
}