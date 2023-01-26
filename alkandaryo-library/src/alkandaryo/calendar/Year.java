package alkandaryo.calendar;

import alkandaryo.Alkandaryo;

import java.util.Calendar;
import java.util.Objects;

public class Year extends Date.Builder<Year> {
    protected Day   day;    // Optional...
    protected Month month;  // Optional...

    public Year() {
        this.number = localDate.getYear();
    }

    public Year(int number) {
        super(number);
    }

    public final boolean isLeapYear() {
        return localDate.isLeapYear();
    }

    @SuppressWarnings("MagicConstant")
    public final int getTotalOfDays() {
        var calendar = Calendar.getInstance(Alkandaryo.locale);
        calendar.set(number,
              Objects.isNull(month) ? 1 : month.number -1,
              Objects.isNull(day)   ? 1 : day.number);
        return  calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
