package week14.example2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter {

	MyFrame2 frame;
	
	public MyWindowAdapter(MyFrame2 frame) {
		this.frame = frame;
	}
	
	// source - override 사용
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowOpened(e);
	}
	
}
