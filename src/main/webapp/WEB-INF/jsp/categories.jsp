<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th>Category Id</th>
      <th>Category Name</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="category" items="${categories}">
									<tr>
									<td scope="row">
									${category.categoryId}
									</td>
										<td scope="row">${category.category}</td>
									<td>
									<a href="category/${category.categoryId}">Edit
									</a>
									</td>
									<td>
									<a href="category/${category.categoryId}">Delete
									</a>
									</td>	
										
									</tr>
								</c:forEach>
  </tbody>
</table>
<div class="container">
<a href="" class="btn btn-primary btn-lg" role="button" aria-pressed="true">Add Category</a>
</div>
</body>
</html>