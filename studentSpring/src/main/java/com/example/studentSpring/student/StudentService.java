package com.example.studentSpring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//SERVICE LAYER gives back to the API LAYER
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();//returns a list to us
    }

    public void addNewStudent(Student student) {
         Optional<Student> studentByEmail= studentRepository.findStudentByEmail(student.getEmail());
         if(studentByEmail.isPresent()){
             throw new IllegalMonitorStateException("email taken");
         }
         /*if(studentByEmail.isEmpty()){
             throw new IllegalStateException("No email inserted");
         }*/
         studentRepository.save(student);
    }

    public void deleteStudent(long studentid) {
        boolean exist = studentRepository.existsById(studentid);
        if(exist) {
            studentRepository.deleteById(studentid);
        }
        else{
            throw new IllegalStateException("Student with studentid" + studentid +"does not exist");
        }
    }

    @Transactional
    public void updateStudent(long studentid, String name, String email) {
        Student student = studentRepository.findById(studentid)
                .orElseThrow(() -> new IllegalStateException("Student with studentid" + studentid +"does not exist"));

                        if( name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
                            student.setName(name);
                        }
                        //we check if the email is already existing because we dont want two same mail to exist
                        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
                            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
                            if(studentOptional.isPresent()){
                                throw new IllegalStateException("email taken");
                            }
                            student.setEmail(email);
                        }

    }
}
