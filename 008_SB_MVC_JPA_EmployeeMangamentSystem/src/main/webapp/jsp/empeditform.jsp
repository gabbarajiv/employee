<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@page isELIgnored="false" %>

		<h1>Edit Employee</h1>
       <form:form method="POST" action="editsave" modelAttribute="employee">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="eno" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="ename"  /></td>
         </tr>  
         <tr>  
          <td>EmployeeAddress :</td>  
          <td><form:input path="eadd" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
