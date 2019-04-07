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

		}

	}

	public boolean check() {
		if(APanel.getInt(array.get(APanel.getInt(a))) > APanel.getInt(array.get(APanel.getInt(b))) ) {
			return true;
		}
		return false;
	}

	private void input(int a,int b) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		this.a.requestFocus();
		this.a.setText("" + (a));
		this.b.requestFocus();
		this.b.setText("" + b);
	}


}
