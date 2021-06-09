package com.jakubjirak;

import java.security.SecureRandom;

public class IcoGenerator {
    private static int EXPECTED_ICO_LENGTH =  8;

    static final String AB = "0123456789";
    static SecureRandom rnd = new SecureRandom();

    private String randomIco(){
        StringBuilder sb = new StringBuilder(EXPECTED_ICO_LENGTH);
        for(int i = 0; i < EXPECTED_ICO_LENGTH; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    private String stringArrayToString(String[] stringArray){
        StringBuffer sb = new StringBuffer();
        for (String s : stringArray) {
            sb.append(s);
        }
        return sb.toString();
    }


    /**
     * This method returns valid ICO
     * */
    public String generate() {
        String ico= randomIco();

        int a = 0;
        String[] icoNumbers = ico.split("");
        for (int i = 0; i < EXPECTED_ICO_LENGTH-1; i++) {
            a += Integer.valueOf(icoNumbers[i]) * ( EXPECTED_ICO_LENGTH - i);
        }
        a %= 11;
        int c = 11 - a;

        c %= 10;

        if(Integer.valueOf(icoNumbers[7]) != c ) {
            icoNumbers[7] = String.valueOf(c);
        }


        return stringArrayToString(icoNumbers);
    }

    public static void main(String[] args) {
        IcoValidator icoValidator = new IcoValidator();
        IcoGenerator icoGenerator = new IcoGenerator();

        String generatedIco  = icoGenerator.generate();

        System.out.println(generatedIco);
        System.out.println(icoValidator.check(generatedIco));
    }
}
