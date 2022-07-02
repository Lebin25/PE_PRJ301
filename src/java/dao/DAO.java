package dao;

import context.DBContext;
import dto.Account;
import dto.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bin
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String user, String pass) {
        String query = "select * from Account\n"
                + "where Username = ? \n"
                + "and Password = ? \n"
                + "and Status = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "Select * from Account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account checkUserExist(String username) {
        String query = "select * from Account\n"
                + "where Username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
//
//    public Product checkProductExist(String productName) {
//        String query = "select * from Product\n"
//                + "where ProductName = ?";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, productName);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getInt(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(7),
//                        rs.getString(8));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }

    public String checkProductNameExist(String productName) {
        String query = "select ProductName from Product\n"
                + "where ProductName = ?";
        String pname;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productName);
            rs = ps.executeQuery();
            while(rs.next()){
                return pname = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void createUser(String username, String password, String fullname, int role) {
        String query = "insert into Account\n"
                + "values(?, ?, ?, ?, 1)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setInt(4, role);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void createProduct(String productName, int quantity, double price, String image, String userCreate) {
        String query = "insert into Product\n"
                + "values(?, ?, ?, ?, ?, GETDATE())";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productName);
            ps.setInt(2, quantity);
            ps.setDouble(3, price);
            ps.setString(4, image);
            ps.setString(5, userCreate);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "Select * from Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteAccount(String username) {
        String query = "update Account \n"
                + "set Status = 0\n"
                + "where Username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(String productID) {
        String query = "Delete from Product\n"
                + "where ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account getAccountByUsername(String username) {
        String query = "select * from Account\n"
                + "where Username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateUser(String username, String password, String fullname, int role, int status) {
        String query = "Update Account\n"
                + "Set Username = ?,\n"
                + "[Password] = ?,\n"
                + "Fullname =?,\n"
                + "Role = ?,\n"
                + "Status = ?\n"
                + "where Username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setInt(4, role);
            ps.setInt(5, status);
            ps.setString(6, username);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Product getProductById(String productId) {
        String query = "select * from product\n"
                + "where ProductId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateProduct(int productID, String productName, int quantity, double price, String image, String userCreate) {
        String query = "update Product \n"
                + "set ProductName = ?,\n"
                + "Quantity = ?,\n"
                + "Price = ?,\n"
                + "[Image] = ?,\n"
                + "UserCreate = ?\n"
                + "where ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productName);
            ps.setInt(2, quantity);
            ps.setDouble(3, price);
            ps.setString(4, image);
            ps.setString(5, userCreate);
            ps.setInt(6, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
