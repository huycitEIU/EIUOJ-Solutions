package eiu.cse201.week7;

import java.util.*;

public class EIUGRDSA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int m = scanner.nextInt();

        Map<Integer, Student> studentMap = new HashMap<>();
        Map<Integer, Boolean> problemSet = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            studentMap.put(id, new Student(id));
        }

        for (int i = 0; i < p; i++) {
            int code = scanner.nextInt();
            problemSet.put(code, true);
        }

        for (int i = 0; i < m; i++) {
            int id = scanner.nextInt();
            int code = scanner.nextInt();
            int grade = scanner.nextInt();

            if (problemSet.get(code) == null) {
                continue;
            }

            studentMap.get(id).addGrade(code, grade);
        }

        List<Student> studentList = new ArrayList<>();

        for (Student student : studentMap.values()) {
            int total = 0;
            for (int grade : student.gradeMap.values()) {
                total += grade;
            }

            student.average = (int) Math.floor((double) total / problemSet.size());

            studentList.add(student);
        }

        studentList.sort(Comparator.comparingInt(Student::getId));

        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
            sb.append(student.id).append(' ').append(student.average);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class Student {
        int id;
        int average;
        Map<Integer, Integer> gradeMap;

        public int getId() {
            return this.id;
        }

        public Student(int id) {
            this.id = id;
            gradeMap = new HashMap<>();
        }

        public void addGrade(int code, int newGrade) {
            var currentGrade = gradeMap.get(code);

            if (currentGrade == null || currentGrade < newGrade) {
                gradeMap.put(code, newGrade);
            }
        }

    }
}
