// https://leetcode.com/discuss/interview-question/125263/construct-huffman-tree/124125
import java.util.*;
public class HuffmanTree {
    private static Map<Character, String> encodeMap = new HashMap<>();
    // 假设 chars，freqs 不为null，且长度相等
    // huffman tree is always a full binary tree
    public Node constructHuffmanTree(List<Character> chars, List<Integer> freqs) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
        for (int i = 0; i < chars.size(); i++) {
            pq.offer(new Node(chars.get(i), freqs.get(i)));
        }
        if (pq.size() == 1) return pq.poll();
        while (pq.size() != 1) {
            Node first = pq.poll();
            Node second = pq.poll();
            Node newNode = new Node(first.frequency + second.frequency);
            newNode.left = first;
            newNode.right = second;
            pq.offer(newNode);
        }
        return pq.poll();
    }

    private void generateEncodeMap(Node root, String s) {
        if (root != null && root.left == null && root.right == null) {
            encodeMap.put(root.letter, s);
            return;
        }
        generateEncodeMap(root.left, s + "0");
        generateEncodeMap(root.right, s + "1");
    }

    // s = "0011110..." res = "ABCD..."
    private String decode(String s, Node root) {
        Node head = root;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (head != null && head.left == null && head.right == null) {
                res += head.letter;
                head = root;
            }
            if (s.charAt(i) == '0') {
                head = head.left;
            }
            else {
                head = head.right;
            }
        }
        if (head != null && head.left == null && head.right == null) {
            res += head.letter;
            head = root;
        }
        return res;
    }

    static class Node {
        char letter;
        int frequency;
        Node left;
        Node right;

        public Node (int frequency) {
            this.frequency = frequency;
        }

        public Node(char letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        HuffmanTree s = new HuffmanTree();
        List<Character> letters = new ArrayList<>();
        letters.add('A');
        letters.add('B');
        letters.add('C');
        letters.add('D');
        letters.add('E');
        List<Integer> freqs = new ArrayList<>();
        freqs.add(3);
        freqs.add(5);
        freqs.add(6);
        freqs.add(4);
        freqs.add(2);
        Node root = s.constructHuffmanTree(letters, freqs);
        s.generateEncodeMap(root, "");
        String inputString = "BCCABBDDAECCBBAEDDCC"; // This is the string that generate List<Character> letters and List<Integer> freqs 
        String encoded = "";
        for (char c : inputString.toCharArray()) {
            encoded += encodeMap.get(c);
        }
        System.out.println(encoded);
        String decoded = s.decode(encoded, root);
        System.out.println(decoded);
        System.out.println(inputString.equals(decoded));
    }
}
