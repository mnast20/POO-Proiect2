package child;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import database.SantaDatabase;
import enums.Category;
import enums.Cities;
import enums.Elf;
import gift.Gift;
import input.ChildInput;
import input.ChildUpdate;

import java.util.ArrayList;
import java.util.ListIterator;

@JsonIgnoreProperties(value = {
        "niceScoreBonus",
        "elf",
        "elfBudget"
})

public class Child {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final Cities city;
    private Integer age;
    private final ArrayList<Category> giftsPreferences;
    private Double averageScore;
    private final Double niceScoreBonus;
    private final ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts;
    private Elf elf;

    /**
     * Child copy constructor based on a child's input data
     */
    public Child(final ChildInput child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.age = child.getAge();
        this.giftsPreferences = new ArrayList<>();
        for (Category category: child.getGiftsPreferences()) {
            if (!giftsPreferences.contains(category)) {
                giftsPreferences.add(category);
            }
        }
        this.averageScore = 0.0;
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreBonus = child.getNiceScoreBonus();
        this.niceScoreHistory.add(child.getNiceScore());
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
        this.elf = child.getElf();
    }

    /**
     * Child copy constructor based on another child
     */
    public Child(final Child child) {
        this.id = child.id;
        this.lastName = child.lastName;
        this.firstName = child.firstName;
        this.city = child.city;
        this.age = child.age;
        this.giftsPreferences = new ArrayList<>(child.giftsPreferences);
        this.averageScore = child.averageScore;
        this.niceScoreHistory = new ArrayList<>(child.niceScoreHistory);
        this.niceScoreBonus = child.niceScoreBonus;
        this.assignedBudget = child.assignedBudget;
        this.receivedGifts = new ArrayList<>(child.receivedGifts);
        this.elf = child.elf;
    }

    public final Integer getId() {
        return id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final Cities getCity() {
        return city;
    }

    public final Integer getAge() {
        return age;
    }

    public final ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public final ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    public final ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public final Elf getElf() {
        return elf;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public final void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public final void setElf(final Elf elf) {
        this.elf = elf;
    }

    /**
     * Method calculating a child's average score
     */
    public void calculateAverageScore() {
        averageScore = 0.0;
    }

    /**
     * Method calculating a child's assigned Santa budget
     */
    public void calculateSantaBudget() {
        assignedBudget = SantaDatabase.getSantaDatabase().getBudgetUnit() * averageScore;
    }

    /**
     * Method incrementing a child's age
     */
    public void age() {
        age++;
    }

    /**
     * Method searching for a Category inside a child's Gifts Preferences list
     * and returning the index
     */
    public int searchCategory(final Category searchedCategory) {
        int i = 0;
        for (Category category: giftsPreferences) {
            if (searchedCategory == category) {
                // Category was found
                return i;
            }
            i++;
        }

        // Category wasn't found
        return -1;
    }

    /**
     * Method adding nice score to the child's nice score history and recalculating average score
     */
    public void addNiceScore(final Double niceScore) {
        if (niceScore == null) {
            return;
        }

        // add new score to child's nice score list
        niceScoreHistory.add(niceScore);
        // recalculate average score
        this.calculateAverageScore();
    }

    /**
     * Method adding new Categories to child's Gift Preferences List
     */
    public void addGiftPreferences(final ArrayList<Category> newGiftPreferences) {
        // check if there are categories to add to the gift preferences list
        if (newGiftPreferences == null) {
            return;
        }

        ListIterator<Category> categoryIterator =
                newGiftPreferences.listIterator(newGiftPreferences.size());

        // iterate through the new Gift Preferences list in reverse order
        while (categoryIterator.hasPrevious()) {
            Category category = categoryIterator.previous();
            // search the new Category inside the child's Gift Preferences list
            int foundCategory = this.searchCategory(category);

            if (foundCategory != 0) {
                // add Category at the start of child's Gift Preferences list
                giftsPreferences.add(0, category);
                if (foundCategory != -1) {
                    // Category was found inside the child's Gift Preferences list
                    // remove the existing Category
                    giftsPreferences.remove(foundCategory + 1);
                }
            }
        }
    }

    /**
     * Method applying an update to a child
     */
    public void applyUpdate(final ChildUpdate update) {
        // add new nice score to child's nice score list
        this.addNiceScore(update.getNiceScore());
        // add Category to child's gifts preferences list
        this.addGiftPreferences(update.getGiftsPreferences());
        this.elf = update.getElf();
    }

    /**
     * Method clearing a child's Received Gifts List
     */
    public void clearReceivedGifts() {
        receivedGifts = new ArrayList<>();
    }
}
