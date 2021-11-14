package testing;

//import java.io.*;
import java.util.*;

public class Runner {
   public static void main(String[] args) {
      Scanner s = new Scanner("test<two");
      s.useDelimiter("<");
      System.out.println(s.next());
   }
}