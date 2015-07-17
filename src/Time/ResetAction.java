package Time;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!TimeGui.bool){
			TimeGui.ms=0; 
			TimeGui.s=0; 
			TimeGui.min=0;
			TimeGui.minute.setText(Integer.toString(TimeGui.min));
			TimeGui.second.setText(Integer.toString(TimeGui.s));
			TimeGui.milisecond.setText(Integer.toString(TimeGui.ms));
			TimeGui.status.setText("STATUS: "+TimeGui.RESET_TRUE);
		}
		if(TimeGui.bool){
			TimeGui.status.setText("STATUS: "+TimeGui.RESET_FALSE);
		}
	}

}
