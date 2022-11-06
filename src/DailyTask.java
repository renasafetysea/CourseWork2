import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task implements Repetable {
    public DailyTask(String title, String category, LocalDateTime dateTime, Boolean isPersonalTask) {
        super(title, category, dateTime, isPersonalTask);
    }

    @Override
    public boolean appearsIn(LocalDate dateForChecking) {
        return (dateForChecking.isAfter
                (getDateTime().toLocalDate()) || dateForChecking.isEqual(getDateTime().toLocalDate()))
                && dateForChecking.getDayOfWeek() == getDateTime().getDayOfWeek();
    }

    @Override
    public LocalDateTime getNextTask() {
        LocalDateTime dateTime = getDateTime();
        while (LocalDateTime.now().isAfter(dateTime)) {
            dateTime = dateTime.plusDays(1);
        }
        return dateTime;
    }

    @Override
    public String toString() {
        return super.toString() + "\nБлижайшее время выполнения: " + getNextTask() + '\n';
    }
}