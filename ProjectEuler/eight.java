/**
 * @(#)8.java
 *
 *
 * @author 
 * @version 1.00 2020/2/15
 */

import java.util.Scanner;
public class eight {

    public static void main(String [] args){
    	String num = "9552732382738052319352724087986028573098933337850448854586945290724937717872426807598271830020827926413440247495764962187038575599674036288078586938643452804331448825305154312990932360239343660901237040384131105593791470242443322086531804861204272773082222863784270399142463610268006539622161293404163524443842250617872784819569948858811629600496032045466224678093186599013865257960481598468076251192471137937790293265490680129558716923905055954021040074503365936497273336097277491355107648884067192189183776363925521414934976601660760833508743577892412001244858573449368742398140745696448150104212272097474067250889828527306684596648885140486772244726430402670137140764207842765679658923450289824333196000138358763264543630606568222427717450192306536213000122345541955347147652907263086086998556363773725151343093594800397652459296490484306035191816231229772294945706642189554764883365586747485872839831846993329922567376793754240731233198940189726545800829304972688396128828207672826714840494613281";
    	String current = "";
    	
    	double currentNum = 0;
    	double hi = 0;
    	
    	for (int i = 0; i < num.length() - 14; i++){
    		current = num.substring(i, i + 13);
    		//System.out.println(current);
    		double d0 = (double) Character.digit(current.charAt(0), 10);
    		double d1 = (double) Character.digit(current.charAt(1), 10);
    		double d2 = (double) Character.digit(current.charAt(2), 10);
    		double d3 = (double) Character.digit(current.charAt(3), 10);
    		double d4 = (double) Character.digit(current.charAt(4), 10);
    		double d5 = (double) Character.digit(current.charAt(5), 10);
    		double d6 = (double) Character.digit(current.charAt(6), 10);
    		double d7 = (double) Character.digit(current.charAt(7), 10);
    		double d8 = (double) Character.digit(current.charAt(8), 10);
    		double d9 = (double) Character.digit(current.charAt(9), 10);
    		double d10 = (double) Character.digit(current.charAt(10), 10);
    		double d11 = (double) Character.digit(current.charAt(11), 10);
    		

    		currentNum = d0 * d1 * d2 * d3 * d4 * d5 * d6 * d7 * d8 * d9 * d10 * d11; 
    		if (currentNum > hi)
    		{
    			hi = currentNum;
    		}
    	}
    	System.out.println(hi);
    }
    
    
}