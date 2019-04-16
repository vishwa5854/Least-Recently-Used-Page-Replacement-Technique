package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        new Contacts();
        Contacts[] contacts = new Contacts[countNumberOfLinesInAFile()];
        try {
            setContactsIntoList(contacts);
        } catch (IOException e) {
            System.out.println("Failed to load contacts");
        }
        assignNumericalValuesToContacts(contacts);
        System.out.print("Enter the input:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        showSuggestions(contacts, input);

    }

    private static void showSuggestions(Contacts[] contacts, String input) throws IOException {
        String[] finalArray = assignTheLengthValueToNewArray(input,contacts);
        for(int i=0;i<countNumberOfLinesInAFile();i++){
            if(input.compareTo(contacts[i].numericalName) == 0){
                System.out.println(contacts[i].actualName);
            }
            else if((finalArray[i].compareTo(input)) == 0){
                System.out.println(contacts[i].actualName);
            }
        }
    }

    private static void assignNumericalValuesToContacts(Contacts[] contacts) {
        for(int i=0;i<contacts.length;i++){
            for(int j=0;j<contacts[i].actualName.length();j++){
                if((contacts[i].actualName.charAt(j) == 'a') || (contacts[i].actualName.charAt(j) == 'b') || (contacts[i].actualName.charAt(j) == 'c')){
                    contacts[i].numericalName += "2";
                }
                else if((contacts[i].actualName.charAt(j) == 'd') || (contacts[i].actualName.charAt(j) == 'e') || (contacts[i].actualName.charAt(j) == 'f')){
                    contacts[i].numericalName += "3";
                }
                else if((contacts[i].actualName.charAt(j) == 'g') || (contacts[i].actualName.charAt(j) == 'h') || (contacts[i].actualName.charAt(j) == 'i')){
                    contacts[i].numericalName += "4";
                }
                else if((contacts[i].actualName.charAt(j) == 'j') || (contacts[i].actualName.charAt(j) == 'k') || (contacts[i].actualName.charAt(j) == 'l')){
                    contacts[i].numericalName += "5";
                }
                else if((contacts[i].actualName.charAt(j) == 'm') || (contacts[i].actualName.charAt(j) == 'n') || (contacts[i].actualName.charAt(j) == 'o')){
                    contacts[i].numericalName += "6";
                }
                else if((contacts[i].actualName.charAt(j) == 'p') || (contacts[i].actualName.charAt(j) == 'q') || (contacts[i].actualName.charAt(j) == 'r') || (contacts[i].actualName.charAt(j) == 's')){
                    contacts[i].numericalName += "7";
                }
                else if((contacts[i].actualName.charAt(j) == 't') || (contacts[i].actualName.charAt(j) == 'u') || (contacts[i].actualName.charAt(j) == 'v')){
                    contacts[i].numericalName += "8";
                }
                else if((contacts[i].actualName.charAt(j) == 'w') || (contacts[i].actualName.charAt(j) == 'x') || (contacts[i].actualName.charAt(j) == 'y') || (contacts[i].actualName.charAt(j) == 'z')){
                    contacts[i].numericalName += "9";
                }
            }
        }
    }

    private static String[] assignTheLengthValueToNewArray(String temp,Contacts[] contacts) throws IOException {
        String[] temp1 = new String[countNumberOfLinesInAFile()];
        for (int i = 0; i < countNumberOfLinesInAFile(); i++) {
            for (int j = 0; j < temp.length(); j++) {
                if (j == 0) {
                    temp1[i] = Character.toString(contacts[i].numericalName.charAt(j));
                } else {
                    temp1[i] += Character.toString(contacts[i].numericalName.charAt(j));
                }
            }
        }
        return temp1;
    }

    private static void setContactsIntoList(Contacts[] con) throws IOException {
        FileReader fileReader = new FileReader("D:\\Test\\Contacts.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for(int i=0;i<countNumberOfLinesInAFile();i++){
            con[i] = new Contacts(bufferedReader.readLine());
        }
    }

    private static int countNumberOfLinesInAFile() throws IOException {
        int count = 0;
        FileReader fileReader = new FileReader("D:\\Test\\Contacts.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.readLine()!=null){
            count++;
        }
        return count;
    }
}
