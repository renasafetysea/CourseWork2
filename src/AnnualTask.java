import java.time.LocalDateTime;

public class AnnualTask extends Task implements Repetable{
    public AnnualTask(String title, String category, LocalDateTime deadline, Boolean isPersonalTask) {
        super(title, category, deadline, isPersonalTask);
    }

    @Override
    public LocalDateTime getNextTask() {
        LocalDateTime  deadline = getDeadline();
        while (LocalDateTime.now().isAfter(deadline)) {
            deadline = deadline.plusYears(1);
        }
        return deadline;
    }

    @Override
    public String toString() {
        return super.toString() + "\nБлижайшее актуальное время выполнения: " + getNextTask() + '\n';
    }
}