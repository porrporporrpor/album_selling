/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import payments.CreditCard;
import payments.MoneyTranfer;
import payments.Payment;

/**
 *
 * @author porx
 */
@WebServlet(name = "paymentServlet", urlPatterns = {"/paymentServlet"})
@MultipartConfig
public class paymentServlet extends HttpServlet {

    private Connection conn;
    private static int invoice_number = 90007;
    private static String customer_name = "JSON";
    private static double balance = 12000;
    private final String UPLOAD_DIRECTORY = "/Users/porx/NetBeansProjects/webpro_project/web/images/pp_test";

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            //set attribute to session for test dev
            HttpSession session = request.getSession();
            session.setAttribute("invoice_number", invoice_number);
            session.setAttribute("customer_name", customer_name);
            session.setAttribute("balance", balance);
            System.out.println("invoice number : " + invoice_number);
            System.out.println("customer name : " + customer_name);
            System.out.println("balance : " + balance);

            // get parameter from payment.html for check is money tranfer or credit card
            String operation = request.getParameter("operation");
            System.out.println(operation);
            
            int returnCode;

            // check is money tranfer or credit card
            if (operation.equals("ชำระเงิน1")) { //money tranfer
                Part filePart = request.getPart("file");
                String bank = request.getParameter("bank");
                Double money = Double.parseDouble(request.getParameter("money"));
                String transfer_date = request.getParameter("date");
                String transfer_time = request.getParameter("time");

                // set filePart to InputStream (image from payment.html) 
                InputStream inputStream = filePart.getInputStream();

                MoneyTranfer payment = new MoneyTranfer();
                payment.setConnection(conn);
                payment.addPayment(invoice_number, customer_name, balance);

                returnCode = payment.addImage(payment, bank, transfer_date, transfer_time, inputStream);
            } else { //credit card
                String nameCard = request.getParameter("name");
                String cardNo = request.getParameter("number");
                String cvv = request.getParameter("security-code");
                String expDate = request.getParameter("expiration-month-and-year");

                CreditCard payment = new CreditCard();
                payment.setConnection(conn);
                payment.addPayment(invoice_number, customer_name, balance);

                returnCode = payment.addCreditCard(payment, nameCard, cardNo, cvv, expDate);
            }

            out.println("SUCCESS LAEWWWWW");
//            // insert into database
//            String sql = "insert into moneyTranfer(invoiceId, imgPath, date) values(?,?,?)";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, invoiceId);
//            pstmt.setString(2, path+"");
//            pstmt.setString(3, payment.getDatePayment());
//            pstmt.executeUpdate();
//            out.println("SUCCESS JAA");

            System.out.println("returnCode " + returnCode);
            if (returnCode == 0) {
                request.setAttribute("message", "error inserting image");
                getServletContext().getRequestDispatcher("/jsp/fail.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "your image inserted fully");
                getServletContext().getRequestDispatcher("/finish_payment.html").forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
