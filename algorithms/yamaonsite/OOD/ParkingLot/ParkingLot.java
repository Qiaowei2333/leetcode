package OOD.ParkingLot;
import java.util.*;
public class ParkingLot {
    private String name;
    private Location address;
    private ParkingRate parkingRate;

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorbikeCount;
    private final int maxElectricCount;

    // all active parking tickets, identified by their ticketNumber
    private HashMap<String, ParkingTicket> activeTickets;

    private static ParkingLot parkingLot = null;

    private static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) {
        if (this.isFull(vehicle.getType())) {
            throw new Exception();
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);

        this.incrementSpotCount(vehicle.getType());
        this.activeTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }

    public boolean isFull(VehicleType type) {
        // trucks and vans can only be parked in LargeSpot
        if (type == VehicleType.Truck || type == VehicleType.Van) {
          return largeSpotCount >= maxLargeCount;
        }
    
        // motorbikes can only be parked at motorbike spots
        if (type == VehicleType.Motorbike) {
          return motorbikeSpotCount >= maxMotorbikeCount;
        }
    
        // cars can be parked at compact or large spots
        if (type == VehicleType.Car) {
          return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }
    
        // electric car can be parked at compact, large or electric spots
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
            + maxElectricCount);
    }

    private boolean incrementSpotCount(VehicleType type) {
        if (type == VehicleType.Truck || type == VehicleType.Van) {
          largeSpotCount++;
        } else if (type == VehicleType.Motorbike) {
          motorbikeSpotCount++;
        } else if (type == VehicleType.Car) {
          if (compactSpotCount < maxCompactCount) {
            compactSpotCount++;
          } else {
            largeSpotCount++;
          }
        } else { // electric car
          if (electricSpotCount < maxElectricCount) {
            electricSpotCount++;
          } else if (compactSpotCount < maxCompactCount) {
            compactSpotCount++;
          } else {
            largeSpotCount++;
          }
        }
    }
}
