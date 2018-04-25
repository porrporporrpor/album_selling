/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author porx
 */
public class Payment {
    private int invoice_number;
    private String customer_name;
    private Double balance;
    private Connection conn;


    public Payment() {
        
    }
    
    public void addPayment(int invoice_number,String customer_name, Double balance) {
        this.invoice_number = invoice_number;
        this.customer_name = customer_name;
        this.balance = balance;
        
        try {
            String sql = "insert into payments(invoice_number, customer_name, balance) values(?,?,?)";
            PreparedStatement rstmt = conn.prepareStatement(sql);
            rstmt.setInt(1, invoice_number);
            rstmt.setString(2, customer_name);
            rstmt.setDouble(3, balance);
            rstmt.executeUpdate();
            System.out.println("inserted payment susscess!");
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public int getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(int invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    
    public Connection getConnection() {
        return this.conn = conn;
    }
    
    
}
