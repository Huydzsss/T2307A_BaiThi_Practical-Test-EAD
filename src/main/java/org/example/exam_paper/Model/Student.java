package org.example.exam_paper.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id",length = 50)
    private String studentId;
    @Column(name = "student_name", nullable = false)
    private String student_name;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student_score> scores;

}
