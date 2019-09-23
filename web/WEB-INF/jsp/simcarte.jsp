<%-- 
    Document   : simcarte
    Created on : 6 sept. 2015, 15:53:52
    Author     : Abroun
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
	<title>Sim Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
    <body>
        <h1>Ajouter une carte sim</h1>
        
        <c:url var="addAction" value="/sim/add" ></c:url>

<form:form action="${addAction}" commandName="sim">
<table>
	
       <tr>
		<td>
			<form:label path="numerotel">
				<spring:message text="Numerotel"/>
			</form:label>
		</td>
		<td>
			<form:input path="numerotel" />
		</td> 
	</tr>
        <tr>
		<td>
			<form:label path="seriesim">
				<spring:message text="Seriesim"/>
			</form:label>
		</td>
		<td>
			<form:input path="seriesim" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="puk">
				<spring:message text="Puk"/>
			</form:label>
		</td>
		<td>
			<form:input path="puk" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="pin">
				<spring:message text="Pin"/>
			</form:label>
		</td>
		<td>
			<form:input path="pin" />
		</td>
	</tr>
        <tr>
		<td>
			<form:label path="type">
				<spring:message text="Type"/>
			</form:label>
		</td>
		<td>
			<form:input path="type" />
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
                        <c:if test="${empty varedit}">
                        <form:option value="-1" label="--- Select ---" />
                        </c:if>
                         <c:if test="${!empty varedit}">
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
			<c:if test="${!empty varedit}">
                            <input type="submit" 
					value="<spring:message text="Edit Sim"/>" />
			</c:if>
			<c:if test="${empty varedit}">
				<input type="submit" 
					value="<spring:message text="Add Sim"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
        <br>
<h3>Phones List</h3>
<c:if test="${!empty listSims}">
	<table class="tg">
	<tr>
		<th width="80">Sim numero</th>
		<th width="120">Sim Serie</th>
                <th width="120">Sim Puk</th>
                <th width="120">Sim Pin</th>
                <th width="120">Sim Type</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listSims}" var="sim">
		<tr>
			<td>${sim.numerotel}</td>
			<td>${sim.seriesim}</td>
			<td>${sim.puk}</td>
                        <td>${sim.pin}</td>
                        <td>${sim.type}</td>
                        
			<td><a href="<c:url value='/edit_sim/${sim.numerotel}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove_sime/${sim.numerotel}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
    </body>
</html>
