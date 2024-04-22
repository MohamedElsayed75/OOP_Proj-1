import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui {

    private static String customerName = "";
    private static int customerID = -1;
    private static String customerAddress= "";
    private static int orderID = -1;
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGui();
            }
        });


    }

    private static void runGui(){
        final int HEIGHT = 400;
        final int WIDTH = 750;


        AvailableProducts availableProducts = new AvailableProducts();


        ElectronicProduct phone = new ElectronicProduct(1,"smartphone" , 599.9F , "Samsung" , 1);
        ClothingProduct shirt = new ClothingProduct(2 , "T-shirt" , 19.99F , "Medium" , "Cotton");
        BookProduct book = new BookProduct(3,"OOP" , 39.99F , "O’Reilly" , "X Publications");

        availableProducts.addProduct(phone);
        availableProducts.addProduct(shirt);
        availableProducts.addProduct(book);


        //frame 1
        JFrame welcomeFrame = new JFrame("Welcome!");
        welcomeFrame.setSize(WIDTH,HEIGHT);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setResizable(false);


        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(null);

        JLabel customerNameLabel = new JLabel("Name");
        customerNameLabel.setBounds(150,40,80,25);
        welcomePanel.add(customerNameLabel);

        JTextField customerNameField = new JTextField(20);
        customerNameField.setBounds(250,40,165,25);
        welcomePanel.add(customerNameField);

        JLabel customerIdLabel = new JLabel("ID");
        customerIdLabel.setBounds(150,90,80,25);
        welcomePanel.add(customerIdLabel);

        JTextField customerIdField = new JTextField(20);
        customerIdField.setBounds(250,90,165,25);
        welcomePanel.add(customerIdField);

        JLabel customerAddressLabel = new JLabel("Address");
        customerAddressLabel.setBounds(150,140,80,25);
        welcomePanel.add(customerAddressLabel);

        JTextField customerAddressField = new JTextField(20);
        customerAddressField.setBounds(250,140,165,25);
        welcomePanel.add(customerAddressField);

        JLabel orderIdLabel = new JLabel("Order ID");
        orderIdLabel.setBounds(150,190,80,25);
        welcomePanel.add(orderIdLabel);

        JTextField orderIdField = new JTextField();
        orderIdField.setBounds(250,190,165,25);
        welcomePanel.add(orderIdField);

        JButton infoButton = new JButton("Submit");
        //Action listener bellow
        infoButton.setBounds(150,280,80,25);
        welcomePanel.add(infoButton);

        welcomeFrame.add(welcomePanel);
        welcomeFrame.setVisible(true);


        //frame2

        Customer customer = new Customer(customerID,customerName,customerAddress);
        Cart cart = new Cart(customerID , availableProducts);

        JFrame cartFrame = new JFrame("Cart");
        cartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartFrame.setSize(WIDTH,HEIGHT);
        cartFrame.setLocationRelativeTo(null);
        cartFrame.setResizable(false);

        JPanel productsPanel = new JPanel();
        productsPanel.setPreferredSize(new Dimension(WIDTH/2 ,HEIGHT));
        productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));

        JPanel cartPanel = new JPanel();
        productsPanel.setSize(new Dimension((WIDTH/2)-40 ,HEIGHT));
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        JLabel labelTemp1 = new JLabel("Welcome " + customer.getName() +" !" );
        cartPanel.add(labelTemp1);
        JLabel labelTemp2 = new JLabel("Cart");
        cartPanel.add(labelTemp2);
        cartPanel.add(Box.createVerticalStrut(20));
        JButton orderButton = new JButton("Place Order");
        cartPanel.add(orderButton);
        cartPanel.add(Box.createVerticalStrut(20));
        JLabel labelTemp4 = new JLabel("Total: $" +cart.calculatePrice());
        cartPanel.add(labelTemp4);
        cartPanel.add(Box.createVerticalStrut(20));

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                cart.addProduct(Integer.parseInt(clickedButton.getName()));
                JLabel label = new JLabel(availableProducts.getProduct(Integer.parseInt(clickedButton.getName())).getName());
                cartPanel.add(label);
                labelTemp4.setText("Total: $" + cart.calculatePrice());


                cartPanel.revalidate();
                cartPanel.repaint();
                System.out.println(customerID + customerName + customerAddress + orderID);
                System.out.println("ID PRESSED: " + Integer.parseInt(clickedButton.getName()));
            }
        };
        // ID ::: Integer.parseInt(clickedButton.getName())

        String[] productInfo = availableProducts.getProductsInfo();
        Integer[] IDs = availableProducts.getIDs();



        for (int i = 0 ; i< availableProducts.length() ; i++){
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel label = new JLabel(productInfo[i]);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton button = new JButton();
            button.setText("ADD TO CART");
            button.setName(String.valueOf(IDs[i]));
            button.addActionListener(listener);

            JLabel filler = new JLabel("");
            filler.setPreferredSize(new Dimension(30, 0));

            panel.add(label);
            panel.add(filler);
            panel.add(button);

            productsPanel.add(Box.createVerticalStrut(20));
            productsPanel.add(panel);


        }

        container.add(Box.createHorizontalStrut(40));
        cartPanel.add(Box.createHorizontalGlue());
        container.add(productsPanel);
        container.add(cartPanel);

        cartFrame.getContentPane().add(container);



        //frame 3

        JFrame receiptFrame = new JFrame("Receipt");
        receiptFrame.setSize(WIDTH/2,HEIGHT);
        receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        receiptFrame.setLocationRelativeTo(null);
        receiptFrame.revalidate();
        receiptFrame.repaint();

        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));





        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    customerID = Integer.parseInt(customerIdField.getText());
                    customerName = customerNameField.getText();
                    customerAddress = customerAddressField.getText();
                    orderID = Integer.parseInt(orderIdField.getText());

                    JOptionPane.showMessageDialog(welcomeFrame, "ID: "+customerID +"\nName: "+customerName+"\nAddress: "+customerAddress+"\nOrderID: "+orderID);

                    welcomeFrame.dispose();
                    cartFrame.setVisible(true);


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(welcomeFrame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();

                Order order = cart.placeOrder(orderID);

                cartFrame.dispose();

                JLabel labelTemp5 = new JLabel("Name: "+customerName);
                receiptPanel.add(labelTemp5);
                JLabel labelTemp6 = new JLabel("Address: "+customerAddress);
                receiptPanel.add(labelTemp6);

                ArrayList<String> list = order.getOrderInfo();

                for (String s : list) {
                    JLabel label = new JLabel();
                    label.setText(s);
                    receiptPanel.add(label);

                    receiptPanel.revalidate();
                    receiptPanel.repaint();
                }

                receiptFrame.add(receiptPanel);
                receiptFrame.setVisible(true);
            }
        });
    }


}
