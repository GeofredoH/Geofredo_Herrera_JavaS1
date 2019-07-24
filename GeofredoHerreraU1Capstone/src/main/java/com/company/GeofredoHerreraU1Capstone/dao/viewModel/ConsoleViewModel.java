package com.company.GeofredoHerreraU1Capstone.dao.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {
    private int consoleId;
    @NotEmpty(message = "Console model must not be empty")
    private String model;
    @NotEmpty(message = "Console manufacturer must not be empty")
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    @NotNull(message = "Console price must not be empty")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price for this item is lower than the minimum price allowed, $0.0")
    @DecimalMax(value = "999.99", inclusive = true, message = "Price for this item exceeds the maximum price allowed, $999.99")
    private BigDecimal price;
    @NotNull(message = "Console quantity must not be empty")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 2147483647, message = "Quantity can not be larger than the max Integer value: 2147483647")
    private int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getConsoleId() == that.getConsoleId() &&
                getQuantity() == that.getQuantity() &&
                getModel().equals(that.getModel()) &&
                getManufacturer().equals(that.getManufacturer()) &&
                Objects.equals(getMemoryAmount(), that.getMemoryAmount()) &&
                Objects.equals(getProcessor(), that.getProcessor()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoleId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }
}
