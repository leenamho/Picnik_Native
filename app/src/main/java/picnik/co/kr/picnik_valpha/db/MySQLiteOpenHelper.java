package picnik.co.kr.picnik_valpha.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cha-sc on 2015-10-21.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    // 전역변수
    MySQLiteOpenHelper helper;
    SQLiteDatabase db;

    // 생성자
    public MySQLiteOpenHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    // 최초 디비 생성할 때 한번 작동
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    // db 업그레이드
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
