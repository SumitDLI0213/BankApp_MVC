<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Details</title>
<style>
   .intro {

            display: flex;

            flex-direction: column;

            justify-content: center;

            align-items: center;

            width: 100vw;

            height: 100vh;

            background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url("https://www.valueresearchonline.com/content-assets/images/52446_high-cash__w1200__.jpg");
            background-size: cover;

            background-position: center;

            background-repeat: no-repeat;

        }
.container
{

            background-color: rgba(255, 255, 255, 0.4); /* rgba(255, 255, 255, alpha) - Here alpha is set to 0.8 */

            border-radius: 10px;

            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            
            padding: 40px;
             

            width: 800px;

            text-align: center;

 }
       body {

            margin: 0;

            font-family: 'Arial', sans-serif;

            text-align: center;

            background-color: #f0f0f0;

        }
        h1 {

            color: Black;

            font-size: 28px;

            margin-bottom: 20px;

        } 
        form {

            display: flex;

            flex-direction: column;

            align-items: center;

        }
        label {

            font-weight: bold;

            color: #ffffff;

            margin-bottom: 5px;

        }
        input[type="submit"] {

            background-color: #2980b9;

            color: white;

            border: none;

            padding: 10px 20px;

            border-radius: 5px;

            cursor: pointer;

            font-size: 16px;

            transition: background-color 0.3s ease;

        }
        input[type="submit"]:hover {

            background-color: #1a5276;

        }
    </style>
</head>
<body>
<div class="intro">

        <div class="container">
        <h1 align="left">
        <%           
        String s2 = (String) session.getAttribute("l_type");
        out.println(s2+" Details Are :-");

        %>
        </h1>
       <table border="1">
        <tr>
            <th>Loan ID</th>
            <th>Loan Type</th>
            <th>Tenure</th>
            <th>Interest</th>
            <th>Description</th>
        </tr>
        <%
            session = request.getSession();
            int s1 = (int) session.getAttribute("lid");
            int s3 = (int) session.getAttribute("tenure");
            float s4 = (float) session.getAttribute("interest");
            String s5 = (String) session.getAttribute("description");
        %>
        <tr>
            <td><%= s1 %></td>
            <td><%= s2 %></td>
            <td><%= s3 %></td>
            <td><%= s4 %></td>
            <td><%= s5 %></td>
        </tr>
    </table>
    </div>
     </div>
</body>
</html>