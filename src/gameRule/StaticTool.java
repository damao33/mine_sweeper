package gameRule;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class StaticTool {

	public static int allcount = 10;
	public static int allcol = 9;
	public static int allrow = 9;
	public static int bombCount = allcount;

	public static boolean isStart = false;

	public static Icon[] num = new Icon[10];

	public static Icon iconBlank = new ImageIcon("./image/blank.gif");
	public static Icon bloodIcon = new ImageIcon("./image/blood.gif");
	public static Icon icon0 = new ImageIcon("./image/0.gif");
	public static Icon flagIcon = new ImageIcon("./image/flag.gif");
	public static Icon askIcon = new ImageIcon("./image/ask.gif");
	public static Icon askPressIcon = new ImageIcon("./image/ask1.gif");
	public static Icon errorBombIcon = new ImageIcon("./image/error.gif");
	public static Icon blackBombIcon = new ImageIcon("./image/mine.gif");

	static {
		for (int i = 0; i < num.length; i++) {
			num[i] = new ImageIcon("./image/" + i + ".gif");
		}

	}


	public static int getLevel() {
		if (allrow == 9 && allcol == 9 && allcount == 10) {
			return 1;
		} else if (allrow == 16 && allcol == 16 && allcount == 40) {
			return 2;
		} else if (allrow == 16 && allcol == 30 && allcount == 99) {
			return 3;
		} else {
			return 0;
		}
	}

}
