import java.io.*;
import java.util.*;
class CC{
	boolean checkBD(char a){
		if(Character.isDigit(a)&&(a-'0')<2)
			return true;
		else
			return false;
	}
	boolean checkDD(char a){
		if(Character.isDigit(a))
			return true;
		else
			return false;
	}
	byte[] DtoBf(byte [] a,Integer n){
		byte ab,rem=0,result[];
		int temp=50;
		result=new byte[50];
		Arrays.fill(result,(byte)0);
		/*for(byte i:result){
			System.out.print(i+" ");
		}*/
		for(int j=1;j<50;j++){
			boolean t=false;
			rem=0;
		for(int i=n-1;i>=0;i--){
			ab=(byte)(a[i]*2+rem);
			a[i]=(byte)(ab%10);
			if(ab%10!=0)
				t=true;
			rem=(byte)(ab/10);
			
		}
		result[j]=rem;
		if(!t){
			result[0]=(byte)j;
			System.out.println("Unfi" +result[0]);
			return result;
		}
		result[0]=(byte)j;
		}
	return result;
	}
	double BtoD(String ab,boolean flag,boolean fractional){
		double result=0d,temp;
		int id=ab.length();
		long a=Long.parseLong(ab);
		if(fractional){
		for(int i=0;i<id;i++){
			temp=(a/(long)Math.pow(10,id-i-1));
			a%=(long)Math.pow(10,id-i-1);
			result+=temp*Math.pow(2,-i-1);
		}
		}
		else if(!fractional){
			if(!flag){
				a=-a;
		for(int i=0;i<id-1;i++){
			temp=a%10;
			a/=10;
			result+=temp*Math.pow(2,i);
			}	}
			else{
				for(int i=0;i<id;i++){
					temp=a%10;
					a/=10;
					result+=temp*Math.pow(2,i);
			}	
			}
		}
		return result;
	}
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		CC cc=new CC();
		String input;
		byte integer[]=new byte[100],fractional[]=new byte[50];
		/*for(byte i:fractional){
			System.out.print(i+" ");
		}*/
		boolean t=true;
		while(t){
			System.out.println("Which operation would you like to do?\n1:Convert Decimal to Binary\n2:Convert Binary to Decimal\n3:Exit");
			byte abc=sc.nextByte();
			int a,j,k;
			boolean checkValid,flag,sign;
			switch(abc){
				case 1:
				System.out.println("Enter a decimal number :");
				input=sc.next();
				a=input.length();
				j=0;k=0;	//length of integer and fractional part...
				checkValid=true;
				flag=false;//to check for decimal point
				sign=true; //true for +ve & 0 and false for -ve
				for(int i=0;i<a;i++){
					char d=input.charAt(i);
					if(cc.checkDD(d)&&!flag){
						integer[j++]=(byte)(d-'0');
					}
					else if(cc.checkDD(d)&&flag){
						fractional[k++]=(byte)(d-'0');
					}
					else if(d=='-'&&sign)
						sign=false;
					else if(d=='.'&&!flag)
						flag =true;
					else{
						System.out.println("Wrong Input entered.......Try again");
						checkValid=false;
						break;
					}
				}
				if(checkValid){
					System.out.println("The Decimal number entered is:"+input);
					StringBuilder builder = new StringBuilder();
					Integer K=k;
					/*for(byte i:fractional){
			System.out.print(i+" ");
		}*/
					byte []abd=cc.DtoBf(fractional,K);
					//System.out.println(K);
					for (int i=1;i<=abd[0];i++) {
						builder.append(abd[i]);
					}
					String text = builder.toString();
					System.out.println("The Equivalent Binary number is:"+Long.toBinaryString(new Long(new StringTokenizer(input,".").nextToken()))+"."+text);
				}
				break;
				case 2:
				System.out.println("Enter a Binary number :");
				input=sc.next();
				a=input.length();
				j=0;k=0;	//length of integer and fractional part...
				checkValid=true;
				flag=false;//to check for decimal point
				sign=true; //true for +ve & 0 and false for -ve
				for(int i=0;i<a;i++){
					char d=input.charAt(i);
					if(cc.checkBD(d)&&!flag){
						integer[j++]=(byte)(d-'0');
					}
					else if(cc.checkBD(d)&&flag){
						fractional[k++]=(byte)(d-'0');
					}
					else if(d=='-'&&sign)
						sign=false;
					else if(d=='.'&&!flag)
						flag =true;
					else{
						System.out.println("Wrong Input entered.......Try again");
						checkValid=false;
						break;
					}
				}
				if(checkValid){
					System.out.println("The Binary number entered is:"+input);
					StringTokenizer st =new StringTokenizer(input,".");
					int ab1=(int)cc.BtoD(st.nextToken(),sign,false);
					double ab2=0d;
					if(st.hasMoreTokens())
						ab2=cc.BtoD(st.nextToken(),sign,true);					
					System.out.println("The Equivalent decimal number is"+((double)ab1+ab2));
				}
				break;
				case 3:
				t=false;
				break;
				default:
				System.out.println("Entered wrong choice...\nTry again");
				break;
			}
		}
	}
}