<%@ page import="java.util.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="author1" content="Konstantinos Christoforidis">
    <meta name="author2" content="Antonios Tseos">
    <meta name="description" content="Result TestSCG">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="icon" href="images/logo.jpg">
	<title>Results</title>

		<style>
			body{ 
				background-color: #778899;
			}
			.q1 {
				  text-align: center;
				  width: 80%;
				  border: 3px solid gray;
				  padding: 5px;
				  margin: auto;
				  margin-top: 20px;
				  background-color: #FFFFF0;
			}
			
			.sbmt {
				  text-align: center;
				  width: auto;
				  padding: 5px;
				  margin: auto;
				  margin-top: 5px;
				  margin-bottom: 20px;
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
			
			.title {
				font-size: 60px;
			}​​​​​
		</style>

</head>

<body>
	
	<%
		float resProfil1 = (float)request.getAttribute("resProfil1");
		float resProfil2 = (float)request.getAttribute("resProfil2");
		float resProfil3 = (float)request.getAttribute("resProfil3");
		float resProfil4 = (float)request.getAttribute("resProfil4");
		
		float resField1 = (float)request.getAttribute("resField1");
		float resField2 = (float)request.getAttribute("resField2");
		float resField3 = (float)request.getAttribute("resField3");
		float resField4 = (float)request.getAttribute("resField4");
		
		String name = (String)request.getAttribute("name");
		
		int resFinal;
		
		if(resField1>resField2) {
			if(resField1>resField3) {
				if (resField1>resField4) {
					resFinal = 1;
				}
				
				else {
					resFinal = 4;
				}
			}
			if (resField3>resField4) {
				resFinal = 3;
			}
			else {
				resFinal = 4;
			}
		}
		else if(resField2>resField3) {
			if(resField2>resField4) {
				resFinal = 2;
			}
			else {
				resFinal = 4;
			}
		}
		else if(resField3>resField4) {
			resFinal = 3;
		}
		else {
			resFinal = 4;
		}
	%>
	
	<div class="title" style="text-align: center; margin-top: 50px;">
		<h1>
			<strong>Results! &#128516;</strong>
		</h1>
	</div>
    
	<div class="q1">
	<h2>
		<strong>Mister/Miss <%out.print(name);%>:</strong>
	</h2>
		<p> 	These are results based upon your answers in the previous questions. The following are a combination of personality
			characteristics and field suggestions so you can have a better view of your personal preferences. Please, remember 
			these are just a sample/suggestion and cannot be 100% accurate. It is preferable to use these results as a starting
			point towards making your decisions.</p>
	</div>

	<div class="q1">
		<h2>
			<strong>How much of an extrovert are you?</strong>
		</h2>
        <div class="w3-light-grey w3-round w3-tiny">
        	<div class="w3-container w3-round w3-padding-tiny w3-blue" style="height:24px;width:<%out.print(resProfil1);%>%">
        		<%out.print(resProfil1);%>%
       		</div>
        </div>
	</div>
		
	<div class="q1">
		<h2>
			<strong>How creative are you?</strong>
		</h2>
        <div class="w3-light-grey w3-round w3-tiny">
        	<div class="w3-container w3-round w3-padding-tiny w3-blue" style="height:24px;width:<%out.print(resProfil2);%>%">
        		<%out.print(resProfil2);%>%
        	</div>
        </div>
	</div>
		
	<div class="q1">
		<h2>
			<strong>How much would you be able to adapt to the needs of a work group?</strong>
		</h2>
        <div class="w3-light-grey w3-round w3-tiny">
        	<div class="w3-container w3-round w3-padding-tiny w3-blue" style="height:24px;width:<%out.print(resProfil3);%>%">
        		<%out.print(resProfil3);%>%
        	</div>
        </div>
	</div>
		
	<div class="q1">
		<h2>
			<strong>How consistent are you?</strong>
		</h2>
        <div class="w3-light-grey w3-round w3-tiny">
        	<div class="w3-container w3-round w3-padding-tiny w3-blue" style="height:24px;width:<%out.print(resProfil4);%>%">
        		<%out.print(resProfil4);%>%
        	</div>
        </div>
	</div>
		
	<div class="q1">
		<h2>
			<strong>1) Theoretic and Humane Sciences</strong>
		</h2>
        <div class="w3-light-grey w3-round w3-tiny">
        	<div class="w3-container w3-round w3-padding-tiny w3-blue" style="height:24px;width:<%out.print(resField1);%>%">
        		<%out.print(resField1);%>%
        	</div>
        </div>
	</div>
		
	<div class="q1">
		<h2>
			<strong>2) Natural and Exact Sciences</strong>
		</h2>
        <div class="w3-light-grey w3-round w3-tiny">
        	<div class="w3-container w3-round w3-padding-tiny w3-blue" style="height:24px;width:<%out.print(resField2);%>%">
        		<%out.print(resField2);%>%
        	</div>
        </div>
	</div>
		
	<div class="q1">
		<h2>
			<strong>3) Natural and Health Sciences</strong>
		</h2>
        <div class="w3-light-grey w3-round w3-tiny">
        	<div class="w3-container w3-round w3-padding-tiny w3-blue" style="height:24px;width:<%out.print(resField3);%>%">
        		<%out.print(resField3);%>%
        	</div>
       	</div>
	</div>
	
	<div class="q1">
		<h2>
			<strong>4) Economics and Informatics</strong>
		</h2>
        <div class="w3-light-grey w3-round w3-tiny">
        	<div class="w3-container w3-round w3-padding-tiny w3-blue" style="height:24px;width:<%out.print(resField4);%>%">
        		<%out.print(resField4);%>%
        	</div>
        </div>
	</div>
	
	<div class="q1">
		<h1>
			<strong>Field Number <%out.print(resFinal);%> is the one closest to your interests.</strong>
		</h1>
	</div>
	
	<div class="q1">
		<h2>
			<strong>Thank You for completing this questionnaire! &#128519;</strong>
		</h2>
	</div>
	
	<div class="sbmt">
		<h4>
       		<a href="user-list.jsp"><input type="SUBMIT" name="List of All Users" value="List of All Users"></a>
   		</h4>
	</div>
</body>
