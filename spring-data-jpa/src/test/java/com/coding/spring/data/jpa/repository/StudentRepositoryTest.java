package com.coding.spring.data.jpa.repository;

import com.coding.spring.data.jpa.entity.Guardian;
import com.coding.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student=Student.builder()
                .emailId("paikarayabhishek@gmail.com")
                .firstName("Abhishek")
                .lastName("Paikaray")
                //.guardianName("Dillip")
                //.guardianEmail("dkp@gmail.com")
                //.guardianMobile("1234569870")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian= Guardian.builder()
                .name("dkp")
                .email("xyz@hma.com")
                .mobile("6595213558")

                .build();

        Student student=Student.builder()
                .emailId("ashek@gmail.com")
                .firstName("Abhi")
                .lastName("ray")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

     @Test
     public void printAllStudent()
     {
         List<Student> list1=studentRepository.findAll();

         System.out.println("studentList= "+list1);
     }



     @Test
     public void getStudentByEmailAddress()
     {
         Student student=studentRepository.getStudentByEmailAddress("paikarayabhishek@gmail.com");

         System.out.println(student);

     }

     @Test
    public void getEmailAddressByNativeNamedParam()
     {
         Student student=studentRepository.getEmailAddressByNativeNamedParam("paikarayabhishek@gmail.com");

         System.out.println(student);
     }

     @Test
    public void updateStudentNameByEmailIdTest()
     {
         studentRepository.updateStudentNameByEmailId("Abhishekha","paikarayabhishek@gmail.com");
     }
}