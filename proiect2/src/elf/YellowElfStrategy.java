package elf;

import child.Child;
import database.SantaDatabase;
import enums.Category;
import gift.Gift;
import gift.GiftUtil;

import java.util.ArrayList;

public class YellowElfStrategy implements ElfStrategy {
    /**
     * Method executing the yellow elf strategy, meaning the child will receive the cheapest gift
     * in his favourite category, if the product is still in stock
     */
    public void execute(final Child child) {
        if (child.getReceivedGifts().size() == 0) {
            Category favouriteCategory = child.getGiftsPreferences().get(0);
            ArrayList<Gift> giftsInCategory = new GiftUtil().findGiftsInCategory(favouriteCategory,
                      SantaDatabase.getSantaDatabase().getSantaGiftsList(), false);
            Gift foundGift = new GiftUtil().findGiftMinPrice(giftsInCategory);
            if (foundGift != null && foundGift.getQuantity() > 0) {
                child.getReceivedGifts().add(foundGift);
                foundGift.reduceQuantity();
            }
        }
    }
}
