import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

public class InsertionSort implements Sortable {



	private ArrayList<Button> array;
	private JTextField a,b;

	private JButton swap;
	public InsertionSort(ArrayList<Button> array, JTextField a, JTextField b,JButton swap) {
		this.array = array;
		this.a = a;
		this.b = b;


		this.swap = swap;

		sort();


	}



	public void sort() {
		for(int o = 1; o < array.size();o++) {
			for(int i = o; i > 0; i--) {
				input(i-1,i);
				if(check()) {
					swap.doClick();
				}
			}
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


