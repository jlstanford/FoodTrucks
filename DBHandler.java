package jstan11.foodtrucks;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "foodTrucks";

    private static final String TRUCKS_TABLE = "trucks";
    private static final String TRUCK_NAME = "truckName";
    private static final String FOOD_TYPE = "foodType";
    private static final String LOCATION = "location";

    private static final String COUPONS_TABLE = "coupons";
    private static final String COUPON_NAME = "couponName";
    private static final String COUPON_ID = "couponID";

    private static final String COUPON_INFO_TABLE = "couponInfo";
    private static final String COUPON_DESCRIPTION = "couponDescription";
    private static final String COUPON_CODE = "couponCode";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TRUCKS_TABLE = "CREATE TABLE " + TRUCKS_TABLE + "(" + TRUCK_NAME + " TEXT PRIMARY KEY," + FOOD_TYPE + " TEXT," + LOCATION + " TEXT" + ")";

        String CREATE_COUPONS_TABLE = "CREATE TABLE " + COUPONS_TABLE + "(" + TRUCK_NAME + " TEXT," + COUPON_NAME + " TEXT," + COUPON_ID + " INTEGER UNIQUE," + ")";

        String CREATE_COUPON_INFO_TABLE = "CREATE TABLE " + COUPON_INFO_TABLE + "(" + COUPON_ID +" INTEGER UNIQUE PRIMARY KEY," + COUPON_DESCRIPTION + " TEXT," +COUPON_CODE + " TEXT"+ ")";

        db.execSQL(CREATE_TRUCKS_TABLE);
        db.execSQL(CREATE_COUPONS_TABLE);
        db.execSQL(CREATE_COUPON_INFO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
