<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

   <head>
   
   <title>Update</title>
   
   <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
   
   </head>
   
   <body>
   
     <div class = "container">   
     
     <h1> Enter the details that you want to update, your id is ${id} </h1>
     
     <form:form method = "post" modelAttribute = "todo">
     
        Description : <form:input type = "text" path = "description" required = "required"/> <br>
                      <form:errors path = "description" cssClass = "text-warning"/> <br>
        
        
        <input type = "submit" class = "btn btn-success">
     
     
     </form:form>
     
     </div>
     
     
     
   
     
     <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js">  </script>
	 <script src="webjars/jquery/3.6.0/jquery.min.js">  </script>
	 
  
   </body>

</html>