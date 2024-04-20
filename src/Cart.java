import java.util.ArrayList;

public class Cart {
    AvailableProducts availableProducts;
    //ID has to be +ve
    private int customerID;
    //used arrayList instead of an array
    private ArrayList<Product> cart;

    public Cart(int customerID , AvailableProducts availableProducts) {
        if (customerID<0) this.customerID = Math.abs(customerID);
        else this.customerID = customerID;
        this.cart = new ArrayList<>();
        this.availableProducts=availableProducts;
    }
    public void addProduct(int productID){
        if (! availableProducts.isAvailable(productID)) System.out.println("Product not available or doesn't exist (check id)");
        else cart.add(availableProducts.getProduct(productID));
    }
    public void removeProduct(int productID){
        if (! isInCart(productID)) System.out.println("Product not in cart (check id)");
        else cart.remove(availableProducts.getProduct(productID));
    }
    public boolean isInCart(int productID){
        return cart.contains(availableProducts.getProduct(productID));
    }
    public float calculatePrice(){
        float price = 0;
        for (Product product : cart){
            price += product.getPrice();
        }
        return price;
    }

    public void print(){
        System.out.print("Products in cart are: [");
        for (Product product : cart){
            System.out.print(product.getName() + " || ");
        }
        System.out.println("]");
    }
    public String getProductNames(){
        String name = "";
        for (Product product : cart){
            name = (name + ", " + product.getName()+"\n");
        }
        return name;
    }

    public Order placeOrder(int orderID){
        Order order = new Order(this.customerID , orderID , cart , calculatePrice());
        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Order placed!");
        return order;
    }
    public int length(){
        return cart.size();
    }
    public Product getProduct(int index){
        return cart.get(index);
    }

    public AvailableProducts getAvailableProducts() {
        return availableProducts;
    }
}
