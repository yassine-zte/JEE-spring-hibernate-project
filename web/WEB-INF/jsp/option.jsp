<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
	<title>Service Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
    <body>
        <h1>Ajouter un service</h1>
        
        <c:url var="addAction" value="/service/add" ></c:url>

<form:form action="${addAction}" commandName="service">
<table>
	<c:if test="${!empty service.nomService}">
	<tr>
		<td>
			<form:label path="idservice">
				<spring:message text="IDSERVICE"/>
			</form:label>
		</td>
		<td>
			<form:input path="idservice" readonly="true" size="8"  disabled="true" />
			<form:hidden path="idservice" />
		</td> 
	</tr>
	</c:if>
        
       
        <tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="nomService">
				<spring:message text="NomService"/>
			</form:label>
		</td>
		<td>
			<form:input path="nomService" />
		</td> 
	</tr>
	
		
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty service.nomService}">
                            <input type="submit" 
					value="<spring:message text="Edit Service"/>" />
			</c:if>
			<c:if test="${empty service.nomService}">
				<input type="submit" 
					value="<spring:message text="Add Service"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
        <br>
<h3>Employees List</h3>
<c:if test="${!empty listServices}">
	<table class="tg">
	<tr>
		<th width="80">Service ID</th>
		<th width="120">Service nom</th>
		<th width="120">Service Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listServices}" var="service">
		<tr>
			<td>${service.idservice}</td>
			<td>${service.nomService}</td>
			<td>${service.description}</td>
                        
                       
			<td><a href="<c:url value='/edit_service/${service.idservice}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove_service/${service.idservice}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
    </body>
</html>
