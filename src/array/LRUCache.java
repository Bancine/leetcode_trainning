package array;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class DNode{
        int key;
        int value;
        DNode next;
        DNode last;
        public DNode(){};
        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer,DNode> cache;
    DNode head;
    DNode tail;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.head = new DNode();
        this.tail = new DNode();
        head.next=tail;
        tail.last=head;
    }

    public int get(int key) {
        DNode dNode = cache.get(key);
        if (dNode == null) {
            return -1;
        }
        moveToHead(dNode);
        return dNode.value;
    }

    public void put(int key, int value) {
        DNode dNode = cache.get(key);
        if (dNode == null) {
            dNode = new DNode(key, value);
            cache.put(key, dNode);
            addToHead(dNode);
            size++;
        }else {
            dNode.value =value;
            moveToHead(cache.get(key));
        }

        if (size > capacity) {
            removeTail();
            size--;
        }
    }

    private void moveToHead(DNode dNode) {
        dNode.last.next = dNode.next;
        dNode.next.last = dNode.last;
        dNode.last = head;
        dNode.next = head.next;
        dNode.next.last = dNode;
        head.next = dNode;
    }

    private void removeTail(){
        cache.remove(tail.last.key);
        tail.last.last.next = tail;
        tail.last = tail.last.last;
    }

    private void addToHead(DNode dNode) {
        dNode.last = head;
        dNode.next = head.next;
        dNode.next.last = dNode;
        head.next = dNode;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(2);    // 返回 1
        lRUCache.put(1, 1); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4,1);    // 返回 -1 (未找到)
        lRUCache.get(2);
    }
}
