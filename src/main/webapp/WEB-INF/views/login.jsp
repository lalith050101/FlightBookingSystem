<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>

 <style>
        	body{
        	background-color: #bbaa99;
			background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='688' height='344' viewBox='0 0 160 80'%3E%3Cg fill='%23B0A090' %3E%3Cpolygon points='0 10 0 0 10 0'/%3E%3Cpolygon points='0 40 0 30 10 30'/%3E%3Cpolygon points='0 30 0 20 10 20'/%3E%3Cpolygon points='0 70 0 60 10 60'/%3E%3Cpolygon points='0 80 0 70 10 70'/%3E%3Cpolygon points='50 80 50 70 60 70'/%3E%3Cpolygon points='10 20 10 10 20 10'/%3E%3Cpolygon points='10 40 10 30 20 30'/%3E%3Cpolygon points='20 10 20 0 30 0'/%3E%3Cpolygon points='10 10 10 0 20 0'/%3E%3Cpolygon points='30 20 30 10 40 10'/%3E%3Cpolygon points='20 20 20 40 40 20'/%3E%3Cpolygon points='40 10 40 0 50 0'/%3E%3Cpolygon points='40 20 40 10 50 10'/%3E%3Cpolygon points='40 40 40 30 50 30'/%3E%3Cpolygon points='30 40 30 30 40 30'/%3E%3Cpolygon points='40 60 40 50 50 50'/%3E%3Cpolygon points='50 30 50 20 60 20'/%3E%3Cpolygon points='40 60 40 80 60 60'/%3E%3Cpolygon points='50 40 50 60 70 40'/%3E%3Cpolygon points='60 0 60 20 80 0'/%3E%3Cpolygon points='70 30 70 20 80 20'/%3E%3Cpolygon points='70 40 70 30 80 30'/%3E%3Cpolygon points='60 60 60 80 80 60'/%3E%3Cpolygon points='80 10 80 0 90 0'/%3E%3Cpolygon points='70 40 70 60 90 40'/%3E%3Cpolygon points='80 60 80 50 90 50'/%3E%3Cpolygon points='60 30 60 20 70 20'/%3E%3Cpolygon points='80 70 80 80 90 80 100 70'/%3E%3Cpolygon points='80 10 80 40 110 10'/%3E%3Cpolygon points='110 40 110 30 120 30'/%3E%3Cpolygon points='90 40 90 70 120 40'/%3E%3Cpolygon points='10 50 10 80 40 50'/%3E%3Cpolygon points='110 60 110 50 120 50'/%3E%3Cpolygon points='100 60 100 80 120 60'/%3E%3Cpolygon points='110 0 110 20 130 0'/%3E%3Cpolygon points='120 30 120 20 130 20'/%3E%3Cpolygon points='130 10 130 0 140 0'/%3E%3Cpolygon points='130 30 130 20 140 20'/%3E%3Cpolygon points='120 40 120 30 130 30'/%3E%3Cpolygon points='130 50 130 40 140 40'/%3E%3Cpolygon points='120 50 120 70 140 50'/%3E%3Cpolygon points='110 70 110 80 130 80 140 70'/%3E%3Cpolygon points='140 10 140 0 150 0'/%3E%3Cpolygon points='140 20 140 10 150 10'/%3E%3Cpolygon points='140 40 140 30 150 30'/%3E%3Cpolygon points='140 50 140 40 150 40'/%3E%3Cpolygon points='140 70 140 60 150 60'/%3E%3Cpolygon points='150 20 150 40 160 30 160 20'/%3E%3Cpolygon points='150 60 150 50 160 50'/%3E%3Cpolygon points='140 70 140 80 150 80 160 70'/%3E%3C/g%3E%3C/svg%3E");
        	
        	background-attachment: fixed;
			background-size: cover;
			background-repeat:  no-repeat;
        	
	       	margin:0px;
        	}
        	
        	
			# {
			  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
			  border-collapse: collapse;
			  width: 100%;
			}
			
			
			.header{
			width:100%;
			height:70px;
			margin:0;
			background-color: #0505060f;
			display:flex;
			justify-content: center;
			
			align-items:center;
			position:fixed;

			
			}
			
			table{
	        margin:0 auto;
	         border-collapse: collapse;
	        }
	        td,th{
	        height:35px;
	        width:75px;
	        text-align:center;
	        }
			
			#products td, #products th {
			  border: 1px solid #ddd;
			  padding: 8px;
			}
			
			#products tr:nth-child(even){background-color: #f2f2f2;}
			
			#products tr:hover {background-color: #ddd;}
			
			#products th {
			  padding-top: 12px;
	 		  padding-bottom: 12px;
	  		  text-align: center;	
			  background-color: #34495e;;
			  color: white;
			  opacity:0.9;
			}
			.product-list{
			background-color: rgba(250, 250, 250,0.6);
			width:max-content;
			margin:0 auto;
			padding: 4rem 4rem;
		    align-items: center;
		    position: absolute;
		    bottom: 0;
		    top: 70px;
		    left: 0;
		    right: 0;
		    overflow: scroll;
			
			}
			
			a{
			margin:0px;
			display:inline-block;
			
			}
			.actionlink,.headerlink {
			color: white;
			
			padding:0.5rem 1rem;
			text-decoration:none;
			background-color:#34495e;
			
			transition:all 1.2s;
			}
			
			.actionlink,.headerlink:hover{
			background-color: #34495e;
			transform:scale(0.9);
			}
			
			.header a{
			padding:1.1rem 1.6rem;
			color: #fff;
			
			margin:1rem;
			}
			
			
		#pdheading{
		
		transition:opacity .3s;
		
		
		}
		
		</style>
        
</head>
<body>
	  
	
	 <div align="center" class="productform">
       <h1>LOGIN</h1>
        <h2 class="error">${msg}</h2>
        <form:form  action="login" method="post"   modelAttribute="login">
        <table >
	
            <tr>
                <td>UserId:</td>
                <td><form:input id="procode" path="email"  maxlength="30" required="required"/></td>
            	<form:errors path="email" cssClass="error"/>
            </tr>
            <tr>
                <td>password:</td>
                <td><form:input id="proname" path="password" maxlength="30"  /></td>
                <form:errors path="password" cssClass="error"/>
            </tr>
            <tr>
                <td  align="center"><input class="btn" type="submit" value="Login"></td>
            	<td align="center"> <a class="btn" href="/">Cancel</a></td>
            </tr>
			
        </table>
        </form:form>
        
    </div> 
</body>
</html>