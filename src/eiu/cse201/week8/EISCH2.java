package eiu.cse201.week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EISCH2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int s = scanner.nextInt();

            int totalGrade = 0;
            for (int j = 0; j < s; j++) {
                totalGrade += scanner.nextInt();
            }

            double gpa = (double) totalGrade / s;

            studentList.add(new Student(name, gpa));
        }

        studentList.sort(
                (s1, s2) -> {
                    var compare = Double.compare(s2.gpa, s1.gpa);
                    if (compare == 0) {
                        compare = s1.name.compareTo(s2.name);
                    }
                    return compare;
                }
        );

        int noTypeA = Math.max(1, n / 12);
        int noTypeB = Math.max(noTypeA + 1, n / 3);
        int noTypeC = Math.max(noTypeB + 1, n / 2);

        int index = Math.min(noTypeC - 1, n - 1);

        while (index >= 0 && studentList.get(index).gpa < 50.0) {
            index--;
        }

        if (index + 1 < n) {
            while (index >= 0
                    && studentList.get(index).gpa == studentList.get(index + 1).gpa) {
                index--;
            }
        }

        while (index >= 0 && index >= noTypeB) {
            studentList.get(index).scholarship = 'C';
            index --;
        }

        if (index + 1 < n) {
            while (index >= 0
                    && studentList.get(index).gpa == studentList.get(index + 1).gpa) {
                studentList.get(index).scholarship = 'C';
                index--;
            }
        }

        while (index >= 0 &&  index >= noTypeA) {
            studentList.get(index).scholarship = 'B';
            index--;
        }

        if (index + 1 < n) {
            while (index >= 0 && index < n
                    && studentList.get(index).gpa == studentList.get(index + 1).gpa) {
                studentList.get(index).scholarship = 'B';
                index--;
            }
        }

        while (index >= 0 && index < n) {
            studentList.get(index).scholarship = 'A';
            index--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Student student = studentList.get(i);

            if (student.scholarship == 'N') break;

            sb.append(student.name).append(' ');
            sb.append(Math.round(student.gpa * 100.0) / 100.0);
            sb.append(' ');
            sb.append(student.scholarship);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static class Student {
        String name;
        double gpa;
        char scholarship;

        public Student(String name, double gpa) {
           this.name = name;
           this.gpa = gpa;
           this.scholarship = 'N';
        }
    }
}
