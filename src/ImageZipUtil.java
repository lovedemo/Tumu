import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageZipUtil {

	/*public static void main(String[] args) {
		zipWidthHeightImageFile(new File("img\\2017_04_13\\集中荷载#中心处#HPB300#8#HRB235#6#100#120#250#C20#\\2.jpg"),
				new File("img\\2017_04_13\\集中荷载#中心处#HPB300#8#HRB235#6#100#120#250#C20#\\i2.jpg"), 600, 500, 0.8f);

		// System.out.println("ok");
	}
*/
	/**
	 * 根据设置的宽高等比例压缩图片文件<br>
	 * 先保存原文件，再压缩、上传
	 * 
	 * @param oldFile
	 *            要进行压缩的文件
	 * @param newFile
	 *            新文件
	 * @param width
	 *            宽度 //设置宽度时（高度传入0，等比例缩放）
	 * @param height
	 *            高度 //设置高度时（宽度传入0，等比例缩放）
	 * @param quality
	 *            质量
	 * @return 返回压缩后的文件的全路径
	 */
	public static String zipImageFile(File oldFile, File newFile, int width, int height, float quality) {
		if (oldFile == null) {
			return null;
		}
		try {
			/** 对服务器上的临时文件进行处理 */
			Image srcFile = ImageIO.read(oldFile);
			int w = srcFile.getWidth(null);
			int h = srcFile.getHeight(null);
			double bili;
			if (width > 0) {
				bili = width / (double) w;
				height = (int) (h * bili);
			} else {
				if (height > 0) {
					bili = height / (double) h;
					width = (int) (w * bili);
				}
			}

			String srcImgPath = newFile.getAbsoluteFile().toString();
			// System.out.println(srcImgPath);
			String subfix = "jpg";
			subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());

			BufferedImage buffImg = null;
			if (subfix.equals("png")) {
				buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			} else {
				buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			}

			Graphics2D graphics = buffImg.createGraphics();
			graphics.setBackground(new Color(255, 255, 255));
			graphics.setColor(new Color(255, 255, 255));
			graphics.fillRect(0, 0, width, height);
			graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			ImageIO.write(buffImg, subfix, new File(srcImgPath));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return newFile.getAbsolutePath();
	}

	/**
	 * 按设置的宽度高度压缩图片文件<br>
	 * 先保存原文件，再压缩、上传
	 * 
	 * @param oldFile
	 *            要进行压缩的文件全路径
	 * @param newFile
	 *            新文件
	 * @param width
	 *            宽度
	 * @param height
	 *            高度
	 * @param quality
	 *            质量
	 * @return 返回压缩后的文件的全路径
	 */
	public static boolean zipWidthHeightImageFile(File oldFile, File newFile, int width, int height, float quality) {
		if (oldFile == null) {
			return false;
		}
		Image srcFile = null;
		BufferedImage buffImg = null;
		try {
			/** 对服务器上的临时文件进行处理 */
			srcFile = ImageIO.read(oldFile);

			String srcImgPath = newFile.getAbsoluteFile().toString();
			// System.out.println(srcImgPath);
			String subfix = "jpg";
			subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());

			if (subfix.equals("png")) {
				buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			} else {
				buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			}

			Graphics2D graphics = buffImg.createGraphics();
			graphics.setBackground(new Color(255, 255, 255));
			graphics.setColor(new Color(255, 255, 255));
			graphics.fillRect(0, 0, width, height);
			graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			ImageIO.write(buffImg, subfix, new File(srcImgPath));
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (srcFile != null) {
				srcFile.flush();
			}
			if (buffImg != null) {
				buffImg.flush();
			}

		}

	}

}
