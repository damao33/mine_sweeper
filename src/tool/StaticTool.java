package tool;

import java.awt.Image;

import javax.swing.ImageIcon;

public class StaticTool {

	public static int allcount = 6;
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
	public static ImageIcon imageIcon = new ImageIcon("./image/icon.jpg");
	public static ImageIcon headImage=new ImageIcon("./image/headImage");

	static {
		int width, height;
		width = height = 35;
		for (int i = 0; i < num.length; i++) {
			num[i] = new ImageIcon("./image/" + i + ".jpg");
			num[i] = changeIcon(num[i], width, height);
		}
		iconBlank = changeIcon(iconBlank, width, height);
		bloodIcon = changeIcon(bloodIcon, width, height);
		icon0 = changeIcon(icon0, width, height);
		flagIcon = changeIcon(flagIcon, width, height);
		askIcon = changeIcon(askIcon, width, height);
		askPressIcon = changeIcon(askPressIcon, width, height);
		errorBombIcon = changeIcon(errorBombIcon, width, height);
		blackBombIcon = changeIcon(blackBombIcon, width, height);
		headImage= changeIcon(blackBombIcon, 40, 40);

	}

	public static ImageIcon changeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image temp = (image.getScaledInstance(width, height, Image.SCALE_DEFAULT));
		icon = new ImageIcon(temp);
		return icon;
	}

}
