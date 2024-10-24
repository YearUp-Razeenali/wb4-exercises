package com.pluralsight;

public class NameFormatter {

    private NameFormatter(){}


    public static String format(String firstName, String lastName){
        return firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix){
        String[] nameParts = {prefix, firstName, middleName, lastName, suffix};

        StringBuilder result = new StringBuilder();
        for(String NameParts: nameParts){
            if(!NameParts.isEmpty()){
                result.append(NameParts.substring(0, 1).toUpperCase()).append(NameParts.substring(1).toLowerCase()).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String format(String fullName){
        return fullName;
    }


}
