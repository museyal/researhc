package Time;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class ListenerClass implements KeyListener{

	public int i = 0;
	public static Timer timer;
	
	@Override
	public void keyPressed(KeyEvent e) {
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			i++;
			
			if((e.getKeyCode() == KeyEvent.VK_SPACE) && (IsOdd(i) == true)){
				TimeGui.bool = true;
				start();
			}
			if((e.getKeyCode() == KeyEvent.VK_SPACE) && (IsOdd(i) == false)){
				TimeGui.bool = false;
				stop();
			}
			
		}
		
		if((e.getKeyCode() == KeyEvent.VK_R) && (!TimeGui.bool)){
			resetperform();
		}
		else if ((e.getKeyCode() == KeyEvent.VK_R) && (TimeGui.bool)){
			TimeGui.status.setText("STATUS: "+TimeGui.RESET_FALSE);
		}
		
	}

	private boolean IsOdd(int i){
		if(i%2 ==  0)
			return false;
		else 
			return true;
	}
	
	public static synchronized void start() {
		//System.out.println(TimeGui.bool);
		actionPerformed();
		addTime();
		TimeGui.status.setText("STATUS: "+TimeGui.START);
		
	}

	public static synchronized void stop() {
		//System.out.println(TimeGui.bool);
		actionPerformed();
		addTime();
		TimeGui.status.setText("STATUS: "+TimeGui.STOP);
	}

	public static void actionPerformed() {
		int i = TimeGui.getCounter();
		i++;
		TimeGui.setCounter(i);
		
		if((TimeGui.getCounter()%2) == 0){
			TimeGui.state.setText("start".toUpperCase());
		}
		else if((TimeGui.getCounter()%2) != 0){
			TimeGui.state.setText("stop".toUpperCase() + " ");
		}
	}
	
	private void resetperform() {
		TimeGui.ms=0; 
		TimeGui.s=0; 
		TimeGui.min=0;
		TimeGui.minute.setText(Integer.toString(TimeGui.min));
		TimeGui.second.setText(Integer.toString(TimeGui.s));
		TimeGui.milisecond.setText(Integer.toString(TimeGui.ms));
	}

	public  static void addTime() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTasking(), 0, 1);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
