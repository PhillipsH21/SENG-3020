package eost;

import eost.Insurance.Status.*;

public class Insurance {

    enum Status { YES, NO, NOT_STATED };

    /**
     * Calculate insurance premium.<br>
     *
     * The basic cost of an insurance premium for drivers is EUR 500.<br>
     *
     * This premium can increase or decrease depending on: age, no-claims-bonus, and ocupation.<br>
     *
     * a) There is an premium increase of EUR 1500 for drivers that are below the age of 25<br>
     * b) There is a premium reduction of EUR 200 for drivers who are at least 25, have an ncb, and:<br>
     *    - have a low risk occupation<br>
     *    and/or<br>
     *    - are less than 45 years old<br>
     *
     * Drivers younger than 16 or older than 65 will not be insured.<br>
     *
     * @param age - age of person to be insured
     * @param ncb - no claims bonus status
     * @param lowRisk - true if have a low risk occupation
     *
     * @return
     *  500 - base insurance premium<br>
     * 2000 - premium for drivers less than 25<br>
     *  300 - premium for drivers who are at least 25, have an ncb and a low risk occupation<br>
     *  300 - premium for drivers who are at least 25, have an ncb and are less than 45 years old<br>
     *    0 - are not eligible for insurance<br>
     *   -1 - invalid inputs (invalid age or ncb not stated)<br>
     */
    public static int premium( int age, Status ncb, boolean lowRisk ) {

        int p=-1;

        if (age>=0 && ncb!=Status.NOT_STATED) {

            // Check if uninsurable
            if (age<16 || age>65)
                p=0;

                // Otherwise, determine premium
            else {
                p=500;
                if (age<25)
                    p += 1500;
                else if ((age<45 || lowRisk) && ncb==Status.YES)
                    p -= 200;
            }

        }

        // Return the result
        return p;

    }

}
