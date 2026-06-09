package eiu.cse201.week7;

import java.util.PriorityQueue;
import java.util.Scanner;

public class EIUSLS {
    static class Student {
        public String name;
        public double gpa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] arr = new Student[2];

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.name = scanner.next();

            int m = scanner.nextInt();
            int totalGrade = 0;

            for (int j = 0; j < m; j++) {
                totalGrade += scanner.nextInt();
            }

            student.gpa = (double) totalGrade / m;

            if (i < 2) {
                arr[i] = student;
                if (arr[1] == null) continue;
            }


            if (student.gpa > arr[1].gpa) {
                arr[1] = student;
            }

            if (arr[1].gpa > arr[0].gpa) {
                var temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
        }

        for (Student student : arr) {
            if (student != null) {
                System.out.println(student.name);
            }
        }
    }
}
