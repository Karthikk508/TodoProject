<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>

	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>Todos</title>
	</head>
	
	<body>
	
		<div class="container">
	
			<h1>Here is the list of your TODOS:</h1>
	
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Username</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.username}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td> 
							<td> <a href = "update-todo?id=${todo.id}" class = "btn btn-success" >Update</a>
							<td> <a href = "delete-todo?id=${todo.id}" class = "btn btn-warning">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a href = "add-todos" class = "btn btn-success" > Add Todo</a>
	
		</div>
	
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js">  </script>
		<script src="webjars/jquery/3.6.0/jquery.min.js">  </script>
	
	</body>
	
</html>
