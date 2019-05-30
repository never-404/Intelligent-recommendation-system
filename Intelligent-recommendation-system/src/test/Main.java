package test;

import test.Graph;  

public class Main {  
  
    public static void main(String[] args) {  
        //第几张图，有两张(0,1)，起点序号(0-6)，终点序号(0-6)  
        AF operation = new AF(new Graph(0), 3, 6);  
        operation.getResult();  
  
    }  
}  