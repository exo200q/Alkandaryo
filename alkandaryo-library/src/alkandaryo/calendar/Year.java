package alkandaryo.calendar;

public class Year extends Date.Builder<Year> {
    public Year() {
        this.number = localDate.getYear();
    }

    public Year(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
