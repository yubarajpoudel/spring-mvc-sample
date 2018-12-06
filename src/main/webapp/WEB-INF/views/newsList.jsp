<%@page import="com.yuvi.testapp.model.News"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>News List</h1>

	<table>

		<tr>
			<td>Title</td>
		</tr>

		 
		 <%     List<News> nlist = (List<News>)request.getAttribute("newsList"); 
		 
		    for(News n : nlist){
		    	
		  %>
		  
		  
		  <tr>
				<td><%= n.getTitle() %></td>
			</tr>
		  
		    	
		 <% } %>

			



	</table>
</body>
</html>
