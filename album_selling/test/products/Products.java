/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author phpond
 */
public class Products {
    private Products album;
    private int productId = 10000;
    
    private Connection conn;
    private PreparedStatement pstmt;
    
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImg;
    private String artist;
    private String linkEx;
    
    public void addProduct(String name, String description, String artist, String linkexample, double price, String image) throws SQLException{
//        this.album = album;
        productId++;
        setProductId(productId);
        setProductName(name);
        setProductDescription(description);
        setProductPrice(price);
        setArtist(artist);
        setProductImg(image);
        setLinkEx(linkexample);
        
        String sql = "INSERT INTO product VALUES(?,?,?,?,?,?,?)";
        pstmt.execute(sql);
        pstmt.setInt(1, this.album.getProductId());
        pstmt.setString(2, this.album.getProductName());
        pstmt.setString(3, this.album.artist);
        pstmt.setFloat(4, (float) this.album.getProductPrice());
        pstmt.setString(5, this.album.getProductDescription());
        pstmt.setString(6, this.album.getLinkEx());
        pstmt.setString(7, this.album.getProductImg());
       
    }
    
    public void updateProduct(String name, String description, String artist, String linkexample, double price, String image){
        //this.album = album;
        productId++;
        album.setProductId(productId);
        album.setProductName(name);
        album.setProductDescription(description);
        album.setProductPrice(price);
        album.setArtist(artist);
        album.setProductImg(image);
        album.setLinkEx(linkexample);
        
        /// update to db /////
        String sql = "UPDATE .... ";
        
    }
    
    public void deleteProduct(String artist, String name) throws SQLException{
        album.getProductId();
        String sql = "DELETE FROM product WHERE singer = ? and product_name = ?";
        pstmt.execute(sql);
        pstmt.setString(1, artist);
        pstmt.setString(2, name);
    }
    
    public Products serchProduct(){
        return album;
    }
    
    public Products viewProduct(){
        return album;
    }

    public Products getAlbum() {
        return album;
    }

    public void setAlbum(Products album) {
        this.album = album;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLinkEx() {
        return linkEx;
    }

    public void setLinkEx(String linkEx) {
        this.linkEx = linkEx;
    }
    
    
         
}
