package com.company.GeofredoHerreraU1Capstone.dao.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {

    private int gameId;
    @NotEmpty(message = "Title of the game must not be empty.")
    private String title;
    @NotEmpty(message = "ESRB Rating of the game must not be empty.")
    private String esrbRating;
    @NotEmpty(message = "Description of the game must not be empty.")
    private String description;
    @NotNull(message = "Price of the game must not be empty.")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price for this item is lower than the minimum price allowed, $0.0")
    @DecimalMax(value = "999.99", inclusive = true, message = "Price for this item exceeds the maximum price allowed, $999.99")
    private BigDecimal price;
    @NotEmpty(message = "Studio of the game must not be empty.")
    private String studio;
    @NotNull(message = "Game quantity must not be empty")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 2147483647, message = "Quantity can not be larger than the max Integer value: 2147483647")
    private int quantity;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        GameViewModel that = (GameViewModel) o;
        return getGameId() == that.getGameId() &&
                getQuantity() == that.getQuantity() &&
                getTitle().equals(that.getTitle()) &&
                getEsrbRating().equals(that.getEsrbRating()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                getPrice().equals(that.getPrice()) &&
                getStudio().equals(that.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameId(), getTitle(), getEsrbRating(), getDescription(), getPrice(), getStudio(), getQuantity());
    }
}
