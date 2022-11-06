import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualTask extends Task implements Repetable{
    public AnnualTask(String title, String category, LocalDateTime dateTime, Boolean isPersonalTask) throws IllegalArgumentException  {
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
        LocalDateTime  dateTime = getDateTime();
        while (LocalDateTime.now().isAfter(dateTime)) {
            dateTime = dateTime.plusYears(1);
        }
        return dateTime;
    }

    @Override
    public String toString() {
        return super.toString() + "\nБлижайшее время выполнения: " + getNextTask() + '\n';
    }
}