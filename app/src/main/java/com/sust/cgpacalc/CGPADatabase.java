package com.sust.cgpacalc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CGPADatabase implements Database {

    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private Context context;

    public CGPADatabase(Context context) {
        this.context = context;
        dbHelper = DBHelperPreference.getInstance(context);
    }

    @Override
    public List read() {
        database = dbHelper.getReadableDatabase();

        String[] projection = {
                CGPARecords.CGPAEntries._ID,
                CGPARecords.CGPAEntries.COLUMN_CREDIT,
                CGPARecords.CGPAEntries.COLUMN_GRADE
        };

        String sortOrder =
                CGPARecords.CGPAEntries.COLUMN_CREDIT + " DESC";

        Cursor cursor = database.query(
                CGPARecords.CGPAEntries.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        List<Cgpa> itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(CGPARecords.CGPAEntries._ID));
            float credit = cursor.getFloat(cursor.getColumnIndexOrThrow(CGPARecords.CGPAEntries.COLUMN_CREDIT));
            float grade = cursor.getFloat(cursor.getColumnIndexOrThrow(CGPARecords.CGPAEntries.COLUMN_GRADE));

            itemIds.add(new Cgpa(itemId,credit,grade));
        }
        cursor.close();

        return itemIds;
    }

    @Override
    public void insert(float credit,float grade) {
        database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CGPARecords.CGPAEntries.COLUMN_CREDIT, credit);
        values.put(CGPARecords.CGPAEntries.COLUMN_GRADE, grade);

// Insert the new row, returning the primary key value of the new row
        long newRowId = database.insert(CGPARecords.CGPAEntries.TABLE_NAME, null, values);
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }
}
