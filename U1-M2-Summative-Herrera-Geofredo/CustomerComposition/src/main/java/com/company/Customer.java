package com.company;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address shipAddress;  //Holds Address object
    private Address billAddress;
    private Rewards memberInfo;   //Holds Rewards object

    public Customer(String firstName, String lastName, String email, String phoneNumber,
                    Address shipAddress, Address billAddress, Rewards memberInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.shipAddress = shipAddress;
        this.billAddress = billAddress;
        this.memberInfo = memberInfo;
    }

    public Customer() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
        this.shipAddress = null;
        this.billAddress = null;
        this.memberInfo = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(Address shipAddress) {
        this.shipAddress = shipAddress;
    }

    public Address getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
    }

    public Rewards getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(Rewards memberInfo) {
        this.memberInfo = memberInfo;
    }
}
