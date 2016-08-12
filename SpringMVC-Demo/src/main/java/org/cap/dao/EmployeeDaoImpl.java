package org.cap.dao;

import java.util.List;

import org.cap.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		
	}
	@Override
	public Employee getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Employee p = (Employee) session.load(Employee.class, new Integer(id));
		return p;
	}

	@Override
	public List<Employee> getAllEmployees() {
	
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		if(emp!=null)
			sessionFactory.getCurrentSession().delete(emp);
		
	}
	@Override
	public void updateEmployee(Employee e) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(e);
			//logger.info("Person updated successfully, Person Details="+p);
		}
		
	}


