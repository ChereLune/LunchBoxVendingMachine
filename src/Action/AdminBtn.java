package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminBtn implements ActionListener{

	public AdminBtn() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Admin.AdminFront();
	}
}
