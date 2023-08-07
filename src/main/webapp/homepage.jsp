<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Welcome to Bank</title>

    <style>

        body {

            font-family: 'Arial', sans-serif;

            background-color: lightblue;

            margin: 0;

            display: flex;

            flex-direction: column;

            justify-content: center;

            align-items: center;

            min-height: 100vh;
            background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url("https://www.paymentscardsandmobile.com/wp-content/uploads/2020/05/Digital-banking.jpg");
            background-size: cover;

            background-position: center;

            background-repeat: no-repeat;

        }

 

        .container {

            background-color: rgba(255, 255, 255, 0.6);

            border-radius: 10px;

            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);

            padding: 40px;

            width: 400px;

            text-align: center;

        }

 

        h1 {

            color: #333333;

            font-size: 24px;

            margin-bottom: 20px;

        }

 

        h3 {

            margin-top: 20px;

        }

 

        a {

            text-decoration: none;

            color: black;

            transition: color 0.3s ease;

        }

 

        a:hover {

            color: #2980b9;

        }

    </style>

</head>

<body>

    <div class="container">

        <h1>Welcome to Bank</h1>

        <p>

            <%

                session = request.getSession();

                String s1 = (String) session.getAttribute("cust_name");

                out.println(s1 + ", welcome to your account. Please select an operation to perform:");

            %>

        </p>

        <h3><a href="checkbalance">1. Check Balance</a></h3>

        <h3><a href="changepsd.html">2. Change Pin</a></h3>

        <h3><a href="loan.jsp">3. Apply Loan</a></h3>

        <h3><a href="transfer.html">4. Transfer Amount</a></h3>
        
        <h3><a href="Transcationdetails.jsp">5. Transcation Details</a></h3>
        

        <h3><a href="logout">6. Logout</a></h3>

    </div>

</body>

</html>

 