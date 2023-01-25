package alkandaryo.calendar;

import java.time.LocalDate;
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
         this.number += 1;
         return (B) this;
      }

      @SuppressWarnings("unchecked")
      public B previous() {
         this.number -= 1;
         return (B) this;
      }

      @Override
      public boolean equals(Object object) {
         return super.equals(object)
               && Objects.equals(((Builder<?>) object).localDate, localDate)
               && Objects.equals(((Builder<?>) object).number,    number);
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
      this.day   = new Day(day);
      this.month = new Month(month);
      this.year  = new Year(year);
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
      day.next();
      return this;
   }

   public Date previous() {
      day.previous();
      return this;
   }

   @Override
   public boolean equals(Object object) {
      return super.equals(object)
              && Objects.equals(((Date) object).day,   day)
              && Objects.equals(((Date) object).month, month)
              && Objects.equals(((Date) object).year,  year);
   }

   @Override
   public String toString() {
      return day.toString();
   }
}