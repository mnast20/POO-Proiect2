package input;

import enums.Category;

public final class GiftInput {
    private String productName;
    private Double price;
    private Category category;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
