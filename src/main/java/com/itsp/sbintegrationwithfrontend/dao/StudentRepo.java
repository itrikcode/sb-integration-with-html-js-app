package com.itsp.sbintegrationwithfrontend.dao;

import com.itsp.sbintegrationwithfrontend.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class StudentRepo {

    List<Student> studentList = new ArrayList<>();

    Iterator<Student> studentIterator = studentList.iterator();

    public String saveStudent(Student std) {
        String result = null;

        // Using an iterator to avoid ConcurrentModificationException
        Iterator<Student> iterator = studentList.iterator();

        if (studentList.isEmpty()) {
            studentList.add(std);
            result = "One record successfully added";
        } else {
            boolean studentExists = false;

            while (iterator.hasNext()) {
                Student std1 = iterator.next();

                if (std1.getName().equals(std.getName()) && std1.getAddress().equals(std.getAddress())) {
                    studentExists = true;
                    result = "Record already exists with the same name and address";
                    break;
                }
            }

            if (!studentExists) {
                studentList.add(std);
                result = "Record added successfully";
            }
        }

        return result;
    }


    public List<Student> showStudent(){
        return studentList.stream().toList();
    }
}
