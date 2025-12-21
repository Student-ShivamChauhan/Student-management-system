<%@ page import="java.util.*,dao.StudentDAO,model.Student" %>
<html>
<body>
<h2>Student List</h2>

<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Email</th>
</tr>

<%
List<Student> list = StudentDAO.getAllStudents();
for (Student s : list) {
%>
<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
</tr>
<% } %>

</table>
</body>
</html>
