package com.sust.cgpacalc;

import android.provider.BaseColumns;

public final class CGPARecords {
    private CGPARecords() {
    }

    public static class CGPAEntries implements BaseColumns {

        public static final String TABLE_NAME = "cgpa";
        public static final String COLUMN_GRADE = "grade";
        public static final String COLUMN_CREDIT = "credit";
        public static final String COLUMN_COURSE = "course";

    }
}
