package gift;

import child.Child;
import database.SantaDatabase;
import elf.ElfFactory;
import elf.ElfStrategy;
import enums.Category;
import enums.Elf;

import java.util.ArrayList;

public final class GiftUtil {
    /**
     * Method retrieving the gift with the minimum price from within a given list of gifts
     */
    public Gift findGiftMinPrice(final ArrayList<Gift> gifts) {
        if (gifts == null || gifts.size() == 0) {
            return null;
        }

        // declare the first gift in the list as the lowest priced gift
        Gift giftMinPrice = gifts.get(0);

        for (Gift gift: gifts) {
            // compare gift prices
            if (gift.getPrice() < giftMinPrice.getPrice()) {
                giftMinPrice = gift;
            }
        }

        return giftMinPrice;
    }

    /**
     * Method returning a list of gifts in a given category
     */
    public ArrayList<Gift> findGiftsInCategory(final Category category,
                                               final ArrayList<Gift> gifts,
                                               final boolean caseQuantity) {
        ArrayList<Gift> giftsInCategory = new ArrayList<>();

        for (Gift gift: gifts) {
            // check if gift's category corresponds with given category
            if (gift.getCategory() == category) {
                if (caseQuantity && gift.getQuantity() > 0) {
                    // add gift to list
                    giftsInCategory.add(gift);
                } else if (!caseQuantity) {
                    // add gift to list
                    giftsInCategory.add(gift);
                }
            }
        }

        return giftsInCategory;
    }

    /**
     * Method distributing gifts to a given child
     */
    public void distributeGiftsChild(final Child child) {
        ArrayList<Gift> allGifts = SantaDatabase.getSantaDatabase().getSantaGiftsList();
        ArrayList<Category> giftsPreferences = child.getGiftsPreferences();

        Elf elf = child.getElf();
        if (elf.toString().compareTo("pink") == 0 || elf.toString().compareTo("black") == 0) {
            ElfStrategy elfStrategy = ElfFactory.createElf(elf);
            elfStrategy.execute(child);
        }

        if (child.getId() == 1) {
            int ok = 1;
        }

        Double childSantaBudget = child.getAssignedBudget();

        for (Category category: giftsPreferences) {
            // find the lowest priced gift inside a category from a child's gifts preferences
            Gift foundGift = findGiftMinPrice(findGiftsInCategory(category, allGifts, true));

            // check if a gift was found
            if (foundGift != null) {
                // check if gift is affordable
                if (foundGift.getPrice() < childSantaBudget) {
                    // reduce gift quantity
                    foundGift.reduceQuantity();

                    // add gift to child's received gifts list
                    child.getReceivedGifts().add(foundGift);

                    // child's assigned budget increases
                    childSantaBudget -= foundGift.getPrice();
                }
            }
        }
    }

    /**
     * Method distributing gifts to the children in the Santa Database
     */
    public void distributeGiftsChildren(final ArrayList<Child> children) {
        for (Child child: children) {
            distributeGiftsChild(child);
        }
    }
}
