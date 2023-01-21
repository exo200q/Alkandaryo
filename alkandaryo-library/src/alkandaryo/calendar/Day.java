package alkandaryo.calendar;

import java.time.LocalDate;
import java.util.Objects;

public class Day extends Date.Builder<Day> {
    private int month;

    public static Day ofMonth(int day, int month) {
        return new Day(day).setMonth(month);
    }

    public static String getWeek(int day, int month, int year) {
        return Date.textFormat(LocalDate.of(year, month, day)
                .getDayOfWeek()
                .name());
    }

    public Day() {
        this.number = localDate.getDayOfMonth();
        this.month  = localDate.getMonthValue();
    }

    public Day(int day) {
        this.number = day;
        this.month  = localDate.getMonthValue();
    }

    public String getWeek() {
        return Day.getWeek(number, month, localDate.getYear());
    }

    public Day setMonth(int month) {
        this.month = month;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object)
                && Objects.equals(((Day) object).month, month);
    }

    @Override
    public String toString() {
        return String.format("%s, %d", getWeek(), number);
    }
}
