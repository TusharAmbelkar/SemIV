import java.util.*;
import java.lang.*;
import java.io.*;
public class BoothM{
    /**
     * This function is used to add two binary numbers in two's complement form.
     * <p>
     * First it converts both input numbers to equal size.
     * Then It adds them bit by bit starting from rightmost bit...
     * <p>
     * An overflow condition is indicated if two numbers are added, 
     * and they are both positive or both negative,
     * then overflow occurs if and only if the result has the opposite sign.
     *  
     * @param in1 First input binary number in two's complement form
     * @param in2 Second input binary number in two's complement form
     * @return Sum of input in two's complement form.
     */
    public static String add(String in1,String in2){  
        String output;
        StringBuilder sb=new StringBuilder();
        int a,b;
        a=in1.length();
        b=in2.length();
        if(a<b){
            for(int i=0;i<b-a;i++)
                sb.append(in1.charAt(0));
            sb.append(in1);
            in1=sb.toString();
        }
        else if(a>b){
            for(int i=0;i<a-b;i++)
                sb.append(in2.charAt(0));
            sb.append(in2);
            in2=sb.toString();
        }
       sb=new StringBuilder();
       int c=0;
       int s=0;
       for(int i=in1.length()-1;i>=0;i--){
           a=Integer.parseInt(new Character(in1.charAt(i)).toString());
           b=Integer.parseInt(new Character(in2.charAt(i)).toString());
           s=a^b^c;
           c=(a&b)|(c&(a^b));
           sb.append(s);
       }
       sb=sb.reverse();
       boolean n=false;
       if(in1.charAt(0)==in2.charAt(0)&&sb.charAt(0)!=in2.charAt(0)){
           System.out.println("Overflow....");
           n=true;
           sb=sb.reverse();
           sb.append(in1.charAt(0));
           sb=sb.reverse();
       }
       if(n&&c==1){
           sb=sb.reverse();
           sb.append(c);
           sb=sb.reverse();
       }
       output=sb.toString();
        return output;
    }
    public static String add1(String in1,String in2){
        return "A";
    }
/**
 * This function calculates the two's complement of input inString and returns it.
 * 
 * @param inString input binary string....
 * @return twos complement of input.
 */
    public static String twoComplement(String inString){
        String output;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<inString.length();i++){
            if(inString.charAt(i)=='0')
            sb.append('1');
            else
            sb.append('0');
        }
        //System.out.print(sb.toString());
        output = add(sb.toString(),"01");
        //System.out.print(output);
        return output;
    }
    public static String makeEqualLength(String inputString,int length){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<(length-inputString.length());i++)
            sb.append(inputString.charAt(0));
        sb.append(inputString);
        return sb.toString();
    }
    public static String rightShift(String A,String Q,String Q1){
        StringBuffer sb=new StringBuffer();
        sb.append(A.charAt(0));
        sb.append(A);
        sb.append(Q);
        return sb.toString();       
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String in1,in2;
        boolean k=true;
        int i,j;
        do{
            System.out.println("Booths multiplication algorithm\nEnter input values in twos complement form only\nEnter the first number");
            in1=sc.next();
            if(!in1.matches("[10]+")){
                System.out.println("Wrong input....Please try again");
                continue;
            }
            System.out.println("Enter the second number");
            in2=sc.next();
            if(!in2.matches("[10]+")){
                System.out.println("Wrong input....Please try again");
                continue;
            }
            int l1,l2;
            l1=in1.length();
            l2=in2.length();
            if(l1>l2){
                in2=makeEqualLength(in2,l1);
                l2=in2.length();
            }
            else if(l1<l2){
                in1=makeEqualLength(in1,l2);
                l1=in1.length();
            }
            String S=twoComplement(in2);
            //System.out.println(S);
            String M=in2;
            String Q=in1;
            String Q1="0";
            String A="00";
            String P;
            A=makeEqualLength(A,l1);
            //System.out.print(A.length());
            for(i=0;i<M.length();i++){
                String check=Q.charAt(l1-1) + Q1;
                //System.out.println(check);
                if(check.equals("01")){
                    A=add(A,M);
                    //System.out.println(A);
                    P=rightShift(A, Q, Q1);
                    //System.out.println(P);
                    A=P.substring(0, l1);
                    Q=P.substring(l1, 2*l1);
                    Q1=new Character(P.charAt(P.length()-1)).toString();
                }
                else if(check.equals("10")){
                    A=add(A,S);
                   // System.out.println(A);
                    P=rightShift(A, Q, Q1);
                    //System.out.println(P);
                    A=P.substring(0, l1);
                    Q=P.substring(l1, 2*l1);
                    Q1=new Character(P.charAt(P.length()-1)).toString();
                }
                else{
                    P=rightShift(A, Q, Q1);
                    //System.out.println(P);
                    A=P.substring(0, l1);
                    Q=P.substring(l1, 2*l1);
                    Q1=new Character(P.charAt(P.length()-1)).toString();
                }
            }
            System.out.println("The product is:"+A+Q+"\nWould you like to continue y/n");
            String d=sc.next();
            if(d.toLowerCase().charAt(0)=='n')
                k=false;
        }
        while(k);
    }
}