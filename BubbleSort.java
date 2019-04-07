import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BubbleSort implements Sortable {
	private ArrayList<Button> array;
	private JTextField a,b;

	private JButton swap;
	public BubbleSort(ArrayList<Button> array, JTextField a, JTextField b,JButton swap) {
		this.array = array;
		this.a = a;
		this.b = b;
		
		
		this.swap = swap;
		
		sort();
		
		
	}
	
	
	
	public void sort() {
		
		
		for(int o = 1; o < array.size(); o++) {
			for(int n = 1; n < array.size() - o+1; n++ ) {
				
				for(int i = 0; i < n; i++) {
               array.get(i).setState(Button.NONE);
            }
				
            a.setText("" + (n-1));
				array.get(APanel.getInt(a)).setState(Button.COMPARE);

				b.setText("" + n);
				array.get(APanel.getInt(b)).setState(Button.COMPARE);

			
				
				if(check()) {
					swap.doClick();
				}
				
				
            try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
         array.get(array.size()-o-1).setState(Button.NONE);
			array.get(array.size()-o).setState(Button.SECURED);
		}
      array.get(0).setState(Button.SECURED);
	}
	public boolean check() {
		if(APanel.getInt(array.get(APanel.getInt(a))) > APanel.getInt(array.get(APanel.getInt(b))) ) {
			return true;
		}
		return false;
	}

	
	
	
}
