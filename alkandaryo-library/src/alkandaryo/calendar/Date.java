package alkandaryo.calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Date {
   public static class Builder<B extends Builder<?>> {
      protected LocalDate localDate;
      protected int number;

      public Builder() {
         this.localDate = LocalDate.now();
      }

      public Builder(int number) {
         this.localDate = LocalDate.now();
         this.number    = number;
      }

      public Builder(int number, LocalDate localDate) {
         this.localDate = localDate;
         this.number    = number;
      }

      public int getValue() {
         return number;
      }

      @SuppressWarnings("unchecked")
      public B next() {
         if (this instanceof Day) {
            if (number < ((Day) this).getMonth().getLength()) {
               this.number += 1;
            } else {
               if (((Day) this).getMonth().getValue() < 12)
                   ((Day) this).setMonth(((Day) this).getMonth().getValue() +1);
               else ((Day) this).setMonth(1);
               this.number = 1;
            }
         }
         else if (this instanceof Month) this.number = number < 12 ? number +1 : 1;
         else if (this instanceof Year)  this.number += 1;
         return (B) this;
      }

      @SuppressWarnings("unchecked")
      public B previous() {
         if (this instanceof Day) {
            if (number > 1) {
               this.number -= 1;
            } else {
               ((Day) this).setMonth(((Day) this).getMonth().getValue() -1);
               this.number = ((Day) this).getMonth().getLength();
            }
         }
         if (this instanceof Month) this.number = number > 1 ? number -1 : ((Month) this).getLength();
         if (this instanceof Year)  this.number = number > 1 ? number -1 : this.getValue();
         return (B) this;
      }

      @Override
      public boolean equals(Object object) {
         return localDate.equals(((Builder<?>) object).localDate)
               && Objects.equals(((Builder<?>) object).number, number);
      }
   }

   public static class Range {
      protected List<Day> days;

      public Range(Date from, Date to) {
         this.days = new ArrayList<>();

         while (!from.equals(to)) {
            days.add(from.day);
            from.next();
         }
      }

      public int countOfDays() {
         return days.size();
      }

      public int countOfWeeks() {
         int counts = 0;
         days.forEach((day) -> {

         });
         return counts;
      }
   }

   public static String baseName(String name) {
      return name.toLowerCase().replaceFirst("[a-z]",
                  name.substring(0, 1).toUpperCase());
   }

   private Day   day;
   private Month month;
   private Year  year;

   public Date() {
      this.day   = new Day();
      this.month = new Month();
      this.year  = new Year();
   }

   public Date(int month, int day, int year) {
      // Variable initializations...
      this.day   = new Day(day);
      this.month = new Month(month);
      this.year  = new Year(year);

      // Day's references...
      this.day.setMonth(month);
      this.day.setYear(year);

      // Month's references...
      this.month.setYear(year);
   }

   public Day getDay() {
      return day;
   }

   public Month getMonth() {
      return month;
   }

   public Year getYear() {
      return year;
   }

   public void setDay(Day day) {
      this.day = day;
   }

   public void setMonth(Month month) {
      this.month = month;
   }

   public void setYear(Year year) {
      this.year = year;
   }

   public Date next() {
      if (day.getValue() < month.getLength()) {
         day.next();
      } else if (month.getValue() < 12) {
         month.next();
         day.next();
      } else {
         year.next();
         month.next();
         day.next();
      }
      return this;
   }

   public Date previous() {
      day.previous();
      return this;
   }
   @Override
   public boolean equals(Object object) {
      return   day  .equals(((Date) object).day)
            && month.equals(((Date) object).month)
            && year .equals(((Date) object).year);
   }

   @Override
   public String toString() {
      return day.toString();
   }
}