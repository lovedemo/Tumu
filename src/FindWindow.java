import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FindWindow extends JFrame {

	/**
	 * This is test
	 */
	String type;
	int hezai;
	java.awt.List li;
	List<MyItem> items;
	private static final long serialVersionUID = 1390632582866015928L;

	FindWindow() {
	}

	FindWindow(String type)
	{
		
		this.type=type;
		li=new java.awt.List();
		setLayout(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		List<String> list=MyJDBC.ishavetype(type);
		if(list.isEmpty()){
			JOptionPane.showMessageDialog(null, "没有找到相关数据", "ERROR", JOptionPane.ERROR_MESSAGE);

		}else{
			this.setSize(500, 600);
			this.setVisible(true);
			int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 500) / 2;
			int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 600) / 2;
			this.setLocation(w, h);
			
			for (String ss : list) {
				li.add(ss);
			}
//			li.add("2");
//			li.add("3");
//			li.add("4");
//			li.add("5");
//			li.add("6");
			JLabel jl=new JLabel("为你找到如下数据");
			Font font = new Font("宋体", Font.BOLD, 22);
			jl.setFont(font);
			this.add(jl);
			this.add(li);
			jl.setBounds(50,50,200,50);
			li.setFont(font);
			li.setBounds(0, 100, 600, 500);
			li.setMultipleMode(false);
			li.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String s=li.getSelectedItem();
					if(!MyJDBC.delitems(type, s))
					{
						JOptionPane.showMessageDialog(null, "删除失败", "ERROR", JOptionPane.ERROR_MESSAGE);
						
					}else
					{
						JOptionPane.showMessageDialog(null, "删除成功");
						getContentPane().setVisible(false);
					}
					

				}
			});
		}	
	}

	FindWindow(String type, int hezai) {

		this.type = type;
		this.hezai = hezai;
		li = new java.awt.List();
		setLayout(null);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		List<String> list = MyJDBC.ishavetype(type);
		if (list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "没有找到相关数据", "ERROR", JOptionPane.ERROR_MESSAGE);

		} else {
			this.setSize(500, 600);
			this.setVisible(true);
			int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 500) / 2;
			int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 600) / 2;
			this.setLocation(w, h);
			items = MyJDBC.getItemsBy(list, type, hezai);
			if (items.isEmpty()) {
				JOptionPane.showMessageDialog(null, "没有找到相关数据", "ERROR", JOptionPane.ERROR_MESSAGE);
				this.setVisible(false);
			}
			for (MyItem it : items) {
				System.out.println(it.toString());
				li.add(it.getTime() + " \t\t负载为:   " + it.getDesign() + "KN");
			}
			// li.add("2");
			// li.add("3");
			// li.add("4");
			// li.add("5");
			// li.add("6");
			JLabel jl = new JLabel("为你找到如下数据");
			Font font = new Font("宋体", Font.BOLD, 22);
			jl.setFont(font);
			this.add(jl);
			this.add(li);
			jl.setBounds(50, 50, 200, 50);
			li.setFont(font);
			li.setBounds(0, 100, 600, 500);
			li.setMultipleMode(false);
			li.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int index = li.getSelectedIndex();
					int i = 0;
					MyItem my = null;
					for (MyItem m : items) {
						if (i == index) {
							my = m;
							break;
						} else
							i++;
					}
					new ShowWindow(my);
					// System.out.println(i);
				}
			});

		}

	}

}
