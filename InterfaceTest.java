package T2;

import java.util.List;
import java.util.Random;

interface VehicleFunctions{
    void start();
    void stop();
    void lightsOn();
    void lightsOff();

}

enum CarBrand{
    MERCEDES_BENZ,
    BMW,
    AUDI

}

enum TruckBrand{
    MAN,
    SCANIA,
    VOLVO
}

class SpeedUnderZero extends Exception{
    public SpeedUnderZero(int speed) {
        super("The speed cannot be " + speed);
    }
}

class TruckBrandDoesNotExist extends Exception{
    public TruckBrandDoesNotExist(TruckBrand message) {
        super(message + " does not exist ");
    }
}

class Car implements VehicleFunctions{
    private int maxSpeed;
    private String registerPlate;
    private CarBrand carBrand;

    public Car(int maxSpeed, String registerPlate, CarBrand carBrand) throws SpeedUnderZero {
        this.maxSpeed = maxSpeed;

        this.registerPlate = registerPlate;
        this.carBrand = carBrand;
        if(maxSpeed < 0){
            throw new SpeedUnderZero(maxSpeed);
        }

    }


    public Car race(Car c2){

        Car c1 = this;

        int winner = (int) Math.round(Math.random());
        if(winner == 0){
            return c1;
        }else{
            return c2;
        }

    }

    @Override
    public String toString() {
        return "Car Brand: " + carBrand + "\nMax Speed: " + maxSpeed +"\nRegister Plate: " + registerPlate;
    }

    @Override
    public void start() {
        System.out.println(carBrand + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(carBrand + " is stopping...");

    }

    @Override
    public void lightsOn() {
        System.out.println("The lights are turning on");
    }

    @Override
    public void lightsOff() {
        System.out.println("The lights are turning off");

    }
}

class Truck implements VehicleFunctions{
    private int maxSpeed;
    private float totalWeight;
    private TruckBrand truckBrand;

    public Truck(int maxSpeed, float totalWeight, TruckBrand truckBrand) throws TruckBrandDoesNotExist {
        this.maxSpeed = maxSpeed;
        this.totalWeight = totalWeight;
        this.truckBrand = truckBrand;

        List<TruckBrand> truckBrandList = List.of(TruckBrand.values());
        if(!truckBrandList.contains(truckBrand)){
            throw new TruckBrandDoesNotExist(truckBrand);
        }
    }

    @Override
    public String toString() {
        return "Truck{" +
                "maxSpeed=" + maxSpeed +
                ", totalWeight=" + totalWeight +
                ", truckBrand=" + truckBrand +
                '}';
    }

    @Override
    public void start() {
        System.out.println(truckBrand + " is starting...");

    }

    @Override
    public void stop() {
        System.out.println(truckBrand + " is stopping...");

    }

    @Override
    public void lightsOn() {
        System.out.println("The lights are turning on");

    }

    @Override
    public void lightsOff() {
        System.out.println("The lights are turning off");

    }
}

public class InterfaceTest {


    public static void main(String[] args) throws Exception {

        try{
//            Car audi = new Car(-50,"0003",CarBrand.AUDI);


            Car mercedes = new Car(300,"0001",CarBrand.MERCEDES_BENZ);
            Car bmw = new Car(250,"0002",CarBrand.BMW);

            mercedes.start();
            mercedes.lightsOn();

            bmw.start();
            bmw.lightsOn();

            System.out.println("The Winner is:");
            System.out.println(mercedes.race(bmw));

            Truck truck = new Truck(150,1500.21F,TruckBrand.MAN);
            System.out.println(truck);

            Truck truck2 = new Truck(150,1500.21F,TruckBrand.valueOf("ASD"));
            System.out.println(truck2);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }





    }


}
