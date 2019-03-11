package Action;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import Product.ProductArray;

public class PurchaseBtn implements ActionListener {

	static public int selectedSum = 0, selectedReset[] = { 0, 0, 0, 0, 0, 0 };
	JLabel selectedM;
	int i, Pricelist;

	public PurchaseBtn(JLabel selectedM, int i) {
		this.selectedM = selectedM;
		this.i = i;
		Pricelist = ProductArray.productList.get(i).getProductPrice();
	}

	public void actionPerformed(ActionEvent e) {

		if (Admin.AdminInventory.numberSum[i] > 0) { // 재고가 있을시
			selectedSum = selectedSum + Pricelist; // 선택금액에 누적
			selectedM.setText("" + selectedSum);
			Admin.AdminInventory.numberSum[i]--; // 선택한만큼 재고떨어짐
			selectedReset[i]++; // 선택취소를대비해 만듬.
		} else
			showMessageDialog(null, "재고가 부족합니다.");

	}
}