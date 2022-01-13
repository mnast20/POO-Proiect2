package child;

import common.ChildAge;
import database.SantaDatabase;
import elf.ElfFactory;
import elf.ElfStrategy;
import enums.Cities;
import enums.Elf;

import java.util.ArrayList;
import java.util.Objects;

public final class ChildUtil {
    /**
     * Method applying the yellow elves' strategy to the children (with yellow elves) in
     * a given list
     */
    public void applyYellowElvesChildren(ArrayList<Child> children) {
        for (Child child: children) {
            Elf elf = child.getElf();
            // check if child has a yellow elf
            if (elf.toString().compareTo("yellow") == 0) {
                // apply yellow elf strategy
                ElfStrategy elfStrategy = ElfFactory.createElf(elf);
                elfStrategy.execute(child);
            }
        }
    }

    /**
     * Method finding all children in given city
     */
    public ArrayList<Child> findChildrenInCity(Cities city) {
        ArrayList<Child> childrenInCity = new ArrayList<>();
        for (Child child: SantaDatabase.getSantaDatabase().getChildren()) {
            // check if a child is located in given city
            if (child.getCity() == city) {
                childrenInCity.add(child);
            }
        }
        return childrenInCity;
    }

    /**
     * Method finding a child based on a given id
     */
    public Child findChildBasedOnId(final Integer id) {
        for (Child child: SantaDatabase.getSantaDatabase().getChildren()) {
            // check if a child has the same id as the child update's id
            if (Objects.equals(id, child.getId())) {
                return child;
            }
        }

        return null;
    }

    /**
     * Method aging all children from a given list of children
     */
    public void ageChildren(final ArrayList<Child> children) {
        for (int i = 0; i < children.size(); i++) {
            Child child = children.get(i);

            // increment child's age
            child.age();

            if (child.getAge().equals(ChildAge.KID_YEARS_START)) {
                // Baby turns into a Kid
                children.set(i, new Kid(child));
            } else if (child.getAge().equals(ChildAge.TEEN_YEARS_START)) {
                // Kid turns into a Teen
                children.set(i, new Teen(child));
            }
        }
    }

    /**
     * Method removing all the adults from a list of children
     */
    public void removeAdults(final ArrayList<Child> children) {
        children.removeIf((child -> child.getAge() > ChildAge.TEEN_YEARS_FINAL));
    }

    /**
     * Method calculating assigned budgets for a list of children
     */
    public void calculateAssignedBudgetChildren(final ArrayList<Child> children) {
        for (Child child: children) {
            child.calculateSantaBudget();
        }
    }

    /**
     * Method calculating the average score of a given children list
     */
    public Double calculateAverageScoreChildren(final ArrayList<Child> children) {
        int size = children.size();
        Double averageScore = 0.0;
        for (Child child: children) {
            averageScore += child.getAverageScore();
        }
        return averageScore / size;
    }
}
