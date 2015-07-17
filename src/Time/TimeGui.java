package Time;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TimeGui extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static int ms=0,s=0,min=0;
	public static int counter=0; 
	public static final String START="RUNNING", STOP="STOPPED", RESET_TRUE="RESET COMPLETE", RESET_FALSE="STOP THE TIMER FIRST";
	public static JLabel bg, milisecond, second, minute, colon, period, title, status;
	public static boolean bool = false;	//meaning stopped
	public static JButton state, reset;
	public static Font ButtonFont;
	public static Font TimeFont;
	
	//Constructor that starts it all
	public TimeGui(){
		ButtonFont();	//Adds Custom Fonts
		
		setLayout(new BorderLayout());
		ListenerClass l = new ListenerClass();
		title();
		setFocusable(true);
		addKeyListener(l);
		add(zeroTime());	//Initializes all the integer variables and adds stuff to them.
		//addTime();
		buttons();
	
	}


	
	
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		TimeGui.counter = counter;
	}
	
	private void title() {
		title = new JLabel("<html><font color=#4eb9bd size=15>Press </font><font color=#d17bc1 size=15>Spacebar </font><font color=#4eb9bd size=15>to Start/Stop</font></html>");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setHorizontalTextPosition(JLabel.CENTER);
		add(title, BorderLayout.NORTH);
		
	}

	public static void ButtonFont(){
		try {
			ButtonFont = Font.createFont(Font.TRUETYPE_FONT, new URL("http://www.fontsaddict.com/fontface/sega-logo-font.TTF").openStream()).deriveFont(Font.PLAIN, 40);
			TimeFont = Font.createFont(Font.TRUETYPE_FONT, new URL("http://www.webpagepublicity.com/free-fonts/d/Digital%20Readout%20Thick%20Upright.ttf").openStream()).deriveFont(Font.PLAIN, 150);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	public void buttons() {
		JPanel ButtonPanels = new JPanel();
		ButtonPanels.setLayout(new BorderLayout());
		ButtonPanels.setAlignmentX(BOTTOM_ALIGNMENT);
		//ButtonPanels.setBorder(new EmptyBorder(10, 100, 10, 100));
		state = new JButton();
		final String start = "start";
		
		state.setFont(ButtonFont);
		state.setText(start.toUpperCase());
		state.setSize(new Dimension(30,30));
		state.setBorder(new EmptyBorder(20, 50, 20, 50));
		state.setHorizontalAlignment(JButton.CENTER);
		state.setVerticalAlignment(JButton.CENTER);
		state.setForeground(new Color(182,139,104));
		state.setAlignmentX(CENTER_ALIGNMENT);
		state.addActionListener(new ActionClass());
		
		reset = new JButton();
		reset.setFont(ButtonFont);
		reset.setText("Reset".toUpperCase());
		reset.setSize(new Dimension(30,30));
		reset.setBorder(new EmptyBorder(20, 50, 20, 50));
		reset.setHorizontalAlignment(JButton.CENTER);
		reset.setVerticalAlignment(JButton.CENTER);
		reset.setForeground(new Color(178,34,34));
		reset.setAlignmentX(CENTER_ALIGNMENT);
		reset.setToolTipText("You need to \"Stop\" the Timer before you can RESET".toUpperCase());
		reset.addActionListener(new ResetAction());
		
		status = new JLabel();
		status.setFont(new Font("Verdana", Font.PLAIN, 24));
		status.setText("STATUS: ");
		status.setHorizontalTextPosition(JLabel.CENTER);
		
		ButtonPanels.add(state, BorderLayout.WEST);
		//ButtonPanels.setBorder(new EmptyBorder(10, 30, 10, 30));	//Adds gap between buttons
		ButtonPanels.add(reset, BorderLayout.EAST);
		ButtonPanels.add(status, BorderLayout.SOUTH);
		
		add(ButtonPanels, BorderLayout.SOUTH);
		
		
	}
	
	public static JPanel zeroTime(){
		JPanel Time = new JPanel();
		Time.setLayout(new FlowLayout());
		Time.setAlignmentX(CENTER_ALIGNMENT);
		Time.setToolTipText("Press \'Spacebar\' to Start/Stop and \'R\' to Reset the Stopwatch".toUpperCase());
		ButtonFont();
		
		minute = new JLabel();
		minute.setFont(TimeFont);
		minute.setText(Integer.toString(0));
		Time.add(minute);
		
		colon = new JLabel();
		colon.setFont(TimeFont);
		colon.setText(":");
		colon.setBorder(new EmptyBorder(-20,0,20,0));
		Time.add(colon);
		
		second = new JLabel();
		second.setFont(TimeFont);
		second.setText(Integer.toString(0));
		Time.add(second);
		

		period = new JLabel();
		period.setFont(TimeFont);
		period.setText(".");
		//period.setBorder(new EmptyBorder(-20,0,20,0));
		Time.add(period);
		
		milisecond = new JLabel();
		milisecond.setFont(TimeFont);
		milisecond.setText(Integer.toString(0));
		Time.add(milisecond);
		
		
		return Time;
		
	}
	
}
