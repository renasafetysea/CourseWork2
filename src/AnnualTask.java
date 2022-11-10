import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualTask extends Task {
    public AnnualTask(String title, String category, LocalDateTime dateTime, Boolean isPersonalTask) throws IllegalArgumentException  {
        super(title, category, dateTime, isPersonalTask);
    }

    @Override
    public boolean appearsIn(LocalDate dateForChecking) {
        return (dateForChecking.isAfter
                (getDateTime().toLocalDate()) || dateForChecking.isEqual(getDateTime().toLocalDate()))
                && dateForChecking.getYear() == getDateTime().getYear();
    }

    @Override
    public String toString() {
        return super.toString() + "\nБлижайшее время выполнения: " +getDateTime() + '\n';
    }
}