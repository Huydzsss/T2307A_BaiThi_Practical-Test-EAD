package org.example.exam_paper.Service;

import org.example.exam_paper.Model.Student_score;
import org.example.exam_paper.Repository.Student_CoreRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentScoreService {
    @Autowired
    private Student_CoreRespository studentScoreRepository;

    public List<Student_score> getAllStudentScores() {
        return studentScoreRepository.findAll();
    }

    public void saveScore(Student_score studentScore) {
        studentScoreRepository.save(studentScore);
    }
}