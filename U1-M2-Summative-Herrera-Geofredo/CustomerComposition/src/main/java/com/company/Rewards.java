package com.company;

public class Rewards {
    private int memberNumber;
    private int points;
    private String memberLevel;

    public Rewards(int memberNumber, int points, String memberLevel) {
        this.memberNumber = memberNumber;
        this.points = points;
        this.memberLevel = memberLevel;
    }

    public Rewards() {
        this.memberNumber = 0;
        this.points = 0;
        this.memberLevel = "";
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }
}
