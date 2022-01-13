package gift;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.Category;
import input.GiftInput;

@JsonIgnoreProperties(value = {
        "quantity"
})

public final class Gift {
    private final String productName;
    private final Double price;
    private final Category category;
    private Integer quantity;

    /**
     * Gift copy constructor based on a gift's input data
     */
    public Gift(final GiftInput gift) {
        this.productName = gift.getProductName();
        this.price = gift.getPrice();
        this.category = gift.getCategory();
        this.quantity = gift.getQuantity();
    }

    /**
     * Method decrementing the gift's quantity
     */
    public void reduceQuantity() {
        quantity--;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}
