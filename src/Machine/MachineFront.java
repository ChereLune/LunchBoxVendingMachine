package Machine;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Action.AdminBtn;
import Action.ChangeCashBtn;
import Action.PaymentCardBtn;
import Action.PaymentCashBtn;
import Action.PurchaseBtn;
import Action.PushBtn;
import Action.InputCashBtn;
import Action.BtnSelectColor;
import Action.ResetBtn;
import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Product.Product;
import Product.ProductArray;

public class MachineFront extends JFrame  {

	JButton purchaseButton, cardButton, cashButton, inputButton, changeButton, closeButton, adminButton, pushButton;
	JTextField putCashText;
	JLabel selectedM;
	JLabel pushM;
	
	MachineFront(){
		List<JButton> blist = new ArrayList<JButton>();
		setTitle("도시락 자동판매기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container frontPane = getContentPane();
		frontPane.setLayout(null);
		this.setResizable(false);
		
		JPanel title = new JPanel();
		JPanel selectProduct = new JPanel();
		JPanel payment = new JPanel();
		JPanel printProduct = new JPanel();
		
		frontPane.add(title);
		frontPane.add(selectProduct);
		frontPane.add(payment);
		frontPane.add(printProduct);
		
	//-----------<제목 패널 : title>-----------//
		title.setLayout(new FlowLayout());
		title.setBounds(40,10,400,70);
		JLabel titleImage = new JLabel(new ImageIcon("img/title.png"));
		title.add(titleImage);
		
	//-----------<결제관련 패널 : payment>-----------//
		payment.setLayout(null);
		payment.setBounds(305,90,140,450);
		
		//상품선택금액 출력
		JLabel exp01 = new JLabel("선택금액");
		exp01.setBounds(5,20,90,30);
		payment.add(exp01);
		selectedM = new JLabel("0");
		selectedM.setBounds(65,20,90,30);
		payment.add(selectedM);
		JLabel exp02 = new JLabel("원");
		exp02.setBounds(115,20,90,30);
		payment.add(exp02);
		
		//현금투입금액 출력
		JLabel exp03 = new JLabel("투입금액");
		exp03.setBounds(5,55,90,30);
		payment.add(exp03);
		pushM = new JLabel("0");
		pushM.setBounds(65,55,90,30);
		payment.add(pushM);
		JLabel exp04 = new JLabel("원");
		exp04.setBounds(115,55,90,30);
		payment.add(exp04);
		
		//현금투입 TextField
		putCashText = new JTextField("0",6);
		putCashText.setBounds(20,135,90,30);
		payment.add(putCashText);
		JLabel exp05 = new JLabel("원");
		exp05.setBounds(115,135,90,30);
		payment.add(exp05);
		
		//현금투입 버튼
		inputButton = new JButton("현금투입");
		inputButton.setBounds(20,100,90,30);
		payment.add(inputButton);
		
		//현금결제 버튼
		cashButton = new JButton("현금결제");	
		cashButton.setBounds(20,210,90,30);
		payment.add(cashButton);
		
		//카드결제 버튼
		cardButton = new JButton("카드결제");	
		cardButton.setBounds(20,250,90,30);
		payment.add(cardButton);
		
		//잔돈반환 버튼
		changeButton = new JButton("잔돈반환");
		changeButton.setBounds(20,290,90,30);
		payment.add(changeButton);
		
		//선택취소 버튼
		closeButton = new JButton("선택취소");
		closeButton.setBounds(20,360,90,30);
		payment.add(closeButton);
		
		//관리자모드 버튼
		adminButton = new JButton("관리자모드");
		adminButton.setBounds(5,410,120,30);
		adminButton.setBackground(new Color(0,0,0));
		adminButton.setForeground(new Color(255,255,255));
		payment.add(adminButton);	
		
	//-----------<상품선택 패널 : selectProduct>-----------//
		selectProduct.setLayout(new GridLayout(3,2,10,10));
		selectProduct.setBounds(35,90,260,440);
		selectProduct.setBackground(new Color(47,47,47));
		
		//-------<상품등록 -> productList로>-------///
		ProductArray.productList.add(new Product("김치볶음 도시락",0,3500));
		ProductArray.productList.add(new Product("치킨마요 도시락",0,4000));
		ProductArray.productList.add(new Product("제육볶음 도시락",0,4500));
		ProductArray.productList.add(new Product("왕돈까스 도시락",0,5000));
		ProductArray.productList.add(new Product("생수",0,1000));
		ProductArray.productList.add(new Product("탄산음료",0,1500));

		//-------<productList 구성>-------///
		for (int i=0;i<ProductArray.productList.size();i++) {
			JLabel productName = new JLabel(ProductArray.productList.get(i).getProductName()); //상품명 라벨
			JLabel productPrice = new JLabel(ProductArray.productList.get(i).getProductPrice()+"원"); //상품가격 라벨
			productName.setFont(new Font("돋움",Font.PLAIN,11));
			productPrice.setFont(new Font("돋움",Font.PLAIN,10));
			productName.setHorizontalAlignment(JLabel.CENTER);
			productPrice.setHorizontalAlignment(JLabel.CENTER);
			productName.setForeground(new Color(255,255,255));
			productPrice.setForeground(new Color(255,255,255));
			purchaseButton = new JButton("구입"); //구입버튼
			blist.add(purchaseButton);

		//-------<상품별 패널 : productEach>-------//
			JPanel productEach = new JPanel(); 
			productEach.setLayout(new BorderLayout());
			productEach.setSize(120,160);
			productEach.setBackground(new Color(0,0,0));
			JPanel plus = new JPanel(); 
			plus.setLayout(new BorderLayout());
			plus.setBackground(new Color(0,0,0));
			
			//productEach 패널 : 상품사진, plus 패널
			productEach.add(new JLabel(new ImageIcon("img/product0"+i+".png")),BorderLayout.CENTER); //상품사진 라벨
			productEach.add(plus,BorderLayout.SOUTH);
			
			//plus 패널 : 상품이름, 가격, 구입버튼
			plus.add(productName,BorderLayout.NORTH);
			plus.add(productPrice,BorderLayout.CENTER);
			plus.add(purchaseButton,BorderLayout.SOUTH);
			
			selectProduct.add(productEach);
			blist.get(i).addActionListener(new PurchaseBtn(selectedM,i));	
			blist.get(i).addMouseListener(new BtnSelectColor(blist,i));	
		}
	
	//-----------<상품출력 패널 : printProduct>-----------//
		printProduct.setLayout(new FlowLayout());
		printProduct.setBounds(20,564,420,100);
		pushButton = new JButton(new ImageIcon("img/printProduct.png"));
		pushButton.setBackground(Color.red);
		pushButton.setBorderPainted(false);
		pushButton.setFocusPainted(false);
		pushButton.setContentAreaFilled(false);

		JLabel teamname = new JLabel("made by JANG & LEE & PARK");
		teamname.setFont(new Font("돋움",Font.ITALIC,12));
		teamname.setForeground(new Color(155,155,155));
		
		printProduct.add(pushButton);
		printProduct.add(teamname);
		
	//-----------<Button Action>-----------//
		inputButton.addActionListener(new InputCashBtn(putCashText,pushM));
		changeButton.addActionListener(new ChangeCashBtn(pushM));
		cardButton.addActionListener(new PaymentCardBtn(selectedM));
		cashButton.addActionListener(new PaymentCashBtn(selectedM,pushM));
		closeButton.addActionListener(new ResetBtn(pushM,selectedM));
		pushButton.addActionListener(new PushBtn());
		adminButton.addActionListener(new AdminBtn());
		
		
		setSize(480,696);
		setVisible(true);
	}
}