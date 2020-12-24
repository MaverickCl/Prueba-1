/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

//@author Diego Garrido

public class Generala {


    public static int chance(int... dice)
    {
       int total = 0;
        for (int die : dice)
            total+=die;
        return total;
    }

    public static int generala(int... dice){
        int[] counts = counter(dice);
        for (int i = 0; i <6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int... dice) {

        return sumEqualDice(1, dice);

    }

    public static int twos(int... dice) {
        return sumEqualDice(2, dice);
    }

    public static int threes(int... dice) {
        return sumEqualDice(3, dice);
    }

    protected int[] dice= new int[5];

    public Generala(int... dices) {
        int n=0;
      for(int i:dices) {
          dice[n] = i;
          n++;
      }
    }

    public int fours() {
       return sumEqual(dice, 4);
    }

    public int fives() {
        return sumEqual(dice, 5);
    }

    public int sixes() {
        return sumEqual(dice, 6);
    }

    public static int score_pair(int... dice) {
        int[] tallies =counter(dice);
        for (int i = 0; i<6; i++)
            if (tallies[6-i-1] >= 2)
                return (6-i)*2;
        return 0;
    }

    public static int two_pair(int... dice) {
        int[] tallies =counter(dice);
        int score = 0,n = 0;
        for (int i = 0; i < 6; i += 1)
            if (tallies[6-i-1] >= 2) {
                score += (6-i);
                n++;
            }
        if (n == 2) return score * 2;

        return 0;
    }

    public static int four_of_a_kind(int... dice) {
        int[] tallies =counter(dice);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int... dice) {
        int[] tallies =counter(dice);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int... dice) {
        int[] tallies =counter(dice);
        if(itsSmall(tallies))return 15;
        return 0;
    }

    public static int largeStraight(int... dice) {
        int[] tallies =counter(dice);
        if(itsLarge(tallies))return 20;
        return 0;
    }

    public static int fullHouse(int... dice) {
        int resultDouble=0,resultTriple = 0, result=0;
        boolean itsDouble=false,itsTriple = false;
        int[] tallies =counter(dice);

        for (int i = 0; i<6; i++)
            if (tallies[i] == 2) {
                itsDouble = true;
                resultDouble = i+1;
            }
        for (int i = 0; i<6; i += 1)
            if (tallies[i] == 3) {
                itsTriple = true;
                resultTriple = i+1;
            }
        if(itsTriple&&itsDouble) result= (resultDouble*2)+(resultTriple*3);
        
        return result;
    }

    public static int[] counter(int... dice){
        int[] tallies = tallies = new int[6];
        for(int i:dice)
            tallies[i-1]++;
        return tallies;
    }

    public static int sumEqual(int[] numbers, int number){
        int total=0;
        for(int i=0; i <numbers.length; i++){
            if(numbers[i]==number)total+=numbers[i];
        }
        return total;
    }
    public static int sumEqualDice(int number,int ...dice){
        int total=0;
        for(int die: dice)
            if(die==number)total+=number;

        return total;
    }
    public static boolean itsLarge(int[] tallies){
        return(tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1);
    }
    public static boolean itsSmall(int[] tallies){
        return(tallies[0] == 1 && tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1);
    }

}

