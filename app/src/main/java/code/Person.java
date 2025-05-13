package code;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    public double totalDebt;
    public String name;
    public ArrayList<Money> charges = new ArrayList<>();

    public Person(double totalDebt , String name) {
        this.totalDebt = totalDebt;
        this.name = name;
    }

    public void addCharge(Money charge) {
        this.charges.add(charge);
    }

    public void removeCharge(Money charge) {
        if (this.charges.isEmpty()) {
            System.out.println("List of charges is empty");
        }
        this.charges.remove(charge);
    }

    public double getTotalDebt() {
        double total = 0.0;
        if (!charges.isEmpty()) {
            for (int i = 0; i < charges.size() ; i++) {
                total += charges.get(i).getAmount();
            }
        } else {
            return totalDebt;
        }
        this.totalDebt = total;
        return totalDebt;
    }

    public ArrayList<Money> getCharges() {
        return charges;
    }

    public void setCharges(ArrayList<Money> charges) {
        this.charges = charges;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(totalDebt, person.totalDebt) == 0 && Objects.equals(name, person.name) && Objects.equals(charges, person.charges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalDebt, name, charges);
    }

    @Override
    public String toString() {
        return "name: " + name + " total debt: " + getTotalDebt();
    }
}