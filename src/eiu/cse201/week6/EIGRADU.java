package eiu.cse201.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EIGRADU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int requiredCredits = scanner.nextInt();

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Student student = new Student();

            student.id = scanner.nextLong();
            student.name = scanner.next();

            int m = scanner.nextInt();

            for (int j = 0; j < m; j++) {
                student.addGrade(scanner.nextInt());
            }

            student.computeGpa();

            studentList.add(student);
        }

        studentList.sort((s1, s2) -> {
            var compare = Double.compare(s2.roundedGpa, s1.roundedGpa);
            if (compare == 0) {
                compare = Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
            if (student.totalCredits >= requiredCredits) {
                sb.append(student);
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    public static class Student {
        public long id;
        public String name;
        public int totalCredits;
        public List<Integer> gradeList;
        public double rawGpa;
        public double roundedGpa;

        public Student() {
            gradeList = new ArrayList<>();
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                totalCredits += 4;
                gradeList.add(grade);
            }
        }

        public void computeGpa() {
            int total = 0;

            for (int grade : gradeList) {
                total += grade;
            }

            rawGpa = 0.0;

            if (!gradeList.isEmpty()) {
                rawGpa = (double) total / gradeList.size();
            }

            roundedGpa = (int) Math.floor(rawGpa);
        }

        @Override
        public String toString() {
            return id + " " + name + " " + roundedGpa;
        }
    }
}
