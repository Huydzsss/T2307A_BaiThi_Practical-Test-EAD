package org.example.exam_paper.Repository;

import org.example.exam_paper.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRespository extends JpaRepository<Subject, Long> {
}
