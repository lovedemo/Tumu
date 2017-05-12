import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExcel {

	private File file;
	private MyWindow my;
	public List<MyItem> items;

	public MyExcel(File file) {
		this.file = file;
		items = new ArrayList<MyItem>();

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * String xls = "C:\\Users\\YZ\\Desktop\\��ľ\\����2��������ʵ�����ݴ���.xlsx"; MyExcel
	 * myExcel = new MyExcel(new File(xls)); myExcel.jiexi(); //
	 * myExcel.showitems();
	 * 
	 * }
	 */
	

	void jiexi() {
		int n = JOptionPane.showConfirmDialog(null, "ȷ�Ͻ���" + file.getName() + "ô?", "", JOptionPane.YES_NO_OPTION);
		// JOptionPane.showMessageDialog(my, "���ڽ�����");
		System.out.println(n);
		if (n == 1)
			return;
		try {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
			// ��ȡÿһ��������
			for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
				System.out.println("���ǵ�" + (numSheet + 1) + "��������");
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
				if (xssfSheet == null) {
					JOptionPane.showMessageDialog(my, "���ļ�", "ERROR", JOptionPane.ERROR_MESSAGE);

					continue;
				}
				/*
				 * //��ȡ��ǰ��ǰ3�� ����type for(int i=0;i<3;i++) { //��ȡ��i�� XSSFRow
				 * xssfRow1 = xssfSheet.getRow(i); if (xssfRow1 != null) {
				 * 
				 * for (int lineNum = 0; lineNum < xssfRow1.getLastCellNum();
				 * lineNum++) { XSSFCell cell=xssfRow1.getCell(lineNum);
				 * if(cell!=null) System.out.print(cell+ " ");
				 * 
				 * } } }
				 */
				// ֱ�Ӷ�ȡ����������type
				StringBuffer sb = new StringBuffer();
				XSSFRow xssfRow = xssfSheet.getRow(2);
				if (xssfRow != null) {

					// String temp=xssfRow.getCell(0).getStringCellValue();

					for (int lineNum = 0; lineNum < 10; lineNum++) {
						XSSFCell cell = xssfRow.getCell(lineNum);
						if (cell != null)
							if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
								sb.append((int) cell.getNumericCellValue() + "#");
							else
								sb.append(cell.toString().trim() + "#");

					}
				}
				String type = sb.toString().replace(' ', '\\');
				System.out.println(type);
				if (!(type.startsWith("���к���") || type.startsWith("�ֲ�����"))) {
					JOptionPane.showMessageDialog(my, "��" + (numSheet + 1) + "������������δ�ҵ�", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					continue;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				// �������ڸ�ʽ
				String time = df.format(new Date()).replace('-', '_');
				if (MyJDBC.isexits(new MyItem(time, type))) {
					JOptionPane.showMessageDialog(my, "��" + (numSheet + 1) + "���������ѵ���,�����ظ�����", "ERROR",
							JOptionPane.ERROR_MESSAGE);

					continue;
				}

				System.out.println(time);
				// ��ȡͼƬ·��

				File imgfilepath = new File("img\\" + time + "\\" + (numSheet + 1));
				// imgfilepath.mkdirs();
				System.out.println(imgfilepath);
				if (imgfilepath.exists()) {
					imgfilepath.renameTo(new File("img\\" + time + "\\" + type));

				} else if (!new File("img\\" + time + "\\" + type).exists()) {
					JOptionPane.showMessageDialog(my, "�Ҳ�����" + (numSheet + 1) + "�����ͼƬ", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					continue;
				}

				// ��ȡ��ǰ��������ÿһ��
				//System.out.println(xssfSheet.getLastRowNum());
				for (int rowNum = 5; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {

					//System.out.println(rowNum);
					xssfRow = xssfSheet.getRow(rowNum);
					if (xssfRow.getCell(1) != null) {
						String path = "img\\" + time + "\\" + type + "\\" + (rowNum - 4) + ".jpg";
						if (!new File(path).exists()) {
							// System.out.println("img\\"+time+"\\"+type+"\\"+xssfRow.getCell(1)+".jpg");
							System.out.println(path);
							JOptionPane.showMessageDialog(my,
									"��" + (numSheet + 1) + "��������ĵ�" + (rowNum - 4) + "��ͼƬ�Ҳ���,��ȷ�Ϻ�����", "ERROR",
									JOptionPane.ERROR_MESSAGE);

							return;
						}
						//System.out.println("ͼƬ" + path);
						items.add(new MyItem(time, type, xssfRow.getCell(1).getNumericCellValue(),
								xssfRow.getCell(2).getNumericCellValue(), xssfRow.getCell(3).getNumericCellValue(),
								xssfRow.getCell(4).getNumericCellValue(), xssfRow.getCell(7).getNumericCellValue(),
								(int) xssfRow.getCell(8).getNumericCellValue(),
								(int) xssfRow.getCell(9).getNumericCellValue(),
								(int) xssfRow.getCell(10).getNumericCellValue(),
								(int) xssfRow.getCell(11).getNumericCellValue(),
								(int) xssfRow.getCell(12).getNumericCellValue(),
								(int) xssfRow.getCell(13).getNumericCellValue(),
								(int) xssfRow.getCell(14).getNumericCellValue(),
								(int) xssfRow.getCell(15).getNumericCellValue(),
								xssfRow.getCell(16).getNumericCellValue(), xssfRow.getCell(17).getNumericCellValue(),
								xssfRow.getCell(18).getNumericCellValue(), xssfRow.getCell(19).getNumericCellValue(),
								xssfRow.getCell(20).getNumericCellValue(), xssfRow.getCell(21).getNumericCellValue(),
								xssfRow.getCell(22).getNumericCellValue(), xssfRow.getCell(23).getNumericCellValue(),
								xssfRow.getCell(24).getNumericCellValue(), xssfRow.getCell(25).getNumericCellValue(),
								path.replace("\\", "\\\\")));

					} else {
						// �����굱ǰ������������һ����
						break;
					}
					

				}
				MyJDBC.inittable(time);
				MyJDBC.additem(time, items);
				MyJDBC.initall();
				MyJDBC.addAllitems(new MyItem(time, type));
				JOptionPane.showMessageDialog(null, "��" + (numSheet + 1) + "���������ѳɹ�����");
				items = new ArrayList<MyItem>();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		// TODO Auto-generated constructor stub

	}

	void showitems() {
		for (MyItem myItem : items) {
			System.out.println(myItem.toString());
		}
	}

	// ת�����ݸ�ʽ
	String getValue(XSSFCell cell) {

		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}

}
