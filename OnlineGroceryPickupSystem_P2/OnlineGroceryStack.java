
package OnlineGroceryPickupSystem;

import java.io.PrintWriter;

public class OnlineGroceryStack {

    private Order top;

    public OnlineGroceryStack() {
        top = null;
    }

    public Order getTop() {
        return top;
    }

    public void setTop(Order top) {
        this.top = top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Order newOrder) {
        top = newOrder;
    }

    public Order pop() {
        if (!isEmpty()) {
            Order temp = top;
            top = top.getNextS();
            return temp;
        }
        return null;

    }

    public Order top() {
        if (!isEmpty()) {
            return top;
        }
        return null;
    }

    public void printStack(PrintWriter output) {
        while (!isEmpty()) {
            output.println(top.toString());
            output.println("-----------------------------------------------");
            top = top.getNextS();
        }

    }

}
