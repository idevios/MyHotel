package th.ac.cmru.computer.myhotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Jedi on 17/3/2559.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "hotelDB";

    public static final String ROOM_TABLE_NAME = "room";

    public static final String ROOM_COLUMN_ID = "id";
    public static final String ROOM_COLUMN_IN = "checkin";
    public static final String ROOM_COLUMN_OUT = "checkout";
    public static final String ROOM_COLUMN_NAME = "name";

    public static final String USER_TABLE_NAME = "user";
    public static final String USER_COLUMN_ID = "id";
    public static final String USER_COLUMN_NAME = "name";
    public static final String USER_COLUMN_PHONE = "phone";
    public static final String USER_COLUMN_EMAIL = "email";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE room " +
                "(id integer primary key autoincrement, " +
                "checkin text, " +
                "checkout text, " +
                "name text );";
        String sqlUser = "CREATE TABLE user " +
                "(id integer primary key autoincrement, " +
                "name text, " +
                "phone text, " +
                "email text );";
        db.execSQL(sql);
        db.execSQL(sqlUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ ROOM_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS"+ USER_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String strCheckin, String strCheckout, String roomName){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ROOM_COLUMN_IN, strCheckin);
        contentValues.put(ROOM_COLUMN_OUT, strCheckout);
        contentValues.put(ROOM_COLUMN_NAME, roomName);

        db.insert(ROOM_TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean insertUser(String name, String phone, String email){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(USER_COLUMN_NAME, name);
        contentValues.put(USER_COLUMN_PHONE, phone);
        contentValues.put(USER_COLUMN_EMAIL, email);

        db.insert(USER_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+ ROOM_TABLE_NAME;
        Cursor res = db.rawQuery(sql,null);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRow = (int) DatabaseUtils.queryNumEntries(db, ROOM_TABLE_NAME);
        return numRow;
    }

    public boolean updateDB(String id, String name, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROOM_COLUMN_ID, id);
        contentValues.put(ROOM_COLUMN_IN, name);
        contentValues.put(ROOM_COLUMN_NAME, price);
        db.update(ROOM_TABLE_NAME, contentValues, "id=?", new String[]{id});
        return true;
    }

    public Integer deleteDB(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(ROOM_TABLE_NAME,"id=?",new String[]{id});
    }

    public ArrayList<String> getAllData(int numRows){
        ArrayList<String> arrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+ ROOM_TABLE_NAME+" WHERE id = "+numRows;
        Cursor res = db.rawQuery(sql,null);
        res.moveToFirst();

        while (res.isAfterLast() == false){
            arrayList.add("Room: "+res.getString(res.getColumnIndex(ROOM_COLUMN_NAME))+
                    "\n"+"CHECK-IN: "+res.getString(res.getColumnIndex(ROOM_COLUMN_IN))+
                    "\n"+"CHECK-OUT: "+res.getString(res.getColumnIndex(ROOM_COLUMN_OUT)));
            res.moveToNext();
        }


        return arrayList;
    }

    public ArrayList<String> getUserData(int numRows){
        ArrayList<String> arrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+ USER_TABLE_NAME+" WHERE id = "+numRows;
        Cursor res = db.rawQuery(sql,null);
        res.moveToFirst();

        while (res.isAfterLast() == false){
            arrayList.add("NAME: "+res.getString(res.getColumnIndex(USER_COLUMN_NAME))+
                    "\n"+"PHONE: "+res.getString(res.getColumnIndex(USER_COLUMN_PHONE))+
                    "\n"+"EMAIL: "+res.getString(res.getColumnIndex(USER_COLUMN_EMAIL)));
            res.moveToNext();
        }


        return arrayList;
    }
}
