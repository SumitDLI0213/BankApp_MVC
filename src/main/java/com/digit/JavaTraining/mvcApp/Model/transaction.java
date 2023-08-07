package com.digit.JavaTraining.mvcApp.Model;

 

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

 

public class transaction {

    int cust_id;

    String bank_name;

    String ifsc;

    int s_accno;

    String r_ifsc;

    int r_accno;

    int amount;

    int trans_id;

    public static Connection con;

 

    public transaction() {

        String url = "jdbc:mysql://localhost:3306/bankingapplication";

        String user = "root";

        String pwd = "cseibm";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

 

            con = DriverManager.getConnection(url, user, pwd);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

 

    public transaction(int customerID, String senderBankName, String senderIFSC, int senderAccountNumber,

            String receiverIFSC, int receiverAccountNumber, int amountOfTransfer, int transactionID) {

        super();

        this.cust_id = customerID;

        this.bank_name = senderBankName;

        this.ifsc = senderIFSC;

        this.s_accno = senderAccountNumber;

        this.r_accno = receiverAccountNumber;

        this.r_ifsc = receiverIFSC;

        this.amount = amountOfTransfer;

        this.trans_id = transactionID;

    }

 

    public int getCust_id() {

        return cust_id;

    }

 

    public void setCust_id(int cust_id) {

        this.cust_id = cust_id;

    }

 

    public String getBank_name() {

        return bank_name;

    }

 

    public void setBank_name(String bank_name) {

        this.bank_name = bank_name;

    }

 

    public String getIfsc() {

        return ifsc;

    }

 

    public void setIfsc(String ifsc) {

        this.ifsc = ifsc;

    }

 

    public int getS_accno() {

        return s_accno;

    }

 

    public void setS_accno(int s_accno) {

        this.s_accno = s_accno;

    }

 

    public String getR_ifsc() {

        return r_ifsc;

    }

 

    public void setR_ifsc(String r_ifsc) {

        this.r_ifsc = r_ifsc;

    }

 

    public int getR_accno() {

        return r_accno;

    }

 

    public void setR_accno(int r_accno) {

        this.r_accno = r_accno;

    }

 

    public int getAmount() {

        return amount;

    }

 

    public void setAmount(int amount) {

        this.amount = amount;

    }

 

    public int getTrans_id() {

        return trans_id;

    }

 

    public void setTrans_id(int trans_id) {

        this.trans_id = trans_id;

    }

 

    public ArrayList<transaction> alltransaction(int accno) {

        ArrayList<transaction> list = new ArrayList<transaction>();

       PreparedStatement ps;

        try {

            ps = con.prepareStatement("SELECT * FROM transferstatus WHERE sender_accno = ? OR reciever_accno = ?");

            ps.setInt(1, accno);

            ps.setInt(2, accno);

            ResultSet rs = ps.executeQuery();

            while (rs.next() == true) {

                System.out.println("HAS DATAAAAAAA");

                int customerID = rs.getInt("cust_id");

                String senderBankName = rs.getString("bank_name");

                String senderIFSC = rs.getString("ifsc");

                int senderAccountNumber = rs.getInt("sender_accno");

                String receiverIFSC = rs.getString("reciever_ifsc");

                int receiverAccountNumber = rs.getInt("reciever_accno");

                int amountOfTransfer = rs.getInt("amount");

                int transactionID = rs.getInt("trans_id");

 

                transaction t = new transaction(customerID, senderBankName, senderIFSC, senderAccountNumber,

                        receiverIFSC, receiverAccountNumber, amountOfTransfer, transactionID);

 

                list.add(t);

            }

 

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return list;

    }

}
