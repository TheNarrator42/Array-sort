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
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				a.requestFocus();
				a.setText("" + (n-1));
				b.requestFocus();
				b.setText("" + n);
				
				if(check()) {
					swap.doClick();
				}
				
				
			}
			array.get(array.size()-o).setState(Button.SECURED);
		}
	}
	public boolean check() {
		if(APanel.getInt(array.get(APanel.getInt(a))) > APanel.getInt(array.get(APanel.getInt(b))) ) {
			return true;
		}
		return false;
	}

	
	
	
}
