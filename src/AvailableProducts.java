import java.util.*;

public class AvailableProducts {
    //set of all products
    private Set<Product> set;
    public AvailableProducts(){
        set = new HashSet<>();
    }
    public void addProduct(Product product){
        if (!alreadyExists(product)) set.add(product);
        else System.out.println("Product already available");
    }
    public void removeProduct(Product product){
        set.remove(product);
    }
    private boolean alreadyExists(Product product){
        Iterator<Product> value = set.iterator();
        while (value.hasNext()) {
            if(value.next().getProductID() == product.getProductID()) return true;
        }
        return false;
    }
    public boolean isAvailable(Product product){
        return (set.contains(product));
    }
    public void print(){
        Iterator<Product> value = set.iterator();
        System.out.print("Available products are: [");
        while (value.hasNext()) {
            System.out.print(value.next().getName()+", ");
        }
        System.out.println("]");

    }
}
