package com.wwx.integerChangeLetter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class IntegerChangeLetterUnit 
{
    public void testChange()
    {
    	System.out.println("Please input an integer between 0 and 99.");
    	Scanner in=new Scanner(System.in);
    	Integer input=0;
    	try {
			input=in.nextInt();
		} catch (Exception e) {
			System.err.println("Please input an integer.");
		}
    	if(input<0||input>=100)
    	{
    		System.err.println("The integer have to between 0 and 99.");
    	}
    	else
    	{
    		String number = input.toString(); 
        	List<String> list = getLetter(number);
        	for(int i=0;i<list.size();i++)
        	{
        		System.out.print(list.get(i)+" ");
        	}
    	}
    }
    
    
    public List<String> getLetter(String input)
    {
       HashMap<Character,String> map = new HashMap();
       map.put('0', "");
       map.put('1', "");
       map.put('2', "abc");
       map.put('3', "def");
       map.put('4', "ghi");
       map.put('5', "jkl");
       map.put('6', "mno");
       map.put('7', "pqrs");
       map.put('8', "tuv");
       map.put('9', "wxyz");
       int length = input.length();
      
       List<String> list = new ArrayList<String>();
       if(length == 0)
       {
    	   return list; 
       }
       for(int i = 0;i<map.get(input.charAt(0)).length();i++)
       {
    	   list.add(String.valueOf(map.get(input.charAt(0)).charAt(i)));
       }
       if(length == 1)
       {
    	   return list; 
       }
       for(int j=1;j<length;j++)
       {
    	   List<String> transform = new ArrayList<String>();
    	   if(list.size()>0)
    	   {
    		   for(int x=0;x<list.size();x++)
        	   {
    			   if(input.charAt(j)=='0'||input.charAt(j)=='1')
    			   {
    				   transform.add(String.valueOf(map.get(input.charAt(0)).charAt(x))); 
    			   }
    			   else
    	    	   {
    				   for(int y=0;y<map.get(input.charAt(j)).length();y++)
            		   {
            			   transform.add(list.get(x)+map.get(input.charAt(j)).charAt(y));
            		   }
    	    	   }
        		   
        	   }
    	   }
    	   else
    	   {
    		   for(int i = 0;i<map.get(input.charAt(1)).length();i++)
    	       {
    			   transform.add(String.valueOf(map.get(input.charAt(1)).charAt(i)));
    	       }
    	   }
    	   list = transform;
       }
       return list;
      
    }
}
