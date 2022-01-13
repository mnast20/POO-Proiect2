package sort;

import child.Child;
import database.SantaDatabase;

import java.util.ArrayList;

public class SortById implements Sort {
    public ArrayList<Child> sort() {
        return SantaDatabase.getSantaDatabase().getChildren();
    }
}
