package com.example.tusharpc.barcodescanner;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by TUSHAR PC on 28-12-2016.
 */
public class DatabaseHandler extends SQLiteAssetHelper {
    private static String DB_NAME = "barcodes.db";
    private static int DB_VERSION = 1;

    public DatabaseHandler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    public String getProductName(String barcode){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb =new SQLiteQueryBuilder();
        String[] sqlSelect = {"0 _id","ProductName"};
        String sqlTable = "products";
        String selection = "barcode LIKE '"+barcode+"'";
        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, selection, null, null, null, null);
        c.moveToFirst();
        return c.getString(1);
    }
    public Float getProductPrice(String barcode){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb =new SQLiteQueryBuilder();
        String[] sqlSelect = {"0 _id","ProductPrice"};
        String sqlTable = "products";
        String selection = "barcode LIKE '"+barcode+"'";
        qb.setTables(sqlTable);
        Cursor c = qb.query(db,sqlSelect,selection,null,null,null,null);
        c.moveToFirst();
        return Float.parseFloat(c.getString(1));
    }
}
