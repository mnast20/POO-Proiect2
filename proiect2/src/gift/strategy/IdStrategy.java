package gift.strategy;

import child.Child;
import gift.GiftUtil;
import sort.SortById;

import java.util.ArrayList;

public class IdStrategy implements DistributeGiftsStrategy {
    /**
     * Method distributing gifts to all children in the order of their IDs
     */
    public void distributeGifts() {
        // sort children by ID
        ArrayList<Child> children = new SortById().sort();

        // distribute gifts to sorted list of children
        new GiftUtil().distributeGiftsChildren(children);
    }
}
