package Action;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetBtn implements ActionListener {

	JLabel pushM;
	JLabel selectedM;

	public ResetBtn(JLabel pushM, JLabel selectedM) {
		this.pushM = pushM;
		this.selectedM = selectedM;
	}

	public void actionPerformed(ActionEvent e) {
		showMessageDialog(null, "상품선택을 재시작합니다.");

		// 상품재고 리셋
		for (int i = 0; i < 6; i++) {
			Admin.AdminInventory.numberSum[i] += PurchaseBtn.selectedReset[i];
			PurchaseBtn.selectedReset[i] = 0;
		}

		PurchaseBtn.selectedSum = 0; // 상품선택금액 0으로 초기화
		selectedM.setText("" + PurchaseBtn.selectedSum);
	}
}