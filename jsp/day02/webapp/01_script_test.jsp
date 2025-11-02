<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example</title>
</head>
<body>
	<h1>Script Tag</h1>
	<hr>
	<!-- JSP Declaration -->
	<%! 
		int count = 10;
		String makeLower(String data){
			return data.toLowerCase();
		}
	%>
	<br>
	<table>
		<tr><td>Hello<%=makeLower("My Name is Mr.Owen")%></td></tr>	
	</table>
	<br>
	<!-- JSP Scriptlet -->
	<% 
		out.println("This is My First JSP Code!!<br>");
		for(int i=0; i<count; i++){
			out.println("Current I : " + i + "<br>");
		}
	%>
	<br>
	<!-- JSP Expression Tag -->
	<!-- Use no semicolon(;) -->
	<input type="text" value="My Name is Mr.Owen"><br>
	<input type="text" value="<%=makeLower("My Name is Mr.Owen")%>"><br>
	<h1><%=makeLower("My Name is Mr.Owen")%></h1>
	<button><%=makeLower("My Name is Mr.Owen")%></button>
</body>
</html>