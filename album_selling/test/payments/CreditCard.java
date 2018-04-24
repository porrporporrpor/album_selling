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
    private String nameCard;
    private String ccv;
    private String cardNo;
    private String expDate;
    
    private Connection conn;

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    
    public int addCreditCard(CreditCard credit, String nameCard, String ccv, String cardNo, String expDate) {
        this.nameCard = nameCard;
        this.ccv = ccv;
        this.cardNo = cardNo;
        this.expDate = expDate;
        int returnCode=0;
        this.conn = credit.getConnection();
        
        try {
            String sql = "insert into creditCards(invoiceId, nameCard, cardNo, ccv, ecpDate) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, credit.getInvoiceId());
            pstmt.setString(2, nameCard);
            pstmt.setString(3, cardNo);
            pstmt.setString(4, expDate);
            
        } catch (SQLException ex) {
            Logger.getLogger(CreditCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnCode;
        
    }
    
    public void deleteCreditCard() {
        
    }
}
