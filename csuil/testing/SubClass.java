package testing;

//import java.io.*;
import java.util.*;

public class SubClass extends SuperClass{

   public SubClass(){
      System.out.println("made subclass");
   }

   public void printS(){
      System.out.println(this.s);
   }
}