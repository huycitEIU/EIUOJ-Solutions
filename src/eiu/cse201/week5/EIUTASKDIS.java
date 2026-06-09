package eiu.cse201.week5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EIUTASKDIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int t = scanner.nextInt();

        int[] tasks = new int[t];

        for (int i = 0; i < t; i++) {
            tasks[i] = scanner.nextInt();
        }

        Arrays.sort(tasks);

        for (int i = 0; i < t / 2; i++) {
            int temp = tasks[i];
            tasks[i] = tasks[t - i - 1];
            tasks[t - i - 1] = temp;
        }

        Worker[] workers = new Worker[p];

        var priorityQueue = new PriorityQueue<Worker>(
                Comparator.comparing(Worker::getWorkload)
                        .thenComparing(Worker::getId)
        );

        for (int i = 0; i < p; i++) {
            workers[i] = new Worker(i);
            priorityQueue.offer(workers[i]);
        }

        for (int i = 0; i < t; i++) {
            Worker worker = priorityQueue.poll();
            worker.workload += tasks[i];
            priorityQueue.offer(worker);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p; i++) {
            sb.append(workers[i].getWorkload());
            sb.append(" ");
        }

        System.out.println(sb);
    }

    static class Worker {
        private final int id;
        private long workload;

        public Worker(int id) {
            this.id = id;
            this.workload = 0;
        }

        public int getId() {
            return id;
        }

        public long getWorkload() {
            return workload;
        }
    }
}
