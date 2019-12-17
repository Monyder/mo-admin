package mon.sof.common.util.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class ImageUtils {

	public static final void pressImage(String targetImg, String waterImg,
			int x, int y, float alpha) {
		try {
			File file = new File(targetImg);
			Image image = ImageIO.read(file);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bufferedImage = new BufferedImage(width, height, 1);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);

			Image waterImage = ImageIO.read(new File(waterImg));
			int width_1 = waterImage.getWidth(null);
			int height_1 = waterImage.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(10, alpha));

			int widthDiff = width - width_1;
			int heightDiff = height - height_1;
			if (x < 0) {
				x = widthDiff / 2;
			} else if (x > widthDiff) {
				x = widthDiff;
			}
			if (y < 0) {
				y = heightDiff / 2;
			} else if (y > heightDiff) {
				y = heightDiff;
			}
			g.drawImage(waterImage, x, y, width_1, height_1, null);
			g.dispose();
			ImageIO.write(bufferedImage, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void pressText(String targetImg, String pressText,
			String fontName, int fontStyle, int fontSize, Color color, int x,
			int y, float alpha) {
		try {
			File file = new File(targetImg);

			Image image = ImageIO.read(file);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bufferedImage = new BufferedImage(width, height, 1);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setColor(color);
			g.setComposite(AlphaComposite.getInstance(10, alpha));

			int width_1 = fontSize * getLength(pressText);
			int height_1 = fontSize;
			int widthDiff = width - width_1;
			int heightDiff = height - height_1;
			if (x < 0) {
				x = widthDiff / 2;
			} else if (x > widthDiff) {
				x = widthDiff;
			}
			if (y < 0) {
				y = heightDiff / 2;
			} else if (y > heightDiff) {
				y = heightDiff;
			}
			g.drawString(pressText, x, y + height_1);
			g.dispose();
			ImageIO.write(bufferedImage, "jpg", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getLength(String text) {
		int textLength = text.length();
		int length = textLength;
		for (int i = 0; i < textLength; i++) {
			if (String.valueOf(text.charAt(i)).getBytes().length > 1) {
				length++;
			}
		}
		return length % 2 == 0 ? length / 2 : length / 2 + 1;
	}

	public static void resize(String filePath, int height, int width, boolean bb) {
		try {
			double ratio = 0.0D;
			File f = new File(filePath);
			BufferedImage bi = ImageIO.read(f);
			Image itemp = bi.getScaledInstance(width, height, 4);
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = new Integer(height).doubleValue() / bi.getHeight();
				} else {
					ratio = new Integer(width).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {
				BufferedImage image = new BufferedImage(width, height, 1);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null)) {
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				} else {
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				}
				g.dispose();
				itemp = image;
			}
			ImageIO.write((BufferedImage) itemp, "jpg", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 给图片添加图片水印
	 * 
	 * @param pressImg
	 *            水印图片
	 * @param srcImageFile
	 *            源图像地址
	 * @param destImageFile
	 *            目标图像地址
	 * @param x
	 *            修正值。 默认在中间
	 * @param y
	 *            修正值。 默认在中间
	 * @param alpha
	 *            透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
	 */
	public final static void pressImage(String pressImg, String srcImageFile,
			String destImageFile, float alpha) {
		try {
			File img = ImageUtils.scale2(srcImageFile, 600, 600);// 测试OK
			Image src = ImageIO.read(img);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			File a = new File(pressImg);// 测试NoOK
			// 水印文件
			Image src_biao = ImageIO.read(a);
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			// 去掉右上水印
			// g.drawImage(src_biao, 5, 5, wideth_biao, height_biao, null);
			// 保留中间水印
			g.drawImage(src_biao, (wideth - wideth_biao) / 2,
					(height - height_biao) / 2, wideth_biao, height_biao, null);
			// 去掉坐下水印
			// g.drawImage(src_biao, wideth - wideth_biao - 5, height
			// - height_biao - 5, wideth_biao, height_biao, null);
			// 水印文件结束
			g.dispose();
			ImageIO.write((BufferedImage) image, "JPEG",
					new File(destImageFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 缩放图像（按高度和宽度缩放）
	 * 
	 * @param srcImageFile
	 *            源图像文件地址
	 * @param result
	 *            缩放后的图像地址
	 * @param height
	 *            缩放后的高度
	 * @param width
	 *            缩放后的宽度
	 * @param bb
	 *            比例不对时是否需要补白：true为补白; false为不补白;
	 */
	public final static File scale2(String srcImageFile, int height, int width) {
		File f = null;
		double ratio = 0.0; // 缩放比例
		try {

			f = new File(srcImageFile);
			BufferedImage bi = ImageIO.read(f);
			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
			// 计算比例
			/*if ((bi.getHeight() > height) || (bi.getWidth() > width)) {*/
				if (bi.getHeight() < bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			/*} else {
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(1, 1), null);
				itemp = op.filter(bi, null);
			}*/

			ImageIO.write((BufferedImage) itemp, "JPEG", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	public static void main(String[] args) throws IOException {
		// pressImage("D:/aa.png", "D:/shuiyin.png", 5000, 5000, 1F);
		// pressText("D:/aa.png", "旺仔之印", "宋体", 3, 20, Color.BLACK, 0, 0, 8.0F);
		// resize("D:/aa.png", 1000, 500, true);
		/**
		 *  request.getSession().getServletContext().getRealPath("/") === D:\apache-tomcat-7.0.70\webapps\timetree\
		 *  request.getSession().getServletContext().getRealPath("/") === /usr/local/javaSoftware/tomcat7-timetree/
		 *  
		 *  水印图片路径windows === D:\apache-tomcat-7.0.70\webapps\timetree\static\static\shuiyin.png
		 *  图片路径windows === D:\apache-tomcat-7.0.70\webapps\timetree\ upload\image\20170225
		 *  
		 *  水印图片路径linux === /usr/local/javaSoftware/tomcat7-timetree/static/static/shuiyin.png
		 *  图片路径linux === /usr/local/javaSoftware/tomcat7-timetree/webapps/timetree/upload/image/20170225
		 */
		// 单个图片测试
		// pressImage("D:/shuiyin.png", "D:/bb.png", "D:/bb.png", 1f);// 测试OK
		fileScale("D:/aa/20170211", "D:/aa/20170211");
		fileScale("D:/aa/20170212", "D:/aa/20170212");
		fileScale("D:/aa/20170213", "D:/aa/20170213");
		fileScale("D:/aa/20170215", "D:/aa/20170215");
		fileScale("D:/aa/20170216", "D:/aa/20170216");
		fileScale("D:/aa/20170217", "D:/aa/20170217");
		fileScale("D:/aa/20170218", "D:/aa/20170218");
		fileScale("D:/aa/20170219", "D:/aa/20170219");
		fileScale("D:/aa/20170221", "D:/aa/20170221");
		fileScale("D:/aa/20170222", "D:/aa/20170222");
		fileScale("D:/aa/20170223", "D:/aa/20170223");
		fileScale("D:/aa/20170224", "D:/aa/20170224");
		fileScale("D:/aa/20170225", "D:/aa/20170225");
		fileScale("D:/aa/20170226", "D:/aa/20170226");
		fileScale("D:/aa/20170227", "D:/aa/20170227");
		fileScale("D:/aa/20170228", "D:/aa/20170228");
		fileScale("D:/aa/20170301", "D:/aa/20170301");
		fileScale("D:/aa/20170302", "D:/aa/20170302");
		fileScale("D:/aa/20170303", "D:/aa/20170303");
		fileScale("D:/aa/20170304", "D:/aa/20170304");
		fileScale("D:/aa/20170305", "D:/aa/20170305");
		fileScale("D:/aa/20170306", "D:/aa/20170306");
		fileScale("D:/aa/20170307", "D:/aa/20170307");
		fileScale("D:/aa/20170308", "D:/aa/20170308");
		fileScale("D:/aa/20170309", "D:/aa/20170309");
		fileScale("D:/aa/20170310", "D:/aa/20170310");
		fileScale("D:/aa/20170311", "D:/aa/20170311");
		fileScale("D:/aa/20170312", "D:/aa/20170312");
		fileScale("D:/aa/20170313", "D:/aa/20170313");
		fileScale("D:/aa/20170314", "D:/aa/20170314");
		fileScale("D:/aa/20170315", "D:/aa/20170315");
		fileScale("D:/aa/20170316", "D:/aa/20170316");
		fileScale("D:/aa/20170317", "D:/aa/20170317");
		fileScale("D:/aa/20170318", "D:/aa/20170318");
		fileScale("D:/aa/20170319", "D:/aa/20170319");
		fileScale("D:/aa/20170320", "D:/aa/20170320");
		fileScale("D:/aa/20170321", "D:/aa/20170321");
		fileScale("D:/aa/20170322", "D:/aa/20170322");
		fileScale("D:/aa/20170323", "D:/aa/20170323");
		fileScale("D:/aa/20170324", "D:/aa/20170324");
		fileScale("D:/aa/20170325", "D:/aa/20170325");
		fileScale("D:/aa/20170326", "D:/aa/20170326");
		fileScale("D:/aa/20170327", "D:/aa/20170327");
		fileScale("D:/aa/20170328", "D:/aa/20170328");
		fileScale("D:/aa/20170329", "D:/aa/20170329");
		fileScale("D:/aa/20170330", "D:/aa/20170330");
		fileScale("D:/aa/20170331", "D:/aa/20170331");
		fileScale("D:/aa/20170401", "D:/aa/20170401");
		fileScale("D:/aa/20170402", "D:/aa/20170402");
		fileScale("D:/aa/20170403", "D:/aa/20170403");
		fileScale("D:/aa/20170404", "D:/aa/20170404");
		fileScale("D:/aa/20170405", "D:/aa/20170405");
		fileScale("D:/aa/20170406", "D:/aa/20170406");
		fileScale("D:/aa/20170407", "D:/aa/20170407");
		fileScale("D:/aa/20170408", "D:/aa/20170408");
		fileScale("D:/aa/20170409", "D:/aa/20170409");
		fileScale("D:/aa/20170410", "D:/aa/20170410");
		fileScale("D:/aa/20170411", "D:/aa/20170411");
		fileScale("D:/aa/20170412", "D:/aa/20170412");
		fileScale("D:/aa/20170413", "D:/aa/20170413");
		fileScale("D:/aa/20170415", "D:/aa/20170415");
		fileScale("D:/aa/20170416", "D:/aa/20170416");
		fileScale("D:/aa/20170417", "D:/aa/20170417");
		fileScale("D:/aa/20170418", "D:/aa/20170418");
		fileScale("D:/aa/20170419", "D:/aa/20170419");
		fileScale("D:/aa/20170420", "D:/aa/20170420");
		fileScale("D:/aa/20170421", "D:/aa/20170421");
		fileScale("D:/aa/20170422", "D:/aa/20170422");
		fileScale("D:/aa/20170424", "D:/aa/20170424");
		fileScale("D:/aa/20170425", "D:/aa/20170425");
		fileScale("D:/aa/20170426", "D:/aa/20170426");
		fileScale("D:/aa/20170427", "D:/aa/20170427");
		
		fileScale("D:/aa/image/20170211", "D:/aa/image/20170211");
		fileScale("D:/aa/image/20170212", "D:/aa/image/20170212");
		fileScale("D:/aa/image/20170213", "D:/aa/image/20170213");
		fileScale("D:/aa/image/20170215", "D:/aa/image/20170215");
		fileScale("D:/aa/image/20170216", "D:/aa/image/20170216");
		fileScale("D:/aa/image/20170217", "D:/aa/image/20170217");
		fileScale("D:/aa/image/20170218", "D:/aa/image/20170218");
		fileScale("D:/aa/image/20170219", "D:/aa/image/20170219");
		fileScale("D:/aa/image/20170221", "D:/aa/image/20170221");
		fileScale("D:/aa/image/20170222", "D:/aa/image/20170222");
		fileScale("D:/aa/image/20170223", "D:/aa/image/20170223");
		fileScale("D:/aa/image/20170224", "D:/aa/image/20170224");
		fileScale("D:/aa/image/20170225", "D:/aa/image/20170225");
	}
	
	/**
	 * 
	 * @param oldName
	 *            源图像地址
	 * @param newName
	 *            目标图像地址
	 */
	public static void fileScale(String oldName, String newName) {
		File file = new File(oldName);
		File[] lf = file.listFiles();
		for (int i = 0; i < lf.length; i++) {
			String fileName = lf[i].getName();
			System.out.println(lf[i].getName());
			// ImageUtils.scale2(file.getPath()+File.separator+fileName,
			// "D:/123/"+fileName, 2500, 2500, true);//测试OK
			ImageUtils.pressImage("D:/shuiyin.png", file.getPath()
					+ File.separator + fileName, newName + File.separator
					+ fileName, 1f);// 测试OK
		}

	}
}
