<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Loan</title>
<style>
   .intro {

            display: flex;

            flex-direction: column;

            justify-content: center;

            align-items: center;

            width: 100vw;

            height: 100vh;

            background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url("https://www.hdbfs.com/themes/custom/hdbfs/images/new-img/Business-Loan.webp");
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
        
        
        
         <form action="loan" method="post">
         <h1>Welcome to Loan Details</h1>
         <br>
         <h3>1. Home Loan</h3>
         <h3>2. Education Loan</h3>
         <h3>3. vechicle Loan</h3>
         <h3>4. Gold Loan</h3>
         <h3>5. Personal Loan</h3>
         <label>Enter Choice </label>
         <input type="text" name="lid"><br><br>
         
         <input type="submit" vlaue="Enter Choice">
         </form>
        
       </div>
     </div>
         
</body>
</html>