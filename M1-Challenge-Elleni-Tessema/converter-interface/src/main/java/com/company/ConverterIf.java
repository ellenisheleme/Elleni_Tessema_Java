package com.company;


public class ConverterIf implements ConverterInterface {


    /**
     * This method converts the given number into its corresponding month.
     *
     * @param monthNumber&mdash;the number you wish to convert to a month
     * @return&mdash;the name of the corresponding month if the parameter value is between 1 and 12; error message otherwise
     */

    public String convertMonth(int monthNumber) {
        String correspondingMonth = "";
        if (monthNumber == 1) {
            correspondingMonth = "January";
        }
        else if (monthNumber == 2) {
            correspondingMonth = "Februry";
        }
        else if(monthNumber == 3) {
            correspondingMonth = "March";
        }
        else if(monthNumber == 4) {
            correspondingMonth = "April";
        }
        else if(monthNumber == 5) {
            correspondingMonth = "May";
        }
        else if (monthNumber == 6) {
            correspondingMonth = "June";
        }
        else if (monthNumber == 7) {
            correspondingMonth = "July";
        }
        else if (monthNumber == 8) {
            correspondingMonth = "August";
        }
        else if(monthNumber == 9) {
            correspondingMonth = "September";
        }
        else if (monthNumber == 10) {
            correspondingMonth = "October";
        }
        else if (monthNumber == 11) {
            correspondingMonth = "November";
        }
        else if(monthNumber == 12) {
            correspondingMonth = "December";
        }
        else if(monthNumber >= 13) {
            correspondingMonth = "please enter number between 1 and 12";
        }

        return correspondingMonth;
    }

    /**
     * This method converts the given number into its corresponding day of the week.
     *
     * @param dayNumber&mdash;number you wish to convert to a day of the week
     * @return&mdash;the name of the corresponding day if the parameter value is between 1 and 7, error message otherwise
     * The first day of the week is Sunday
     */
    public String convertDay(int dayNumber) {
       String dayOfWeek = "";
       if(dayNumber == 1){
           dayOfWeek = "Sunday";

       }else if(dayNumber == 2){
            dayOfWeek = "Monday";

       }else if(dayNumber == 3){
           dayOfWeek = "Tuesday";

       }else if(dayNumber == 4){
           dayOfWeek = "Wednesday";
       }else if(dayNumber == 5){
           dayOfWeek = "Thursday";

       }else if (dayNumber == 6){
           dayOfWeek = "Friday";
       }else if (dayNumber == 7){
           dayOfWeek = "Saturday";
       }else if (dayNumber >=8){
           System.out.println("Please enter a number between 1 and 12");;
       }
    return dayOfWeek;
    }

}
