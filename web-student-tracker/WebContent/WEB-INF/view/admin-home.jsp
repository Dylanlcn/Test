<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

<title>List Customers</title>



<!--  reference style sheet -->
			
			<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" />
				

</head>

<body>

     <div id="wrapper">

		<div id="header">
		<h2>   <a href="${pageContext.request.contextPath}/student/home">
    Administration
  </a> </h2>
		</div>
		</div>


<div id="container">

<div id="content">


<input type="button" value="View Pending Apps"
	onclick="window.location.href='admin-home'; return false;"
	class = "add-button"
/>


<input type="button" value="View All Apps"
	onclick="window.location.href='admin-all'; return false;"
	class = "add-button"
/>


<table>

<tr>
		<th>Application #</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Action</th>
</tr>

		<c:forEach var = "tempStudent" items="${students}">
		
		
		
		<!--  embeded student ID -->
		
	<c:url var="updateLink" value="/student/approve">
	<c:param name ="studentId" value ="${tempStudent.id}"/>
	
	</c:url>
	
	<c:url var="deleteLink" value="/student/reject">
	<c:param name ="studentId" value ="${tempStudent.id}"/>
	
	</c:url>
	
	
	
	<tr>
		<td> ${tempStudent.id} </td>
		<td> ${tempStudent.firstName} </td>
		<td> ${tempStudent.lastName} </td>
		
		<td>
		
		<a href= "${updateLink}"		
		
		onclick="if (!(confirm('Are you sure you want to Approve?'))) return false">Approve</a>
		
		
		
		<a href= "${deleteLink}"
				
			onclick="if (!(confirm('Are you sure you want to reject?'))) return false">Reject</a>
		
		
		
		
		
		</td>
		
		</tr>
		
		</c:forEach>


</table>


</div>

</div>

</body>

</html>