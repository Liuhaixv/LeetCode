package Level_346;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> queue = new LinkedList<>();
    int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() < size) {
            queue.offer(val);


        } else if (queue.size() == size) {
            queue.poll();
            queue.offer(val);
        }
        Queue<Integer> temp = new LinkedList<>(queue);
        double sum = 0;
        for (int i = 0; i < queue.size(); i++) {
            sum += temp.poll();
        }
        return sum / queue.size();
    }

    public static void main(String[] args) {
        new MovingAverage(2).next(2);
        Queue<Integer> ints = new LinkedList<>();
        ints.offer(2);
        if(ints.peek()!=null){
            int a = ints.peek();
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */