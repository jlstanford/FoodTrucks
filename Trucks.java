package jstan11.foodtrucks;

/**
 * Created by Jessica on 12/21/2016.
 */
public class Trucks {
    private String name;
    private String type;
    private String location;

   public Trucks(){

   }

    public Trucks(String name, String type, String location){
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public String getLocation(){
        return this.location;
    }
}
