import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

public class SelectionSort implements Sortable {

	private ArrayList<Button> array;
	private JTextField a,b;

	private JButton swap;
	public SelectionSort(ArrayList<Button> array, JTextField a, JTextField b,JButton swap) {
		this.array = array;
		this.a = a;
		this.b = b;


		this.swap = swap;

		sort();


	}



	public void sort() {
		for(int x = 0; x < array.size();x++) {
			int min = x;
			for(int y = x; y < array.size();y++) {
				input(min,y);
				if(check()) {
					min = y;
				}
			}
			input(min, x);
         
			swap.doClick();
         array.get(x).setState(Button.SECURED);
         
		}

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
			Thread.sleep(500/array.size());
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}


}
