
import java.util.*;
class BinaryTreeNode implements Comparable<BinaryTreeNode>{
BinaryTreeNode left,right,parent;
String data;
int count;
BinaryTreeNode(){
	left=null;
	right=null;
	data=null;
	parent=null;
	count=0;
}
BinaryTreeNode(String in,int count){
	left=null;
	right=null;
	parent=null;
	data=in;
	this.count=count;
}
void setLeft(BinaryTreeNode a){
	left=a;
}
void setRight(BinaryTreeNode a){
	right=a;
}
void setParent(BinaryTreeNode a){
	parent=a;
}
BinaryTreeNode getLeft(){
	return left;
}
BinaryTreeNode getRight(){
	return right;
}
BinaryTreeNode getParent(){
	return parent;
}
void setData(String in,int count){
	data=in;
	this.count=count;
}
String getData(){
	return data;
}
int getCount(){
	return count;
}
public int compareTo(BinaryTreeNode b){
	if(this.count==b.count)
		return 0;
	else if(this.count<b.count)
		return -1;
	else if(count>b.count)
		return 1;
	return 0;
}
}
