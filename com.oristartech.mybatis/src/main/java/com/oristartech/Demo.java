package com.oristartech;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
public static void main(String[] args) throws ParseException {
	/*DateFormat df = new SimpleDateFormat("HH:ss");
	Date today = new Date();
	System.out.println(today);
	String format = df.format(today);
	System.out.println(format);
	Date parse = df.parse(format);
	System.out.println(parse);*/
	
	int[] arr = new int[5];
	arr[1] = 1;
	arr[4] = 2;
	String str = "[";
	for (int i = 0; i < arr.length; i++) {
		if(i == arr.length-1){
			str += arr[i]+"]";
		}else{
		str += arr[i] +",";
		}
	}
	System.out.println(str);
	

}
}
