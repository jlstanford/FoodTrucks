package jstan11.foodtrucks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "foodTrucks";

    private static final String TRUCKS_TABLE = "trucks";
    private static final String TRUCK_NAME = "truckName";
    private static final String FOOD_TYPE = "foodType";
    private static final String LOCATION = "location";

    private static final String AVAILABLE_TRUCK_COUPONS_TABLE = "availableTruckCoupons";

    private static final String COUPON_INFO_TABLE = "couponInfo";
    private static final String COUPON_DESCRIPTION = "couponDescription";
    private static final String COUPON_CODE = "couponCode";
    private static final String COUPON_NAME = "couponName";
    private static final String COUPON_ID = "couponID";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TRUCKS_TABLE = "CREATE TABLE " + TRUCKS_TABLE + "(" + TRUCK_NAME + " TEXT PRIMARY KEY," + FOOD_TYPE + " TEXT," + LOCATION + " TEXT" + ")";

        String CREATE_COUPONS_TABLE = "CREATE TABLE " + COUPON_INFO_TABLE + "(" + COUPON_ID +" INTEGER UNIQUE PRIMARY KEY," + COUPON_NAME + " TEXT," + COUPON_DESCRIPTION + " TEXT," +COUPON_CODE + " TEXT"+ ")";

        String CREATE_AVAILABLE_TRUCK_COUPONS_TABLE = "CREATE TABLE " + AVAILABLE_TRUCK_COUPONS_TABLE + "(" + TRUCK_NAME + " TEXT," +  COUPON_ID + " INTEGER" + ")";

        db.execSQL(CREATE_TRUCKS_TABLE);
        db.execSQL(CREATE_COUPONS_TABLE);
        db.execSQL(CREATE_AVAILABLE_TRUCK_COUPONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TRUCKS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + AVAILABLE_TRUCK_COUPONS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COUPON_INFO_TABLE);
        onCreate(db);
    }

    SQLiteDatabase writableDb = this.getWritableDatabase();

    public void addCoupon(Coupon coupon){
        ContentValues values = new ContentValues();
        values.put(COUPON_ID,coupon.getCouponId());
        values.put(COUPON_NAME,coupon.getName());
        values.put(COUPON_DESCRIPTION,coupon.getDescription());
        values.put(COUPON_CODE,coupon.getCode());

        writableDb.insert(COUPON_INFO_TABLE,null,values);
        writableDb.close();
    }

    public void addTruck(Truck truck){
        ContentValues values = new ContentValues();
        values.put(TRUCK_NAME,truck.getName());
        values.put(FOOD_TYPE, truck.getFoodType());
        values.put(LOCATION, truck.getLocation());

        writableDb.insert(TRUCKS_TABLE,null,values);
        writableDb.close();
    }

    public void addCouponAvalability(Truck truck, Coupon coupon){
        ContentValues values = new ContentValues();
        values.put(TRUCK_NAME,truck.getName());
        values.put(COUPON_ID, coupon.getCouponId());

        writableDb.insert(AVAILABLE_TRUCK_COUPONS_TABLE, null, values);
    }

    Cursor cursor;
    public List<Truck> getAllTrucks(){
        List<Truck> truckList = new ArrayList<Truck>();
        String selectTrucksQuery = "SELECT * FROM " + TRUCKS_TABLE;

        cursor = writableDb.rawQuery(selectTrucksQuery,null);

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                String name = cursor.getString(0);
                String foodType = cursor.getString(1);
                String location = cursor.getString(2);
                Truck truck = new Truck(name, foodType,location);

                truckList.add(truck);
            }
        }

        return truckList;
    }

    public List<Coupon> getCouponsForTruck(Truck truck){
        List<Coupon> couponList = new ArrayList<Coupon>();

        String selectCouponsQuery = ""; //TODO: write query to link tables and get coupons;
        cursor = writableDb.rawQuery(selectCouponsQuery,null);

        if(cursor.moveToFirst()) {
            while(cursor.moveToNext()){
                String couponName;
            }
        }

        return couponList;
    }

}
