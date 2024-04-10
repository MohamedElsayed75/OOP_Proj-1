import java.util.Scanner;

public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        AvailableProducts availableProducts = new AvailableProducts();


        ElectronicProduct phone = new ElectronicProduct(1,"smartphone" , 599.9F , "Samsung" , 1);
        ClothingProduct shirt = new ClothingProduct(2 , "T-shirt" , 19.99F , "Medium" , "Cotton");
        BookProduct book = new BookProduct(3,"OOP" , 39.99F , "O’Reilly" , "X Publications");

        Customer customer1 = new Customer(1234 , "MyName" , "Address");

        availableProducts.addProduct(phone);
        availableProducts.addProduct(shirt);
        availableProducts.addProduct(book);

        Cart cart = new Cart(customer1.getCustomerID() , availableProducts);

        while (true){
            System.out.println("Enter the ID of the product to add to cart ~ enter 0 to exit ~");
            cart.print();
            availableProducts.print();
            System.out.print(">>  ");
            int option = scanner.nextInt();

            if (option==0) break;

            cart.addProduct(option);
        }

        System.out.print("Would you like to place the order? (y/n) : ");
        String input = scanner.next();
        if (input.equals("y")) {
            System.out.print("Order ID: ");
            int x = scanner.nextInt();
            Order order = cart.placeOrder(x);
            order.printOrderInfo();
        }

    }
}
