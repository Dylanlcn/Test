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


<input type="button" value="Student"
	onclick="window.location.href='student-home'; return false;"
	class = "add-button"
/>


<input type="button" value="Admin"
	onclick="window.location.href='admin-home'; return false;"
	class = "add-button"
/>



<!--  Buttons for navigation -->




</div>

</div>

</body>

</html>