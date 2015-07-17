package Time;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionClass implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if((TimeGui.getCounter()%2) == 0){
			TimeGui.bool = true;
			//TimeGui.state.setText("start".toUpperCase());
			ListenerClass.start();
		}
		else if((TimeGui.getCounter()%2) != 0){
			TimeGui.bool = false;
			//TimeGui.state.setText("stop".toUpperCase() + " ");
			ListenerClass.stop();
		}
	}

}
