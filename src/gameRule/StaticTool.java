package gameRule;

import java.awt.Image;

import javax.swing.ImageIcon;

public class StaticTool {

	public static int allcount = 80;
	public static int allcol = 20;
	public static int allrow = 20;
	public static int bombCount = allcount;

	public static boolean isStart = false;

	public static ImageIcon[] num = new ImageIcon[10];

	public static ImageIcon iconBlank = new ImageIcon("./image/blank.jpg");
	public static ImageIcon bloodIcon = new ImageIcon("./image/blood.jpg");
	public static ImageIcon icon0 = new ImageIcon("./image/0.jpg");
	public static ImageIcon flagIcon = new ImageIcon("./image/flag.jpg");
	public static ImageIcon askIcon = new ImageIcon("./image/ask.jpg");
	public static ImageIcon askPressIcon = new ImageIcon("./image/ask1.jpg");
	public static ImageIcon errorBombIcon = new ImageIcon("./image/error.jpg");
	public static ImageIcon blackBombIcon = new ImageIcon("./image/mine.jpg");

	static {
		for (int i = 0; i < num.length; i++) {
			num[i] = new ImageIcon("./image/" + i + ".jpg");
		}
		changeIcon(40, 40);
	}

	public static void changeIcon(int width, int height) {
		ImageIcon iconTemp;

		iconBlank.getImage();
		Image temp = (iconBlank.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		iconTemp = new ImageIcon(temp);
		iconBlank = iconTemp;

	}

}
