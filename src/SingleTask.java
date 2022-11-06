import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task implements Repetable{
    public SingleTask(String title, String category, LocalDateTime dateTime, Boolean isPersonalTask) {
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
        if (LocalDateTime.now().isBefore(getDateTime())) {
            return getDateTime();
        } else return null;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Время выполнения: " + getNextTask() + '\n';
    }
}