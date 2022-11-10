import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task{
    public SingleTask(String title, String category, LocalDateTime dateTime, Boolean isPersonalTask) {
        super(title, category, dateTime, isPersonalTask);
    }

    @Override
    public boolean appearsIn(LocalDate dateForChecking) {
        return (dateForChecking.isAfter
                (getDateTime().toLocalDate()) || dateForChecking.isEqual(getDateTime().toLocalDate()))
                && dateForChecking.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
       @Override
    public String toString() {
        return super.toString() + "\n Время выполнения: " + getDateTime() + '\n';
    }
}