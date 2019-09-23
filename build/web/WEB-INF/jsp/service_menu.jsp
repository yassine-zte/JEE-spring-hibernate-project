<%-- 
    Document   : service_menu
    Created on : 19 oct. 2015, 14:03:20
    Author     : Abroun
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
	<title>Menu services</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
    <body>
        <h1>Page Sim Service Atttribution</h1>
               <c:url var="searchAction" value="/search_sim" ></c:url>

<form:form action="${searchAction}" commandName="sim">
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
		<td colspan="2">
			
			
				<input type="submit" 
					value="<spring:message text="Search Sim"/>" />
			
		</td>
	</tr>
</table>
<br/>                                                                                            
</form:form>
               
  <c:if test="${!empty simsearch}">
      <h3>numero cherché</h3>
	<table class="tg">
	<tr>
		<th width="80">Sim numero</th>
		<th width="120">Sim Serie</th>
                <th width="120">Sim Puk</th>
                <th width="120">Sim Pin</th>
                <th width="120">Sim Type</th>
	</tr>
       
	<tr>
			<td><c:out value="${simsearch.numerotel}"/></td>
			<td><c:out value="${simsearch.seriesim}"/></td>
			<td><c:out value="${simsearch.puk}"/></td>
                        <td><c:out value="${simsearch.pin}"/></td>
                        <td><c:out value="${simsearch.type}"/></td>
                        
			
	</tr>
	
        </table>
                        <h3>service activé</h3>  
        <table class="tg">
            
            <tr>
                <th width="80">id Service</th>
		<th width="120">service description</th>
                <th width="120">action</th>
            </tr>
            <c:forEach items="${optionsNum}" var="op">
            <tr>
                <td><c:out value="${op.idservice}"/></td>
                <td><c:out value="${op.description}"/></td>
                <td><a href="<c:url value='/remove_serviceactivate/${op.idservice}&${simsearch.numerotel}' />" >Delete</a></td>
            </tr>
            </c:forEach>
        </table>
  
                        <h2> Attribuer un service au numero</h2>  
                        
                        <c:url var="attribuerAction" value="/attribut_service" ></c:url>
         <form:form action="${attribuerAction}" commandName="option">
<table>
	
     
       
      
         <tr>
             <td>
			 <%--<form:label path="option.idservice">
				<spring:message text="Option"/>
			</form:label>--%>
		</td>
		<td>
                    <form:select     path="idservice">
                        <%--<c:if test="${empty varedit}">
                        <form:option value="-1" label="--- Select ---" />
                        </c:if>
                        --%>
                            <form:option value="-1" label="--- Select ---" />
                            <c:forEach items="${optionsToActivt}" var="servToAct">
                                <form:option  value="${servToAct.idservice}">${servToAct.description}</form:option>
                                </c:forEach>  
	               <spring:message text="Option"/>
                    </form:select>
                    
		</td>
              
		
	</tr>
	<tr>
            <td>
			
				<input type="submit" 
					value="<spring:message text="Attribuer Option"/>" />
			
		</td>
	</tr>
</table>	
</form:form>
   
  </c:if>
    </body>
</html>
