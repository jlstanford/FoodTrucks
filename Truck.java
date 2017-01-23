package jstan11.foodtrucks;


public class Truck {
    private String name;
    private String foodType;
    private String location;
    private Coupon[] coupons;

   public Truck(){

   }

    public Truck(String name, String type, String location){
        name = this.name;
        type = this.foodType;
        location = this.location;
    }

    public String getName(){
        return this.name;
    }

    public String getFoodType(){
        return this.foodType;
    }

    public String getLocation(){
        return this.location;
    }
}
