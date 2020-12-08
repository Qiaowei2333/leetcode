package OOD.ParkingLot;

public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;

    public boolean resetPassword() {
        return true;
    };

    public String getUsername() {
        return this.userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }
}


