package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.*;

public class PushBtn implements ActionListener {
	public PushBtn() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		showMessageDialog(null, "결제가 완료되면 상품을 수령하세요. 감사합니다^^");
	}
}
