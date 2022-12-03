package com.dannycancode.danny.dao;

import com.dannycancode.danny.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// TODO 可以不用加@Repository
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // TODO 可以改繼承CrudRepository，裡面會有很多實用的基本方法，例如findById 或其他的，相關有哪些可以用的可以上網去查
    // TODO 這裡建議寫出三種方法
    // 1. 使用CrudRepository的方法去寫 ex:
    // Optional<Student> findByEmail(String email);
    //
    // 2. 使用nativeQuery方式去寫 ex:
    // @Query(nativeQuery = true, value = "裡面可以下原生sql")
    // Optional<Student> findStudentByEmail(String email);
    //
    // 3. 使用jpql方式去寫
    // @Query(nativeQuery = true, value = "裡面可以下原生sql")
    // Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.email =?1")
    Optional<Student> findStudentByEmail(String email);

}
