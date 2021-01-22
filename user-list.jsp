<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.model.User" %>
<%@ page import="com.example.dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="icon" href="images/logo.jpg">
	<title>TestSCG Database</title>
	
		<style>
			body{ 
				background-color: #778899;
			}
	
			.centeral {
				text-align: center;
			}
			
			.sbmt {
				  text-align: center;
				  width: auto;
				  padding: 5px;
				  margin: auto;
				  margin-top: 5px;
				  margin-bottom: 20px;
			}
			
			.userTable {
				 	text-align: center;
					margin: auto;
					width: auto;
			}
			
			.table {
					margin: auto;
					max-width: 500px;
					background-color: #FFFFF0;
			}
			
			input[type=submit] {
				padding:15px 15px;
				width: 100px;
				background:#ccc;
				border:0 none;
				cursor:pointer;
				transition: 0.2s;
				-webkit-border-radius: 5px;
				border-radius: 5px;
			}
			
			input[type=submit]:hover {
				background: #90EE90;
				width: 150px;
				transition: 0.2s;
			}
		</style>
	
</head>
<body>
	<div class="centeral">
		<h1>
			<strong>Database</strong>
		</h1>	
	</div>

    <div class="userTable">
        <table class="table" border="1" cellpadding="5">
            <caption>
            	<font style="text-decoration: underline;">
            		List of Users
            	</font>
            </caption>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
            </tr>
            <%
				ArrayList<User> Users = new ArrayList<User>();
				Users = UserDao.getUsers();
				int i;
				for(i=0; i<Users.size();i++) {
			%>
            <tr>
               <td><%= Users.get(i).getName() %></td>
               <td><%= Users.get(i).getAge() %></td>
               <td><%= Users.get(i).getEmail() %></td>
            </tr>
			<%
			    }
			%>
        </table>
    </div>	
    
	<div class="sbmt">
		<h4>
       		<a href="index.html"><input type="SUBMIT" name="Back to Questionnaire" value="Back"></a>
   		</h4>
	</div>
	
</body>
</html>
