import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class ShowWindow extends JFrame {

	/**
	 * 
	 */
	/*public static void main(String[] args) {

		
		
		JFrame jf=new JFrame("查看图片");
		JLabel jl=new JLabel();
		jf.add(jl);
		String s="img\\2017_04_13\\集中荷载#中心处#HPB300#8#HRB235#6#100#120#250#C20#\\2.jpg";
		
		System.out.println(s);
		//String s="img\\2017_04_13\\集中荷载#中心处#HPB300#8#HRB235#6#100#120#250#C20#\\2.jpg";
		//jl.setIcon(new ImageIcon(s));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500	, 600);
	}*/
	private static final long serialVersionUID = -7609535328546413995L;

	public ShowWindow(MyItem m) {
		this.setSize(500, 700);
		//this.
		this.setVisible(true);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 500) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 700) / 2;
		this.setLocation(w, h);
		NumberFormat nf = NumberFormat.getInstance();
		   nf.setMinimumFractionDigits(4);
		//GridBagLayout layout=new GridBagLayout();
		//JPanel jp=new JPanel(layout);
		getContentPane().setLayout(null);
		//this.add(jp);
		//jp.setBounds(0, 0, 500, 200);
		Font font = new Font("宋体", Font.BOLD, 20);
		Font font1 = new Font("宋体", Font.BOLD, 19);
		JLabel l1=new JLabel("加载荷载:"+m.getDesign()+"kN");
		JLabel l2=new JLabel("实际荷载:"+m.getMyreal()+"kN");
		JLabel l3=new JLabel("弯矩:"+m.getWanju()+"kN*m");
		JLabel l4=new JLabel("挠度百分表:"+m.getBaifenbiao()+"με");
		JLabel l5=new JLabel("跨中扰度:"+nf.format(m.getKuazhongraodu())+"mm");
		JLabel ll=new JLabel("混凝土及钢筋应变");
		JLabel ll1=new JLabel("混凝土及钢筋应力");
		//JLabel l6=new JLabel("混凝土及钢筋应变(1-8点)");
		//JLabel l7=new JLabel("混凝土及钢筋应力(1-8点)");
		JLabel l8=new JLabel("界面曲率:"+nf.format(m.getJiemianqulv()));
		nf.setMinimumFractionDigits(5);
		JLabel l9=new JLabel("裂缝宽度:"+nf.format(m.getLiefeng())+"mm");
		JButton j=new JButton("\u5B9E\u9645\u88C2\u7F1D\u56FE\u7247");
		j.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame jf=new JFrame("查看图片");
				JLabel jl=new JLabel();
				File bigfile=new File(m.getImg());
				String s1 = m.getImg().replace(".jpg", "azip.jpg");
				File zipfile=new File(s1);
				if(!zipfile.exists())	
					ImageZipUtil.zipImageFile(bigfile, zipfile, 1920, 1080, 0.8f);
				//File zipfile=new File;
				
				jl.setIcon(new ImageIcon(s1));
				jf.add(new JScrollPane(jl));
				jf.setVisible(true);
				//jf.getContentPane().add(jl);
				jf.setSize(800	, 600);
			
				jf.setLocation(0, 0);
				System.out.println(m.getImg());
				
				
			}
		});
		
		JLabel lyb1=new JLabel("1点:"+m.getYb1()+"με");
		JLabel lyb2=new JLabel("2点:"+m.getYb2()+"με");
		JLabel lyb3=new JLabel("3点:"+m.getYb3()+"με");
		JLabel lyb4=new JLabel("4点:"+m.getYb4()+"με");
		JLabel lyb5=new JLabel("5点:"+m.getYb5()+"με");
		JLabel lyb6=new JLabel("6点:"+m.getYb6()+"με");
		JLabel lyb7=new JLabel("7点:"+m.getYb7()+"με");
		JLabel lyb8=new JLabel("8点:"+m.getYb8()+"με");
		lyb1.setFont(font1);
		lyb2.setFont(font1);
		lyb3.setFont(font1);
		lyb4.setFont(font1);
		lyb5.setFont(font1);
		lyb6.setFont(font1);
		lyb7.setFont(font1);
		lyb8.setFont(font1);
		
		
		JLabel lyl1=new JLabel("1点:"+nf.format(m.getYl1())+"Mpa");
		JLabel lyl2=new JLabel("2点:"+nf.format(m.getYl2())+"Mpa");
		JLabel lyl3=new JLabel("3点:"+nf.format(m.getYl3())+"Mpa");
		JLabel lyl4=new JLabel("4点:"+nf.format(m.getYl4())+"Mpa");
		JLabel lyl5=new JLabel("5点:"+nf.format(m.getYl5())+"Mpa");
		JLabel lyl6=new JLabel("6点:"+nf.format(m.getYl6())+"Mpa");
		JLabel lyl7=new JLabel("7点:"+nf.format(m.getYl7())+"Mpa");
		JLabel lyl8=new JLabel("8点:"+nf.format(m.getYl8())+"Mpa");
		lyl1.setFont(font1);		
		lyl2.setFont(font1);		
		lyl3.setFont(font1);		
		lyl4.setFont(font1);		
		lyl5.setFont(font1);		
		lyl6.setFont(font1);		
		lyl7.setFont(font1);		
		lyl8.setFont(font1);		
		//ll1.setFont(font1);
		//ll2.setFont(font1);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		ll.setFont(font);
		ll1.setFont(font);
		//l6.setFont(font);
		//l7.setFont(font);
		l8.setFont(font);
		l9.setFont(font);
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);
		 getContentPane().add(l4);
		 getContentPane().add(l5);
		 getContentPane().add(ll);
		 getContentPane().add(ll1);
		// add(l6);
		// add(l7);
		 getContentPane().add(l8);
		 getContentPane().add(l9);
		// add(ll1);
		// add(ll2);
		 getContentPane().add(j);
		 getContentPane().add(lyb1);
		 getContentPane().add(lyb2);
		 getContentPane().add(lyb3);
		 getContentPane().add(lyb4);
		 getContentPane().add(lyb5);
		 getContentPane().add(lyb6);
		 getContentPane().add(lyb7);
		 getContentPane().add(lyb8);
		
		 getContentPane().add(lyl1);
		 getContentPane().add(lyl2);
		 getContentPane().add(lyl3);
		 getContentPane().add(lyl4);
		 getContentPane().add(lyl5);
		 getContentPane().add(lyl6);
		 getContentPane().add(lyl7);
		 getContentPane().add(lyl8);
		 setVisible(true);
		l1.setBounds(50, 20, 200, 50);
		l2.setBounds(240, 20, 200, 50);
		l3.setBounds(50, 50, 400, 50);
		l4.setBounds(50, 80, 400, 50);
		l5.setBounds(50, 110, 400, 50);
		ll.setBounds(50, 140, 400, 50);
		ll1.setBounds(240, 140, 400, 50);
		//l6.setBounds(50, 250, 400, 50);
		//l7.setBounds(50, 320, 400, 50);
		l8.setBounds(50, 370, 400, 50);
		l9.setBounds(50, 400, 400, 50);
		//ll1.setBounds(50,290,500,50);
		//ll2.setBounds(50,350,500,50);
		j.setBounds(334,522,126,43);
		int temp=143;
		lyb1.setBounds(50,temp+=25,400,50);
		lyb2.setBounds(50,temp+=25,400,50);
		lyb3.setBounds(50,temp+=25,400,50);
		lyb4.setBounds(50,temp+=25,400,50);
		lyb5.setBounds(50,temp+=25,400,50);
		lyb6.setBounds(50,temp+=25,400,50);
		lyb7.setBounds(50,temp+=25,400,50);
		lyb8.setBounds(50,temp+=25,400,50);
		temp=143;
		lyl1.setBounds(240,temp+=25,400,50);
		lyl2.setBounds(240,temp+=25,400,50);
		lyl3.setBounds(240,temp+=25,400,50);
		lyl4.setBounds(240,temp+=25,400,50);
		lyl5.setBounds(240,temp+=25,400,50);
		lyl6.setBounds(240,temp+=25,400,50);
		lyl7.setBounds(240,temp+=25,400,50);
		lyl8.setBounds(240,temp+=25,200,50);
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel();
		
		lblNewLabel_1.setIcon(new ImageIcon("img//ybp.png"));
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setBounds(29, 441, 300, 199);
		
		/*GridBagConstraints s= new GridBagConstraints();
		s.fill=GridBagConstraints.BOTH;
		s.gridheight=3;
		s.weightx=1;
		s.weighty=0;
		layout.setConstraints(l1, s);
		s.gridheight=2;
		s.weightx=1;
		s.weighty=1;
		layout.setConstraints(l2, s);
		*/
		
		
	}
}
