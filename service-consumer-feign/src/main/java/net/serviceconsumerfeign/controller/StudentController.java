package net.serviceconsumerfeign.controller;

import net.serviceconsumerfeign.Response;
import net.serviceconsumerfeign.dto.StudentDTO;
import net.serviceconsumerfeign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{studentId}")
    public Response<StudentDTO> getStudentByStudentId(@PathVariable long studentId){
        return Response.newSuccess(studentService.getStudentByStudentId(studentId));
    }
    @PostMapping("/student")
    public Response<Long> addNewStudent(@RequestBody StudentDTO studentDTO) {
        return Response.newSuccess(studentService.addNewStudent(studentDTO));
    }
    @DeleteMapping("/student/{studentId}")
    public void deleteStudentByStudentId(@PathVariable long studentId){
        studentService.deleteStudentByStudentId(studentId);
    }
    @PutMapping("/student/{ignoredStudentId}")
    public Response<StudentDTO> updateStudentByStudentId(@PathVariable long ignoredStudentId,
                                                         @RequestParam(required = false) String name,
                                                         @RequestParam(required = false) String email) {
        return Response.newSuccess(studentService.updateStudentByStudentId(ignoredStudentId, name, email));
    }

    @GetMapping("/student")
    public Response<List<StudentDTO>> getAllStudent(){
        return Response.newSuccess(studentService.getAllStudent());
    }

}
