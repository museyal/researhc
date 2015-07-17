package Time;

import java.util.TimerTask;

public class TimerTasking extends TimerTask{

	 @Override
	  public void run() {
	   if(TimeGui.bool){
		TimeGui.ms++;
	    if(TimeGui.ms==1000){
	        TimeGui.s++;
	        TimeGui.ms=0;
	    }
	    if(TimeGui.s==60){
	        TimeGui.min++;
	        TimeGui.s=0;
	    }
	    TimeGui.milisecond.setText(Integer.toString(TimeGui.ms));
	    TimeGui.second.setText(Integer.toString(TimeGui.s));
	    TimeGui.minute.setText(Integer.toString(TimeGui.min));
	   }
	   
	   if(!TimeGui.bool){
			this.cancel();
		 }
	  }
}
