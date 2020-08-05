package com.utilities;

public class SeleniumUtils {


    public static void waitPlease(int seconds){

        try{
            Thread.sleep(seconds*1000);
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }
}
