package com.sergiandreplace.recordsbox.cusor;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

/**
 * Base template to create cursor reading/writing
 */
public abstract class BaseCursorHelper<T> {

    /**
     * Stores a T object into a content value array
     * @param item The object to store
     * @return The content values
     */
    public abstract ContentValues setValues(T item);

    /**
     * Reads a cursor and deserializes to a T object
     * @param cursor the cursor positioned in the record to extract
     * @return A T object representing the record
     */
    public abstract T readCursor (Cursor cursor);

    /**
     * Generates an array of content values from a list of items of type T
     * @param items The list of T type objects
     * @return The array of content values. Empty if no items, bu tno null;
     */
    public ContentValues[] setValuesArray(List<T> items) {
        int length=items.size();
        ContentValues[] tableValues=new ContentValues[length];
        for (int i=0; i<length; i++) {
            tableValues[i]=setValues(items.get(i));
        }
        return tableValues;

    }
}
