package org.example.exam_paper.Service;

import org.example.exam_paper.Model.Student_score;
import org.example.exam_paper.Repository.Student_CoreRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public void updateScore(Student_score studentScore) {
        Student_score existingScore = studentScoreRepository.findById(studentScore.getId())
                .orElseThrow(() -> new IllegalArgumentException("Score not found"));
        existingScore.setScore1(studentScore.getScore1());
        existingScore.setScore2(studentScore.getScore2());
        studentScoreRepository.save(existingScore);
    }

    public Student_score getScoreById(Long id) {
        return studentScoreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Score not found with ID: " + id));
    }


}