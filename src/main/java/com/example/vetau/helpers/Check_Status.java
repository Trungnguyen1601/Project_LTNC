package com.example.vetau.helpers;

public class Check_Status {
    public static boolean ReturnBoolean_Check(String Status)
    {
        boolean flag = true;
       if (Status.equals("Yes"))
       {
           flag = true;
       }
       else {
           flag = false;
       }
       return flag;
    }
    public static String ReturnString_Check(boolean status)
    {
       String Trangthai = null;
       if(status == true )
       {
           Trangthai = "Yes";
       }
       else {
           Trangthai = "No";
       }
       return Trangthai;
    }
}
