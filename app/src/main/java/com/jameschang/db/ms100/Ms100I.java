package com.jameschang.db.ms100;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class Ms100I {
    private static final String DB_FILE = "MS.db";
    private static final String DB_TABLE = "MS100";

    /**
     * 檢查Table是否存在
     * @param context
     * @param factory
     * @param version
     */
    public void checkTable(@Nullable Context context,
                              @Nullable SQLiteDatabase.CursorFactory factory,
                              int version){
        Ms100 tMs100 = new Ms100(context,DB_FILE,factory,version);
        SQLiteDatabase msDB = tMs100.getWritableDatabase();

        StringBuilder checkTableSQL = new StringBuilder();
        checkTableSQL.append(" SELECT ");
        checkTableSQL.append(" DISTINCT ");
        checkTableSQL.append(" tbl_name ");
        checkTableSQL.append(" FROM sqlite_master ");
        checkTableSQL.append(" WHERE ");
        checkTableSQL.append(" tbl_name =  '");
        checkTableSQL.append(DB_TABLE);
        checkTableSQL.append("'");
        Log.d("checkTable",checkTableSQL.toString());

        Cursor cursor = msDB.rawQuery(checkTableSQL.toString(),null);

        if(cursor != null){
            if(cursor.getCount() == 0){

                StringBuilder creatTableSQL = new StringBuilder();
                creatTableSQL.append(" CREATE TABLE MS100 ( ");
                creatTableSQL.append(" ID INTEGER PRIMARY KEY, ");
                creatTableSQL.append(" RECEIPT_1 TEXT, ");
                creatTableSQL.append(" RECEIPT_2 INTEGER, ");
                creatTableSQL.append(" TOTAL_AMT INTEGER, ");
                creatTableSQL.append(" BUY_DATE TEXT ");
                creatTableSQL.append(" ); ");
                Log.d("creatTable",creatTableSQL.toString());

                msDB.execSQL(creatTableSQL.toString());
                cursor.close();
            }
        }

        msDB.close();

    }
}
