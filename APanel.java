import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.TransferHandler;

@SuppressWarnings("serial")
public class APanel extends JPanel {
   ArrayList<Button> buttons;
   JTextField temp1;
   JTextField temp2;
   Timer t;
   Thread th;
   String[] sorts = {"Bubble Sort", "Selection Sort", "Insertion Sort"};
   
   public APanel() {
   	
      super();
      buttons = new ArrayList<>();//The array
      setLayout(new FlowLayout());
      for (int i = 0; i < 5; i++) {
         addButton();
      	
      }
      temp1 = new JTextField(5);//Access field one
      temp1.addFocusListener(new FocusListener() {
         public void focusGained(FocusEvent e) {
        	 if(getInt(temp1) < buttons.size()) {
            buttons.get(getInt(temp1)).setState(Button.NONE);
        	 }
         }
         public void focusLost(FocusEvent e) {
        	 if(getInt(temp1) < buttons.size()) {
            buttons.get(getInt(temp1)).setState(Button.COMPARE);
        	 }
         }
      });
      temp1.setDragEnabled(true);
      add(temp1);
      temp2 = new JTextField(5);//access field 2
      temp2.setDragEnabled(true);
      temp2.addFocusListener(new FocusListener() {
         public void focusGained(FocusEvent e) {
        	 if(getInt(temp2) < buttons.size()) {
            buttons.get(getInt(temp2)).setState(Button.NONE);
        	 }
         }
         public void focusLost(FocusEvent e) {
        	 if(getInt(temp2) < buttons.size()) {
            buttons.get(getInt(temp2)).setState(Button.COMPARE);
        	 }
         }
      });
      add(temp2);
      JButton swap = new JButton("swap");
      swap.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
            swap();
         }
      });
      add(swap);//swap button
      t = new Timer(900, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			th.suspend();
			updateUI();
			th.resume();
			
		}
	});
      
      JButton scramble = new JButton("Scramble");
      scramble.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Random r = new Random();
			for(Button i: buttons) {
				i.setText("" + (r.ints().iterator().nextInt()%10));
			}
			
		}
	});
      add(scramble);
      JComboBox<String> jc = new JComboBox<>(sorts);//sort selection
      add(jc);
      JButton selection = new JButton("Sort");
      debugInit();
      selection.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch((String)jc.getSelectedItem()) {
			case "Bubble Sort": 
				th = new Thread() {
					public void run() {
						selection.setEnabled(false);
						new BubbleSort(buttons,temp1,temp2,swap);
						selection.setEnabled(true);
					}
					
				};
				th.start();
				t.start();
				break;
			case "Selection Sort":
				th = new Thread() {
					public void run() {
						selection.setEnabled(false);
						new SelectionSort(buttons,temp1,temp2,swap);
						selection.setEnabled(true);
					}
				};
				th.start();
				t.start();
				break;
			case "Insertion Sort":
				th = new Thread() {
					public void run() {
						selection.setEnabled(false);
						new InsertionSort(buttons,temp1,temp2,swap);
						selection.setEnabled(true);
					}
				};
				th.start();
				t.start();
				break;
			}
			
		}
	});
      add(selection);
      //setLayout(new FlowLayout());
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //setSize(400,400);
      
   }
   public APanel(int size) {
	   	
	      super();
	      buttons = new ArrayList<>();//The array
	      setLayout(new FlowLayout());
	      for (int i = 0; i < size; i++) {
	         addButton();
	      	
	      }
	      temp1 = new JTextField(5);//Access field one
	      temp1.addFocusListener(new FocusListener() {
	         public void focusGained(FocusEvent e) {
	        	 if(getInt(temp1) < buttons.size()) {
	            buttons.get(getInt(temp1)).setState(Button.NONE);
	        	 }
	         }
	         public void focusLost(FocusEvent e) {
	        	 if(getInt(temp1) < buttons.size()) {
	            buttons.get(getInt(temp1)).setState(Button.COMPARE);
	        	 }
	         }
	      });
	      temp1.setDragEnabled(true);
	      add(temp1);
	      temp2 = new JTextField(5);//access field 2
	      temp2.setDragEnabled(true);
	      temp2.addFocusListener(new FocusListener() {
	         public void focusGained(FocusEvent e) {
	        	 if(getInt(temp2) < buttons.size()) {
	            buttons.get(getInt(temp2)).setState(Button.NONE);
	        	 }
	         }
	         public void focusLost(FocusEvent e) {
	        	 if(getInt(temp2) < buttons.size()) {
	            buttons.get(getInt(temp2)).setState(Button.COMPARE);
	        	 }
	         }
	      });
	      add(temp2);
	      JButton swap = new JButton("swap");
	      swap.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e)
	         {
	            swap();
	         }
	      });
	      add(swap);//swap button
	      t = new Timer(900, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				th.suspend();
				updateUI();
				th.resume();
				
			}
		});
	      
	      JButton scramble = new JButton("Scramble");
	      scramble.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Random r = new Random();
				for(Button i: buttons) {
					i.setText("" + (r.ints().iterator().nextInt()%10));
				}
				
			}
		});
	      add(scramble);
	      JComboBox<String> jc = new JComboBox<>(sorts);//sort selection
	      add(jc);
	      JButton selection = new JButton("Sort");
	      debugInit();
	      selection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch((String)jc.getSelectedItem()) {
				case "Bubble Sort": 
					th = new Thread() {
						public void run() {
							selection.setEnabled(false);
							new BubbleSort(buttons,temp1,temp2,swap);
							selection.setEnabled(true);
						}
						
					};
					th.start();
					t.start();
					break;
				case "Selection Sort":
					th = new Thread() {
						public void run() {
							selection.setEnabled(false);
							new SelectionSort(buttons,temp1,temp2,swap);
							selection.setEnabled(true);
						}
					};
					th.start();
					t.start();
					break;
				case "Insertion Sort":
					th = new Thread() {
						public void run() {
							selection.setEnabled(false);
							new InsertionSort(buttons,temp1,temp2,swap);
							selection.setEnabled(true);
						}
					};
					th.start();
					t.start();
					break;
				}
				
			}
		});
	      add(selection);
	      //setLayout(new FlowLayout());
	      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      //setSize(400,400);
	      
	   }
   private void debugInit() {
	   for(Button i: buttons) {
		   i.setText("" + new Random().nextInt(10));
	   }
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
   {  try{
         int temp = getInt(buttons.get(getInt(temp1)));
         buttons.get(getInt(temp1)).setText("" + getInt(buttons.get(getInt(temp2))));
         buttons.get(getInt(temp2)).setText("" + temp);
      }catch(Exception e) {
      
      }
       
   }
   public static int getInt(JButton button)
   {
	   
	   int a = 0;
      try{
    	  a= Integer.parseInt(button.getText()) ;
      }catch(NullPointerException ex) {
      
      }catch(NumberFormatException ex) {}
      return a;
      
   }
   public static int getInt(JTextField text)
   {
	   int a = 0;
	      try{
	    	  a= Integer.parseInt(text.getText()) ;
	      }catch(NullPointerException ex) {
	      
	      }catch(NumberFormatException e) {}
	      return a;
   }

}
