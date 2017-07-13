package com.cxfRestApi.example.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.stereotype.Service;

import com.cxfRestApi.example.bean.UserBean;

import in.benchresources.cdm.user.User;

@Service("userResource")
public class IUserResourceImpl implements IUserResource {

	@Override
	public User getUserInfo(int userId) {
		System.out.println("In IUserResourceImpl class and getUserInfo() method *************");
		String username = "Siddharth";
		
		GregorianCalendar gcal = new GregorianCalendar();
		
		User user = new User();
		user.setUserId(userId);
		user.setFirstName("Siddharth");
		user.setLastName("Mannem");
		user.setMatches(1);
		user.setSalary(5000.00);
		try {
			user.setDob(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal));
			
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public UserBean getUserDetails(int userId) {

		System.out.println("In IUserResourceImpl class and getUserDetails() method #############");

		UserBean userBean = new UserBean();

		if(userId == 32) {
			userBean.setUserId(userId);
			userBean.setFirstName("Robert");
			userBean.setLastName("Jr");
		} else if (userId == 546) {
			userBean.setUserId(userId);
			userBean.setFirstName("Steve");
			userBean.setLastName("Rogers");
		} else {
			userBean.setUserId(userId);
			userBean.setFirstName("Roger");
			userBean.setLastName("Moore");
		}
		
		return userBean;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		String str = "Hello Restful service... Welcome!!!!";
		
		return str;
	}

	@Override
	public String addName(String name) {
		
		System.out.println("In IUserResourceImpl class and addName() method #############");
		System.out.println("POst body String you entered: " + name);
		UserBean userBean = new UserBean();
		userBean.setLastName(name);
		
		return "Hello... " + name;
	}

	@Override
	public String printCustomName(long userId) {
		System.out.println("In IUserResourceImpl class and printCustomName() method #############");
		System.out.println("Entered User-ID : " + userId);
		
		if(userId == 45712L) {
			return "Hello MicroInfo... ";
		} else if (userId == 24341L) {
			return "Hello Apple Inc...";
		} else {
			return "Hello Uber...";
		}
		
	}

	@Override
	public Collection<UserBean> getAllUsers() {
		System.out.println("In IUserResourceImpl class and getAllUsers() method #############");

		List<UserBean> userBeanList = new ArrayList<>();
		
		UserBean userBean1 = new UserBean();
		userBean1.setUserId(32);
		userBean1.setFirstName("Robert");
		userBean1.setLastName("Jr");
		
		UserBean userBean2 = new UserBean();
		userBean2.setUserId(546);
		userBean2.setFirstName("Steve");
		userBean2.setLastName("Rogers");
		
		UserBean userBean3 = new UserBean();
		userBean3.setUserId(47856);
		userBean3.setFirstName("Roger");
		userBean3.setLastName("Moore");
		
		userBeanList.add(userBean1);
		userBeanList.add(userBean2);
		userBeanList.add(userBean3);
		
		return userBeanList;
		
	}

	@Override
	public UserBean addUser(UserBean bean) {
		System.out.println("In IUserResourceImpl class and addUser() method #############");
		System.out.println("Values you entered: ");
		System.out.println("UserId: " + bean.getUserId());
		System.out.println("FirstName: " + bean.getFirstName());
		System.out.println("LastName: " + bean.getLastName());

		// Call SErvice layer and from there DAO Layer
		
		bean.setFirstName("Ent - " + bean.getFirstName());
		bean.setLastName("Ent - " + bean.getLastName());
		
		return bean;
	}
}
