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
		<h2> Student Table </h2>
		</div>
		</div>

<div id="container">

<div id="content">


<input type="button" value="App Form"
	onclick="window.location.href='students-form'; return false;"
	class = "add-button"
/>


<input type="button" value="App Status"
	onclick="window.location.href='appstatus'; return false;"
	class = "add-button"
/>

<input type="button" value="Request Room"
	onclick="window.location.href='showFormForApp'; return false;"
	class = "add-button"
/>

<input type="button" value="Room Status"
	onclick="window.location.href='showFormForApp'; return false;"
	class = "add-button"
/>

<!--  Buttons for navigation -->



<table>

<tr>
		<th>Application Number</th>
		<th>Application Status</th>
	
</tr>

		<c:forEach var = "tempStudent" items="${students}">
		
		
		
		<!--  embeded student ID -->
		
	<c:url var="updateLink" value="/student/showFormForUpdate">
	<c:param name ="studentId" value ="${tempStudent.id}"/>
	
	</c:url>
	
	<c:url var="deleteLink" value="/student/delete">
	<c:param name ="studentId" value ="${tempStudent.id}"/>
	
	</c:url>
	
	
	
	<tr>
		<td> ${tempStudent.id} </td>
		<td> ${tempStudent.status} </td>

		

		
		</tr>
		
		</c:forEach>


</table>


</div>

</div>

</body>

</html>