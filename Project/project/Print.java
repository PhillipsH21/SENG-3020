package project;

public class Print {
    enum Size {
        FOUR_BY_SIX,
        FIVE_BY_SEVEN,
        EIGHT_BY_TEN;
    }

    enum Finish {
        GLOSSY,
        MATTE;
    }

    enum ProcessingTime {
        NEXT_DAY,
        ONE_HOUR;
    }
    
    Size size;
    Finish finish;
    ProcessingTime processingTime;

    Print next;

    public Print(Size size, Finish finish, ProcessingTime processingTime) {
        if (size == null) {
            this.size = Size.FOUR_BY_SIX;
        } else{
            this.size = size;
        }

        if (finish == null) {
            this.finish = Finish.GLOSSY;
        } else {
            this.finish = finish;
        }

        if (processingTime == null) {
            this.processingTime = ProcessingTime.NEXT_DAY;
        } else {
            this.processingTime = processingTime;
        }

        this.next = null;
    }
}
