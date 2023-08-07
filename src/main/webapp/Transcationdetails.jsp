<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.JavaTraining.mvcApp.Model.*,  java.util.ArrayList"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
	padding: 8px;
}

tr.green {
	background-color: #c8e6c9;
}

tr.red {
	background-color: #ffcdd2;
}
</style>

</head>

<body>



	<%
	session = request.getSession();

	if (session == null) {
		System.out.println("session not");
		response.sendRedirect("/mvc_BankApp/homepage.jsp");

		return;

	}

	BankApp curBankUser = (BankApp) session.getAttribute("BankApp");

	if (curBankUser == null) {

		System.out.println("session not");

		response.sendRedirect("/mvc_BankApp/homepage.jsp");

		return;

	}

	String isListGenerated = (String) session.getAttribute("isListGenerated");

	if (isListGenerated == null) {

		response.sendRedirect("/mvc_BankApp/transcationDetails");

	} else {

		session.removeAttribute("isListGenerated");

	}

	ArrayList<transaction> arrayList = (ArrayList<transaction>) session.getAttribute("ALL_TRANSACTIONS");

	if (arrayList == null) {

		return;

	}
	%>



	<%
	if (arrayList.size() == 0) {
	%>

	<h1 align="center">No Transactions Made Yet!</h1>

	<%
	return;

	}
	%>



	<h1 align="center">All Transactions</h1>



	<table>



		<tr>

			<th>Customer ID</th>

			<th>Sender Bank Name</th>

			<th>Sender Bank IFSC Code</th>

			<th>Sender Account Number</th>

			<th>Receiver IFSC</th>

			<th>Receiver Account Number</th>

			<th>Amount of Transfer</th>

			<th>Transaction ID</th>

		</tr>



		<%
		for (transaction curTransaction : arrayList) {

			String trTypeClass = curTransaction.getS_accno() == curBankUser.getAccno() ? "red" : "green";
		%>

		<tr class="<%=trTypeClass%>">

			<td><%=curTransaction.getCust_id()%></td>

			<td><%=curTransaction.getBank_name()%>
			<td><%=curTransaction.getIfsc()%></td>

			<td><%=curTransaction.getS_accno()%></td>

			<td><%=curTransaction.getR_ifsc()%></td>

			<td><%=curTransaction.getR_accno()%></td>

			<td><%=curTransaction.getAmount()%></td>

			<td><%=curTransaction.getTrans_id()%></td>

		</tr>



		<%
		}
		%>



	</table>







</body>

</html>