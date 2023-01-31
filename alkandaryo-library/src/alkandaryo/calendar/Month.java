package alkandaryo.calendar;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class Month extends Date.Builder<Month> {
    public static class Weeks extends AbstractList<Day.Week> implements Iterator<Day.Week> {
        private int index = 0;

        protected List<Day.Week> weeks;

        public Weeks() {
            this.weeks = new ArrayList<>();
        }

        public Day.Week getByDay(int number) {
            for (Day.Week week : weeks) {
                if (Objects.equals(week.day.number, number))
                    return week;
            }
            return null;
        }

        @Override
        public Day.Week get(int number) {
            return weeks.get(number);
        }

        @Override
        public int size() {
            return weeks.size();
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public Day.Week next() {
            return weeks.get(index++);
        }
    }

    {
        this.year = new Year();
        this.year.month = this;
    }

    private final Year year;

    public Month() {
        this.number = localDate.getMonthValue();
    }

    public Month(int number) {
        super(number, LocalDate.of(new Year().number, number, 1));
    }

    public Month(int number, int year) {
        super(number, LocalDate.of(year, number, 1));
    }

    public Year getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year.number = year;
    }

    public String getName() {
        return Date.baseName(LocalDate.of(year.number, number, 1).getMonth().name());
    }

    public int getLength() {
        var month = LocalDate.of(year.number, number, 1);
        try {
            return LocalDate.of(year.number, number, month.getMonth().maxLength())
                  .getMonth().maxLength();
        } catch (DateTimeException dateTimeException) {
            return month.getMonth().maxLength() -1;
        }
    }

    @SuppressWarnings("ReassignedVariable")
    public Weeks getWeeks() {
//        var calendar = Calendar.getInstance(Alkandaryo.locale);
//
//        calendar.set(Calendar.MONTH, number);
//        calendar.set(Calendar.YEAR,  year.number);
//
//        return calendar.get(Calendar.WEEK_OF_MONTH);
        var weeks = new Weeks();
        for (var index = 1; index <= getLength(); index++) {
            var day = new Day(index);

            day.setMonth(number);
            day.setYear(year.number);

            weeks.weeks.add(day.getWeek());
        }
        return weeks;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object)
              && year.equals(((Month) object).year);
    }

    @Override
    public String toString() {
        return String.format("%d, %s", year.number, getName());
    }
}
