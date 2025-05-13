package code;

import java.util.ArrayList;

public class Group {
    public ArrayList<Person> personList = new ArrayList<>();
    public ArrayList<Item> itemList = new ArrayList<>();
    public String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public boolean isEmptyGroup() {
        return personList.isEmpty();
    }

    public boolean isEmptyItem() {
        return itemList.isEmpty();
    }

    public void removeMember(Person personToRemove) {
        if (isEmptyGroup()) {
            System.out.println("java.Group is already empty, cannot remove: " + personToRemove.getName());
        }
        personList.remove(personToRemove);
    }

    public void addMember(Person personToAdd) {
        if (personList.contains(personToAdd)) {
            System.out.println("java.Person already in group");
        }
        personList.add(personToAdd);
    }

    public void removeItem(Item itemToRemove) {
        if (isEmptyItem()) {
            System.out.println("No items exist in group");
        }
        itemList.remove(itemToRemove);
    }

    public void addItem(Item itemToAdd) {
        itemList.add(itemToAdd);
    }

    public String getGroupName() {
        return groupName;
    }

    public void changeGroupName(String newName) {
        this.groupName = newName;
    }

    public void deleteGroup() {
        personList.clear();
        itemList.clear();
    }

    public void listGroup() {
        if (personList.isEmpty()) {
            System.out.println("Group is empty");
        }
        for (Person person : personList) {
            System.out.print(person + ", ");
        }
    }

    public void listItems() {
        for (Item items : itemList) {
            System.out.print(items + ", ");
        }
    }

    public Money getTotalDebt() {
        double total = 0;

        for (int i = 0 ; i < personList.size() ; i++) {
            total += personList.get(i).getTotalDebt();
        }

        return new Money(total);
    }

}