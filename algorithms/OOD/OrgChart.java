// draftkings oa  O(n) 操作
import java.io.*;
import java.util.*;
public class OrgChart {
    private Map<String, Employee> map = new HashMap<>();

    public static void main(String[] agrs) {
        OrgChart s = new OrgChart();
        s.add("10", "S G", "-1");
        s.add("7", "D M", "10");
        s.add("6", "E N", "10");
        s.add("8", "F O", "7");
        s.add("9", "G P", "8");
        s.remove("7");
        s.print();
        System.out.println(s.count("10"));
    }

    public void add(String id, String name, String managerId) {
        try {
            if (map.containsKey(id)) return;
            Employee newEmployee = new Employee(id, name);
            map.put(id, newEmployee);
            if (map.containsKey(managerId)) {
                Employee manager = map.get(managerId);
                manager.members.add(newEmployee);
                newEmployee.supervisor = manager;
            }
        } 
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public void print() {
        try {
            Set<String> set = new HashSet<>();
            for (Map.Entry<String, Employee> entry : map.entrySet()) {
                Employee e = entry.getValue();
                if (e.supervisor == null && !set.contains(e.id)) {
                    traverse(e, set, 1);
                }
            }
        } 
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    private void traverse(Employee e, Set<String> set, int depth) {
        if (set.contains(e.id)) return;
        set.add(e.id);
        System.out.println(e.name + " " + e.id);
        
        for (Employee member : e.members) {
            printIndents(depth);
            traverse(member, set, depth + 1);
        }
    }

    private void printIndents(int times) {
        while (times != 0) {
            System.out.print("  ");
            times--;
        }
    }

    public void remove(String employeeId) {
        try {
            if (!map.containsKey(employeeId)) return;
            Employee employee = map.remove(employeeId);
            Employee manager = employee.supervisor;
            if (manager != null) 
                manager.members.remove(employee);
        
            for (Employee e : employee.members) {
                e.supervisor = manager;
                if (manager != null) 
                    manager.members.add(e);
            }
        } 
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public void move(String employeeId, String newManagerId) {
        try {
            if (!map.containsKey(employeeId) || !map.containsKey(newManagerId)) return;
            Employee employee = map.get(employeeId);
            Employee oldMgr = employee.supervisor;
            if (oldMgr != null) oldMgr.members.remove(employee);
            Employee newMgr = map.get(newManagerId);
            newMgr.members.add(employee);
            employee.supervisor = newMgr;
        } 
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public int count(String employeeId) {
        try {
            if (!map.containsKey(employeeId)) return 0;
            Employee e = map.get(employeeId);
            int numOfReports = e.members.size();
            for (Employee member : e.members) {
                numOfReports += count(member.id);
            }
            return numOfReports;
        }
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    static class Employee {
        String id;
        String name;
        Employee supervisor;
        List<Employee> members;
        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
            members = new LinkedList<>();
        }
    }
}
