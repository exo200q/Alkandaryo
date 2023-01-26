import alkandaryo.calendar.Date;
import alkandaryo.calendar.Day;
import alkandaryo.calendar.Month;
import alkandaryo.calendar.Year;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var range = new Date.Range(new Date(2, 26, 2023),
              new Date(2, 26, 2030));

        System.out.println(range.countOfYears());
//        System.out.println((double) 365 / 366);
    }
}