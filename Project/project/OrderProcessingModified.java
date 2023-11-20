package project;

import java.util.Scanner;

import project.Print.Finish;
import project.Print.ProcessingTime;
import project.Print.Size;

public class OrderProcessingModified {
    public static double processOrder(int quantity, Size size, Finish finish, ProcessingTime processingTime, boolean promotionCode, boolean separate) {
        Order o = new Order();

        if (quantity <= 0 || quantity < 100) {
            return o.getTotal();
        }

        o.addPrints(quantity, size, finish, processingTime, promotionCode, separate);

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

        if (o.total > 35 && (promotionCode || separate)) {
            o.total *= 0.95;
        }
        
        o.setTotal(Math.round(o.total * 100) / 100.0);
        return o.total;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int userQuantity;
        int userSize;
        int userFinish;
        int userProcessingTime;
        int userPromotionCode;
        int userSeparate;

        int checkedQuantity;
        Size checkedSize;
        Finish checkedFinish;
        ProcessingTime checkedProcessingTime;
        boolean checkedPromotionCode;
        boolean checkedSeparate;

        System.out.println("Please enter the number of prints you would like [Enter an integer 1 - 100]: ");
        
        try {
            userQuantity = Integer.parseInt(scan.nextLine());
        } catch(Exception e) {
            System.out.println("Invalid input");
            scan.close();
            return;
        }

        System.out.println("Please enter your desired print size [Enter an integer 0 - 2]: ");
        System.out.println("0: 4 x 6\n1: 5 x 7\n2: 8 x 10\n");
        
        try {
            userSize = Integer.parseInt(scan.nextLine());
        } catch(Exception e) {
            System.out.println("Invalid input");
            scan.close();
            return;
        }

        System.out.println("Please enter your desired print finish [Enter an integer 0 - 1]: ");
        System.out.println("0: Glossy\n1: Matte\n");
        
        try {
            userFinish = Integer.parseInt(scan.nextLine());
        } catch(Exception e) {
            System.out.println("Invalid input");
            scan.close();
            return;
        }

        System.out.println("Please enter your desired processing time [Enter an integer 0 - 1]: ");
        System.out.println("0: Next Day\n1: One Hour\n");
        
        try {
            userProcessingTime = Integer.parseInt(scan.nextLine());
        } catch(Exception e) {
            System.out.println("Invalid input");
            scan.close();
            return;
        }

        System.out.println("Do you have a valid promotional code? [Enter an integer 0 - 1]: ");
        System.out.println("0: Yes\n1: No\n");
        
        try {
            userPromotionCode = Integer.parseInt(scan.nextLine());
        } catch(Exception e) {
            System.out.println("Invalid input");
            scan.close();
            return;
        }

        if (userPromotionCode == 0) {
            System.out.println("Please enter the promotional code: ");
            String code = scan.nextLine();

            if (code.equals("N56M2")) {
                System.out.println("Valid code entered.");
                checkedPromotionCode = true;
            } else {
                System.out.println("Invalid code entered.");
                checkedPromotionCode = false;
            }
        } else {
            checkedPromotionCode = false;
        }

        System.out.println("Will all prints in the order have the same size, finish, and processing time? [Enter an integer 0 - 1]: ");
        System.out.println("0: Yes\n1: No\n");
        
        try {
            userSeparate = Integer.parseInt(scan.nextLine());
        } catch(Exception e) {
            System.out.println("Invalid input");    
            scan.close();
            return;
        }
        
        scan.close();

        if (userQuantity <= 0 || userQuantity > 100) {
            System.out.println("Quantity out of range.");
            return;
        } else {
            checkedQuantity = userQuantity;
        }

        if (userSize == 0) {
            checkedSize = Size.FOUR_BY_SIX;
        } else if (userSize == 1) {
            checkedSize = Size.FIVE_BY_SEVEN;
        } else if (userSize == 2) {
            checkedSize = Size.EIGHT_BY_TEN;
        } else {
            System.out.println("Size out of range.");
            return;
        }

        if (userFinish == 0) {
            checkedFinish = Finish.GLOSSY;
        } else if (userFinish == 1) {
            checkedFinish = Finish.MATTE;
        } else {
            System.out.println("Finish out of range.");
            return;
        }

        if (userProcessingTime == 0) {
            checkedProcessingTime = ProcessingTime.NEXT_DAY;
        } else if (userProcessingTime == 1) {
            checkedProcessingTime = ProcessingTime.ONE_HOUR;
        } else {
            System.out.println("Processing time out of range.");
            return;
        }

        if (userSeparate == 0) {
            checkedSeparate = false;
        } else if (userSeparate == 1) {
            checkedSeparate = true;
        } else {
            System.out.println("Separate out of range.");
            return;
        }

        double userTotal = processOrder(checkedQuantity, checkedSize, checkedFinish, checkedProcessingTime, checkedPromotionCode, checkedSeparate);
        System.out.println("Your total will be $" + userTotal);
    }
}
