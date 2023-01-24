package alkandaryo.calendar;

import java.time.LocalDate;
import java.util.Objects;

public class Day extends Date.Builder<Day> {
   {
      this.month = localDate.getMonthValue();
      this.year  = localDate.getYear();
   }

   private int month;
   private int year;

   public Day() {
      this.number = localDate.getDayOfMonth();
   }

   public Day(int number) {
      this.number = number;
   }

   public void setMonth(int month) {
      this.month = month;
   }

   public int getMonth() {
      return month;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public int getYear() {
      return year;
   }

   public String getWeek() {
      return Date.baseName(LocalDate
            .of(year, month, number)
            .getDayOfWeek()
            .name());
   }

   @Override
   public boolean equals(Object object) {
      return super.equals(object)
            && Objects.equals(((Day) object).month, month)
            && Objects.equals(((Day) object).year,  year);
   }

   @Override
   public String toString() {
      return String.format("%.3s, %s %d, %d", getWeek(),
              new Month(month).getName(), number, year);
   }
}
