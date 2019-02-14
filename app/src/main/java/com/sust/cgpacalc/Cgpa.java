package com.sust.cgpacalc;

public class Cgpa {

    private long itemId;
    private float credit;
    private float grade;
    private String course;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Cgpa(long itemId, float credit, float grade, String course) {
        this.itemId = itemId;
        this.credit = credit;
        this.grade = grade;
        this.course = course;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
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
