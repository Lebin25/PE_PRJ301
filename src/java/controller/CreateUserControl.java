package controller;

import dao.DAO;
import dto.Account;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bin
 */
@WebServlet(name = "CreateUserControl", urlPatterns = {"/createUser"})
public class CreateUserControl extends HttpServlet {

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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String fullname = request.getParameter("fullname");

        DAO dao = new DAO();
        Account a = dao.checkUserExist(username);
        try {
            int role = Integer.parseInt(request.getParameter("role"));
            if (username == "" || password == "" || fullname == "") {
                request.setAttribute("messFillAllInfo", "Please fill all information of user");
                request.getRequestDispatcher("createUser.jsp").forward(request, response);
            } else if (a != null) {
                request.setAttribute("messUsername", "This username is used, please use another username.");
                request.getRequestDispatcher("createUser.jsp").forward(request, response);
            } else {
                dao.createUser(username, password, fullname, role);
                response.sendRedirect("upload");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("messRole", "Please enter only 1 for Admin and 0 for User.");
            request.getRequestDispatcher("createUser.jsp").forward(request, response);
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
