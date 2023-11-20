package project;

import project.Print.Finish;
import project.Print.ProcessingTime;
import project.Print.Size;

public class OrderProcessing {
    public static double processOrder(int quantity, Size size, Finish finish, ProcessingTime processingTime, boolean promotionCode, boolean separate) {
        Order o = new Order();
        o.addPrints(quantity, size, finish, processingTime, promotionCode, separate);
        return o.getTotal();
    }
}
