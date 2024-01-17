package org.wilmer.mongodb.wmscControlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wilmer.mongodb.wmscDto.WmscStudentDto;
import org.wilmer.mongodb.wmscDto.WmscStudentExistengDto;
import org.wilmer.mongodb.wmscDto.WmscStudentNewDto;
import org.wilmer.mongodb.wmscExcepciones.WmscError;
import org.wilmer.mongodb.wmscExcepciones.WmscResourcenotFoundException;
import org.wilmer.mongodb.wmscServicios.WmscStudentService;

@RestController
@RequestMapping(path = "/students")

public class WmscStudentController {
    @Autowired
    private WmscStudentService studentService;

    @PostMapping(path = "/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid  WmscStudentNewDto studentNewDto) {
      try {
        WmscStudentDto student = studentService.addStudent(studentNewDto);
        return ResponseEntity.ok(student);
      } catch ( WmscResourcenotFoundException e) {
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    @PutMapping(path = "/update")
    public ResponseEntity<?> updateStudent( @RequestBody @Valid WmscStudentExistengDto studentExistingDto) {
        try {
          WmscStudentDto student = studentService.updateStudent(studentExistingDto);
          return ResponseEntity.ok(student);
        } catch (WmscResourcenotFoundException e) {
          return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable(name = "studentId") String studentId) {
        studentService.deleteStudent(studentId);
    }
    @GetMapping(path = "/{studentId}")
    public ResponseEntity<WmscStudentDto> getStudent(
            @PathVariable(name = "studentId") String studentId) {
        WmscStudentDto student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<Page<WmscStudentDto>> getStudents(@PageableDefault(page = 0,
            size = 30) @SortDefault.SortDefaults({@SortDefault(sort = "wmscmodified",
            direction = Sort.Direction.DESC)}) Pageable pageable) {
        Page<WmscStudentDto> students = studentService.getAllStudents(pageable);
        return ResponseEntity.ok(students);
    }

}
