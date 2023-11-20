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

    public Order() {
        this.first = null;
        this.last = null;
        this.quantity = 0;
        this.separate = false;
        this.promotionCode = false;
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

    public void checkSeparate() {
        if (this.first == null) {
            this.separate = false;
        } else {
            Print current = this.first;

            while (current != null) {
                if (current.size != current.next.size || current.finish != current.next.finish || current.processingTime != current.next.processingTime) {
                    this.separate = true;
                    return;
                }

                current = current.next;
            }
        }
    }

    public double processOrder() {
        if (this.quantity <= 0 || this.quantity > 100) {
            return 0;
        }

        double total = 0;
        int count = 1;

        if (!separate) {
            Print current = this.first;

            while (current != null) {
                if (count <= 50) {
                    switch (current.finish) {
                        case GLOSSY:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    total += 0.14;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    total += 0.34;
                                    break;

                                case EIGHT_BY_TEN:
                                    total += 0.68;
                                    break;
                            }
                            break;
                    
                        case MATTE:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    total += 0.16;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    total += 0.37;
                                    break;

                                case EIGHT_BY_TEN:
                                    total += 0.72;
                                    break;
                            }
                            break;
                    }
                } else if (count <= 75) {
                    switch (current.finish) {
                        case GLOSSY:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    total += 0.12;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    total += 0.31;
                                    break;

                                case EIGHT_BY_TEN:
                                    total += 0.64;
                                    break;
                            }
                            break;
                    
                        case MATTE:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    total += 0.14;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    total += 0.34;
                                    break;

                                case EIGHT_BY_TEN:
                                    total += 0.68;
                                    break;
                            }
                            break;
                    }
                } else {
                    switch (current.finish) {
                        case GLOSSY:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    total += 0.10;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    total += 0.28;
                                    break;

                                case EIGHT_BY_TEN:
                                    total += 0.60;
                                    break;
                            }
                            break;
                    
                        case MATTE:
                            switch (current.size) {
                                case FOUR_BY_SIX:
                                    total += 0.12;
                                    break;
                            
                                case FIVE_BY_SEVEN:
                                    total += 0.31;
                                    break;

                                case EIGHT_BY_TEN:
                                    total += 0.64;
                                    break;
                            }
                            break;
                    }
                }

                count++;
                current = current.next;
            }

            if (this.first.processingTime == ProcessingTime.ONE_HOUR) {
                if (quantity <= 60) {
                    total += 1;
                } else {
                    total += 1.5;
                }
            }

            if (promotionCode && quantity == 100) {
                total -= 2;
            }
        } else {
            boolean addCharge = false;
            Print current = this.first;

            while (current != null) {
                switch (current.finish) {
                    case GLOSSY:
                        switch (current.size) {
                            case FOUR_BY_SIX:
                                total += 0.19;
                                break;
                        
                            case FIVE_BY_SEVEN:
                                total += 0.39;
                                break;
                            
                            case EIGHT_BY_TEN:
                                total += 0.79;
                        }
                        break;
                
                    case MATTE:
                        switch (current.size) {
                            case FOUR_BY_SIX:
                                total += 0.23;
                                break;
                        
                            case FIVE_BY_SEVEN:
                                total += 0.45;
                                break;
                            
                            case EIGHT_BY_TEN:
                                total += 0.87;
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
                    total += 2;
                } else {
                    total += 2.5;
                }
            }
        }

        if (total > 35 && (!promotionCode || separate)) {
            total *= 0.95;
        }
        
        total = Math.round(total * 100) / 100.0;
        return total;
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