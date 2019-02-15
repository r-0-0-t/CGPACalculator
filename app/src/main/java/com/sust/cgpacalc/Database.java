package com.sust.cgpacalc;

import java.util.List;

public interface Database {
    List<Cgpa> read();
    void insert(float credit,float grade,String course);
    void delete(long _ID);
    void update(float credit,float grade,String course,long _ID);
}
