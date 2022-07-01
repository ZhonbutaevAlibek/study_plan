package src;

public class BoxMachine {
   public static void main(String[] args) {
       for(int  i = 0; i < 5; i++) {
           System.out.println(new Box(Math.random()*10));
       }
   }
}