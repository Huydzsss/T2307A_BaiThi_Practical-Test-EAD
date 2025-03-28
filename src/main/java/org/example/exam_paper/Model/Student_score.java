package org.example.exam_paper.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student_score")
public class Student_score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id")
    private long studentScoreId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "score1", nullable = false)
    private double score1;

    @Column(name = "score2", nullable = false)
    private double score2;
    public String getGrade() {
        double finalScore = 0.3 * score1 + 0.7 * score2;
        if (finalScore >= 8.0) return "A";
        else if (finalScore >= 6.0) return "B";
        else if (finalScore >= 4.0) return "D";
        else return "F";
    }


    public Long getId() {
        return studentScoreId;
    }
}
