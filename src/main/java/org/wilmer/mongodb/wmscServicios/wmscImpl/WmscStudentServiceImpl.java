package org.wilmer.mongodb.wmscServicios.wmscImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.wilmer.mongodb.wmscDto.WmscStudentDto;
import org.wilmer.mongodb.wmscDto.WmscStudentExistengDto;
import org.wilmer.mongodb.wmscDto.WmscStudentNewDto;
import org.wilmer.mongodb.wmscExcepciones.WmscResourcenotFoundException;
import org.wilmer.mongodb.wmscModelos.WmscStudent;
import org.wilmer.mongodb.wmscRepositorio.WmscStudentRepository;
import org.wilmer.mongodb.wmscServicios.WmscStudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WmscStudentServiceImpl implements WmscStudentService {

    @Autowired
    private WmscStudentRepository studentRepository;
    @Override
    public WmscStudentDto addStudent(WmscStudentNewDto studentNewDto) {
        WmscStudent student = new WmscStudent();
        student.setWmscid(studentNewDto.getWmscid());
        student.setWmscfirstName(studentNewDto.getWmscfirstName());
        student.setWmsclastName(studentNewDto.getWmsclastName());
        student.setWmscemail(studentNewDto.getWmscemail());
        student.setWmsccontactNumber(studentNewDto.getWmsccontactNumber());
        student.setWmsccourseName(studentNewDto.getWmsccourseName());
        student = studentRepository.save(student);
        WmscStudentDto studentDto = new WmscStudentDto();
        studentDto.setWmscid(student.getWmscid());
        studentDto.setWmscfirstName(student.getWmscfirstName());
        studentDto.setWmsclastName(student.getWmsclastName());
        studentDto.setWmscemail(student.getWmscemail());
        studentDto.setWmsccontactNumber(student.getWmsccontactNumber());
        studentDto.setWmsccourseName(student.getWmsccourseName());
        studentDto.setWmsccreated(student.getWmsccreated());
        studentDto.setWmscmodified(student.getWmscmodified());
        return studentDto;
    }

    @Override
    public WmscStudentDto updateStudent(WmscStudentExistengDto studentExistingDto) {
        Optional<WmscStudent> studentOpt = studentRepository.findById(studentExistingDto.getWmscid());
        if (studentOpt.isEmpty()) {
            throw new WmscResourcenotFoundException("student not found");
        }
        WmscStudent student = studentOpt.get();
        student.setWmscfirstName(studentExistingDto.getWmscfirstName());
        student.setWmsclastName(studentExistingDto.getWmsclastName());
        student.setWmscemail(studentExistingDto.getWmscemail());
        student.setWmsccontactNumber(studentExistingDto.getWmsccontactNumber());
        student.setWmsccourseName(studentExistingDto.getWmsccourseName());
        student = studentRepository.save(student);
        WmscStudentDto studentDto = new WmscStudentDto();
        studentDto.setWmscid(student.getWmscid());
        studentDto.setWmscfirstName(student.getWmscfirstName());
        studentDto.setWmsclastName(student.getWmsclastName());
        studentDto.setWmscemail(student.getWmscemail());
        studentDto.setWmsccontactNumber(student.getWmsccontactNumber());
        studentDto.setWmsccourseName(student.getWmsccourseName());
        studentDto.setWmsccreated(student.getWmsccreated());
        studentDto.setWmscmodified(student.getWmscmodified());
        return studentDto;

    }

    @Override
    public void deleteStudent(String studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }
        Optional<WmscStudent> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new WmscResourcenotFoundException("student not found");
        }
        studentRepository.deleteById(studentId);

    }

    @Override
    public WmscStudentDto getStudentById(String studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }
        Optional<WmscStudent> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new WmscResourcenotFoundException("student not found");
        }
        WmscStudent student = studentOpt.get();
        WmscStudentDto studentDto = new WmscStudentDto();
        studentDto.setWmscid(student.getWmscid());
        studentDto.setWmscfirstName(student.getWmscfirstName());
        studentDto.setWmsclastName(student.getWmsclastName());
        studentDto.setWmscemail(student.getWmscemail());
        studentDto.setWmsccontactNumber(student.getWmsccontactNumber());
        studentDto.setWmsccourseName(student.getWmsccourseName());
        studentDto.setWmsccreated(student.getWmsccreated());
        studentDto.setWmscmodified(student.getWmscmodified());
        return studentDto;

    }

    @Override
    public Page<WmscStudentDto> getAllStudents(Pageable pageable) {
        Page<WmscStudent> studentsPage = studentRepository.findAll(pageable);
        List<WmscStudentDto> studentsDto = new ArrayList<>();
        Page<WmscStudentDto> studentsDtoPage = new PageImpl<>(studentsDto, pageable,0);
        if (!studentsPage.isEmpty()) {
            studentsPage.getContent().forEach(student -> {
                WmscStudentDto studentDto = new WmscStudentDto();
                studentDto.setWmscid(student.getWmscid());
                studentDto.setWmscfirstName(student.getWmscfirstName());
                studentDto.setWmsclastName(student.getWmsclastName());
                studentDto.setWmscemail(student.getWmscemail());
                studentDto.setWmsccontactNumber(student.getWmsccontactNumber());
                studentDto.setWmsccourseName(student.getWmsccourseName());
                studentDto.setWmsccreated(student.getWmsccreated());
                studentDto.setWmscmodified(student.getWmscmodified());
                studentsDto.add(studentDto);
            });
            studentsDtoPage = new PageImpl<>(studentsDto, pageable, studentsPage.getTotalElements());
        }
        return studentsDtoPage;
    }
}
