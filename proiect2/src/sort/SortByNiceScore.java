package sort;

import child.Child;
import database.SantaDatabase;

import java.util.ArrayList;

public class SortByNiceScore implements Sort {
    /**
     * Method sorting all children based on their nice scores
     */
    public ArrayList<Child> sort() {
        // get all children in the Database
        ArrayList<Child> sortedChildrenByNiceScore =
                new ArrayList<>(SantaDatabase.getSantaDatabase().getChildren());

        // sort children by comparing their average scores
        sortedChildrenByNiceScore.sort((child1, child2) ->
                (-1) * Double.compare(child1.getAverageScore(), child2.getAverageScore()));

        return sortedChildrenByNiceScore;
    }
}
