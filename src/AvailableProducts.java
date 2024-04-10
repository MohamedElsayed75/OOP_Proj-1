import java.util.HashMap;

public class AvailableProducts {
    //set of all products
    private HashMap<Integer,Product> map;
    public AvailableProducts(){
        map = new HashMap<>();
    }
    public void addProduct(Product product){
        if (!isAvailable(product.getProductID())) map.put(product.getProductID(), product);
        else System.out.println("Product already available");
    }
    public void removeProduct(int productID){
        map.remove(productID);
    }
    public boolean isAvailable(int productID){
        return map.containsKey(productID);
    }
    public Product getProduct(int productID){
        return map.get(productID);
    }
    public void print(){
        System.out.print("Available products are: [");
        for (Product product : map.values()){
            System.out.print(product.getName() +"["+product.getProductID()+"][$"+product.getPrice()+ "]  ||   ");
        }
        System.out.println("]");


    }
}
