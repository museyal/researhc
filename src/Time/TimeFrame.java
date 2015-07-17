package Time;

import javax.swing.JFrame;

public class TimeFrame {
	public static void main(String... args){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Timer");
		frame.add(new TimeGui());
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
