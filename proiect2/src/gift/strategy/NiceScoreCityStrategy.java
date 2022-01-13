package gift.strategy;

import child.Child;
import gift.GiftUtil;
import sort.SortByNiceScoreCity;

import java.util.ArrayList;

public class NiceScoreCityStrategy implements DistributeGiftsStrategy {
    /**
     * Method sorting children based on the cities' nice scores and distributing the gifts to the
     * sorted list of children
     */
    public void distributeGifts() {
        ArrayList<Child> children = new SortByNiceScoreCity().sort();
        new GiftUtil().distributeGiftsChildren(children);
    }
}
