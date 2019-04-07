import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       try{
		   frame.setContentPane(new APanel(Integer.parseInt(JOptionPane.showInputDialog("How long is the array?"))));
      }catch(Exception e) {System.exit(0);}
		frame.setVisible(true);
		frame.setSize(600, 100);

}

}
