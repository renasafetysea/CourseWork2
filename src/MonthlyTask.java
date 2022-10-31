import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repetable{
    public MonthlyTask(String title, String category, LocalDateTime deadline, Boolean isPersonalTask) {
        super(title, category, deadline, isPersonalTask);
    }

    @Override
    public LocalDateTime getNextTask() {
        LocalDateTime  deadline = getDeadline();
        while (LocalDateTime.now().isAfter(deadline)) {
            deadline = deadline.plusMonths(1);
        }
        return deadline;
    }
    @Override
    public String toString() {
        return super.toString() + "\nБлижайшее время выполнения: " + getNextTask() + '\n';
    }
}