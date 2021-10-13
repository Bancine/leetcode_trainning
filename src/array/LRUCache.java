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
    private Map<Integer,Integer> cache;
    DNode head;
    DNode tail;
    int length ;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = new DNode();
        this.tail = head;
        tail.last=head;
    }

    public int get(int key) {
        DNode tempNode = head.next;
        while (tempNode.key != key) {
            tempNode = tempNode.next;
        }
        head.next=tempNode;
        return tempNode.value;
    }

    public void put(int key, int value) {
        DNode temp = new DNode(key,value);

        if (length<capacity){
            tail.next=temp;
            temp.last = tail;
            tail = tail.next;
            length++;
        }else {
            tail = tail.last;
            tail.next = temp;
            tail = tail.next;
        }
    }
}
