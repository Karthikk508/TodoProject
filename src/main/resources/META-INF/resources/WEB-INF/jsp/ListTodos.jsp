<%@include file = "common/header.jspf" %>
<%@include file = "common/navigations.jspf"%>
	
		<div class="container">
	
			<h1>Here is the list of your TODOS:</h1>
	
			<table class="table">
				<thead>
					<tr>
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
							<td>${todo.username}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href="update-todo?id=${todo.id}"
								class="btn btn-success">Update</a>
							<td><a href="delete-todo?id=${todo.id}"
								class="btn btn-warning">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
			<a href="add-todos" class="btn btn-success"> Add Todo</a>
	
		</div>
	
<%@include file="common/footer.jspf"%>
	

