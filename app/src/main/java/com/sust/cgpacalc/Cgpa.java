package com.sust.cgpacalc;

public class Cgpa {
    public Cgpa(long itemId, float credit, float grade) {
        this.itemId = itemId;
        this.credit = credit;
        this.grade = grade;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    private long itemId;
    private float credit;
    private float grade;

    public Cgpa(float credit, float grade) {
        this.credit = credit;
        this.grade = grade;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
