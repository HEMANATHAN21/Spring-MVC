package employeemvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import employeemvc.dto.Employee;



@Component
public class EmployeeDao 
{
	@Autowired
	EntityManager em;
	@Autowired
	EntityTransaction et;
	
	public Employee saveEmployee(Employee employee)
	{
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		return employee;
	}
	
	public Employee findById(int empId)
	{
		Employee exEmployee = em.find(Employee.class, empId);
		if(exEmployee != null)
		{
			return exEmployee;
		}
		return null;
	}
	
	public Employee deleteById(int empId)
	{
		Employee exEmployee = em.find(Employee.class, empId);
		if(exEmployee != null)
		{
			em.getTransaction().begin();
			em.remove(exEmployee);
			em.getTransaction().commit();
			return exEmployee;
		}
		return null;
	}
	
	public Employee updateEmployee(Employee employee, int empId)
	{
		Employee exEmployee = em.find(Employee.class, empId);
		if(exEmployee != null)
		{
			em.getTransaction().begin();
			employee.setEmpId(empId);
			Employee updated = em.merge(employee);
			em.getTransaction().commit();
			return updated;
		}
		return null;
	}
	
	public List<Employee> getAll()
	{
		Query query = em.createQuery("select e from Employee e");
		List<Employee> allEmployees = query.getResultList();
		return allEmployees;
	}
	
	public Employee findByEmail(String empEmail)
	{
		Query query = em.createQuery("select e from Employee e where e.empEmail = ?1");
		query.setParameter(1, empEmail);
		Employee employee = (Employee) query.getSingleResult();
		return employee;
	}
}
