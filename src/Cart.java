public class Cart {
    AvailableProducts setOfProducts = new AvailableProducts();
    //ID and numProducts has to be +ve
    private int customerID;
    private int numProducts;
    private Product[] products;
    private int productCount;

    public Cart(int customerID, int numProducts) {
        this.customerID = customerID;
        this.numProducts = numProducts;
        this.products = new Product[numProducts];
        this.productCount=0;
    }

    public void addProduct(Product product){
        if (! setOfProducts.isAvailable(product)) System.out.println("Product is unavailable");
    }
}
