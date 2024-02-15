package lk.ijse.accountManager.model;

import lk.ijse.accountManager.config.SessionFactoryConfig;
import lk.ijse.accountManager.entity.Student;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentModel {
    public boolean saveStudent(Student testStudent) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        session.save(testStudent);
        transaction.commit();
        session.close();
        return true;
    }


    public Student searchStudent(int studentId) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        if (student == null) {
            return null;
        }
        transaction.commit();
        Hibernate.initialize(student.getNumbers()); // Initialize the numbers collection
        session.close();
        return student;
    }


    public boolean updateStudent(int studentId,Student student) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student existingStudent = session.get(Student.class, studentId);
        existingStudent.setUserName(student.getUserName());
        existingStudent.setName(student.getName());
        existingStudent.setBirthdate(student.getBirthdate());
        existingStudent.setNumbers(student.getNumbers());
        existingStudent.setPassword(student.getPassword());
        session.update(existingStudent);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean deleteStudent(int studentId) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }



}

