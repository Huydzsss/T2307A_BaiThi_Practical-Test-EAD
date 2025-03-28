package org.example.exam_paper.Service;

import org.example.exam_paper.Model.Student;
import org.example.exam_paper.Repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Random;

@Service
public class StudentService {
    @Autowired
    private final StudentRespository studentRespository;

    public StudentService(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }
    public List<Student> getAllStudents() {
        return studentRespository.findAll();
    }

    public void saveStudent(Student student) {
        studentRespository.save(student);
    }
    public String generateStudentId() {
        int randomNum = new Random().nextInt(9000) + 1000;
        return "T" + Year.now().getValue() % 100 + "08A" + randomNum;
    }
    public Student getStudentById(String studentId) {
        return studentRespository.findById(studentId).get();
    }

    public void updateStudent(Student student) {

    }
}
