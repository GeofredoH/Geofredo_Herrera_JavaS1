package com.company.GeofredoHerreraU1Capstone.dao.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Invoice {

    private int invoiceId;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String itemType;
    private int itemId;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
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
        return unitPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal.setScale(2, RoundingMode.HALF_UP);
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTax() {
        return tax.setScale(2, RoundingMode.HALF_UP);
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getProcessingFee() {
        return processingFee.setScale(2, RoundingMode.HALF_UP);
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal() {
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void setTotal(BigDecimal total) {
        this.total = total.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceId() == invoice.getInvoiceId() &&
                getItemId() == invoice.getItemId() &&
                getQuantity() == invoice.getQuantity() &&
                getName().equals(invoice.getName()) &&
                getStreet().equals(invoice.getStreet()) &&
                getCity().equals(invoice.getCity()) &&
                getState().equals(invoice.getState()) &&
                getZipcode().equals(invoice.getZipcode()) &&
                getItemType().equals(invoice.getItemType()) &&
                getUnitPrice().equals(invoice.getUnitPrice()) &&
                getSubtotal().equals(invoice.getSubtotal()) &&
                getTax().equals(invoice.getTax()) &&
                getProcessingFee().equals(invoice.getProcessingFee()) &&
                getTotal().equals(invoice.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getUnitPrice(), getQuantity(), getSubtotal(), getTax(), getProcessingFee(), getTotal());
    }
}
