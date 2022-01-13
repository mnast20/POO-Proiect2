package gift.strategy;

import child.Child;
import gift.GiftUtil;
import sort.SortByNiceScore;

import java.util.ArrayList;

public class NiceScoreStrategy implements DistributeGiftsStrategy {
    /**
     * Method distributing gifts to all children in the order of their nice scores
     */
    public void distributeGifts() {
        ArrayList<Child> children = new SortByNiceScore().sort();
        new GiftUtil().distributeGiftsChildren(children);
    }
}
