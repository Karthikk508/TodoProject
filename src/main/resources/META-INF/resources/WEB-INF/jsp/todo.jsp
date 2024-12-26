<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
	
	    <link href = "webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel = "stylesheet">  </link>
	
		<title>Add todo</title>
	
	</head>
	
	<body>
		<div class = "container">
		
			<h1>Add todos </h1>
			
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
			
			
				  
				  
			  <form:input type = "hidden" path = "id"/> <br>
			  <form:input type = "hidden" path = "done"/> <br>
			  <input type = "submit" class="btn btn-success"/>
			
			</form:form>
		
			
		</div>
	</body>
	
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js">  </script>
	<script src="webjars/jquery/3.6.0/jquery.min.js">  </script>

</html>