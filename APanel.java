import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

public class APanel extends JPanel {
	JTextField p;
	public APanel() {
		
		super();
		setLayout(new FlowLayout());
		for (int i = 0; i < 5; i++) {
			addButton();
			
		}
		p = new JTextField(5);
		p.setDragEnabled(true);
		add(p);
	}
	public void addButton() {
		Button b = new Button();
		b.setTransferHandler(new TransferHandler("text"));
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				p.setText(b.getText());
				
			}
		});
		add(b);
		
	}

}
