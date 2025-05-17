package com.example.HibernateLearning.Service;

import com.example.HibernateLearning.Entity.Student;
import com.example.HibernateLearning.Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.List;

public class StudentService {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public void saveStudent(Student student){
        try(Session session = sessionFactory.openSession()){
            Transaction beginTransaction = session.beginTransaction();
            session.persist(student);
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // get by id
    public Student getbyId(int studentId){
        try(Session session = sessionFactory.openSession()) {
            Student student = session.get(Student.class,studentId);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //upadate student
    public Student updateStudent(int id , Student student){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student oldStudent = session.get(Student.class, id);
            if(oldStudent !=null){
                oldStudent.setName(student.getName());
                oldStudent.setAbout(student.getAbout());
                oldStudent.setPhone(student.getPhone());
                //***more information and be updated
                oldStudent = session.merge(oldStudent);
            }
            transaction.commit();
            return oldStudent;
        }
    }
    //delete student
    public void deleteStudent(int id){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class,id);
            if(student!=null){
                session.remove(student);
            }
            transaction.commit();
        }
    }
    //HQL // JPA --> database independent

    //get all students using HQL
    public List<Student> getallStudentsHQl(){
        try(Session session = sessionFactory.openSession()) {
            String getHQL = "FROM Student";
            Query<Student> query = session.createQuery(getHQL, Student.class);
            return query.list();
        }
    }

    //get student name by hql
    public Student getStudentNameByHql(String name){
        try(Session session = sessionFactory.openSession()){
            String getByNameQuery = "FROM Student WHERE name = :studentName";
            Query<Student> query = session.createQuery(getByNameQuery, Student.class);
            query.setParameter("studentName",name);
            return query.uniqueResult();
        }

    }
    //criteria api
    //get students having same college
    public List<Student> getStudentsOfSameCollege(String college){
        try (Session session = sessionFactory.openSession()){
            HibernateCriteriaBuilder hibernateCriteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Student> query = hibernateCriteriaBuilder.createQuery(Student.class);
            Root<Student> root = query.from(Student.class);
            query
                    .select(root)
                    .where(hibernateCriteriaBuilder
                            .equal(root.get("college"),college));
            Query<Student> query1 = session.createQuery(query);
            return query1.getResultList();

        }
    }
    //pagination
    public List<Student> getStudentwithPagination(int pageNo,int pageSize ){
        try(Session session = sessionFactory.openSession()) {
            String pageQuery = "FROM Student";
            Query<Student> query = session.createQuery(pageQuery, Student.class);
            query.setFirstResult((pageNo-1)*pageSize);
            query.setMaxResults(pageSize);
            return query.list();

        }
    }

}
