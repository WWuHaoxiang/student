package net.serviceprovider.service;

import net.serviceprovider.converter.StudentConverter;
import net.serviceprovider.dao.Student;
import net.serviceprovider.dao.StudentRepository;
import net.serviceprovider.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO getStudentByStudentId(long studentId) {
//        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        if (studentRepository.findByStudentId(studentDTO.getStudentId()).isPresent() ||
        studentDTO.getName() == null || studentDTO.getEmail() == null)
            throw new IllegalStateException("studentId: " + studentDTO.getStudentId() + " has already existed\t" +
                    "or name is null\t or email is null");
        else{
            Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));
            return student.getStudentId();
        }

    }

    @Override
    public void deleteStudentByStudentId(long studentId) {
        studentRepository.findByStudentId(studentId).orElseThrow(() -> new IllegalStateException("studentId: " + studentId + " does not exist"));
        studentRepository.deleteByStudentId(studentId);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentByStudentId(long studentId, String name, String email) {
        Student studentInDB = studentRepository.findByStudentId(studentId).orElseThrow(() -> new IllegalStateException("studentId: " + studentId + " does not exist"));
        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)){
            studentInDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)){
            studentInDB.setEmail(email);
        }
        Student student = studentRepository.save(studentInDB);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();

        for (Student student: studentList){
            studentDTOList.add(StudentConverter.convertStudent(student));
        }

        return studentDTOList;
    }
}
