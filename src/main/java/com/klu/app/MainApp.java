package com.klu.app;
import com.klu.model.Department;
import com.klu.model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.klu.util.HibernateUtil;

import java.util.*;

public class MainApp {
	public static SessionFactory factory=HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("-----Main Menu-----");
			
			System.out.println("1) Insert Employee");
			System.out.println("2) Display Employee");
			System.out.println("3) Update Employee");
			System.out.println("4) Delete Employee");
			System.out.println("5) Exit");
			System.out.println("Select your choice:");
			choice =sc.nextInt();
			switch(choice) {
			case 1:insertEmployee(sc);
					break;
			case 2:displayEmployee(sc);
			break;
			case 3:updateEmployee(sc);
			break;
			case 4:deleteEmployee(sc);
			break;
			case 5:System.out.println("Thank you");
			break;
			default :
				System.out.print("Wrong Input");
				break;
			}
			
		}while(choice!=5);
		factory.close();
		session.close();
	}
	static void deleteEmployee(Scanner sc) {
		Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Employee Id: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            session.delete(emp);
            tx.commit();
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Employee Not Found");
        }

        session.close();
    }
		
	
		
		
	
	static void updateEmployee(Scanner sc) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Employee Id: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            emp.setEmpSalary(salary);
            session.update(emp);

            tx.commit();
            System.out.println("Employee updated successfully");
        } else {
            System.out.println("Employee Not Found");
        }

        session.close();
    }
		
		
	
	static void displayEmployee(Scanner sc) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		System.out.println("Enter Employee Id: ");
		int id =sc.nextInt();
		Employee emp=session.get(Employee.class, id);
		if (emp!=null) {
			System.out.println("Name  : "+emp.getEmpName());
			System.out.println("Salary: "+emp.getEmpSalary());
			System.out.println("Dept  : "+emp.getDepartment().getDeptName());
			
		}
		else {
			System.out.println("Enployee Not Found");
			
		}
		session.close();
	}
	static void insertEmployee(Scanner sc) {
		// TODO Auto-generated method stub
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		
		System.out.print("Enter Employee Name:  ");
		String ename=sc.next();
		
		System.out.println("Enter Employee salary: ");
		double sal=sc.nextDouble();
		
		System.out.println("Enter Dept Name: ");
		String deptName=sc.next();
		
		Department dept=new Department();
		dept.setDeptName(deptName);
		 
		Employee emp=new Employee();
		emp.setEmpName(ename);
		emp.setEmpSalary(sal);
		emp.setDepartment(dept);
		
		session.persist(dept);
		session.persist(emp);
		
		tx.commit();
		session.close();
		
		System.out.println("Employee inserted successfully");
	}
}
