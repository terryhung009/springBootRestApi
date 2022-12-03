package com.dannycancode.danny.controller;

import com.dannycancode.danny.entity.Student;
import com.dannycancode.danny.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
  // controller可以加一些驗證Data的code(也可以結合lombok驗證)

  // TODO 這裡可以改成我下面註解這樣
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  // @Autowired
  // private StudentService studentService;

  // ===========================================

  @GetMapping
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @PostMapping
  public void registerNewStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId);
  }

  // TODO 可以研究看看PatchMapping 一般用PutMapping的機會很少
  // TODO api開發原則上通常id都是帶在URL上，但是現今因為資安要求下，除非不重要的資料不然都盡量帶在body內，所以建議這裡資料通通帶在body內
  // TODO 敏感資料如果一定要帶在URL上的話就一定要加密，可以前端加密然後這裡寫解密的code，常見加密手法 ＞base64+URLencode
  // base64 encode:https://www.base64encode.org/
  // URL encode:https://www.urlencoder.org/
  @PutMapping
  public void updateStudent(
      @PathVariable("studentId") Long studentId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {

    studentService.updateStudent(studentId, name, email);
  }
}
