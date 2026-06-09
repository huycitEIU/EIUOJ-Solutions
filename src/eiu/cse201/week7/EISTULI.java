package eiu.cse201.week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EISTULI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            String name = scanner.next();
            int numberOfSubjects = scanner.nextInt();
            List<Integer> scoreList = new ArrayList<>();
            for (int j = 0; j < numberOfSubjects; j++) {
                scoreList.add(scanner.nextInt());
            }

            Student student = new Student(id, name, numberOfSubjects, scoreList);
            student.computeAverage();

            studentList.add(student);
        }

        studentList.sort((s1, s2) -> Float.compare(s2.average, s1.average));

        int pivot = 0;
        if (k >= studentList.size()) {
            pivot = studentList.size();
        } else {
            pivot = k;
            float currentAverage = studentList.get(pivot).average;
            while (pivot > 0 && studentList.get(pivot - 1).average == currentAverage) {
                pivot--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pivot; i++) {
            sb.append(studentList.get(i).toString());
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static class Student {
        public String id;
        public String name;
        public int numberOfSubjects;
        public int credits;
        public float average;
        public List<Integer> scoreList;

        public Student(String id, String name, int numberOfSubjects, List<Integer> scoreList) {
            this.id = id;
            this.name = name;
            this.numberOfSubjects = numberOfSubjects;
            this.scoreList = scoreList;
        }

        public void computeAverage() {
            int sum = 0;
            int subjects = 0;

            for (int score : scoreList) {
                if (score >= 50) {
                    sum += score;
                    subjects++;
                }
            }
            this.average = (subjects > 0) ? (float) sum / subjects : 0.0f;
            this.credits = subjects * 4;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(average) + " " + credits;
        }
    }
}
