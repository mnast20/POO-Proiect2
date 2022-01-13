package sort;

import child.Child;
import database.SantaDatabase;

import java.util.ArrayList;

public class SortById implements Sort {
    /**
     * Method returning all children in Santa's Database because they are already sorted by ID
     */
    public ArrayList<Child> sort() {
        return SantaDatabase.getSantaDatabase().getChildren();
    }
}
