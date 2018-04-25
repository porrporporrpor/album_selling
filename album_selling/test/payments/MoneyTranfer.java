/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author porx
 */
public class MoneyTranfer extends Payment {
    private String bank;
    private String transfer_date;
    private String transfer_time;
    private InputStream image;
    private Connection conn;

    public int addImage(MoneyTranfer payment,String bank, String transfer_date,String transfer_time, InputStream image) {
        this.bank = bank;
        this.transfer_date = transfer_date;
        this.transfer_time = transfer_time;
        this.image = image;
        int returnCode=0;
        this.conn = payment.getConnection();
        
        try {
            
            // set default output file name and path directory
            File path = new File("/Users/porx/NetBeansProjects/webpro_project/web/images/pp_test/" + payment.getInvoice_number()+ ".png");
            FileOutputStream outputStream = new FileOutputStream(path);

            // write image file
            byte[] buffer = new byte[1024];
            while (image.read(buffer) > 0) {
                outputStream.write(buffer);
            }
                
                // insert image into database
            String sql = "insert into moneyTranfer(invoice_number, bank, transfer_date, image_link) values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, payment.getInvoice_number());
            pstmt.setString(2, bank);
            pstmt.setString(3, transfer_date);
            pstmt.setString(4, path+"");
            
            returnCode = pstmt.executeUpdate();
            System.out.println("money transfer inserted into database!");
            }
            
         catch (SQLException ex) {
            Logger.getLogger(MoneyTranfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MoneyTranfer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnCode;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
    
    public String getBank() {
        return bank;
    }

    public void setTransfer_date(String transfer_date) {
        this.transfer_date = transfer_date;
    }
    
    public String getTransfer_date() {
        return transfer_date;
    }
    
    public void setTransfer_time(String transfer_time) {
        this.transfer_date = transfer_time;
    }
    
    public String getTransfer_time() {
        return transfer_time;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
    
     public InputStream getImage() {
        return image;
    }
    
}
