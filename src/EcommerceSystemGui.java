import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EcommerceSystemGui {
    public static void main(String[] args){
        AvailableProducts availableProducts = new AvailableProducts();


        ElectronicProduct phone = new ElectronicProduct(1,"smartphone" , 599.9F , "Samsung" , 1);
        ClothingProduct shirt = new ClothingProduct(2 , "T-shirt" , 19.99F , "Medium" , "Cotton");
        BookProduct book = new BookProduct(3,"OOP" , 39.99F , "O’Reilly" , "X Publications");

        Customer customer1 = new Customer(23010154 , "MohamedElsayed" , "Address");

        availableProducts.addProduct(phone);
        availableProducts.addProduct(shirt);
        availableProducts.addProduct(book);

        Cart cart = new Cart(customer1.getCustomerID() , availableProducts);



        JFrame frame = new JFrame("Ecommerce System");
        frame.setSize(1300,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));
//        productsPanel.setBackground(Color.RED);
        productsPanel.setPreferredSize(new Dimension(700, 550));

        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
//        cartPanel.setBackground(Color.BLUE);
        cartPanel.setPreferredSize(new Dimension(600, 550));






        JLabel welcome = new JLabel("Welcome!, Cart:");
        welcome.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel cartContPanel = new JPanel();
        cartContPanel.setLayout(new BoxLayout(cartContPanel, BoxLayout.Y_AXIS));
        JLabel cartCont = new JLabel();
        cartContPanel.add(cartCont);
        cartCont.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel textInLabel = new JLabel("Order ID:");
        JTextField textField = new JTextField();

        JButton order = new JButton("PLACE ORDER");


        ActionListener orderListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                Order order = cart.placeOrder(Integer.parseInt(textField.getText()));
                for (int i=0 ; i<order.getOrderInfo().size() ; i++){
                    JPanel panel = new JPanel();

                    JLabel label = new JLabel();
                    label.setText(order.getOrderInfo().get(i));
                    panel.add(label);

                    textInLabel.setVisible(false);
                    textField.setVisible(false);
                    cartContPanel.setVisible(false);
                    clickedButton.setVisible(false);
                    welcome.setText("Receipt:");
                    cartPanel.add(Box.createVerticalStrut(20));
                    cartPanel.add(panel);
                }

            }
        };

        cartPanel.add(welcome);
        cartPanel.add(Box.createVerticalStrut(20));
        cartPanel.add(cartContPanel);
        cartPanel.add(Box.createVerticalStrut(40));

        cartPanel.add(textInLabel);
        cartPanel.add(textField);

        order.addActionListener(orderListener);

        cartPanel.add(order);




        String[] productInfo = availableProducts.getProductsInfo();
        Integer[] IDs = availableProducts.getIDs();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                cart.addProduct(Integer.parseInt(clickedButton.getName()));
                cartCont.setText(cart.getProductNames());
                System.out.println("ID PRESSED: " + Integer.parseInt(clickedButton.getName()));
            }
        };
        // ID ::: Integer.parseInt(clickedButton.getName())

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


        container.add(productsPanel);
        container.add(cartPanel);

        frame.getContentPane().add(container);

        frame.pack();
        frame.setVisible(true);
    }



}
