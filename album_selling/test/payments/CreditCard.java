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
public class CreditCard extends Payment{
    private String card_number;
    private String ccv;
    private String card_name;
    private String card_expiry_date;
    
    private Connection conn;

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_expiry_datepDate() {
        return card_expiry_date;
    }

    public void setCard_expiry_date(String card_expiry_date) {
        this.card_expiry_date = card_expiry_date;
    }
    
    public int addCreditCard(CreditCard credit, String card_number, String card_name, String ccv, String card_expiry_date) {
        this.card_name = card_name;
        this.ccv = ccv;
        this.card_number = card_number;
        this.card_expiry_date = card_expiry_date;
        int returnCode=0;
        this.conn = credit.getConnection();
        
        try {
            String sql = "insert into creditCards(invoice_number, card_number, card_name, ccv, card_expiry_date) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, credit.getInvoice_number());
            pstmt.setString(2, card_number);
            pstmt.setString(3, card_name);
            pstmt.setString(4, ccv);
            pstmt.setString(5, card_expiry_date);
            
            System.out.println("credit card inserted into database!");
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CreditCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnCode;
        
    }
    
    public void deleteCreditCard() {
        
    }
}
