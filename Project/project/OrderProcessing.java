package project;

import project.Print.Finish;
import project.Print.ProcessingTime;
import project.Print.Size;

public class OrderProcessing {
    public static double processOrder(int quantity, Size size, Finish finish, ProcessingTime processingTime, boolean promotionCode, boolean separate) {
        Order o = new Order();
        o.addPrints(quantity, size, finish, processingTime, promotionCode, separate);

        if (quantity <= 0 || quantity > 100) {
            return o.getTotal();
        }

        int count = 1;

        if (!o.separate) {
            Print current = o.first;

            while (current != null) {
                if (count <= 50) {
                    switch (current.finish) {
                        case GLOSSY:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    o.total += 0.14;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    o.total += 0.34;
                                    break;

                                case EIGHT_BY_TEN:
                                    o.total += 0.68;
                                    break;
                            }
                            break;
                    
                        case MATTE:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    o.total += 0.16;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    o.total += 0.37;
                                    break;

                                case EIGHT_BY_TEN:
                                    o.total += 0.72;
                                    break;
                            }
                            break;
                    }
                } else if (count <= 75) {
                    switch (current.finish) {
                        case GLOSSY:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    o.total += 0.12;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    o.total += 0.31;
                                    break;

                                case EIGHT_BY_TEN:
                                    o.total += 0.64;
                                    break;
                            }
                            break;
                    
                        case MATTE:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    o.total += 0.14;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    o.total += 0.34;
                                    break;

                                case EIGHT_BY_TEN:
                                    o.total += 0.68;
                                    break;
                            }
                            break;
                    }
                } else {
                    switch (current.finish) {
                        case GLOSSY:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    o.total += 0.10;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    o.total += 0.28;
                                    break;

                                case EIGHT_BY_TEN:
                                    o.total += 0.60;
                                    break;
                            }
                            break;
                    
                        case MATTE:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    o.total += 0.12;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    o.total += 0.31;
                                    break;

                                case EIGHT_BY_TEN:
                                    o.total += 0.64;
                                    break;
                            }
                            break;
                    }
                }

                count++;
                current = current.next;
            }

            if (o.first.processingTime == ProcessingTime.ONE_HOUR) {
                if (quantity <= 60) {
                    o.total += 1;
                } else {
                    o.total += 1.5;
                }
            }

            if (promotionCode && quantity == 100) {
                o.total -= 2;
            }
        } else {
            boolean addCharge = false;
            Print current = o.first;

            while (current != null) {
                switch (current.finish) {
                    case GLOSSY:
                        switch (current.size) {
                            case FOUR_BY_SIX:
                                o.total += 0.19;
                                break;
                        
                            case FIVE_BY_SEVEN:
                                o.total += 0.39;
                                break;
                            
                            case EIGHT_BY_TEN:
                                o.total += 0.79;
                        }
                        break;
                
                    case MATTE:
                        switch (current.size) {
                            case FOUR_BY_SIX:
                                o.total += 0.23;
                                break;
                        
                            case FIVE_BY_SEVEN:
                                o.total += 0.45;
                                break;
                            
                            case EIGHT_BY_TEN:
                                o.total += 0.87;
                        }
                        break;
                }

                if (current.processingTime == ProcessingTime.ONE_HOUR) {
                    addCharge = true;
                }

                count++;
                current = current.next;
            }

            if (addCharge) {
                if (quantity <= 60) {
                    o.total += 2;
                } else {
                    o.total += 2.5;
                }
            }
        }

        if (o.total > 35 && (!promotionCode || separate)) {
            o.total *= 0.95;
        }
        
        o.setTotal(Math.round(o.total * 100) / 100.0);
        return o.total;
    }
}
