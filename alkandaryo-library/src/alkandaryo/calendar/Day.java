package alkandaryo.calendar;

import java.time.LocalDate;
import java.util.Objects;

public class Day extends Date.Builder<Day> {
   {
      this.month = new Month();
      this.year  = new Year();
   }

   private Month month;
   private Year year;

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

   public String getWeek() {
      return Date.baseName(LocalDate
            .of(year.number, month.number, number)
            .getDayOfWeek()
            .name());
   }

   @Override
   public boolean equals(Object object) {
      return super.equals(object)
            && month.equals(((Day) object).month)
            && year .equals(((Day) object).year);
   }

   @Override
   public String toString() {
      return String.format("%.3s, %s %d, %d", getWeek(),
              month.getName(), number, year.number);
   }
}
