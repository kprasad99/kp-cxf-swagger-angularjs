package com.kp.swasthik.cxf.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.kp.swasthik.cxf.db.domain.Employee;

import io.swagger.annotations.Api;

@Api("/employees")
@Path("/employees")
@CrossOriginResourceSharing(allowAllOrigins = true)
public interface EmployeeResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	boolean addAll(List<Employee> employee);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Employee> getAll();
	
	@PUT
	@Path("/{empId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	boolean add(@PathParam("empId") int empId, Employee employee);
	
	@GET
	@Path("/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	Employee get(@PathParam("empId") int empId);
	
	@PUT
	@Path("/{empId}/age/{empAge}")
	@Produces(MediaType.TEXT_PLAIN)
	int updateAge(@PathParam("empId") int empId, @PathParam("empAge") int age);
	
	
	
}
