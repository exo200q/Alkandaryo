package alkandaryo.source;

import java.util.Objects;

public final class Balance extends Source<Balance> {
    private Money amount;

    public Balance() {
        this.amount = new Money();
    }

    public Balance(double amount) {
        this.amount = new Money(amount);
    }

    public Balance(String name) {
        super(name);
        this.amount = new Money();
    }

    public Balance(String name, double amount) {
        super(name);
        this.amount = new Money(amount);
    }

    public Money getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object)
              && amount.equals(((Balance) object).amount);
    }

    @Override
    public String toString() {
        return amount.setDescription(getDescription())
                .setName(getName())
                .toString();
    }
}
