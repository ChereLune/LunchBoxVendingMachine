package Action;

import static javax.swing.JOptionPane.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class PaymentCardBtn implements ActionListener {

	int paymentCard;
	JLabel selectedM;

	public PaymentCardBtn(JLabel selectedM) {
		this.selectedM = selectedM;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		showMessageDialog(null, selectedM.getText() + "   원이 결제 되었습니다.");
		paymentCard = Integer.parseInt(selectedM.getText()) - Integer.parseInt(selectedM.getText());
		selectedM.setText(Integer.toString(paymentCard));

		// 결제완료 후 매출액, 순수익에 추가
		Admin.AdminFront.sales += PurchaseBtn.selectedSum;
		Admin.AdminFront.salesrevenue += PurchaseBtn.selectedSum;

		// 상품선택금액 0으로 초기화
		PurchaseBtn.selectedSum = 0;

		// 선택취소 중복 방지
		for (int i = 0; i < 6; i++) {
			PurchaseBtn.selectedReset[i] = 0;
		}
	}
}
