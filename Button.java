import java.awt.Color;

import javax.swing.JButton;

public class Button extends JButton {
	public static final int NONE = 0;
	public static final int COMPARE = 1;
	public static final int SWAP = 2;
	public static final int SECURED = 3;
	private int state;
	public Button() {
		super();		
		setState(0);
		
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
		case SECURED:
			setBackground(Color.GREEN);
			break;
		default:
			break;
		}
	}
	public int getState() {
		return state;
	}
	
	
}