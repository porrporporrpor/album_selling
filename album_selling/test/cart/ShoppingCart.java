/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;
import java.util.List;
import products.Invoice;

/**
 *
 * @author phpond
 */
public class ShoppingCart {
    private Invoice invoice;
    private ShoppingCart cart;
    private List lisProduct;
    private int quantity;
    
    public void addCart(){
        
    }
    
    public void deleteCart(){
        
    }
    
    public ShoppingCart viewCart(){
        return cart;
    }
    
    public void increaseCart(){
        
    }
    
    public void decreaseCart(){
        
    }
    
    public Invoice checkOut(){
        return invoice;
    }
}
