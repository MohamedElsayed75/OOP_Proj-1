public class Product {
    //id and price have to be +ve
    private int productID;
    private String name;
    private float price;

    public Product(int productID, String name, float price) {

        if (productID<0) this.productID = Math.abs(productID);
        else this.productID = productID;

        this.name = name;

        if (price<0) this.price = Math.abs(price);
        else this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}