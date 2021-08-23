package com.coding.spring.data.jpa.repository;


import com.coding.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    //JPQL Query
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);


    //Native Naming Query
    @Query(
            value=" select * from tbl_student s where s.email_address= :emailId",
            nativeQuery = true
    )
    Student getEmailAddressByNativeNamedParam(@Param("emailId") String emailId);


    @Transactional
    @Modifying
    @Query(
            value="update tbl_student set first_name=?1 where email_address=?2",
            nativeQuery=true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);
}
