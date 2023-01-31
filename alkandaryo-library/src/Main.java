import alkandaryo.Sort;
import alkandaryo.calendar.Day;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        var range = new Date.Range(new Date(2, 26, 2023),
//              new Date(2, 26, 2030));
//
//        System.out.println(range.countOfYears());
//        var weeks = new Month(2).getWeeks();
//
//        for (Day.Week week : weeks) {
//            System.out.println(week.getDay().hashCode());
//        }
        Sort<Day.Week> days = new Sort<>();

        days.add(new Day(1).getWeek());
        days.add(new Day(3).getWeek());
        days.add(new Day(2).getWeek());

//        days.setOrder(Sort.DESCENDING);

        days.forEach(week -> System.out.println(week.getDay()));
    }
}