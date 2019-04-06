import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new APanel());
		frame.setVisible(true);

}

}
