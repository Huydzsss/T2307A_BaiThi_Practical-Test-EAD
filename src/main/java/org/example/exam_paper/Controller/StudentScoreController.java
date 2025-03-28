package org.example.exam_paper.Controller;

import org.example.exam_paper.Model.Student;
import org.example.exam_paper.Model.Student_score;
import org.example.exam_paper.Model.Subject;
import org.example.exam_paper.Repository.StudentRespository;
import org.example.exam_paper.Service.StudentScoreService;
import org.example.exam_paper.Service.StudentService;
import org.example.exam_paper.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/students")
public class StudentScoreController {
    private final StudentService studentService;
    private final StudentScoreService studentScoreService;
    private final SubjectService subjectService;
    private final StudentRespository studentRespository;

    @Autowired
    public StudentScoreController(StudentService studentService, StudentScoreService studentScoreService, SubjectService subjectService, StudentRespository studentRespository) {
        this.studentService = studentService;
        this.studentScoreService = studentScoreService;
        this.subjectService = subjectService;
        this.studentRespository = studentRespository;
    }

    @GetMapping
    public String listStudentsAndScores(Model model) {
        List<Student> students = studentService.getAllStudents();
        List<Student_score> studentScores = studentScoreService.getAllStudentScores();
        List<Subject> subjects = subjectService.getAllSubjects();

        model.addAttribute("students", students);
        model.addAttribute("studentScores", studentScores);
        model.addAttribute("subjects", subjects);

        return "students";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        student.setStudentId(studentService.generateStudentId());
        studentRespository.save(student);
        return "redirect:/v1/students";
    }


    @PostMapping("/scores/add")
    public String addScore(@ModelAttribute Student_score studentScore,
                           @RequestParam("studentId") String studentId,
                           @RequestParam("subjectId") Long subjectId) {
        Student student = studentService.getStudentById(studentId);
        Subject subject = subjectService.getSubjectById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found"));


        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student or Subject not found");
        }

        studentScore.setStudent(student);
        studentScore.setSubject(subject);

        studentScoreService.saveScore(studentScore);

        return "redirect:/v1/students";
    }
    @GetMapping("/edit/{studentId}")
    public String editStudent(@PathVariable String studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/v1/students";
    }

    @GetMapping("/scores/edit/{id}")
    public String editScore(@PathVariable Long id, Model model) {
        Student_score studentScore = studentScoreService.getScoreById(id);
        if (studentScore == null) {
            throw new IllegalArgumentException("Score not found");
        }
        model.addAttribute("studentScore", studentScore);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "edit_score";
    }

    @PostMapping("/scores/update")
    public String updateScore(@ModelAttribute Student_score studentScore) {
        studentScoreService.updateScore(studentScore);
        return "redirect:/v1/students";
    }



}