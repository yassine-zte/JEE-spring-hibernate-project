<%-- 
    Document   : phone
    Created on : 25 août 2015, 16:11:04
    Author     : Abroun
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
	<title>Phone Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
    <body>
        <h1>Ajouter un Portable</h1>
        
        <c:url var="addAction" value="/phone/add" ></c:url>

<form:form action="${addAction}" commandName="phone">
<table>
	<c:if test="${!empty phone.marque}">
	<tr>
		<td>
			<form:label path="idphone">
				<spring:message text="IDPHONE"/>
			</form:label>
		</td>
		<td>
			<form:input path="idphone" readonly="true" size="8"  disabled="true" />
			<form:hidden path="idphone" />
		</td> 
	</tr>
	</c:if>
       
        <tr>
		<td>
			<form:label path="marque">
				<spring:message text="Marque"/>
			</form:label>
		</td>
		<td>
			<form:input path="marque" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="serial">
				<spring:message text="serial"/>
			</form:label>
		</td>
		<td>
			<form:input path="serial" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="seriephone">
				<spring:message text="Seriephone"/>
			</form:label>
		</td>
		<td>
			<form:input path="seriephone" />
		</td>
	</tr>
        
      
         <tr>
             <td>
			<form:label path="employee.idpersonne">
				<spring:message text="Employee"/>
			</form:label>
		</td>
		<td>
                    <form:select     path="employee.idpersonne">
                        <c:if test="${empty phone.marque}">
                        <form:option value="-1" label="--- Select ---" />
                        </c:if>
                         <c:if test="${!empty phone.marque}">
                        <form:option value="${emp.idpersonne}" var="emp" label="${emp.name}" />
                        </c:if>
                            <c:forEach items="${listEmployees}" var="employees">
                                <form:option  value="${employees.idpersonne}">${employees.nom}</form:option>
                                </c:forEach>  
	               <spring:message text="Employee"/>
                    </form:select>
                    
		</td>
              
		
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty phone.marque}">
                            <input type="submit" 
					value="<spring:message text="Edit Phone"/>" />
			</c:if>
			<c:if test="${empty phone.marque}">
				<input type="submit" 
					value="<spring:message text="Add Phone"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
        <br>
<h3>Phones List</h3>
<c:if test="${!empty listPhones}">
	<table class="tg">
	<tr>
		<th width="80">Phone ID</th>
		<th width="120">Phone Marque</th>
		<th width="120">Phone Serial</th>
                <th width="120">Phone Serie</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPhones}" var="phone">
		<tr>
			<td>${phone.idphone}</td>
			<td>${phone.marque}</td>
			<td>${phone.seriephone}</td>
                        <td>${phone.serial}</td>
                        
			<td><a href="<c:url value='/edit_phone/${phone.idphone}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove_phone/${phone.idphone}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
    </body>
</html>
