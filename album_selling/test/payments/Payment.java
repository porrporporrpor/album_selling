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
    private int invoiceId;
    private Double amount;
    private Connection conn;


    public Payment() {
        
    }
    
    public void addPayment(int invoiceId, Double amount) {
        this.invoiceId = invoiceId;
        this.amount = amount;
        
        try {
            String sql = "insert into payments(invoiceId, amount) values(?,?)";
            PreparedStatement rstmt = conn.prepareStatement(sql);
            rstmt.setInt(1, invoiceId);
            rstmt.setDouble(2, amount);
            rstmt.executeUpdate();
            System.out.println("success");
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    
    public Connection getConnection() {
        return this.conn = conn;
    }
    
    
}
