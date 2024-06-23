package net.serviceprovider.service;

import net.serviceprovider.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO getStudentByStudentId(long studentId);

    Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentByStudentId(long studentId);

    StudentDTO updateStudentByStudentId(long studentId, String name, String email);

    List<StudentDTO> getAllStudent();
}
