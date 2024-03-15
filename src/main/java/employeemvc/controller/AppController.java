package employeemvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import employeemvc.dao.EmployeeDao;
import employeemvc.dto.Employee;

@Controller
public class AppController 
{
	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping("/test")
	public void test(HttpServletResponse resp) throws IOException
	{
		PrintWriter pw = resp.getWriter();
		pw.print("Solo");
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup()
	{
		ModelAndView view = new ModelAndView();
		view.addObject("employee", new Employee());
		view.setViewName("signup.jsp");
		return view;
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Employee employee)
	{
		employeeDao.saveEmployee(employee);
		ModelAndView view = new ModelAndView();
		view.setViewName("login.jsp");
		return view;
	}
	
//	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@RequestMapping("/login")
	public ModelAndView loginCheck(@RequestParam String email ,@RequestParam String password)
	{
		Employee emp = employeeDao.findByEmail(email);
		if(emp != null)
		{
			if(emp.getEmpPassword().equals(password))
			{
				ModelAndView view = new ModelAndView();
				view.addObject("empList", employeeDao.getAll());
				view.addObject("message", "Login SuccessFull");
				view.setViewName("home.jsp");
				return view;
			}
			return new ModelAndView("login.jsp");
		}
		return new ModelAndView("login.jsp");
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int empId)
	{
		ModelAndView view = new ModelAndView();
		employeeDao.deleteById(empId);
		view.addObject("empList", employeeDao.getAll());
		view.addObject("message", "One Record Deleted");
		view.setViewName("home.jsp");
		return view;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam int empId)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("employee", employeeDao.findById(empId));
		view.setViewName("edit.jsp");
		return view;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute Employee employee)
	{
		ModelAndView view = new ModelAndView();
		employeeDao.updateEmployee(employee, employee.getEmpId());
		view.addObject("empList", employeeDao.getAll());
		view.addObject("message", "One Record Edited");
		view.setViewName("home.jsp");
		return view;
	}
}
