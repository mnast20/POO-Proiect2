package gift.strategy;

import child.Child;
import gift.GiftUtil;
import sort.SortByNiceScoreCity;

import java.util.ArrayList;

public class NiceScoreCityStrategy implements DistributeGiftsStrategy {
    public void distributeGifts() {
        ArrayList<Child> children = new SortByNiceScoreCity().sort();
        new GiftUtil().distributeGiftsChildren(children);
    }
}
