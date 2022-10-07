package com.company;

public class ConverterApplication {
    public static void main(String[] args) {
        ConverterSwitch converterSwitch = new ConverterSwitch();
        converterSwitch.convertDay(10);
        converterSwitch.convertMonth(10);

        ConverterIf converterIf = new ConverterIf();
        converterIf.convertDay(9);
        converterIf.convertMonth(13);



    }
}
