<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

   <head>
   
      <title>Update</title>
      <%@include file = "common/header.jspf" %>
      <%@include file = "common/navigations.jspf" %>
   
  
   </head>
   
   <body>
   
     <div class = "container">   
     
     <div style = "margin-bottom : 30px;"></div>
     
     <h1> Enter the details that you want to update, your id is ${id} </h1>
     
     <div style = "margin-bottom : 30px;"></div>
     
 
     <form:form method = "post" modelAttribute = "todo">
     
	        <fieldset class = "mb-3">
		         <form:label path = "description" > Description </form:label>
			     <form:input type = "text" path = "description" required = "required"/>
			     <form:errors path = "description" cssClass = "text-warning"/>
		    </fieldset>
		    
		    <fieldset class = "mb-3">
		         <form:label path = "targetDate" > Target date </form:label>
			     <form:input type = "text" path = "targetDate" required = "required"/>
			     <form:errors path = "targetDate" cssClass = "text-warning"/>
		    </fieldset>
        
        
	        <input type = "submit" class = "btn btn-success">
	     
	     
     </form:form>
     
     </div>
     
     <%@include file = "common/footer.jspf" %>
	
   </body>

</html>
