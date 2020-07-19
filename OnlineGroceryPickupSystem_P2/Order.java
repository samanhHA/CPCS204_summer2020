
package OnlineGroceryPickupSystem;

import java.util.Arrays;

public class Order {

    private int orderID;
    private String customerName, customerID, orderTime, pickupTime;
    private String[] orderItems;
    private String[] quantities;
    private Order nextQ, nextS;

    //constructor
    public Order() {
    }

    public Order(int orderID, String customerName, String customerID, String orderTime, String pickupTime, String[] orderItems, String[] quantities) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerID = customerID;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.orderItems = orderItems;
        this.quantities = quantities;

    }

    //Track next Node 
    public void setNextQ(Order nextQ) {
        this.nextQ = nextQ;
    }

    public void setNextS(Order nextS) {
        this.nextS = nextS;
    }

    public Order getNextQ() {
        return nextQ;
    }

    public Order getNextS() {
        return nextS;
    }

    //setters
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public void setOrderItems(String[] orderItems) {
        this.orderItems = orderItems;
    }

    public void setQuantities(String[] quantities) {
        this.quantities = quantities;
    }

    //getters
    public int getOrderID() {
        return orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public String[] getOrderItems() {
        return orderItems;
    }

    public String[] getQuantities() {
        return quantities;
    }

    @Override
    public String toString() {
        return "customer ID: " + customerID + "\ncustomer name: " + customerName + "\norder time: " + orderTime
                + "\npickupTime: " + pickupTime + "\norder items: " + Arrays.toString(orderItems).replace('[', ' ').replace(']', ' ').trim() + "\nquantity: " + Arrays.toString(quantities).replace('[', ' ').replace(']', ' ').trim() + "\n";
    }

}
