import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new APanel(Integer.parseInt(JOptionPane.showInputDialog("How long is the array?"))));
		frame.setVisible(true);
		frame.setSize(600, 100);

}

}
