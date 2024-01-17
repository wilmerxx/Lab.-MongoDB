package org.wilmer.mongodb.wmscServicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.wilmer.mongodb.wmscDto.WmscStudentDto;
import org.wilmer.mongodb.wmscDto.WmscStudentExistengDto;
import org.wilmer.mongodb.wmscDto.WmscStudentNewDto;

public interface WmscStudentService {
    WmscStudentDto addStudent(WmscStudentNewDto studentNewDto);
    WmscStudentDto updateStudent(WmscStudentExistengDto studentExistingDto);
    void deleteStudent(String studentId);
    WmscStudentDto getStudentById(String studentId);
    Page<WmscStudentDto> getAllStudents(Pageable pageable);
}
