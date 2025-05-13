package code;

import java.util.Objects;

public class Money {
    private final long amount;

    public Money(double amount) {
        this.amount =Math.round(amount * 100);
    }

    public String getAmountString() {
        return String.format("%.2f", getAmount());
    }

    public double getAmount() {
        return this.amount / 100.0;
    }

    public Money add(Money add) {
        return new Money(this.getAmount() + add.getAmount());
    }

    public Money subtract(Money subtract) {
        return new Money(this.getAmount() - subtract.getAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public String toString() {
        return "$" + getAmountString();
    }
}