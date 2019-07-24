package com.company.GeofredoHerreraU1Capstone.dao.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {

    private int invoiceId;
    @NotEmpty(message = "Name must not be empty")
    private String name;
    @NotEmpty(message = "Street must not be empty")
    private String street;
    @NotEmpty(message = "City must not be empty")
    private String city;
    @NotEmpty(message = "State must not be empty")
    @Size(min = 2, max = 2, message = "State must be a valid two character state code")
    private String state;
    @NotEmpty(message = "Zipcode must not be empty")
    private String zipcode;
    @NotEmpty(message = "Item type must not be empty")
    private String itemType;
    @NotNull(message = "Item Id must not be empty")
    private int itemId;
    private BigDecimal unitPrice;
    @NotNull(message = "Quantity must not be 0")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 2147483647, message = "Quantity can not be larger than the max Integer value: 2147483647")
    private int quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;                 //If there are precision errors on the currency variable
    private BigDecimal processingFee;       //try adding @Size annotation to the viewModel currency variables as well
    private BigDecimal total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getInvoiceId() == that.getInvoiceId() &&
                getItemId() == that.getItemId() &&
                getQuantity() == that.getQuantity() &&
                getName().equals(that.getName()) &&
                getStreet().equals(that.getStreet()) &&
                getCity().equals(that.getCity()) &&
                getState().equals(that.getState()) &&
                getZipcode().equals(that.getZipcode()) &&
                getItemType().equals(that.getItemType()) &&
                getUnitPrice().equals(that.getUnitPrice()) &&
                getSubtotal().equals(that.getSubtotal()) &&
                getTax().equals(that.getTax()) &&
                getProcessingFee().equals(that.getProcessingFee()) &&
                getTotal().equals(that.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getUnitPrice(), getQuantity(), getSubtotal(), getTax(), getProcessingFee(), getTotal());
    }
}
