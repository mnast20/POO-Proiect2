package gift.strategy;

import child.Child;
import gift.GiftUtil;
import sort.SortById;

import java.util.ArrayList;

public class IdStrategy implements DistributeGiftsStrategy {
    public void distributeGifts() {
        ArrayList<Child> children = new SortById().sort();
        new GiftUtil().distributeGiftsChildren(children);
    }
}
