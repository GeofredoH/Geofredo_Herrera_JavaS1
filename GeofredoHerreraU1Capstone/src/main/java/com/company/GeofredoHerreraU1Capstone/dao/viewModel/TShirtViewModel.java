package com.company.GeofredoHerreraU1Capstone.dao.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirtViewModel {
    private int tShirtId;
    @NotEmpty(message = "T-Shirt size must not be empty")
    private String size;
    @NotEmpty(message = "T-Shirt color must not be empty")
    private String color;
    @NotEmpty(message = "T-Shirt description must not be empty")
    private String description;
    @NotNull(message = "T-Shirt price must not be empty")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price for this item is lower than the minimum price allowed, $0.0")
    @DecimalMax(value = "999.99", inclusive = true, message = "Price for this item exceeds the maximum price allowed, $999.99")
    private BigDecimal price;
    @NotNull(message = "T-Shirt quantity must not be empty")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 2147483647, message = "Quantity can not be larger than the max Integer value: 2147483647")
    private int quantity;

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirtViewModel that = (TShirtViewModel) o;
        return gettShirtId() == that.gettShirtId() &&
                getQuantity() == that.getQuantity() &&
                getSize().equals(that.getSize()) &&
                getColor().equals(that.getColor()) &&
                getDescription().equals(that.getDescription()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(gettShirtId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }
}
