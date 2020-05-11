// lc 1396
import java.util.*;
// import javafx.util.Pair; 

public class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
    Map<String, int[]> checkOutMap = new HashMap<>();
	public UndergroundSystem() {}
    
	public void checkIn(int id, String stationName, int t) {
        Pair<String, Integer> newCheckIn = new Pair<>(stationName, t);
        checkInMap.put(id, newCheckIn);
    }
    
	public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.remove(id);
        String route = checkIn.getKey() + "_" + stationName;
        int totalTime = t - checkIn.getValue();
        int[] checkOut = checkOutMap.getOrDefault(route, new int[]{0, 0});
        checkOut[0] += totalTime;
        checkOut[1] += 1;
        checkOutMap.put(route, checkOut);
    }
    
	public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "_" + endStation;
        int[] checkOut = checkOutMap.get(route);
        if (checkOut == null) {
            return 0;
        } else {
            return (double) checkOut[0] / checkOut[1];
        }
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        double avgTime = undergroundSystem.getAverageTime("Paradise", "Cambridge");
        System.out.println(avgTime);
    }
}