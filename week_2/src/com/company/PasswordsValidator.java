package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordsValidator {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String password = in.nextLine();
//(\s\s)
            String regex = "^(?=.*\\d)(?=.*\\S)(?=.*[a-z])(?=.*[A-Z]).{6,32}$";
            boolean validOrInvalid = isValidPassword(password,regex);

            if(validOrInvalid){
                System.out.println("Senha valida.");
            }
            else{
                System.out.println("Senha invalida.");
            }
        }
    }

    public static boolean isValidPassword(String password,String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
