package OOD.ParkingLot;

public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private ParkingSpotType type;

    public ParkingSpotType getType() {
        return this.type;
    }

    public void setType(ParkingSpotType type) {
        this.type = type;
    }

    //public abstract boolean isFree();

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;
    }
}
