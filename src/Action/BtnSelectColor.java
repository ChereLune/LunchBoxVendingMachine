package Action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;

public class BtnSelectColor implements MouseListener {

	List<JButton> blist;
	int i;
	Color btnDefault;
	JButton Buy;

	public BtnSelectColor(List<JButton> blist, int i) {
		this.blist = blist;
		this.i = i;
		btnDefault = blist.get(i).getBackground();
		Buy = blist.get(i);
	}

	public void mousePressed(MouseEvent e) {// 마우스 눌렸을때
	}

	public void mouseReleased(MouseEvent e) {// 마우스 떼었을때
	}

	public void mouseClicked(MouseEvent e) {// 눌렸다 떼었을때
	}

	public void mouseEntered(MouseEvent e) {// 창의 영역에 들어갔을때

		if (Admin.AdminInventory.numberSum[i] > 0)
			Buy.setBackground(Color.YELLOW);
		else
			Buy.setBackground(btnDefault);

	}

	public void mouseExited(MouseEvent e) {// 창의 영역에 나왔을때
		Buy.setBackground(btnDefault);
	}
}
