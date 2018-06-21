package online.qsx.server;

import online.qsx.model.Student;

import java.util.List;

public interface StudentServer {
    void save(Student student);

    void edit(Student student);

    void remove(Student student);

    Student getStudent(Student student);

    List<Student> getStudents(Student student);
}
