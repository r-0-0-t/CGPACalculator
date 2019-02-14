package com.sust.cgpacalc;

import android.content.Context;

public class DBHelperPreference {

    private static DBHelper dbHelper;

    public static DBHelper getInstance(Context context)
    {
        if(dbHelper == null) {
            return dbHelper = new DBHelper(context);
        }
        else
            return dbHelper;
    }
}
