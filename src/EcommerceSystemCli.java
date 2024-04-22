import java.util.Scanner;

public class EcommerceSystemCli {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        AvailableProducts availableProducts = new AvailableProducts();


        ElectronicProduct phone = new ElectronicProduct(1,"smartphone" , 599.9F , "Samsung" , 1);
        ClothingProduct shirt = new ClothingProduct(2 , "T-shirt" , 19.99F , "Medium" , "Cotton");
        BookProduct book = new BookProduct(3,"OOP" , 39.99F , "O’Reilly" , "X Publications");

        availableProducts.addProduct(phone);
        availableProducts.addProduct(shirt);
        availableProducts.addProduct(book);


        System.out.println("Welcome to E-Commerce System!");
        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        System.out.println("Please enter your address");
        String address = scanner.nextLine();
        System.out.println("Please enter your id");
        int id = scanner.nextInt();

        Customer customer1 = new Customer(id , name , address);
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
