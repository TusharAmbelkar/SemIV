

import java.util.*;

public class Huff {
	public static final int N=100;
	static int k=0;
	static char a[]=new char[N];
	static String [] keys=new String[N];
	public static void traverse(BinaryTreeNode node,String prefix){
		if(node.left==null && node.right==null){
			for(int i=0;i<k;i++){
				if(a[i]==node.data.charAt(0)){
					keys[i]=prefix;
				}
			}
			return;
		}
		traverse(node.left, prefix+"0");
		traverse(node.right,prefix+"1");
	}
	public static void main(String args[]){
		String in;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String:");
		in=sc.next();
		
		int count[]=new int[N];
		for(int i=0;i<in.length();i++){
			int j=0;
			boolean flag=false;
			for(;j<k;j++){
				if(a[j]==in.charAt(i)){
					count[j]+=1;
					flag=!flag;
				}
			}
			if(!flag&&k<N){
				a[k]=in.charAt(i);
				count[k]=1;
				k++;
			}
		}
		System.out.println("The Frequency table is as follows:");
		System.out.println("|Character|Frequency|");
		for(int i=0;i<k;i++){
			System.out.println("|   "+a[i]+"     |     "+count[i]+"   |");
		}
		PriorityQueue<BinaryTreeNode>p=new PriorityQueue<BinaryTreeNode>();
		for(int i=0;i<k;i++){
			p.add(new BinaryTreeNode(new Character(a[i]).toString(),count[i]));
		}
		while(p.size()>=2){
		BinaryTreeNode a1,a2,cp;
		a1=p.remove();
		a2=p.remove();
		cp=new BinaryTreeNode();
		cp.setData(a1.data + a2.data,a1.count+a2.count);
		cp.setLeft(a1);
		cp.setRight(a2);
		a1.setParent(cp);
		a2.setParent(cp);
		p.add(cp);
		}
		BinaryTreeNode root=p.remove();
		traverse(root,new String());
		System.out.println("The Frequency table is as follows:");
		System.out.println("| Character | Frequency | Huffman Code ");
		for(int i=0;i<k;i++){
			System.out.println("|     "+a[i]+"     |    "+count[i]+"      |  "+keys[i]);
		}
		System.out.print("The encoded message is:");
		String code=">";
		int i=0;
		while(i<in.length()){
			for(int c=0;c<k;c++){
				if(a[c]==in.charAt(i)){
					//System.out.println(code);
					if(code==">"){
						code=keys[c];
					}
					else 
						code=code+keys[c];
					i++;
					break;
				}
				//System.out.print(i);
			}
		}
		System.out.println(code);
		System.out.println("Decode....");
		String t,decode=">";
		t=">";
		for(i=0;i<code.length();i++){
			if(t==">"){
				t=new Character(code.charAt(i)).toString();
			}
			else 
				t=t+code.charAt(i);
			for(int jp=0;jp<k;jp++){
				if(t.equals(keys[jp])){
					if(decode==">")
						decode=new Character(a[jp]).toString();
					else
						decode=decode+a[jp];
					t=">";
				}
			}
		}
		System.out.print("The decoded message is:"+decode);
		}
}
