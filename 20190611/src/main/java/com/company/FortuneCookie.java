package com.company;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {

        Random rand1 = new Random();
        Random rand2 = new Random();
        int randFortune = rand1.nextInt((3-1)+1)+1;
        int[] lottoNums = new int[6];

        //adds lotto numbers to array
        for (int i = 0; i < 6; i++){
            lottoNums[i] = rand2.nextInt((54-1)+1)+1;
        }

        if (randFortune == 1) {
            System.out.println("You will fall onto great wealth");
            System.out.println(lottoNums[0] + " - " + lottoNums[1] + " - " + lottoNums[2] + " - " + lottoNums[3] + " - " +
                    lottoNums[4] + " - " + lottoNums[5]);
        }else if (randFortune == 2){
            System.out.println("A big vacation will be gifted to you soon");
            System.out.println(lottoNums[0] + " - " + lottoNums[1] + " - " + lottoNums[2] + " - " + lottoNums[3] + " - " +
                    lottoNums[4] + " - " + lottoNums[5]);
        }else {
            System.out.println("Love will find you soon");
            System.out.println(lottoNums[0] + " - " + lottoNums[1] + " - " + lottoNums[2] + " - " + lottoNums[3] + " - " +
                    lottoNums[4] + " - " + lottoNums[5]);
        }
    }
}
