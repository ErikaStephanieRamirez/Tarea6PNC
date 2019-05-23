package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Student> findAll() throws DataAccessException{
		//TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.student");
		Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
		List<Student> resulset =query.getResultList();
		return resulset;
	}
	
	@Override
	public Student findOne(Integer code) throws DataAccessException{
		//TODO Auto-generated method stub
		Student student = entityManager.find(Student.class, code);
		return student;
	}
	
	@Transactional
	public int save(Student s, Integer newRow) throws DataAccessException{
		try {
			if(newRow == 1) entityManager.persist(s);
			else entityManager.merge(s);
			entityManager.flush();
			return 1;
		}catch(Throwable e){
			e.printStackTrace();
			return 1;
		}
	}
	
	@Transactional
	public int update(Student s) throws DataAccessException {
		try {
			 entityManager.merge(s);
			 entityManager.flush();
			return 1;
		}
		catch(Throwable e) {
			e.printStackTrace();
			return 1;
		}	
	}
	
	
	@Transactional
	public int delete(Integer name) throws DataAccessException {
		try{
			StringBuffer sb= new StringBuffer();
			sb.append("select * from public.student where id_student=:name");
			Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
			query.setParameter("name", name);
			Student result= (Student) query.setMaxResults(1).getSingleResult();
			entityManager.remove(result);
			return 1;
		}catch (Throwable e) {
			e.printStackTrace();
			return 1;
		}
	}
}
