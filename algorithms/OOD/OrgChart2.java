// draftKings oa sol2   O(1) 操作
import java.io.*;
import java.util.*;
public class OrgChart2 {
    private Map<String, Employee> map = new HashMap<>();
    public void add(String id, String name, String managerId) {
        try {
        } 
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public void print() {
        try {
        } 
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public void remove(String employeeId) {
        try {
        } 
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public void move(String employeeId, String newManagerId) {
        try {
        } 
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public int count(String employeeId) {
        try {
        }
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    static class Employee {
        String id;
        String name;
        Employee supervisor;
        Employee endChild;
        int numOfChildren;
        Employee prev;
        Employee next;
        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
