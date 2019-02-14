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
                CGPARecords.CGPAEntries.COLUMN_GRADE,
                CGPARecords.CGPAEntries.COLUMN_COURSE
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
            String course = cursor.getString(cursor.getColumnIndexOrThrow(CGPARecords.CGPAEntries.COLUMN_COURSE));

            itemIds.add(new Cgpa(itemId,credit,grade,course));
        }
        cursor.close();

        return itemIds;
    }

    @Override
    public void insert(float credit,float grade,String course) {
        database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CGPARecords.CGPAEntries.COLUMN_CREDIT, credit);
        values.put(CGPARecords.CGPAEntries.COLUMN_GRADE, grade);
        values.put(CGPARecords.CGPAEntries.COLUMN_COURSE,course);

        long newRowId = database.insert(CGPARecords.CGPAEntries.TABLE_NAME, null, values);
    }

    @Override
    public void delete(long _ID) {
        database = dbHelper.getWritableDatabase();
        // Define 'where' part of query.
        String selection = CGPARecords.CGPAEntries._ID + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = { ((Long)_ID).toString() };
// Issue SQL statement.
        int deletedRows = database.delete(CGPARecords.CGPAEntries.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public void update() {

    }
}
