#!/bin/bash
k=true;
while [ $k = true ]
do
echo "What would you like to do:"
echo 
echo "1)Reverse two numbers:"
echo
echo "2)Swap two numbers:"
echo
echo "3)Exit."
echo "Enter appropriate choice:"
read choice
if [ $choice -eq 3 ]
then
k=false;
elif [ $choice -eq 1 ]
then
echo "Enter a number"
read input;
output=0
while [ $input -ne 0 ]
do 
output=`expr $output \* 10 + $input % 10`
input=`expr $input / 10`
done
echo $output
elif [ $choice -eq 2 ]
then 
echo "Enter first number:"
read a 
echo "Enter second number:"
read b
echo "Before Swapping...."
echo "First Number:$a"
echo "Second Number:$b"
c=$a;
a=$b;
b=$c;
echo "After Swapping...."
echo "First Number:$a"
echo "Second Number:$b"
else
echo "Wrong choice entered...."
echo "Terminating the program...."
k=false;
fi
done
