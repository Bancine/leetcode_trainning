package test;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    public MedianFinder() {
        this.minQueue = new PriorityQueue<>((a, b) -> (b - a));
        this.maxQueue = new PriorityQueue<>((a,b)->(a-b));
    }

    public void addNum(int num){
        minQueue.add(num);
        maxQueue.add(num);
    }

    public int getMedian() {
        if (minQueue.size()==maxQueue.size()){
            return (minQueue.peek()+maxQueue.peek())/2;
        }
        return -1;
    }
}
