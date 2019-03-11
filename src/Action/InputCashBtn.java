package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputCashBtn implements ActionListener{

	static public int pushSum;
	JTextField putCashText;
	JLabel pushM;
	public InputCashBtn(JTextField putCashText , JLabel pushM) {
		this.putCashText=putCashText;
		this.pushM=pushM;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int PutCash = Integer.parseInt(putCashText.getText());
			// 0보다 작거나 0이거나 100으로나눴을때 0이아니거나
		if (PutCash < 0 || putCashText.getText().equals("0") ||PutCash %100!=0) {
			showMessageDialog(null, " 100원 단위로 현금을 투입해주세요.");
		}
		else {
			showMessageDialog(null, "현금   "+putCashText.getText()+"   원이 투입 되었습니다.");
	    	pushSum = pushSum + Integer.parseInt(putCashText.getText()); //투입금액에 추가
	    	pushM.setText(pushSum+"");
	    	putCashText.setText("");
		}
	}
}
