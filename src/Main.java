public class Main {
    public static void main(String[] args) {
        ElectronicProduct AAbattery = new ElectronicProduct(123,"battery" , 2.4F , "Generic" , 1);
        BookProduct book = new BookProduct(111 , "book#1" , 11 , "auth" , "pup");
        ClothingProduct cloth = new ClothingProduct(112 , "shirt" , 12 , "XL" , "silk");

        AvailableProducts availableProducts = new AvailableProducts();
        availableProducts.addProduct(AAbattery);
        availableProducts.addProduct(book);
        availableProducts.addProduct(cloth);
        availableProducts.print();

        availableProducts.removeProduct(112);
        availableProducts.print();

    }
}