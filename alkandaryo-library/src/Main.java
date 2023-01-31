import alkandaryo.Sort;
import alkandaryo.calendar.Day;
import alkandaryo.calendar.Month;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        var range = new Date.Range(new Date(2, 26, 2023),
//              new Date(2, 26, 2030));
//
//        System.out.println(range.countOfYears());
        var weeks = new Month(1).getWeeks();

//        weeks.sort(Sort.DESCENDING);
//        weeks.forEach(week -> {
//
//        });

        System.out.println(weeks.isParticularly());
    }
}