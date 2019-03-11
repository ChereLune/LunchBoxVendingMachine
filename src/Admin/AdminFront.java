package Admin;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

//import Action.AddProductFrame;
import Product.ProductArray;

public class AdminFront extends JFrame {

	String productNames[] = { "전체", "김치볶음 도시락", "치킨마요 도시락", "제육볶음 도시락", "왕돈까스 도시락", "생수", "탄산음료" };
	DefaultTableModel productModel;
	JTable productTable;

	static public int sales = 0; // 매출액
	static public int salesrevenue = 0; // 순수익

	public AdminFront() {

		this.setTitle("관리자모드");
		this.setSize(350, 500);
		this.setLocation(460, 0);
		this.setResizable(false);

		// Container 생성
		Container adminPane = getContentPane();
		adminPane.setPreferredSize(new Dimension(350, 500));
		adminPane.setLayout(null);

		// JPanel 생성
		JPanel titleAdmin = new JPanel();
		JPanel loginAdmin = new JPanel();
		JPanel productAdmin = new JPanel();
		JPanel totalAdmin = new JPanel();
		JPanel closeAdmin = new JPanel();

		adminPane.add(titleAdmin);
		adminPane.add(loginAdmin);
		adminPane.add(productAdmin);
		adminPane.add(totalAdmin);
		adminPane.add(closeAdmin);

		// -----------<제목 패널 : titleAdmin>-----------//
		titleAdmin.setLayout(new FlowLayout());
		titleAdmin.setBounds(0, 15, 350, 50);
		JLabel admintitleImage = new JLabel(new ImageIcon("img/admintitle.png"));
		titleAdmin.add(admintitleImage);

		// -----------<통계 패널 : totalAdmin>----------//
		totalAdmin.setLayout(new GridLayout(2, 1));
		totalAdmin.setBounds(10, 320, 340, 50);
		JPanel totalPanel = new JPanel();
		JPanel purePanel = new JPanel();
		JLabel totalM = new JLabel(sales + " 원");
		JLabel pureM = new JLabel(salesrevenue + " 원");
		totalPanel.setLayout(new FlowLayout());
		totalPanel.add(new JLabel("오늘의 매출액  "));
		totalPanel.add(totalM);
		purePanel.setLayout(new FlowLayout());
		purePanel.add(new JLabel("오늘의 순수익  "));
		purePanel.add(pureM);
		totalAdmin.add(totalPanel);
		totalAdmin.add(purePanel);
		totalAdmin.setVisible(false);

		// -----------<상품관리 패널 : productAdmin>----------//
		productAdmin.setLayout(new FlowLayout());
		productAdmin.setBounds(10, 80, 330, 220);

		// 상품관리 테이블
		String[] productColName = { "상품명", "재고", "상품가격" };
		productModel = new DefaultTableModel(productColName, 0);
		productTable = new JTable(productModel);
		JScrollPane productScrollPanel = new JScrollPane(productTable);
		productScrollPanel.setPreferredSize(new Dimension(300, 180));
		JComboBox<String> combo = new JComboBox<String>(productNames);
		JButton productAddBtn = new JButton("추가");
		JTextField productNumber = new JTextField("0", 3);

		for (int i = 0; i < ProductArray.productList.size(); i++) {
			String arr[] = { ProductArray.productList.get(i).getProductName(),
					Integer.toString(AdminInventory.numberSum[i]),
					Integer.toString(ProductArray.productList.get(i).getProductPrice()) };
			productModel.addRow(arr);
		}

		// 재고추가 버튼
		productAddBtn.addActionListener(new AdminInventory(combo, productNumber, productTable, pureM));

		productAdmin.add(productScrollPanel);
		productAdmin.add(combo);
		productAdmin.add(new JLabel("재고추가"));
		productAdmin.add(productNumber);
		productAdmin.add(productAddBtn);
		productAdmin.setVisible(false);

		// -----------<닫기 패널 : closeAdmin>----------//
		closeAdmin.setLayout(new FlowLayout());
		closeAdmin.setBounds(0, 400, 350, 50);
		JButton logoutBtn = new JButton("로그아웃");
		closeAdmin.add(logoutBtn);
		JButton reloadBtn = new JButton("새로고침");
		closeAdmin.add(reloadBtn);
		closeAdmin.setVisible(false);

		// 새로고침 버튼
		reloadBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				totalM.setText(sales + " 원");
				pureM.setText(salesrevenue + " 원");

				for (int i = 0; i < 6; i++) {
					productTable.setValueAt(AdminInventory.numberSum[i], i, 1);
				}
			}
		});

		// 로그아웃 버튼 클릭
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.YES_OPTION;
				JOptionPane.showMessageDialog(null, "관리자 모드를 로그아웃합니다", "경고", JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					loginAdmin.setVisible(true);
					totalAdmin.setVisible(false);
					productAdmin.setVisible(false);
					closeAdmin.setVisible(false);
				}
			}
		});

		// -----------<로그인 패널 : loginAdmin>----------//
		loginAdmin.setLayout(new FlowLayout());
		loginAdmin.setBounds(0, 100, 350, 400);
		JLabel loginlabel = new JLabel("비밀번호");
		JPasswordField adminPass = new JPasswordField(10);
		adminPass.setEchoChar('*');
		adminPass.setHorizontalAlignment(JPasswordField.CENTER);
		JButton loginAdminBtn = new JButton("로그인");
		loginAdmin.add(loginlabel);
		loginAdmin.add(adminPass);
		loginAdmin.add(loginAdminBtn);

		loginAdmin.setVisible(true);

		// Enter 키 입력시 로그
		Action enterlogin = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int Password = Integer.parseInt(adminPass.getText()); // 비밀번호 문자열

				if (Password == 1234) {
					showMessageDialog(null, "환영합니다");
					loginAdmin.setVisible(false);
					totalAdmin.setVisible(true);
					productAdmin.setVisible(true);
					closeAdmin.setVisible(true);
					closeAdmin.add(logoutBtn);
					adminPass.setText("");

				} else {
					showMessageDialog(null, "비밀번호가 틀렸습니다");
				}
			}
		};
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		adminPass.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		adminPass.getActionMap().put("ENTER", enterlogin);

		// 로그인 버튼 클릭
		loginAdminBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int password = Integer.parseInt(adminPass.getText()); // 비밀번호 문자열
				if (password == 1234) {
					showMessageDialog(null, "환영합니다");
					loginAdmin.setVisible(false);
					totalAdmin.setVisible(true);
					productAdmin.setVisible(true);
					closeAdmin.setVisible(true);
					closeAdmin.add(logoutBtn);
					adminPass.setText("");
				} else {
					showMessageDialog(null, "비밀번호가 틀렸습니다");
				}
			}
		});

		adminPane.setVisible(true);
		this.setVisible(true);
	}
}