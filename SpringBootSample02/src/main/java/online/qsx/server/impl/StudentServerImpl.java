package online.qsx.server.impl;

import online.qsx.dao.StudentRepository;
import online.qsx.model.Student;
import online.qsx.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServerImpl implements StudentServer {

    private @Autowired StudentRepository studentRepository;

    @Override
    public void save(Student student) {
         studentRepository.save(student);
    }

    @Override
    public void edit(Student student) {
         studentRepository.save(student);
    }

    @Override
    public void remove(Student student) {
         studentRepository.delete(student.getId());
    }

    @Override
    public Student getStudent(Student student) {
        return studentRepository.findOne(student.getId());
    }

    @Override
    public List<Student> getStudents(Student student) {
        Iterable<Student> itrrable= studentRepository.findAll();
        List<Student> list=new ArrayList<>();
        itrrable.forEach((obj)->list.add(obj));
        return list;
    }
}
