package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.*;

import javax.swing.JLabel;

public class ChangeCashBtn implements ActionListener {
	int changeCash;
	JLabel pushM;

	public ChangeCashBtn(JLabel pushM) {
		this.pushM = pushM;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		showMessageDialog(null, InputCashBtn.pushSum + "   원이 반환 되었습니다.");
		changeCash = Integer.parseInt(pushM.getText()) - Integer.parseInt(pushM.getText());

		pushM.setText("" + changeCash);
		InputCashBtn.pushSum = 0;
	}
}