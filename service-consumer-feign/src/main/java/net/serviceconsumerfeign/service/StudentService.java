package net.serviceconsumerfeign.service;

import net.serviceconsumerfeign.clients.StudentClient;
import net.serviceconsumerfeign.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentClient studentClient;

    public StudentService(StudentClient studentClient) {
        this.studentClient = studentClient;
    }

    public StudentDTO getStudentByStudentId(long studentId) {
        return studentClient.findByStudentId(studentId).getData();
    }

    public Long addNewStudent(StudentDTO studentDTO) {
        return studentClient.addStudent(studentDTO).getData();
    }

    public void deleteStudentByStudentId(long studentId) {
        studentClient.deleteByStudentId(studentId);
    }

    public StudentDTO updateStudentByStudentId(long studentId, String name, String email) {
        return studentClient.updateByStudentId(studentId, name, email).getData();
    }

    public List<StudentDTO> getAllStudent() {
        return studentClient.findAll().getData();
    }
}
