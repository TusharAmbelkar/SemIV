import java.util.*;
class HBCC{
	boolean checkBinaryDigit(char a){
		if(Character.isDigit(a)&&(a-'0')<2)
			return true;
		else
			return false;
	}
	boolean checkHexDigit(char a){
		if(Character.isDigit(a)||(a<='f'&&a>='a')||(a<='F'&&a>='A'))
			return true;
		else
			return false;
	}
	char returnHex(String a){
		if(a.equals("0000"))
			return '0';
		else if(a.equals("0001"))
			return '1';
		else if(a.equals("0010"))
			return '2';
		else if(a.equals("0011"))
			return '3';
		else if(a.equals("0100"))
			return '4';
		else if(a.equals("0101"))
			return '5';
		else if(a.equals("0110"))
			return '6';
		else if(a.equals("0111"))
			return '7';
		else if(a.equals("1000"))
			return '8';
		else if(a.equals("1001"))
			return '9';
		else if(a.equals("1010"))
			return 'A';
		else if(a.equals("1011"))
			return 'B';
		else if(a.equals("1100"))
			return 'C';
		else if(a.equals("1101"))
			return 'D';
		else if(a.equals("1110"))
			return 'E';
		else if(a.equals("1111"))
			return 'F';
		else 
			return '-';
	}
	String returnBinary(String a){
		if(a.equals("0"))
			return "0000";
		else if(a.equals("1"))
			return "0001";
		else if(a.equals("2"))
			return "0010";
		else if(a.equals("3"))
			return "0011";
		else if(a.equals("4"))
			return "0100";
		else if(a.equals("5"))
			return "0101";
		else if(a.equals("6"))
			return "0110";
		else if(a.equals("7"))
			return "0111";
		else if(a.equals("8"))
			return "1000";
		else if(a.equals("9"))
			return "1001";
		else if(a.equals("A")||a.equals("a"))
			return "1010";
		else if(a.equals("B")||a.equals("b"))
			return "1011";
		else if(a.equals("C")||a.equals("c"))
			return "1100";
		else if(a.equals("D")||a.equals("d"))
			return "1101";
		else if(a.equals("E")||a.equals("e"))
			return "1110";
		else if(a.equals("F")||a.equals("f"))
			return "1111";
		else 
			return "-";
	}
	public static void main(String [] args){
		Scanner sc =new Scanner(System.in);
		HBCC cc=new HBCC();
		boolean w=true;
		String input;
		int c,j,f;
		while(w){
		System.out.println("What would you like to do:\n 1:Convert Binary to Hexadecimal\n 2:Convert Hexadecimal to Binary \n 3:Exit \n Enter correct index number");
		c=sc.nextInt();
		boolean checkValid=true,sign=true,flag=false;
		switch(c){
			case 1:
			System.out.println("Enter Binary number");
			input=sc.next();
			j=0;f=0;
			for(int i=0;i<input.length();i++){
					char d=input.charAt(i);
					if(cc.checkBinaryDigit(d)&&!flag){
						j++;
					}
					else if(cc.checkBinaryDigit(d)&&flag){
						f++;
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
				System.out.println("The Entered Binary number is:"+input);
				StringBuilder t, s=new StringBuilder();
				if(!sign){
					input=new StringTokenizer(input,"-").nextToken();
				}
				for(int i=0;i<4-j%4&&j%4!=0;i++)
					s.append('0');
				s.append(input);
				for(int i=0;i<4-f%4&&f%4!=0;i++)
					s.append('0');
				input=s.toString();
				System.out.println(input);
				String res;
				StringTokenizer st=new StringTokenizer(input,".");
				String integer =st.nextToken();
				t=new StringBuilder();
				for(int i=0;i<integer.length();){
					s=new StringBuilder();
					for(int k=0;k<4&&i<integer.length();k++,i++)
						s.append(integer.charAt(i));
					//System.out.println(s.toString()+" "+cc.returnHex(s.toString()));
					t.append(cc.returnHex(s.toString()));
				}
				if(st.hasMoreTokens()){
					String fr=st.nextToken();
					t.append('.');
					for(int i=0;i<fr.length();){
						s=new StringBuilder();
					for(int k=0;k<4&&i<fr.length();k++,i++)
						s.append(fr.charAt(i));
					//System.out.println(s.toString()+" "+cc.returnHex(s.toString()));
					t.append(cc.returnHex(s.toString()));
					}
				}
				System.out.print("The equivalent Hexadecimal number is:");
				if(!sign){
					System.out.print("-");
				}
				System.out.println(t.toString());
			}
			break;
			case 2:
			System.out.println("Enter a number of Hexadecimal system:");
			input=sc.next();
			j=0;f=0;
			for(int i=0;i<input.length();i++){
					char d=input.charAt(i);
					if(cc.checkHexDigit(d)&&!flag){
						j++;
					}
					else if(cc.checkHexDigit(d)&&flag){
						f++;
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
				System.out.println("The Entered Hexadecimal number is:"+input);
				StringBuilder t;
				if(!sign){
					input=new StringTokenizer(input,"-").nextToken();
				}
				StringTokenizer st=new StringTokenizer(input,".");
				String integer =st.nextToken();
				t=new StringBuilder();
				for(int i=0;i<integer.length();i++){
					//System.out.println(integer);
					t.append(cc.returnBinary(new Character(integer.charAt(i)).toString()));
				}
				if(st.hasMoreTokens()){
					String fr=st.nextToken();
					t.append('.');
					for(int i=0;i<fr.length();i++){
					//System.out.println(fr);
					t.append(cc.returnBinary(new Character(fr.charAt(i)).toString()));
					}
				}
				System.out.print("The equivalent Hexadecimal number is:");
				if(!sign){
					System.out.print("-");
				}
				System.out.println(t.toString());
			}
			break;
			case 3:
			w=false;
			break;
		}
		}
	}
}