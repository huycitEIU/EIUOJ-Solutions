package eiu.cse201.week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EISCHSH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentList = new ArrayList<>();

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (n <= 0 || k <= 0) return;

        for (int i = 0; i < n; i++) {
            Student student = new Student();

            student.id = scanner.nextLong();
            student.name = scanner.next();

            int learnedCourses = scanner.nextInt();

            for (int j = 0; j < learnedCourses; j++) {
                student.addGrade(scanner.nextInt());
            }

            student.computeGpa();

            studentList.add(student);
        }

        studentList.sort((s1, s2) -> {
            var compare = Double.compare(s2.rawGpa, s1.rawGpa);
            if (compare == 0) {
                compare = Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        int rank = 1;
        int index = 1;
        double currentGpa = studentList.get(0).rawGpa;
        StringBuilder sb = new StringBuilder();

        for (Student student : studentList) {
            if (currentGpa != student.rawGpa) {
                rank = index;
                currentGpa = student.rawGpa;
            }
            if (rank > k) {
                break;
            }
            sb.append(rank).append(' ');
            sb.append(student);
            sb.append('\n');
            index++;
        }

        System.out.println(sb);
    }

    public static class Student {
        public long id;
        public String name;
        public List<Integer> passedGradeList;
        public double rawGpa;
        public int roundedGpa;

        public Student() {
            passedGradeList = new ArrayList<>();
            rawGpa = 0.0;
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                passedGradeList.add(grade);
            }
        }

        public void computeGpa() {
            if (passedGradeList.isEmpty()) return;

            int total = 0;
            for (int grade: passedGradeList) {
                total += grade;
            }

            rawGpa = (double) total / passedGradeList.size();
            roundedGpa = (int) Math.round(rawGpa);
        }

        @Override
        public String toString() {
            return id + " " + name + ' ' + roundedGpa;
        }
    }
}
