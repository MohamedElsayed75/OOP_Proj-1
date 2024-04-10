public class Customer {
    //ID has to be +ve
    private int customerID;
    private String name;
    private String address;

    public Customer(int customerID, String name, String address) {
        if (customerID <0 ) this.customerID = Math.abs(customerID);
        else this.customerID = customerID;

        this.name = name;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
