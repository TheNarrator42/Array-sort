import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


import javax.swing.*;

public class APanel extends JPanel {
   ArrayList<Button> buttons;
   JTextField temp1;
   JTextField temp2;
   
   String[] sorts = {"Bubble Sort", "Selection Sort", "Insertion Sort"};
   
   public APanel() {
   	
      super();
      buttons = new ArrayList<>();
      setLayout(new FlowLayout());
      for (int i = 0; i < 5; i++) {
         addButton();
      	
      }
      temp1 = new JTextField(5);
      temp1.setDragEnabled(true);
      add(temp1);
      temp2 = new JTextField(5);
      temp2.setDragEnabled(true);
      add(temp2);
      JButton five = new JButton("swap");
      five.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
            swap();
         }
      });
      add(five);
      
      JComboBox jc = new JComboBox(sorts);
      add(jc);
      //setLayout(new FlowLayout());
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //setSize(400,400);
      
   }
   public void addButton() {
      Button b = new Button();
      b.setTransferHandler(new TransferHandler("text"));
      b.addActionListener(
         new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent arg0) {
               temp1.setText(b.getText());
               
            
            }
         });
      add(b);
      buttons.add(b);
   	
   }
   public void swap()
   {
      int temp = getInt(buttons.get(getInt(temp1)));
      buttons.get(getInt(temp1)).setText("" + getInt(buttons.get(getInt(temp2))));
      buttons.get(getInt(temp2)).setText("" + temp);
       
   }
   public static int getInt(JButton button)
   {
      return Integer.parseInt(button.getText()); 
   }
   public static int getInt(JTextField text)
   {
      return Integer.parseInt(text.getText());
   }

}
