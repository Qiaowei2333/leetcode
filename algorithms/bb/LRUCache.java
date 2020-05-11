// lc 146
// access to random entry in O(1) -> hashtable/hashmap
// remove the last entry in LRU in O(1) -> LinkedList
// Add/move an entry to the front of LRU Cache in O(1) -> Double linked list
import java.util.*;
public class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    // easier to remove and add node by using dummy head and tail
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }    
        }
        addNode(node);
        map.put(key, node);
    }
    
    // add to head
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache s = new LRUCache(2);
        s.put(1, 1);
        s.put(2, 2);
        System.out.println(s.get(1));
        s.put(3, 3);
        System.out.println(s.get(2));
        s.put(4, 4);
        System.out.println(s.get(1));
    }
}