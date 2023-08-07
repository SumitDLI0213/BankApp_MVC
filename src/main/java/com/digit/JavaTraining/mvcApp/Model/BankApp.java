package com.digit.JavaTraining.mvcApp.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import jakarta.servlet.http.HttpSession;

public class BankApp {
	int bank_id;
	String bank_name;
	String ifsc_code;
	int accno;
	int pin;
	int cust_id;
	String cust_name;
	int balance;
	String email;
	long phone;
	int lid;
	String l_type;
	int tenure;
	float interest;
	String description;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultset;
	private ResultSet res1;
	// private Object //resp;
	private ResultSet res2;
	
	String s_ifsc;
	int s_accno;
	String r_ifsc;
	int r_accno;
	int amount;
	
	

	public BankApp() {
		String url = "jdbc:mysql://localhost:3306/bankingapplication";

		String user = "root";

		String pwd = "cseibm";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

		}

		catch (Exception e) {

			e.printStackTrace();
		}

		// HttpSession session = req.getSession(true);
	}

	public int getamount() {
		return amount;
	}
    
	public void setamount(int amount) {
		this.amount = amount;
	}
	
	public int getr_accno() {
		return r_accno;
	}
    
	public void setr_accno(int r_accno) {
		this.r_accno = r_accno;
	}
	
	public String getr_ifsc() {
		return r_ifsc;
	}
    
	public void setr_ifsc(String r_ifsc) {
		this.r_ifsc = r_ifsc;
	}
	
	public int getBank_id() {
		return bank_id;
	}
    
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	
	public int gets_accno() {
		return s_accno;
	}
    
	public void sets_accno(int s_accno) {
		this.s_accno = s_accno;
	}
	
	public String gets_ifsc() {
		return s_ifsc;
	}
    
	public void sets_ifsc(String s_ifsc) {
		this.s_ifsc = s_ifsc;
	}
	
	public int getlid() {
		return lid;
	}
    
	public void setlid(int lid) {
		this.lid = lid;
	}    
	public void setl_type(String l_type) {
		this.l_type = l_type;
	}
	public String getl_type() {
		return l_type;
	}

	public int gettenure() {
		return tenure;
	}
    
	public void settenure(int tenure) {
		this.tenure = tenure;
	}
	public float getinterest() {
		return interest;
	}
    
	public void setinterest(float interest) {
		this.interest = interest;
	}
	public String getdescription() {
		return description;
	}
    
	public void setdescription(String description) {
		this.description = description;
	}
	
	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public boolean Register() {

		try {

			pstmt = con.prepareStatement("insert into bankapp values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, bank_id);

			pstmt.setString(2, bank_name);

			pstmt.setString(3, ifsc_code);

			pstmt.setInt(4, accno);

			pstmt.setInt(5, pin);

			pstmt.setInt(6, cust_id);

			pstmt.setString(7, cust_name);

			pstmt.setInt(8, balance);

			pstmt.setString(9, email);

			pstmt.setLong(10, phone);

			int x = pstmt.executeUpdate();

			if (x > 0) {

				// resp.sendRedirect("/BankingApplication/registersucces.html");
				return true;
			}

			else {

				// resp.sendRedirect("/BankingApplication/registerfail.html");
				return false;
			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}

	public boolean login() {
		try {
			pstmt = con.prepareStatement("select * from bankapp where cust_id=? and pin=?");
			pstmt.setInt(1, cust_id);
			pstmt.setInt(2, pin);
			resultset = pstmt.executeQuery();

			if (resultset.next() == true) {
				setAccno(resultset.getInt("accno"));
				setCust_name(resultset.getString("cust_name"));
				return true;

			}

			else {

				return false;
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	public boolean checkbalance() {
		try {
			pstmt = con.prepareStatement("select * from bankapp where accno=?");
			pstmt.setInt(1, accno);
			resultset = pstmt.executeQuery();

			if (resultset.next() == true) {
				setBalance(resultset.getInt("balance"));
				setCust_name(resultset.getString("cust_name"));
				return true;

			}

			else {

				return false;
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	public boolean changepin(int opin, int npin, int cpin) {
		try {
			pstmt = con.prepareStatement("update bankapp set pin=? where accno=? and pin=?");
			pstmt.setInt(1, npin);
			pstmt.setInt(2, accno);
			pstmt.setInt(3, opin);
			int x = pstmt.executeUpdate();
			if (x > 0) {
				// setPin(resultset.getInt("npin"));
				// setCust_name(resultset.getString("cust_name"));
				return true;

			}

			else {

				return false;
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
	
	public boolean applyloan(int lid) {
		try {
			pstmt = con.prepareStatement("select * from loan where lid=?");
			pstmt.setInt(1, lid);
			resultset = pstmt.executeQuery();

			if (resultset.next() == true) {
				setlid(resultset.getInt("lid"));
				setl_type(resultset.getString("l_type"));
				settenure(resultset.getInt("tenure"));
				setinterest(resultset.getFloat("interest"));
				setdescription(resultset.getString("description"));

				
				return true;

			}
			else 
			{
				return false;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean transfer() 
	{
		try 
		{
            pstmt = con.prepareStatement("select * from BankApp where cust_id=? and ifsc_code=? and accno=? and pin=?");
            pstmt.setInt(1, cust_id);
            pstmt.setString(2, s_ifsc);
            pstmt.setInt(3, s_accno);
            pstmt.setInt(4, pin);
            System.out.println(cust_id + " " + s_ifsc + " " + s_accno + " " + pin);
            res1 = pstmt.executeQuery();
            if (res1.next()) 
            {
            	System.out.println("Executing........................");
                //resp.sendRedirect("/BankingApplication/RegisterSuccess.html");
                pstmt = con.prepareStatement("select * from BankApp where ifsc_code=? and accno=?");
                pstmt.setString(1,r_ifsc);
                pstmt.setInt(2, r_accno);
                res2 =  pstmt.executeQuery();
                if(res2.next()==true)
                {
                    int bal= res1.getInt(8);
                    if(bal>amount)
                    {
                        pstmt =  con.prepareStatement("update Bankapp set balance = balance-? where accno=?");
                        pstmt.setInt(1, amount);
                        pstmt.setInt(2, s_accno);
                        int x1 = pstmt.executeUpdate();
                        if(x1>0)
                        {
                            pstmt = con.prepareStatement("update BankApp set balance=balance+? where accno=?");
                            pstmt.setInt(1, amount);
                            pstmt.setInt(2, r_accno);
                            int x2 = pstmt.executeUpdate();
                            if(x2>0)
                            {
                                pstmt = con.prepareStatement("insert into transferstatus values(?,?,?,?,?,?,?,?)");
                                pstmt.setInt(2, cust_id);
                                pstmt.setString(3, bank_name);
                                pstmt.setString(4, s_ifsc);
                                pstmt.setInt(5,s_accno);
                                pstmt.setString(6, r_ifsc);
                                pstmt.setInt(7,r_accno);
                                pstmt.setInt(8, amount);
                                int i = new Random().nextInt(900000)+100000;
                                pstmt.setDouble(1, Math.random());
                                int x3= pstmt.executeUpdate();
                                if(x3>0)
                                {
                                    return true;
                                }
                                else
                                {
                                    System.out.println("failed at inserting into trans");

                                    return false;
                                }
                            }
                            else
                            {
                                System.out.println("failed at balance+ update");

                                return false;
                            }
                        }
                        else 
                        {
                            System.out.println("failed at balance- update");

                            return false;
                        }
                    }
                    else
                    {
                        System.out.println("failed at balance>");

                        return false;
                    }
                }
                else
                {
                    System.out.println("failed at ifsc code accno");

                    return false;
                }
            }
            else 
            {
                System.out.println("failed at credtal");
                return false;
            }
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
        return false;
	}
	public boolean logout() {
		try {		
				return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}
