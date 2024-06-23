package net.serviceconsumerfeign.clients;

import net.serviceconsumerfeign.Response;
import net.serviceconsumerfeign.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("service-provider")
public interface StudentClient {
    @GetMapping("/student/{studentId}")
    Response<StudentDTO> findByStudentId(@PathVariable long studentId);

    @PostMapping("/student")
    Response<Long> addStudent(@RequestBody StudentDTO studentDTO);

    @DeleteMapping("/student/{studentId}")
    void deleteByStudentId(@PathVariable long studentId);

    @PutMapping("/student/{studentId}")
    Response<StudentDTO> updateByStudentId(@PathVariable long studentId,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String email);

    @GetMapping("/student")
    Response<List<StudentDTO>> findAll();
}
