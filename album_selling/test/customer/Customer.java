package customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phpond
 */
public class Customer {
    private Customer customer;
    private String userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String address;
    private String provice;
    private String postcode;
    private final String userIdAdmin = "00000";
    private final String userIdCustomer = "10000";
    public void register (String username, String password, String firstName, String lastName, String phoneNo, String address, String provice, String postcode) {
        
        customer = new Customer();
        customer.setUserId(userId);
        customer.setUsername(username);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPasswoed(password);
        //userId have 5 number , start 00000 - 09999 = admin
        
    }
    
    public void updateInfo( ){
        
    }
    
    public void login(){
        
    }
    
    public Customer viewInfo(){
        return customer;
    }

    private String getUserId() {
        return userId;
    }

    private void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswoed(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    
}
