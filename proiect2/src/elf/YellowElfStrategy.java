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
        // offer a chance to receive gifts to a child that hasn't received any gift yet
        if (child.getReceivedGifts().size() == 0) {
            // get child's favourite category
            Category favouriteCategory = child.getGiftsPreferences().get(0);

            // get all gifts in given category, ignoring the quantity
            ArrayList<Gift> giftsInCategory = new GiftUtil().findGiftsInCategory(favouriteCategory,
                      SantaDatabase.getSantaDatabase().getSantaGiftsList(), false);

            // find gift with lowest price in favourite category
            Gift foundGift = new GiftUtil().findGiftMinPrice(giftsInCategory);

            // check if gift was found or if it is in stock
            if (foundGift != null && foundGift.getQuantity() > 0) {
                // distribute gift to child and reduce the stock
                child.getReceivedGifts().add(foundGift);
                foundGift.reduceQuantity();
            }
        }
    }
}
