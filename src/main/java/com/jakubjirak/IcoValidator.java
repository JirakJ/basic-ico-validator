package com.jakubjirak;

public class IcoValidator {
    private static int EXPECTED_ICO_LENGTH =  8;

    /**
     * This method returns true if ICO is valid
     * */
    public boolean check(String ico) {
        try {
            int a = 0;
            if(ico.length() == 0)
                throw new Exception(String.format("Invalid length of %d.", ico.length()));
            if(ico == null)
                throw new Exception("Null as input");
            if(ico.length() != EXPECTED_ICO_LENGTH)
                throw new Exception(String.format("Invalid length of %d.", ico.length()));
            String[] icoNumbers = ico.split("");
            int c = 0;
            for (int i = 0; i < EXPECTED_ICO_LENGTH-1; i++) {
                a += Integer.valueOf(icoNumbers[i]) * ( EXPECTED_ICO_LENGTH - i);
                System.out.println(String.format("%s * %d = %d",icoNumbers[i],8-i,Integer.valueOf(icoNumbers[i]) * ( 8 - i)));
            }


            System.out.println(String.format("%d mod 11 = %d",a,a%11));
            System.out.println(String.format("11 - %d = %d",a%11, 11-a%11));
            System.out.println(String.format("%d mod 10 = %d",11-a%11, (11-a%11)%10));

            a %= 11;
            c = 11 - a;
            c %= 10;

            if(Integer.valueOf(icoNumbers[7]) != c ) {
                throw new Exception(String.format("Given check number (%s) is different than expected check number (%d).",icoNumbers[7], c));
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IcoValidator icoValidator = new IcoValidator();
        System.out.println(icoValidator.check("Put here ICO"));
    }
}
