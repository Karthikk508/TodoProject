<%@include file = "common/header.jspf" %>
<%@include file = "common/navigations.jspf" %>
	
	  <div class = "container">
	  
			<h1>Add todos </h1>
			
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
		
			  
			    <form:input type = "hidden" path = "id"/> <br>
			    <form:input type = "hidden" path = "done"/> <br>
			    <input type = "submit" class="btn btn-success"/>
			
			</form:form>
			
	  </div>
	   
<%@include file = "common/footer.jspf" %>


