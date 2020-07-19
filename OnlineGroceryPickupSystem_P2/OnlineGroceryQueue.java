
package OnlineGroceryPickupSystem;

import java.io.PrintWriter;

public class OnlineGroceryQueue {

    private Order front, back;
    private int numOrders;

    public OnlineGroceryQueue() {
        front = null;
        back = null;
    }

    public OnlineGroceryQueue(Order front, Order back, int numOrders) {
        this.front = front;
        this.back = back;
        this.numOrders = numOrders;
    }

    public void setFront(Order front) {
        this.front = front;
    }

    public void setBack(Order back) {
        this.back = back;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders = numOrders;
    }

    public Order getFront() {
        return front;
    }

    public Order getBack() {
        return back;
    }

    public int getNumOrders() {
        return numOrders;
    }

    //Operations
    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Order newOrder) {
        if (front == null) {
            front = newOrder;
            back = front;
        } else {
            back.setNextQ(newOrder);
            back = back.getNextQ();
        }
    }

    public Order dequeue() {
        Order order = front;
        if (!isEmpty()) {
            if (front.getNextQ() == null) {
                front = front.getNextQ();
                back = back.getNextQ();
            } else {
                front = front.getNextQ();
            }

        }

        return order;
    }

    public String peek() {
        if (!isEmpty()) {
            return front.toString();
        }
        return " ";
    }

    public void printQueue(PrintWriter output) {
        while (!isEmpty()) {
            output.println(front.toString());
            output.println("-----------------------------------------------");
            front = front.getNextQ();
        }
    }

}
