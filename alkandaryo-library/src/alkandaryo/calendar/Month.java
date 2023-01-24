package alkandaryo.calendar;

import alkandaryo.Alkandaryo;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

public class Month extends Date.Builder<Month> {
    {
        this.year = new Year();
    }

    private Year year;

    public Month() {
        this.number = localDate.getMonthValue();
    }

    public Month(int number) {
        this.number = number;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = new Year(year);
    }

    public String getName() {
        return Date.baseName(LocalDate.of(year.number, number, 1).getMonth().name());
    }

    public int getLength() {
        return LocalDate.of(year.number, number, 1).getMonth().maxLength();
    }

    public int getWeeks() {
        var calendar = Calendar.getInstance(Alkandaryo.locale);

        calendar.set(Calendar.MONTH, number);
        calendar.set(Calendar.YEAR,  year.number);

        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object)
                && Objects.equals(((Month) object).year, year);
    }

    @Override
    public String toString() {
        return String.format("%d, %s", year.number, Date.baseName(getName()));
    }
}
