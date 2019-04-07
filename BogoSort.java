import java.util.*;
import javax.swing.*;

public class BogoSort implements Sortable
{ 
    // Sorts array a[0..n-1] using Bogo sort 
   private ArrayList<Button> array;
   private JTextField a,b;
   private JButton swap;
   public BogoSort(ArrayList<Button> array, JTextField a, JTextField b,JButton swap) {
      this.array = array;
      this.a = a;
      this.b = b;
      this.swap = swap;
      sort();
   }

   public void sort()
   { 
        // if array is not sorted then shuffle the 
        // array again 
      while (checkArray() == false) 
         shuffle(); 
   } 
  
    // To generate permuatation of the array 
   public void shuffle() 
   { 
         // Math.random() returns a double positive 
         // value, greater than or equal to 0.0 and 
         // less than 1.0. 
      for (int i=1; i < array.size(); i++)
         input(i, (int)(Math.random()*i)); 
         swap.doClick();
   } 
  
    // Swapping 2 elements 
   
  
    // To check if array is sorted or not 
   public boolean checkArray() {
      for(int i = 0; i < array.size()-1-1; i++) {
         input(i,i+1);
         if(check()) {
            return false;
         }
      }
      for(Button i: array) {
         i.setState(Button.SECURED);
      }
      return true;
   }
   public boolean check() {
      if(APanel.getInt(array.get(APanel.getInt(a))) > APanel.getInt(array.get(APanel.getInt(b))) ) {
         return true;
      }
      return false;
   }
   private void input(int a,int b) {
      for(Button i: array) {
         i.setState(Button.NONE);
      }
      this.a.setText("" + (a));
      array.get(APanel.getInt(this.a)).setState(Button.COMPARE);
      this.b.setText("" + b);
      array.get(APanel.getInt(this.b)).setState(Button.COMPARE);
      try {
         Thread.sleep(50);
      } catch (InterruptedException e) {
      
         e.printStackTrace();
      }
   }
}