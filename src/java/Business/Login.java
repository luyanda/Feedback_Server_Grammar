/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import ava.DbAccess;
import ava.Student;
import ava.User;
import ava.UserInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lmiuon
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dispatch="index.jsp";
        
        UserInterface userOps = new DbAccess();
        User user = new User();
        Student student = new Student();
        
        ArrayList<String> errorList = new ArrayList<String>();
        try{
                System.out.println("Errors");
            if (username == null || username.trim().length() == 0)
              {
                  System.out.println("username error");
                errorList.add("username is required for Login");
              }
            if (password == null || password.trim().length() == 0)
              {System.out.println("Passowrd error");
                errorList.add("password is required for Login");
              }

            if (errorList.isEmpty())
              {
                  System.out.println("Non error");
                  int userId = Integer.parseInt(username);
                  user.setUserId(userId);
                  user.setPassword(password);
                  user =  userOps.UserLogin(user);
                  
                if (user != null)
                  {
                    if(user.getType().equalsIgnoreCase("Student"));{
                      student.setId(user.getId());
                      student.setUserId(user.getUserId());
                      student.setName(user.getName());
                      student.setType(user.getType());
                  }
                        
                    HttpSession session = request.getSession();
                    session.setAttribute("LoggedIn", student);
                    session.setAttribute("checker", "checker");
                    //session.setMaxInactiveInterval(30*60);
                    
                    Cookie userName = new Cookie("username",username);
                    userName.setMaxAge(30*60);
                    dispatch = "chooseProject.jsp";
                    
                    response.addCookie(userName);
                    response.sendRedirect(dispatch);
                    
                    request.setAttribute("Successmsg", "Welcome "+user.getName());
                  } else
                  {
                    errorList.add(" Invalid Password or Username");
                    dispatch = "index.jsp";
                    request.setAttribute("error", errorList);
                    //request.setAttribute("id", cell);
                  }
              }
        }
        finally{
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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