package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter number of frames:");
        Scanner scanner = new Scanner(System.in);
        int numberOfFrames = scanner.nextInt();
        System.out.print("Enter number of Pages:");
        int numberOfPages = scanner.nextInt();
        int[][] lol = new int[numberOfPages][numberOfFrames];
        for(int i=0;i<numberOfPages;i++){
            for(int j=0;j<numberOfFrames;j++){
                lol[i][j] = -1;
            }
        }
        System.out.println("Enter Page sequence:");
        int[] pageSequence = new int[numberOfPages];
        for(int i=0;i<numberOfPages;i++){
            pageSequence[i] = scanner.nextInt();
        }
        int hit = 0;
        lru(numberOfFrames, numberOfPages, lol, pageSequence);
        String[] hi = new String[numberOfPages];
        hit = getHit(numberOfFrames, numberOfPages, lol, hit, hi);
        display(numberOfPages, lol,numberOfFrames,hit,numberOfPages-hit);
    }

    private static void display(int numberOfPages, int[][] lol,int numberOfFrames,int hit,int miss) {
        for(int i=0;i<numberOfPages;i++){
            for (int j=0;j<numberOfFrames;j++){
                System.out.print(lol[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("Hit ratio is"+hit);
        System.out.println("Miss ratio is"+miss);
    }

    private static void lru(int numberOfFrames, int numberOfPages, int[][] lol, int[] pageSequence) {
        Main main = new Main();
        int temp = 0;
        for(int i=0;i<numberOfPages;i++){
            if(i < numberOfFrames){
                if(i-1 >= 0){
                    System.arraycopy(lol[i - 1], 0, lol[i], 0, 3);
                }
                lol[i][temp++] = pageSequence[i];
                if(temp == numberOfFrames){
                    temp = 0;
                }
            }
            else {
                if (i - 1 >= 0) {
                    System.arraycopy(lol[i - 1], 0, lol[i], 0, numberOfFrames);
                }
                if (check(lol,pageSequence[i],numberOfFrames,i)) {
                    lol[i][getIndexOfLol(lol, pageSequence, i, numberOfFrames)] = pageSequence[i];
                }
            }
        }
    }
    private static boolean check(int[][] lol,int pagei,int numberOfFrames,int index){
        int count = 0;
        for(int i=0;i<numberOfFrames;i++){
            if(lol[index][i] == pagei){
                count++;
            }
        }
        return count == 0;
    }

    private static int getLru(int[] ps,int index,int numberOfFrames,int[][] lol){
        while (true) {
            if (checkForExistence(ps, index, lol, numberOfFrames)) {
                return ps[index - numberOfFrames];
            }
            else {
                if(index >= 1) {
                    index = index - 1;
                }
            }
        }
    }

    private static boolean checkForExistence(int[] ps,int givenIndex,int[][] lol,int numberOfFrames){
        int count = 0;
        int[] temp = new int[numberOfFrames];
        System.arraycopy(lol[givenIndex], 0, temp, 0, numberOfFrames);
        for(int i=0;i<numberOfFrames;i++){
            for(int j=givenIndex-numberOfFrames;j<=givenIndex;j++){
                if(temp[i] == ps[j]){
                    temp[i] = -1;
                    count++;
                }
            }
        }
        System.arraycopy(lol[givenIndex], 0, temp, 0, numberOfFrames);
        return count == numberOfFrames;
    }
    private static int getIndexOfLol(int[][] lol,int[] ps,int index,int numberOfFrames){
        int j;
        for(j=0;j<numberOfFrames;j++){
            int temp = getLru(ps,index,numberOfFrames,lol);
            if(lol[index][j] == temp){
                return j;
            }
        }
        return j - 1;

    }
    private static int getHit(int numberOfFrames, int numberOfPages, int[][] lol, int hit, String[] hi) {
        for(int i=0;i<numberOfPages;i++){
            for(int j=0;j<numberOfFrames;j++){
                if(j == 0){
                    hi[i] = Integer.toString(lol[i][j]);
                }
                else {
                    hi[i] += Integer.toString(lol[i][j]);
                }
            }
        }
        for(int i=0;i<numberOfPages;i++){
            if(i+1 < numberOfPages){
                if(hi[i].compareTo(hi[i+1]) == 0){
                    hit++;
                }
            }
        }
        return hit;
    }
}