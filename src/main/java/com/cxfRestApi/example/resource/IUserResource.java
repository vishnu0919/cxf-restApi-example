package com.cxfRestApi.example.resource;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cxfRestApi.example.bean.UserBean;

import in.benchresources.cdm.user.User;

@Path("/userService")
public interface IUserResource {

	// http://localhost:8080/cxf-restApi-example/services/userService/getUser/564
	@GET
	@Path("getUser/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserInfo(@PathParam("id") int userId);
	
	
	// http://localhost:8080/cxf-restApi-example/services/userService/getUserBean/123
	@GET
	@Path("getUserBean/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public UserBean getUserDetails(@PathParam("id") int userId);
	
	// http://localhost:8080/cxf-restApi-example/services/userService/getUserBean/123
	@GET
	@Path("getUsers")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<UserBean> getAllUsers();
	
	// http://localhost:8080/cxf-restApi-example/services/userService/addUser
	@POST
	@Path("addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserBean addUser(UserBean bean);
	
	// Simple Get.
	// http://localhost:8080/cxf-restApi-example/services/userService/getName
	@GET
	@Path("getName")
	@Produces(MediaType.TEXT_PLAIN)
	public String getName();
	
	// @GET call with URL params
	// http://localhost:8080/cxf-restApi-example/services/printCustomName/347856
	@GET
	@Path("printCustomName/{user-id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String printCustomName(@PathParam("user-id") long userId);
	
	// Simple POST call
	// http://localhost:8080/cxf-restApi-example/services/userService/getName
	@POST
	@Path("getName")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addName(String name);
	
	
}
