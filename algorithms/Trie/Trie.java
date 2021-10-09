// lc 208 字典树 trie https://www.youtube.com/watch?v=pkaooVBexeU&ab_channel=%E5%B1%B1%E6%99%AF%E5%9F%8E%E4%B8%80%E5%A7%90
import java.util.*;
public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }
    // time O(k) k - length of word
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        TrieNode[] test = new TrieNode[26];
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[0].val);
            
        }
    }
}

class TrieNode {
    char val;
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode(char val) {
        this.val = val;
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}
