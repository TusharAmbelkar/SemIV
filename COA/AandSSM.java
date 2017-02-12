import java.util.*;
import java.io.*;
class AandSSM{
	public static String add(String a,String b){
		int l1=a.length();
		int l2=b.length(),cd;
		String o=new String();
		StringBuilder sb=new StringBuilder();
		cd=(l1>l2)?l1-l2:l2-l1;
		if(cd!=0){
		String n=(l1>l2)?b:a;
		sb.append(n.charAt(0));
		for(int i=0;i<cd;i++){
			sb.append('0');
		}
		for(int i=0;i<n.length()-1;i++){
			sb.append(n.charAt(i+1));
		}
		if(l1>l2)
			b=sb.toString();
		else
			a=sb.toString();
		}
		sb=new StringBuilder();
		char c='0';
		char s='0',d;
		System.out.println(a.length());
		for(int i=a.length()-1;i>0;i--){
			d='0';
			if(a.charAt(i)=='0' && b.charAt(i)=='0')
				s='0';
			else if(a.charAt(i)=='0' && b.charAt(i)=='1')
				s='1';
			else if(a.charAt(i)=='1' && b.charAt(i)=='0')
				s='1';
			else if(a.charAt(i)=='1' && b.charAt(i)=='1'){
				s='0';
				d='1';
			}
			if(s=='0' && c=='0');
			else if(s=='1' && c=='0');
			else if(s=='0' && c=='1')
				s='1';
			else if(s=='1' && c=='1'){
				d='1';
				s='0';
			}
			c=d;
			sb.append(s);
		}
		if(c=='1')
			sb.append('1');
		sb.append(a.charAt(0));
		sb=sb.reverse();
		o=sb.toString();
		return o;
	}
	public static String sub(String a,String b){
		int l1=a.length();
		int l2=b.length(),cd;
		String o=new String();
		StringBuilder sb=new StringBuilder();
		cd=(l1>l2)?l1-l2:l2-l1;
		if(cd!=0){
		String n=(l1>l2)?b:a;
		sb.append(n.charAt(0));
		for(int i=0;i<cd;i++){
			sb.append('0');
		}
		for(int i=0;i<n.length()-1;i++){
			sb.append(n.charAt(i+1));
		}
		if(l1>l2)
			b=sb.toString();
		else
			a=sb.toString();
		}
		sb=new StringBuilder();
		char c='0';
		char s='0',d;
		for(int i=a.length()-1;i>0;i--){
			d='0';
			if(a.charAt(i)=='0' && b.charAt(i)=='0')
				s='0';
			else if(a.charAt(i)=='1' && b.charAt(i)=='1')
				s='0';
			else if(a.charAt(i)=='1' && b.charAt(i)=='0')
				s='1';
			else if(a.charAt(i)=='0' && b.charAt(i)=='1'){
				s='1';
				d='1';
			}
			if(s=='0' && c=='0');
			else if(s=='1' && c=='0');
			else if(s=='1' && c=='1')
				s='0';
			else if(s=='0' && c=='1'){
				d='1';
				s='1';
			}
			c=d;
			sb.append(s);
		}
		if(c=='1'){
			o=sub(b,a);
			sb=new StringBuilder();
			sb.append((a.charAt(0)=='0')?'1':'0');
			for(int i=1;i<o.length();i++){
				sb.append(o.charAt(i));
			}
		}
		else{
			sb.append(a.charAt(0));
			sb=sb.reverse();
		}
		o=sb.toString();
		return o;
	}
	public static boolean check(String a){
		for(int i=0;i<a.length();i++){
			int c=a.charAt(i)-'0';
			if(!(c>=0&&c<2))
				return false;
		}
		return true;
	}
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		boolean k=true;
		String i1,i2;
		StringBuilder sb;
		int i=3;
		while(k){
		System.out.println("Enter the operation:\n1:Addition\n2:Subtraction\n3:Exit");
		i=3;
		i=sc.nextInt();
		switch(i){
			case 1:
			sb=new StringBuilder();
			System.out.println("Enter first Binary input number:=");
			i1=sc.next();
			if(!check(i1)){
				System.out.println("Wrong Input....");
				break;
			}
			System.out.println("Enter second Binary input number:=");
			i2=sc.next();
			if(!check(i2)){
				System.out.println("Wrong Input....");
				break;
			}
			if(i1.charAt(0)==i2.charAt(0)){
				String Out =add(i1,i2);
				System.out.println("The Result is := "+Out);
			}
			else{
				sb.append((i2.charAt(0)=='0')?'1':'0');
				for(i=i2.length()-1;i>0;i--){
					sb.append(i2.charAt(i));
				}
				sb=sb.reverse();
				String Out =sub(i1,sb.toString());
				System.out.println("The Result is := "+Out);
			}
			break;
			case 2:
			sb=new StringBuilder();
			System.out.println("Enter first Binary input number:=");
			i1=sc.next();
			if(!check(i1)){
				System.out.println("Wrong Input....");
				break;
			}
			System.out.println("Enter second Binary input number:=");
			i2=sc.next();
			if(!check(i2)){
				System.out.println("Wrong Input....");
				break;
			}
			if(i1.charAt(0)==i2.charAt(0)){
				String Out =sub(i1,i2);
				System.out.println("The Result is := "+Out);
			}
			else{
				for(i=i2.length()-1;i>0;i--){
					sb.append(i2.charAt(i));
				}
				sb.append((i2.charAt(0)=='0')?'1':'0');
				sb=sb.reverse();
				String Out =add(i1,sb.toString());
				System.out.println("The Result is := "+Out);
			}
			break;
			case 3:
			k=false;
			break;
			default:
			System.out.println("Wrong Input.....");
		}
	}
	}
}