package gameRule;

import java.awt.Image;

import javax.swing.ImageIcon;

public class StaticTool {

	public static int allcount = 10;
	public static int allcol = 9;
	public static int allrow = 9;
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
			changeIcon(num[i], 40, 40);
			
		}
		changeIcon(iconBlank, 40, 40);
		changeIcon(bloodIcon, 40, 40);
		changeIcon(icon0, 40, 40);
		changeIcon(flagIcon, 40, 40);
		changeIcon(askIcon, 40, 40);
		changeIcon(askPressIcon, 40, 40);
		changeIcon(errorBombIcon, 40, 40);
		changeIcon(blackBombIcon, 40, 40);

	}

	public static void changeIcon(ImageIcon icon, int width, int height) {
		Image image= icon.getImage();
		Image temp = (image.getScaledInstance(width, height, Image.SCALE_DEFAULT));
		icon = new ImageIcon(temp);

	}

}
