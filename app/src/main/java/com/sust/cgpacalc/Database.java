package com.sust.cgpacalc;

import java.util.List;

public interface Database {
    List<Cgpa> read();
    void insert(float credit,float grade);
    void delete();
    void update();
}
