package edu.lnu.fang.BiTree;
class ADemo {  
     static int id; 
         
    static {  
       
        System.out.println("��̬ ��ʼ�����idֵΪ" +id );  
    }
   
    {  
        System.out.println("����ʵ����ʼ���Ӿ�..."+id);  //new��ʱ���ڹ��캯��ǰִ��
    }    
    ADemo() {      	
        System.out.println("����ADemo�Ĺ��캯��--->" + id);  
    }  
   ADemo(int v) {  
    	id=v;
        System.out.println("����ADemo�Ĺ��캯��--->" + id);  
    } 
    ADemo instance=new ADemo();//����static��Exception in thread "main" java.lang.StackOverflowError 
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