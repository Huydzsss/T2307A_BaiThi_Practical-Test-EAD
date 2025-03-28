package org.example.exam_paper.Repository;

import org.example.exam_paper.Model.Student_score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_CoreRespository extends JpaRepository<Student_score, Long> {

}
