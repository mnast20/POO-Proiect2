package sort;

import child.Child;
import database.SantaDatabase;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByNiceScore implements Sort {
    public ArrayList<Child> sort() {
        ArrayList<Child> sortedChildrenByNiceScore = new ArrayList<>(SantaDatabase.getSantaDatabase().getChildren());
        sortedChildrenByNiceScore.sort((child1, child2) -> (-1) * Double.compare(child1.getAverageScore(), child2.getAverageScore()));
        return sortedChildrenByNiceScore;
    }
}
