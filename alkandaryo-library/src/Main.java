import alkandaryo.calendar.Date;
import alkandaryo.calendar.Day;
import alkandaryo.calendar.Month;
import alkandaryo.calendar.Year;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var range = new Date.Range(new Date(), new Date(2, 26, 2023));

        System.out.println(range.countOfWeeks());
    }
}