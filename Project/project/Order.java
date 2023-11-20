package project;

import project.Print.Finish;
import project.Print.ProcessingTime;
import project.Print.Size;

public class Order {
    Print first;
    Print last;
    int quantity;
    boolean separate;
    boolean promotionCode;
    double total;

    public Order() {
        this.first = null;
        this.last = null;
        this.quantity = 0;
        this.separate = false;
        this.promotionCode = false;
        this.total = 0;
    }

    public void addPrints(int quantity, Size size, Finish finish, ProcessingTime processingTime, boolean promotionCode, boolean separate) {
        for (int i = 0; i < quantity; i++) {
            Print newPrint = new Print(size, finish, processingTime);

            if (this.first == null) {
                this.first = newPrint;
                this.last = newPrint;
            } else {
                this.last.next = newPrint;
                this.last = newPrint;
            }
        }

        this.quantity += quantity;

        if (separate) {
            this.separate = true;
        }

        if (promotionCode) {
            this.promotionCode = true;
        }
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getSeparate() {
        return this.separate;
    }

    public void setSeparate(boolean separate) {
        this.separate = separate;
    }

    public boolean getPromotionCode() {
        return this.promotionCode;
    }

    public void setPromotionCode(boolean promotionCode) {
        this.promotionCode = promotionCode;
    }
}