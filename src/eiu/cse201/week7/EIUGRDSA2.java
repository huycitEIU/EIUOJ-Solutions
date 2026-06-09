package eiu.cse201.week7;

import java.util.*;

public class EIUGRDSA2 {
    public static class Student {
        int id;
        int validSubmissions;
        int average;
        int problems;
        Map<Integer, Integer> problemMap;

        public Student(int id) {
            this.id = id;
            this.validSubmissions = 0;
            this.average = 0;
            this.problemMap = new HashMap<>();
        }

        public void addGrade(int code, int newGrade, Map<Integer, Integer> problemMap) {
            if (!problemMap.containsKey(code)) return;

            var currentGrade = this.problemMap.get(code);

            if (currentGrade == null) {
                this.problemMap.put(code, newGrade);
            } else if (currentGrade < newGrade) {
                this.problemMap.put(code, newGrade);
            }
            validSubmissions++;
        }

        public void computAverage() {
            int total = 0;
            for (int grade : problemMap.values()) {
                total += grade;
            }
            average = (int) Math.floor((double) total / problems);
        }

        @Override
        public String toString() {
            return id + " " + average + " " + validSubmissions;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int m = scanner.nextInt();

        Map<Integer, Student> studentMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            studentMap.put(id, new Student(id));
        }

        Map<Integer, Integer> problemMap = new HashMap<>();

        for (int i = 0; i < p; i++) {
            int code = scanner.nextInt();
            problemMap.put(code, 0);
        }

        for (int i = 0; i < m; i++) {
            int id = scanner.nextInt();
            int code = scanner.nextInt();
            int grade = scanner.nextInt();
            studentMap.get(id).addGrade(code, grade, problemMap);
        }

        List<Student> studentList = new ArrayList<>();

        for (Student student : studentMap.values()) {
            student.problems = problemMap.size();
            student.computAverage();
            studentList.add(student);
        }

        studentList.sort((s1, s2) -> {
            var c = Integer.compare(s2.average, s1.average);
            if (c == 0) {
                c = Integer.compare(s1.validSubmissions, s2.validSubmissions);
            }
            if (c == 0) {
                c = Integer.compare(s1.id, s2.id);
            }
            return c;
        });

        StringBuilder sb = new StringBuilder();

        for (Student student : studentList) {
            sb.append(student);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
