package ood;


    public enum VehicleType {
        CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE
    }
      
    public enum ParkingSpotType {
        HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
    }
      
    public enum AccountStatus {
        ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
    }
      
    public enum ParkingTicketStatus {
        ACTIVE, PAID, LOST
    }
      
    public class Address {
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }
      
    public class Person {
        private String name;
        private Address address;
        private String email;
        private String phone;
    }

    // For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

    public abstract class Account {
        private String userName;
        private String password;
        private AccountStatus status;
        private Person person;

        public boolean resetPassword();
    }

    public class Admin extends Account {
        public bool addParkingFloor(ParkingFloor floor);
        public bool addParkingSpot(String floorName, ParkingSpot spot);
        public bool addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
        public bool addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel);

        public bool addEntrancePanel(EntrancePanel entrancePanel);
        public bool addExitPanel(ExitPanel exitPanel);
    }

    public class ParkingAttendant extends Account {
        public bool processTicket(string TicketNumber);
    }