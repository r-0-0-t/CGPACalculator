package com.sust.cgpacalc;

public interface OnItemClick {
    void onItemDeleteCgpa(int position);
    void onItemUpdateCgpa(float credit,float grade,String course,int position);
    void onItemClickGrade(int position);
    void onItemClickCredit(int position);
    void onItemClickCourse(int position);
}
