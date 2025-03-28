package org.example.exam_paper.Service;

import org.example.exam_paper.Model.Subject;
import org.example.exam_paper.Repository.SubjectRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRespository subjectRepository;

    @Autowired
    public SubjectService(SubjectRespository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
