package Comparator;

import java.util.Objects;

public class Student implements  Comparable<Student>{
    private int studentId;
    private String studentName;

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Comparator.Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return studentId == student.studentId && Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName);
    }

    /**
     * Sortingh based on studentId
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {
        if(studentId == o.studentId) {
            return 0;
        } else if (studentId > o.studentId) {
            return 1;
        } else {
            return -1;
        }
    }

}
