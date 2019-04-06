import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton {
	public static final int NONE = 0;
	public static final int COMPARE = 1;
	public static final int SWAP = 2;

	private int state;
	public Button() {
		super();		
		state = 0;
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setState(getState() == 2?0:getState()+1);
				
				
			}
		});
	}
	public void setState(int state) {
		this.state = state;
		switch (state) {
		case NONE:
			setBackground(Color.WHITE);
			break;
		case COMPARE:
			setBackground(Color.YELLOW);
			break;
		case SWAP:
			setBackground(Color.RED);
			break;
		default:
			break;
		}
	}
	public int getState() {
		return state;
	}
	
	
}