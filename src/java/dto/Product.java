package dto;


public class Product {
    private int productID;
    private String productName;
    private int quantity;
    private double price;
    private String image;
    private String userCreate;
    private String date;

    public Product() {
    }

    public Product(int productID, String productName, int quantity, double price, String image, String userCreate, String date) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.userCreate = userCreate;
        this.date = date;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", quantity=" + quantity + ", Price=" + price + ", image=" + image + ", userCreate=" + userCreate + ", date=" + date + '}';
    }
    
    
}
