package com.ssd.services.ssdCourseApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CourseRepository extends JpaRepository<Course, BigInteger> {
}
