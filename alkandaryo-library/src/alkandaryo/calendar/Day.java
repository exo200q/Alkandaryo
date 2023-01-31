package alkandaryo.calendar;

import alkandaryo.Sorting;

import java.time.LocalDate;
import java.util.Objects;

public class Day extends Date.Builder<Day> {
   public static class Week implements Sorting.Sortable {
      protected Day day;
      protected int number;

      public static final int MONDAY    = 1;
      public static final int TUESDAY   = 2;
      public static final int WEDNESDAY = 3;
      public static final int THURSDAY  = 4;
      public static final int FRIDAY    = 5;
      public static final int SATURDAY  = 6;
      public static final int SUNDAY    = 7;

      public Week(int number) {
         this.number = number;
      }

      public String getName() {
         switch (number) {
            case Week.MONDAY    -> { return "Monday"; }
            case Week.TUESDAY   -> { return "Tuesday"; }
            case Week.WEDNESDAY -> { return "Wednesday"; }
            case Week.THURSDAY  -> { return "Thursday"; }
            case Week.FRIDAY    -> { return "Friday"; }
            case Week.SATURDAY  -> { return "Saturday"; }
            case Week.SUNDAY    -> { return "Sunday"; }
         }
         return null;
      }

      public Day getDay() {
         return day;
      }

      public int getValue() {
         return number;
      }

      @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
      @Override
      public boolean equals(Object object) {
         return Objects.equals(((Day) object).number, number);
      }

      @Override
      public int hashCode() {
         return !Objects.isNull(day) ? day.hashCode()
               : super.hashCode();
      }

      @Override
      public String toString() {
         return getName();
      }
   }

   {
      this.month = new Month();
      this.year  = new Year();

      this.year.day   = this;
      this.year.month = this.month;
   }

   private final Month month;
   private final Year year;

   public Day() {
      this.number = localDate.getDayOfMonth();
   }

   public Day(int number) {
      this.number = number;
   }

   public void setMonth(int month) {
      this.month.number = month;
   }

   public Month getMonth() {
      return month;
   }

   public void setYear(int year) {
      this.year.number = year;
   }

   public Year getYear() {
      return year;
   }

   public Week getWeek() {
      var week = new Day.Week(LocalDate
            .of(year.number, month.number, number)
            .getDayOfWeek()
            .getValue());
      week.day = new Day(number);
      week.day
            .month
            .number = month.number;
      week.day
            .year
            .number = year.number;
      return week;
   }

   @Override
   public boolean equals(Object object) {
      return super.equals(object)
            && month.equals(((Day) object).month)
            && year .equals(((Day) object).year);
   }

   @Override
   public final int hashCode() {
      return Integer.parseInt(String
            .format("%d%02d%02d", year.number, month.number, number));
   }

   @Override
   public String toString() {
      return String.format("%.3s, %s %d, %d", getWeek().getName(),
              month.getName(), number, year.number);
   }
}
