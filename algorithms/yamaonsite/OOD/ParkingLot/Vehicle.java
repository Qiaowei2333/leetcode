package OOD.ParkingLot;

public abstract class Vehicle {
    private String licenseNumber; // id for a vehicle
    private final VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public VehicleType getType() {
       return this.type; 
    }
}
