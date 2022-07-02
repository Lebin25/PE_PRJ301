package controller;

import dao.DAO;
import dto.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

@WebServlet(name = "CreateProductControl", urlPatterns = {"/CreateProductControl"})

public class CreateProductControl extends HttpServlet {

    private static final long SerialVersionUID = 1L;
    private static final String UPLOAD_DIR = "images";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String productName = request.getParameter("productName");
        //int quantity = Integer.parseInt(request.getParameter("quantity"));
        //double price = Double.parseDouble(request.getParameter("price"));
        String image = uploadFile(request);
        String userCreate = request.getParameter("userCreate");

        DAO dao = new DAO();
        String name = dao.checkProductNameExist(productName);

        try {
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            if(productName=="" || image==""){
                request.setAttribute("messFillAllField", "Please fill all information of product.");
                request.getRequestDispatcher("createProduct.jsp").forward(request, response);
            } else if (name != null) {
                request.setAttribute("messProductName", "This product already exists, if you want to update the product, select update in the product list.");
                request.getRequestDispatcher("createProduct.jsp").forward(request, response);
            } else {
                dao.createProduct(productName, quantity, price, image, userCreate);
                response.sendRedirect("upload");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("messNumber", "Please enter a NUMBER for Quantity and Price.");
            request.getRequestDispatcher("createProduct.jsp").forward(request, response);
        }

    }

    private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart("image");
            fileName = (String) getFileName(filePart);
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }

        } catch (Exception e) {
            fileName = "";
        }
        return fileName;
    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
    }

}
