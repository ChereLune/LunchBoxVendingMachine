package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.*;

import javax.swing.JLabel;

public class PaymentCashBtn implements ActionListener {

	JLabel selectedM;
	JLabel pushM;

	public PaymentCashBtn(JLabel selectedM, JLabel pushM) {
		this.selectedM = selectedM;
		this.pushM = pushM;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (InputCashBtn.pushSum >= PurchaseBtn.selectedSum) { // 투입금액이 선택금액이랑 같거다 클때
			showMessageDialog(null, "현금결제 되었습니다.");
			InputCashBtn.pushSum -= PurchaseBtn.selectedSum; // 투입금액-선택금액
			selectedM.setText("0"); // 선택금액 0으로
			pushM.setText("" + InputCashBtn.pushSum); // 투입금액에 남은돈표시.

			// 결제완료 후 매출액, 순수익에 추가
			Admin.AdminFront.sales += PurchaseBtn.selectedSum;
			Admin.AdminFront.salesrevenue += PurchaseBtn.selectedSum;

			// 상품선택금액 0으로 초기화
			PurchaseBtn.selectedSum = 0;
		} else if (InputCashBtn.pushSum < PurchaseBtn.selectedSum)
			showMessageDialog(null, "현금이 부족합니다.");

		// 선택취소 중복 방지
		for (int i = 0; i < 6; i++) {
			PurchaseBtn.selectedReset[i] = 0;
		}
	}
}