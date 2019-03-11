package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Product.ProductArray;

public class AdminInventory implements ActionListener {

	static public int[] numberSum = { 5, 5, 5, 5, 5, 5 };
	JComboBox combo;
	JTextField productNumber;
	JTable productTable;
	JLabel pureM;

	public AdminInventory(JComboBox combo, JTextField productNumber, JTable productTable, JLabel pureM) {
		this.combo = combo;
		this.productNumber = productNumber;
		this.productTable = productTable;
		this.pureM = pureM;
	}

	public void actionPerformed(ActionEvent e) {

		int number = Integer.parseInt(productNumber.getText());
		productNumber.setText("");

		// 콤보박스에서 전체 추가 선택
		if (combo.getSelectedIndex() == 0) {
			for (int i = 0; i < 6; i++) {
				numberSum[i] += number;
				productTable.setValueAt(numberSum[i], i, 1);

				// 순수익 변동
				int Pricelist = ProductArray.productList.get(i).getProductPrice();
				Admin.AdminFront.salesrevenue -= number * (Pricelist * 0.6);
				pureM.setText(Admin.AdminFront.salesrevenue + " 원");
			}
		}

		// 콤보박스 에서 개별 메뉴 추가 선택
		for (int i = 1; i < 7; i++) {
			if (combo.getSelectedIndex() == i) {
				numberSum[i - 1] += number;
				productTable.setValueAt(numberSum[i - 1], i - 1, 1);

				// 순수익 변동
				int Pricelist = ProductArray.productList.get(i - 1).getProductPrice();
				Admin.AdminFront.salesrevenue -= number * (Pricelist * 0.6);
				pureM.setText(Admin.AdminFront.salesrevenue + " 원");
			}
		}
	}
}
