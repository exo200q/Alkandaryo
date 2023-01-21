package alkandaryo.date;

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
}
