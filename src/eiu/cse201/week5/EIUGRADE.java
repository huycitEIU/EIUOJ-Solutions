package eiu.cse201.week5;

import java.util.*;

public class EIUGRADE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudent = scanner.nextInt();
        HashMap<Integer,Student> studentHashMap = new HashMap<>();

        for (int i = 0; i < numberOfStudent; i++) {
            int studentId = scanner.nextInt();
            int courseId = scanner.nextInt();
            double grade = scanner.nextDouble();

            Student student = studentHashMap.get(studentId);

            if (student == null) {
                student = new Student(studentId);
            }

            student.addGrade(courseId, grade);
            studentHashMap.put(studentId, student);
        }

        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (Student student : studentHashMap.values()) {
            student.calculateGpa();
            studentArrayList.add(student);
        }

        studentArrayList.sort(Comparator.comparing(Student::getGpa)
                .reversed()
                .thenComparing(Student::getId));

        StringBuilder sb = new StringBuilder();

        for (Student student : studentArrayList) {
            sb.append(student.getId());
            sb.append(" ");
            sb.append(Math.round(student.getGpa() * 1000.0) / 1000.0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Student {
        private final int id;
        private double gpa;
        private double totalGrade;
        private int totalCourse;

        public Student(int id) {
            this.id = id;
            this.totalGrade = 0;
            this.totalCourse = 0;
        }

        public void addGrade(int courseId, double grade) {
            totalGrade += grade;
            totalCourse++;
        }

        public void calculateGpa() {

            this.gpa = totalGrade / totalCourse;
        }

        public int getId() {
            return id;
        }
        public double getGpa() {
            return gpa;
        }
    }
}
