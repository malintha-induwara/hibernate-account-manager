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


}

