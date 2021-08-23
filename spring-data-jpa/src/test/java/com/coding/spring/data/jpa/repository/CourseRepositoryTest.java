package com.coding.spring.data.jpa.repository;

import com.coding.spring.data.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses()
    {
        List<Course> courses= courseRepository.findAll();

        System.out.println(courses);

    }

    @Test
    public void findAllPagination() {

        Pageable firstPageWithThreeRecords=
                PageRequest.of(0,3);

        Pageable secondPageWithTwoRecords=
                PageRequest.of(1,2);
        
        List<Course> courses=courseRepository.findAll(firstPageWithThreeRecords).getContent();

        System.out.println(courses);
        
        

    }
}