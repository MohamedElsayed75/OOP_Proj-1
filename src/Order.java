import java.util.ArrayList;

public class Order {
    int customerID;
    int orderID;
    ArrayList<Product> list;
    float totalPrice;

    public Order(int customerID, int orderID, ArrayList<Product> list, float totalPrice) {
        if (customerID<0) this.customerID = Math.abs(customerID);
        else this.customerID = customerID;

        if (orderID<0) this.orderID = Math.abs(orderID);
        else this.orderID = orderID;

        this.list = list;

        if (totalPrice<0) this.totalPrice = Math.abs(totalPrice);
        else this.totalPrice = totalPrice;
    }
    public void printOrderInfo(){
        System.out.println("customerID: "+this.customerID);
        System.out.println("orderID: " +this.orderID);
        System.out.println("Cart: ");
        for (Product product : list){
            System.out.println("Name: " + product.getName() + " | ID: " +product.getProductID() + " | Price: " +product.getPrice());
        }
        System.out.println("Total: $" + totalPrice);
    }
}
