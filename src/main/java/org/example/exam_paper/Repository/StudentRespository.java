package org.example.exam_paper.Repository;

import org.example.exam_paper.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends JpaRepository<Student, String> {

}
