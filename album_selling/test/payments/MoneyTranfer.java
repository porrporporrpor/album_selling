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
    private InputStream image;
    private Connection conn;

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
    
    public int addImage(MoneyTranfer payment, InputStream image) {
        this.image = image;
        int returnCode=0;
        this.conn = payment.getConnection();
        
        try {
            
            
            // set default output file name and path directory
            File path = new File("/Users/porx/NetBeansProjects/webpro_project/web/images/pp_test/" + payment.getInvoiceId() + ".png");
            FileOutputStream outputStream = new FileOutputStream(path);

            // write image file
            byte[] buffer = new byte[1024];
            while (image.read(buffer) > 0) {
                outputStream.write(buffer);
            }
                
                // insert image into database
            String sql = "insert into moneyTranfer(invoiceId, imgPath, date) values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, payment.getInvoiceId());
            pstmt.setString(2, path+"");
            
            returnCode = pstmt.executeUpdate();
            }
            
         catch (SQLException ex) {
            Logger.getLogger(MoneyTranfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MoneyTranfer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnCode;
    }
}
