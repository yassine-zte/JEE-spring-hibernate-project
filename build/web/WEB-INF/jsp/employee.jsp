<%-- 
    Document   : employee
    Created on : 1 août 2015, 14:21:52
    Author     : Abroun
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
    <body>
        <h1>Ajouter un Employee</h1>
        
        <c:url var="addAction" value="/employee/add" ></c:url>

<form:form action="${addAction}" commandName="employee">
<table>
	<c:if test="${!empty employee.nom}">
	<tr>
		<td>
			<form:label path="idpersonne">
				<spring:message text="IDPERSONNE"/>
			</form:label>
		</td>
		<td>
			<form:input path="idpersonne" readonly="true" size="8"  disabled="true" />
			<form:hidden path="idpersonne" />
		</td> 
	</tr>
	</c:if>
       
        <tr>
		<td>
			<form:label path="matricule">
				<spring:message text="Matricule"/>
			</form:label>
		</td>
		<td>
			<form:input path="matricule" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="nom">
				<spring:message text="Nom"/>
			</form:label>
		</td>
		<td>
			<form:input path="nom" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="prenom">
				<spring:message text="Prenom"/>
			</form:label>
		</td>
		<td>
			<form:input path="prenom" />
		</td>
	</tr>
        <tr>
		<td>
			<form:label path="fonction">
				<spring:message text="Fonction"/>
			</form:label>
		</td>
		<td>
			<form:input path="fonction" />
		</td>
	</tr>
        <tr>
		<td>
			<form:label path="cin">
				<spring:message text="Cin"/>
			</form:label>
		</td>
		<td>
			<form:input path="cin" />
		</td>
	</tr>
        <tr>
		<td>
			<form:label path="dateaquise">
				<spring:message text="Dateaquise"/>
			</form:label>
		</td>
		<td>
			<form:input path="dateaquise" />
		</td>
	</tr>
         <tr>
             <td>
			<form:label path="departement.iddepartement">
				<spring:message text="Departement"/>
			</form:label>
		</td>
		<td>
                    <form:select     path="departement.iddepartement">
                        <c:if test="${empty employee.nom}">
                        <form:option value="-1" label="--- Select ---" />
                        </c:if>
                         <c:if test="${!empty employee.nom}">
                        <form:option value="${demp.iddepartement}" var="demp" label="${demp.departementName}" />
                        </c:if>
                            <c:forEach items="${listDepartements}" var="departements">
                                <form:option  value="${departements.iddepartement}">${departements.departementName}</form:option>
                                </c:forEach>  
	               <spring:message text="Departement"/>
                    </form:select>
                    
		</td>
              
		
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.nom}">
                            <input type="submit" 
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty employee.nom}">
				<input type="submit" 
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
        <br>
<h3>Employees List</h3>
<c:if test="${!empty listEmployees}">
	<table class="tg">
	<tr>
		<th width="80">Employee ID</th>
		<th width="120">Employee Matricule</th>
		<th width="120">Employee Nom</th>
                <th width="120">Employee Prenom</th>
                <th width="120">Employee Fonction</th>
                <th width="120">Employee Cin</th>
                <th width="120">Employee Date Aquise</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="employee">
		<tr>
			<td>${employee.idpersonne}</td>
			<td>${employee.matricule}</td>
			<td>${employee.nom}</td>
                        <td>${employee.prenom}</td>
                        <td>${employee.fonction}</td>
                        <td>${employee.cin}</td>
                        <td>${employee.dateaquise}</td>
			<td><a href="<c:url value='/edit_employee/${employee.idpersonne}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove_employee/${employee.idpersonne}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
    </body>
</html>
