package edu.lnu.fang.BiTree;
class ADemo {  
     static int id; 
         
    static {  
       
        System.out.println("静态 初始化块的id值为" +id );  
    }
   
    {  
        System.out.println("进入实例初始化子句..."+id);  //new的时候在构造函数前执行
    }    
    ADemo() {      	
        System.out.println("进入ADemo的构造函数--->" + id);  
    }  
   ADemo(int v) {  
    	id=v;
        System.out.println("进入ADemo的构造函数--->" + id);  
    } 
    ADemo instance=new ADemo();//不加static会Exception in thread "main" java.lang.StackOverflowError 
}  
public class ClassDemo {  
  
    public static void main(String[] args) {     
    	System.out.println(ADemo.id);
    	System.out.println("------------------------------------");
        new ADemo(111);  
        System.out.println("------------------------------------");
        new ADemo(123);  
    }  
}  