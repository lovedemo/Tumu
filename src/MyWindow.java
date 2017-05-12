import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class MyWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l1, l3, l5, l7, l8, l9;
	JButton find, in;
	JComboBox<String> hezaitype, point, hunningtu;
	JComboBox<String> shoula1, gu1;

	JTextField tx = new JTextField();
	JTextField sizehj = new JTextField();
	JTextField sizebj = new JTextField();
	JTextField shoula2 = new JTextField();
	JTextField gu2 = new JTextField();
	JTextField gu3 = new JTextField();
	private JLabel label;
	private JLabel label_1;
	private JLabel lblb;
	private JLabel lblh;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel lblMkp;

	public MyWindow() {
		setLocation(0, -51);
		setResizable(false);
		setTitle("\u94A2\u7B4B\u6DF7\u51DD\u571F\u7B80\u652F\u6881\u865A\u62DF\u5B9E\u9A8C\u5BA4");
		// TODO Auto-generated constructor stub
		// setLayout(new GridLayout(4,2));
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("宋体", Font.BOLD, 22);
		Font font1 = new Font("宋体", Font.BOLD, 16);

		// hezai = new JLabel("荷载设计");
		// liang = new JLabel("梁设计");
		l1 = new JLabel("荷载种类");
		l3 = new JLabel(" \u4F5C\u7528\u4F4D\u7F6E");
		l5 = new JLabel("混凝土强度");
		l7 = new JLabel("\u52A0\u8F7D\u8377\u8F7D");
		l8 = new JLabel("mm");
		l9 = new JLabel("mm");
		getContentPane().add(l1);
		getContentPane().add(l3);
		getContentPane().add(l5);
		getContentPane().add(l7);
		getContentPane().add(l8);
		getContentPane().add(l9);
		// add(hezai);
		// add(liang);
		// hezai.setLocation(10, 10);
		// hezai.setFont(font);
		// liang.setFont(font);
		l1.setFont(font1);
		l3.setFont(font1);
		l5.setFont(font1);
		l7.setFont(new Font("宋体", Font.BOLD, 16));
		l8.setFont(font);
		l9.setFont(font);
		// hezai.setBounds(80, 50, 100, 50);
		// liang.setBounds(250, 50, 100, 50);
		l1.setBounds(50, 224, 70, 41);
		l3.setBounds(40, 274, 80, 41);
		l5.setBounds(300, 330, 85, 41);
		l7.setBounds(50, 325, 70, 50);
		hezaitype = new JComboBox<String>();
		// sizeh = new JComboBox<>();
		point = new JComboBox<>();
		// sizeb = new JComboBox<>();
		shoula1 = new JComboBox<>();
		// shoula2 = new JComboBox<>();
		hunningtu = new JComboBox<>();
		gu1 = new JComboBox<>();

		getContentPane().add(hezaitype);
		// add(sizeh);
		getContentPane().add(sizehj);
		getContentPane().add(point);
		getContentPane().add(sizebj);
		getContentPane().add(shoula1);
		getContentPane().add(shoula2);
		getContentPane().add(hunningtu);
		getContentPane().add(gu1);
		getContentPane().add(gu2);
		getContentPane().add(gu3);
		getContentPane().add(tx);
		hezaitype.setBounds(122, 225, 80, 41);
		sizebj.setBounds(450, 120, 50, 30);
		sizehj.setBounds(450, 150, 50, 30);
		l8.setBounds(500, 120, 50, 30);
		l9.setBounds(500, 150, 50, 30);
		point.setBounds(122, 275, 80, 41);

		shoula1.setBounds(359, 230, 81, 30);
		shoula2.setBounds(450, 231, 50, 30);
		hunningtu.setBounds(395, 336, 80, 30);
		gu1.setBounds(336, 280, 85, 30);
		gu2.setBounds(425, 280, 37, 30);
		gu3.setBounds(477, 280, 50, 30);
		tx.setBounds(125, 337, 50, 30);
		find = new JButton("筛选");
		in = new JButton("<html>\u5BFC\u5165<br/>\u6570\u636E</html>");
		getContentPane().add(find);
		getContentPane().add(in);
		find.setBounds(300, 402, 80, 42);
		in.setBounds(50, 394, 80, 50);

		JLabel lblImg = new JLabel("");
		lblImg.setBounds(21, 19, 300, 162);
		getContentPane().add(lblImg);

		JLabel lblKn = new JLabel("KN");
		lblKn.setFont(new Font("宋体", Font.BOLD, 16));
		lblKn.setBounds(185, 344, 54, 15);
		getContentPane().add(lblKn);

		label = new JLabel("\u7B80\u652F\u6881\u8BBE\u8BA1");
		label.setFont(new Font("宋体", Font.BOLD, 16));
		label.setBounds(370, 50, 85, 30);
		getContentPane().add(label);

		label_1 = new JLabel("\u622A\u9762\u8BBE\u8BA1");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(370, 90, 85, 30);
		getContentPane().add(label_1);

		lblb = new JLabel("\u622A\u9762\u5BBD\u5EA6B");
		lblb.setFont(new Font("宋体", Font.BOLD, 16));
		lblb.setBounds(370, 120, 85, 30);
		getContentPane().add(lblb);

		lblh = new JLabel("\u622A\u9762\u5BBD\u5EA6H");
		lblh.setFont(new Font("宋体", Font.BOLD, 16));
		lblh.setBounds(370, 150, 85, 30);
		getContentPane().add(lblh);

		label_2 = new JLabel("\u6750\u6599");
		label_2.setFont(new Font("宋体", Font.BOLD, 16));
		label_2.setBounds(400, 190, 85, 30);
		getContentPane().add(label_2);

		label_3 = new JLabel("\u53D7\u62C9\u7B4B");
		label_3.setFont(new Font("宋体", Font.BOLD, 16));
		label_3.setBounds(300, 224, 85, 41);
		getContentPane().add(label_3);

		label_4 = new JLabel("mm");
		label_4.setFont(new Font("宋体", Font.BOLD, 22));
		label_4.setBounds(500, 227, 50, 30);
		getContentPane().add(label_4);

		label_5 = new JLabel("\u7B8D\u7B4B");
		label_5.setFont(new Font("宋体", Font.BOLD, 16));
		label_5.setBounds(300, 274, 85, 41);
		getContentPane().add(label_5);

		label_6 = new JLabel("@");
		label_6.setFont(new Font("宋体", Font.BOLD, 17));
		label_6.setBounds(465, 284, 30, 20);
		getContentPane().add(label_6);

		lblMkp = new JLabel("MPa");
		lblMkp.setFont(new Font("宋体", Font.BOLD, 22));
		lblMkp.setBounds(488, 333, 50, 30);
		getContentPane().add(lblMkp);
		lblImg.setIcon(new ImageIcon("img//in.png"));
		
		JButton button = new JButton("<html>\u5220\u9664<br/>\u6570\u636E</html>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isSafe(sizebj.getText()) == false || isSafe(sizehj.getText()) == false) {
					JOptionPane.showMessageDialog(null, "请输入正确的截面尺寸", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (isSafe(gu3.getText()) == false || isSafe(gu2.getText()) == false) {
					JOptionPane.showMessageDialog(null, "请输入正确的箍筋参数", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (isSafe(shoula2.getText()) == false){
					JOptionPane.showMessageDialog(null, "请输入正确的受拉筋参数", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Integer.parseInt(sizebj.getText()) % 10 != 0||Integer.parseInt(sizehj.getText()) % 10 != 0)
				{
					JOptionPane.showMessageDialog(null, "截面尺寸应为10的倍数", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Integer.parseInt(gu3.getText()) % 10 != 0)
				{
					JOptionPane.showMessageDialog(null, "箍筋间距应为10的倍数", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String s = hezaitype.getSelectedItem() + "#" + point.getSelectedItem() + "#" + shoula1.getSelectedItem()
						+ "#" + shoula2.getText() + "#" + gu1.getSelectedItem() + "#" + gu2.getText() + "#" + gu3.getText() + "#" + sizebj.getText() + "#"
						+ sizehj.getText() + "#" + hunningtu.getSelectedItem() + "#";
				
				new FindWindow(s);
				
			}
		});
		button.setBounds(142, 394, 80, 50);
		getContentPane().add(button);
		in.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click_in();
			}
		});
		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (isSafe(sizebj.getText()) == false || isSafe(sizehj.getText()) == false) {
					JOptionPane.showMessageDialog(null, "请输入正确的截面尺寸", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (isSafe(gu3.getText()) == false || isSafe(gu2.getText()) == false) {
					JOptionPane.showMessageDialog(null, "请输入正确的箍筋参数", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (isSafe(shoula2.getText()) == false){
					JOptionPane.showMessageDialog(null, "请输入正确的受拉筋参数", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Integer.parseInt(sizebj.getText()) % 10 != 0||Integer.parseInt(sizehj.getText()) % 10 != 0)
				{
					JOptionPane.showMessageDialog(null, "截面尺寸应为10的倍数", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Integer.parseInt(gu3.getText()) % 10 != 0)
				{
					JOptionPane.showMessageDialog(null, "箍筋间距应为10的倍数", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (tx.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入荷载大小", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String s = hezaitype.getSelectedItem() + "#" + point.getSelectedItem() + "#" + shoula1.getSelectedItem()
						+ "#" + shoula2.getText() + "#" + gu1.getSelectedItem() + "#" + gu2.getText() + "#" + gu3.getText() + "#" + sizebj.getText() + "#"
						+ sizehj.getText() + "#" + hunningtu.getSelectedItem() + "#";
				 System.out.println(s);
				try {
					int hezai = Integer.parseInt(tx.getText());
					// System.out.println(hezai);
					click_find(s, hezai);
				} catch (NumberFormatException num) {

					JOptionPane.showMessageDialog(null, "请输入正确荷载", "ERROR", JOptionPane.ERROR_MESSAGE);
					tx.setText("");
					return;
				}

			}
		});
		// 载入初始选项
		hezaitype.addItem("集中荷载");
		hezaitype.addItem("分布荷载");
		point.addItem("中心处");
		point.addItem("左端1#4处");
		point.addItem("右端1#4处");
		point.addItem("两端各1#4处");
		point.addItem("整跨");
		// int temp = 110;
		// for (int i = 0; i < 10; i++) {
		// if (i < 5)
		// temp += 10;
		// else if (i < 8)
		// temp += 20;
		// else if (i < 9)
		// temp += 30;
		// else
		// temp += 50;
		// sizeb.addItem("" + temp);
		// }
		// temp = 200;
		// sizeh.addItem("200");
		// sizeh.addItem("220");
		// for (int i = 0; i < 8; i++) {
		// if (i < 6)
		// temp += 50;
		// else
		// temp += 100;
		// sizeh.addItem("" + temp);
		// }
		shoula1.addItem("HPB300");
		shoula1.addItem("HRB335");
		shoula1.addItem("HRB400");
		// int temp = 4;
		// for (int i = 0; i < 8; i++) {
		// if (i < 8)
		// temp += 2;
		// else
		// temp += 3;
		// shoula2.addItem("" + temp);
		// }
		//
		// shoula2.addItem("22");
		// shoula2.addItem("25");
		for (int temp = 20; temp <= 50; temp += 5) {
			hunningtu.addItem("C" + temp);

		}
		gu1.addItem("HRB235");
		gu1.addItem("HPB300");
		gu1.addItem("HRB335");
		gu1.addItem("HRB400");
		// gu2.addItem("6");
		// gu2.addItem("8");
		// gu2.addItem("10");
		//
		// for(temp=50;temp<=100;temp+=10)
		// {
		// gu3.addItem(temp+"");
		// }
		// gu3.addItem("120");
		// gu3.addItem("150");
		// gu3.addItem("180");
		// gu3.addItem("200");

	}

	void click_find(String s, int hezai) {
		// TODO Auto-generated method stub

		new FindWindow(s, hezai);
	}

	public void click_in() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));// 设置当前目录
		chooser.addChoosableFileFilter(new MyFileFilter("xls", "Excel Files"));
		chooser.addChoosableFileFilter(new MyFileFilter("xlsx", "Excel Files"));

		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			// System.out.println(file);
			MyExcel m = new MyExcel(file);
			m.jiexi();

		}

	}

	public static boolean isSafe(String s) {
		try {
			if (s.equals(""))
				return false;
			Integer.parseInt(s);
			return true;
		}
		// System.out.println(hezai);
		catch (NumberFormatException num) {

			return false;
		}

	}

	public static void main(String[] args) {
		JFrame j=new JFrame();
		JLabel jlLabel=new JLabel();
		jlLabel.setIcon(new ImageIcon("img//welcome.png"));
		j.getContentPane().add(jlLabel);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 600) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 500) / 2;
		j.setLocation(w, h);
		j.setSize(600, 500);
		j.setVisible(true);
		j.setResizable(false);
		jlLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				j.setVisible(false);
				MyWindow my = new MyWindow();
				my.setSize(600, 500);
				my.setVisible(true);
				int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 600) / 2;
				int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 500) / 2;
				my.setLocation(w, h);
		
			}
		}
		);
	
	}

	public class MyFileFilter extends FileFilter {

		private static final String TYPE_UNKNOWN = "Type   Unknown ";
		private static final String HIDDEN_FILE = "Hidden   File ";
		private Hashtable filters = null;
		private String description = null;
		private String fullDescription = null;
		private boolean useExtensionsInDescription = true;

		public MyFileFilter() {
			this.filters = new Hashtable();
		}

		public MyFileFilter(String extension) {
			this(extension, null);
		}

		public MyFileFilter(String extension, String description) {
			this();
			if (extension != null) {
				addExtension(extension);
			}
			if (description != null) {
				setDescription(description);
			}
		}

		public MyFileFilter(String[] filters) {
			this(filters, null);
		}

		public MyFileFilter(String[] filters, String description) {
			this();
			for (int i = 0; i < filters.length; i++) {
				// add filters one by one
				addExtension(filters[i]);
			}
			if (description != null) {
				setDescription(description);
			}
		}

		public boolean accept(File f) {
			if (f != null) {
				String extension = getExtension(f);
				if (extension != null && filters.get(getExtension(f)) != null) {
					return true;
				}
				;
			}
			return false;
		}

		public String getExtension(File f) {
			if (f != null) {
				String filename = f.getName();
				int i = filename.lastIndexOf('.');
				if (i > 0 && i < filename.length() - 1) {
					return filename.substring(i + 1).toLowerCase();
				}
				;
			}
			return null;
		}

		public void addExtension(String extension) {
			if (filters == null) {
				filters = new Hashtable(5);
			}
			filters.put(extension.toLowerCase(), this);
			fullDescription = null;
		}

		public String getDescription() {
			if (fullDescription == null) {
				if (description == null || isExtensionListInDescription()) {
					fullDescription = description == null ? "( " : description + "   ( ";
					// build the description from the extension list
					Enumeration extensions = filters.keys();
					if (extensions != null) {
						fullDescription += ". " + (String) extensions.nextElement();
						while (extensions.hasMoreElements()) {
							fullDescription += ",   " + (String) extensions.nextElement();
						}
					}
					fullDescription += ") ";
				} else {
					fullDescription = description;
				}
			}
			return fullDescription;
		}

		public void setDescription(String description) {
			this.description = description;
			fullDescription = null;
		}

		public void setExtensionListInDescription(boolean b) {
			useExtensionsInDescription = b;
			fullDescription = null;
		}

		public boolean isExtensionListInDescription() {
			return useExtensionsInDescription;
		}

	}

	public class DigitOnlyField extends JTextField {

		/** 
		 *  
		 */
		private static final long serialVersionUID = 8384787369612949227L;

		public DigitOnlyField(int cols) {
			super(cols);
		}

		public DigitOnlyField() {
			super();
			// TODO Auto-generated constructor stub
		}

		protected Document createDefaultModel() {
			return new UpperCaseDocument();
		}

		class UpperCaseDocument extends PlainDocument {

			/** 
			 *  
			 */
			private static final long serialVersionUID = -4170536906715361215L;

			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

				if (str == null) {
					return;
				}
				char[] upper = str.toCharArray();
				String filtered = "";
				for (int i = 0; i < upper.length; i++) {
					if (Character.isDigit(Character.codePointAt(upper, i))) {
						filtered += upper[i];
					}
				}
				super.insertString(offs, filtered, a);
			}
		}
	}
}
