<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
<style type="text/css">
.errMsg{
	color: red;
	font-size: 14px;
	font-weight: bold;
}
</style>

</head>
<body>
<form:form action="empSave" method="post" commandName="emp">
	<h2 align="center">Employee</h2>
	
	<table>
		<%-- <tr>
			<td>EmployeeId:</td>
			<td>
				<form:input path="empId"/>
			</td>
		</tr> --%>
		<tr>
			<td>FirstName:</td>
			<td>
				<form:input path="firstName"/>
			</td>
			<td>
				<form:errors cssClass="errMsg" path="firstName"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>LastName:</td>
			<td>
				<form:input path="lastName"/>
			</td>
			<form:errors cssClass="errMsg" path="lastName"></form:errors>
			<td>
			</td>
		</tr>
		
		
		<tr>
			<td>Email:</td>
			<td>
				<form:input path="email"/>
			</td>
			<td>
			<form:errors cssClass="errMsg" path="email"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Date of Birth:</td>
			<td>
				<form:input path="empDob"/>
			</td>
			<td>
			<form:errors cssClass="errMsg" path="empDob"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Date Of Joining:</td>
			<td>
				<form:input path="empDoj"/>
			</td>
			<td>
			<form:errors cssClass="errMsg" path="empDoj"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Address:</td>
			<td>
				<form:input path="address"/>
			</td>
			<td>
			<form:errors cssClass="errMsg" path="address"></form:errors>
			</td>
		</tr>
		
		
		<tr>
			<td>Phone:</td>
			<td>
				<form:input path="phone"/>
			</td>
			<td>
			<form:errors cssClass="errMsg" path="phone"></form:errors>
			</td>
	   </tr>
		   
		   
		   
		<td>Project:</td>
			<td>
			<c:if test="${!empty roles}">
				<form:select path="project">
					<c:forEach var="proje" items="${proj}">
						<form:option value="${proje}">${proje}</form:option>
					</c:forEach>
				
				</form:select>
			</c:if>
			</td>
			<td>
			</td>
		
		<td>Roles</td>
			<td>
			<c:if test="${!empty roles}">
				<form:select path="role">
					<c:forEach var="rol" items="${roles}">
						<form:option value="${rol}">${rol}</form:option>
					</c:forEach>
				
				</form:select>
			</c:if>
			</td>
			<td>
			</td>
		
		<td>Departments</td>
			<td>
			<c:if test="${!empty deps }">
				<form:select path="department">
					<c:forEach var="depart" items="${deps}">
						<form:option value="${depart}">${depart}</form:option>
					</c:forEach>
				
				</form:select>
			</c:if>
			</td>
			<td>
			</td>
		
		
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" name="save" value="Save">
			</td>
			<td>
			</td>
		</tr>
	
	</table>
	
</form:form>

<c:if test="${!empty employees }">
	<table>
		<tr>
			<th>EmployeeId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email:</th>
			<th>Address</th>
			<th>DateOf Birth</th>
			<th>Date of joining</th>
			<th>Phone:</th>
			<th>Department:</th>
			<th>Project:</th>
			<th>Role:</th>			
			<th>Edit</th>
			
		</tr>
		
		<c:forEach var="employee" items="${employees}">
		<tr>
			<td>${employee.empId}</td>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.email}</td>
			<td>${employee.address}</td>
			<td>${employee.empDob}</td>
			<td>${employee.empDoj}</td>
			<td>${employee.phone}</td>
			<td>${employee.department}</td>
			<td>${employee.project}</td>
			<td>${employee.role}</td>
			<c:if test="${!empty employees.name}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<td>
				<a href="deleteEmployee/${employee.empId}">Delete</a>
				&nbsp;&nbsp;&nbsp;
				<a href="edit/${employee.empId}">Update</a>
				&nbsp;&nbsp;&nbsp;
			</td>
			
		</tr>
		</c:forEach>
	</table>

</c:if>



</body>
</html>