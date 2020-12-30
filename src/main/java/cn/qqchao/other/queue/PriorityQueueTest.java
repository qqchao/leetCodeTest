package cn.qqchao.other.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(3);
        list.add(6);
        list.add(7);
        list.add(2);
        list.add(4);
        list.add(1);

        PriorityQueue<Integer> queueDefault = new PriorityQueue<>();
        PriorityQueue<Integer> queueReverse = new PriorityQueue<>((a, b) -> b - a);

/*
        PriorityQueue<Integer> queueComparator = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queueOverride = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        PriorityQueue<Integer> queueLambda = new PriorityQueue<>((a, b) -> b - a);*/

        addQueue(queueDefault, list);
        addQueue(queueReverse, list);

        System.out.print("queueDefault toString：  ");
        System.out.println(queueDefault.toString());
        System.out.print("queueReverse toString：  ");
        System.out.println(queueReverse.toString());

        System.out.println();

        System.out.print("queueDefault poll：  ");
        while (!queueDefault.isEmpty()){
            System.out.print(queueDefault.poll() + " ");
        }
        System.out.println();
        System.out.print("queueReverse poll：  ");
        while (!queueReverse.isEmpty()){
            System.out.print(queueReverse.poll() + " ");
        }
        System.out.println();
    }

    static void addQueue(PriorityQueue<Integer> queue, List<Integer> list){
        for (int a : list) {
            queue.offer(a);
        }
    }
}
