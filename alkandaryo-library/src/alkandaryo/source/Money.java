package alkandaryo.source;

import alkandaryo.Alkandaryo;

import java.text.NumberFormat;
import java.util.Objects;

public final class Money extends Source<Money> {
    private final double amount;

    public Money() {
        this.amount = 0.0;
    }

    public Money(double amount) {
        this.amount = amount;
    }

    public Money(String name) {
        super(name);
        this.amount = 0.0;
    }

    public Money(String name, double amount) {
        super(name);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return NumberFormat.getCurrencyInstance(Alkandaryo.locale)
                .format(amount);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object)
                && Objects.equals(((Money) object).amount, amount);
    }

    @Override
    public String toString() {
        return     !Objects.isNull(getDescription())
                && !Objects.isNull(getName())
                    ? String.format("%s: %s\n%s",
                        getName(),
                        getCurrency(),
                        getDescription())
                : !Objects.isNull(getName())
                    ? String.format("%s: %s",
                        getName(),
                        getCurrency())
                : getCurrency();
    }
}
