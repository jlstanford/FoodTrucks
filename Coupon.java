package jstan11.foodtrucks;

/**
 * Created by Jessica on 12/21/2016.
 */
public class Coupon {
    private Integer couponId;
    private String name;
    private String description;
    private String code;

    public Coupon (){

    }

    public Coupon (Integer couponId, String name, String description, String code){
        couponId = this.couponId;
        name = this.name;
        description = this.description;
        code=this.code;
    }

    public Integer getCouponId(){
        return this.couponId;
    }


    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getCode () {
        return this.code;
    }

}
