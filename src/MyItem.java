

public class MyItem {

	@Override
	public String toString() {
		return "MyItem [time=" + time + ", type=" + type + ", design=" + design + ", myreal=" + myreal + ", wanju=" + wanju
				+ ", baifenbiao=" + baifenbiao + ", kuazhongraodu=" + kuazhongraodu + ", yb1=" + yb1 + ", yb2=" + yb2
				+ ", yb3=" + yb3 + ", yb4=" + yb4 + ", yb5=" + yb5 + ", yb6=" + yb6 + ", yb7=" + yb7 + ", yb8=" + yb8
				+ ", yl1=" + yl1 + ", yl2=" + yl2 + ", yl3=" + yl3 + ", yl4=" + yl4 + ", yl5=" + yl5 + ", yl6=" + yl6
				+ ", yl7=" + yl7 + ", yl8=" + yl8 + ", jiemianqulv=" + jiemianqulv + ", liefeng=" + liefeng + "]";
	}
	public String myToString()
	{
		//StringBuffer sb=new StringBuffer();
		//sb.append("values('");
		return "values('" + type + "','" + design + "','" + myreal + "','" + wanju
				+ "','" + baifenbiao + "','" + kuazhongraodu + "','" + yb1 + "','" + yb2
				+ "','" + yb3 + "','" + yb4 + "','" + yb5 + "','" + yb6 + "','" + yb7 + "','" + yb8
				+ "','" + yl1 + "','" + yl2 + "','" + yl3 + "','" + yl4 + "','" + yl5 + "','" + yl6
				+ "','" + yl7 + "','" + yl8 + "','" + jiemianqulv + "','" + liefeng + "','" + img +"');";
		//sb.append("'")
		
	}
	private String time;
	private String type;
	private double design,myreal,wanju,baifenbiao,kuazhongraodu;
	private int yb1,yb2,yb3,yb4,yb5,yb6,yb7,yb8;
	private double yl1,yl2,yl3,yl4,yl5,yl6,yl7,yl8;
	private double jiemianqulv,liefeng;
	private String img;
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public  MyItem(String time, String type)
	{
		this.time = time;
		this.type = type;
	}
	public MyItem(String time, String type, double design, double real, double wanju, double baifenbiao,
			double kuazhongraodu, int yb1, int yb2, int yb3, int yb4, int yb5, int yb6, int yb7, int yb8, double yl1,
			double yl2, double yl3, double yl4, double yl5, double yl6, double yl7, double yl8, double jiemianqulv,
			double liefeng,String img) {
		super();
		this.time = time;
		this.type = type;
		this.design = design;
		this.myreal = real;
		this.wanju = wanju;
		this.baifenbiao = baifenbiao;
		this.kuazhongraodu = kuazhongraodu;
		this.yb1 = yb1;
		this.yb2 = yb2;
		this.yb3 = yb3;
		this.yb4 = yb4;
		this.yb5 = yb5;
		this.yb6 = yb6;
		this.yb7 = yb7;
		this.yb8 = yb8;
		this.yl1 = yl1;
		this.yl2 = yl2;
		this.yl3 = yl3;
		this.yl4 = yl4;
		this.yl5 = yl5;
		this.yl6 = yl6;
		this.yl7 = yl7;
		this.yl8 = yl8;
		this.jiemianqulv = jiemianqulv;
		this.liefeng = liefeng;
		this.img=img;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getDesign() {
		return design;
	}
	public void setDesign(double design) {
		this.design = design;
	}
	public double getMyreal() {
		return myreal;
	}
	public void setMyreal(double myreal) {
		this.myreal = myreal;
	}
	public double getWanju() {
		return wanju;
	}
	public void setWanju(double wanju) {
		this.wanju = wanju;
	}
	public double getBaifenbiao() {
		return baifenbiao;
	}
	public void setBaifenbiao(double baifenbiao) {
		this.baifenbiao = baifenbiao;
	}
	public double getKuazhongraodu() {
		return kuazhongraodu;
	}
	public void setKuazhongraodu(double kuazhongraodu) {
		this.kuazhongraodu = kuazhongraodu;
	}
	public String getyb(int i){
		String re="";
		
		return re;
	}
	
	public int getYb1() {
		return yb1;
	}
	public void setYb1(int yb1) {
		this.yb1 = yb1;
	}
	public int getYb2() {
		return yb2;
	}
	public void setYb2(int yb2) {
		this.yb2 = yb2;
	}
	public int getYb3() {
		return yb3;
	}
	public void setYb3(int yb3) {
		this.yb3 = yb3;
	}
	public int getYb4() {
		return yb4;
	}
	public void setYb4(int yb4) {
		this.yb4 = yb4;
	}
	public int getYb5() {
		return yb5;
	}
	public void setYb5(int yb5) {
		this.yb5 = yb5;
	}
	public int getYb6() {
		return yb6;
	}
	public void setYb6(int yb6) {
		this.yb6 = yb6;
	}
	public int getYb7() {
		return yb7;
	}
	public void setYb7(int yb7) {
		this.yb7 = yb7;
	}
	public int getYb8() {
		return yb8;
	}
	public void setYb8(int yb8) {
		this.yb8 = yb8;
	}
	public double getYl1() {
		return yl1;
	}
	public void setYl1(double yl1) {
		this.yl1 = yl1;
	}
	public double getYl2() {
		return yl2;
	}
	public void setYl2(double yl2) {
		this.yl2 = yl2;
	}
	public double getYl3() {
		return yl3;
	}
	public void setYl3(double yl3) {
		this.yl3 = yl3;
	}
	public double getYl4() {
		return yl4;
	}
	public void setYl4(double yl4) {
		this.yl4 = yl4;
	}
	public double getYl5() {
		return yl5;
	}
	public void setYl5(double yl5) {
		this.yl5 = yl5;
	}
	public double getYl6() {
		return yl6;
	}
	public void setYl6(double yl6) {
		this.yl6 = yl6;
	}
	public double getYl7() {
		return yl7;
	}
	public void setYl7(double yl7) {
		this.yl7 = yl7;
	}
	public double getYl8() {
		return yl8;
	}
	public void setYl8(double yl8) {
		this.yl8 = yl8;
	}
	public double getJiemianqulv() {
		return jiemianqulv;
	}
	public void setJiemianqulv(double jiemianqulv) {
		this.jiemianqulv = jiemianqulv;
	}
	public double getLiefeng() {
		return liefeng;
	}
	public void setLiefeng(double liefeng) {
		this.liefeng = liefeng;
	}

	
	
}
