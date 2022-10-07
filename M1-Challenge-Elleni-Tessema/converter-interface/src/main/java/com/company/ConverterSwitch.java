package com.company;

public class ConverterSwitch implements ConverterInterface {
    /**
     * This method converts the given number into its corresponding month.
     *
     * @param monthNumber&mdash;the number you wish to convert to a month
     * @return&mdash;the name of the corresponding month if the parameter value is between 1 and 12; error message otherwise
     */
    public String convertMonth(int monthNumber) {
        String corresponigMonth = "";
        switch (monthNumber) {
            case (1):
                corresponigMonth = "January";
                break;
            case (2):
                corresponigMonth = "February";
                break;
            case (3):
                corresponigMonth = "March";
                break;
            case (4):
                corresponigMonth = "April";
                break;
            case (5):
                corresponigMonth = "May";
                break;

            case (6):
                corresponigMonth = "June";
                break;
            case (7):
                corresponigMonth = "July";
                break;
            case (8):
                corresponigMonth = "August";
                break;
            case (9):
                corresponigMonth = "September";
                break;
            case (10):
                corresponigMonth = "October";
                break;
            case (11):
                corresponigMonth = "November";
                break;
            case (12):
                corresponigMonth = "December";
            default:

                System.out.println("Please enter number between 1 and 12");
        }
        return corresponigMonth;
    }

    /**
     * This method converts the given number into its corresponding day of the week.
     *
     * @param dayNumber&mdash;number you wish to convert to a day of the week
     * @return&mdash;the name of the corresponding day if the parameter value is between 1 and 7, error message otherwise
     * The first day of the week is Sunday
     */
    public String convertDay(int dayNumber) {

        String correspondingDay = "";

        switch (dayNumber) {
            case (1):
                correspondingDay = "Sunday";
                break;
            case (2):
                correspondingDay = "Monday";
                break;
            case (3):
                correspondingDay = "Tuesday";
                break;
            case (4):
                correspondingDay = "Wednesday";
                break;
            case (5):
                correspondingDay = "Thursday";
                break;
            case (6):
                correspondingDay = "Friday";
                break;
            case (7):
                correspondingDay = "Saturday";
                break;
            case (8):
                correspondingDay = "Sunday";
            default:
                System.out.println("please enter a number between 1 and 7");
        }

        return correspondingDay;
    }


}
