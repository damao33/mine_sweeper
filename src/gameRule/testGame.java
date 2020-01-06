package gameRule;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

public class testGame extends JFrame implements ActionListener, MouseListener {

	AudioClip[] aau;
	AudioClip aau1;
	boolean flag, tt, isFirst;
	static int row;
	static int column;
	static int mine;
	int flagCount, time;
	Font font1, font2;
	ImageIcon[] icon, iconChange;
	int num, num1, num2;
	static int mineEnd;
	public int bonEnd;
	int level;
	static int[][] isMine;
	static int[][] isEnable;
	static int[][] rightClick;
	static int[][] right;
	int[] count1, count2;
	JPanel panel1, panel2, panel3, panel4, panel5;
	static JButton[][] button;
	JButton[] bon;
	JCheckBoxMenuItem jitem;
	JLabel label1, label2;
	JMenuBar bar;
	JMenu menu1, menu2, menu3;
	JMenuItem[] item;
	JToolBar toolbar;
	Random ron;
	// Record record;
	String[] str;
	Timer timer;

	{
		
		
		arrangeMine();
		addCenterPanel(row, column);
		add(panel1, BorderLayout.CENTER);
		validate();
		pack();
		showOnCenter();

	}
	public static void main(String[] args) {
		testGame frame = new testGame("扫雷测试");
		row=20;
		column=20;
		mine=50;
		fresh();
		frame.pack();
		frame.setVisible(true);
	}
	// 设置行数


	// 构造方法
	public testGame(String s) {
		super(s);

		icon = new ImageIcon[16];
		iconChange = new ImageIcon[16];
		for (int i = 0; i < 16; i++)
			icon[i] = new ImageIcon("icon/" + i + ".jpg");// 初始化图片

		setResizable(false);

	}

	// 设置默认外观

	// 初始化部分变量
	public static void fresh() {
		isMine = new int[row][column];
		button = new JButton[row][column];
		isEnable = new int[row][column];
		rightClick = new int[row][column];
		right = new int[row][column];
		mineEnd = 0;
		bonEnd = 0;
		flagCount = mine;
		time = 0;
		isFirst = true;
	}

	// 初始化中部面板
	public void addCenterPanel(int width, int height) {
		panel1 = new JPanel();
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel1.setLayout(new GridLayout(row - 2, column - 2));
		// changeIcon(width, height);
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				button[i][j] = new JButton();
				button[i][j].setPreferredSize(new Dimension(width, height));
				button[i][j].setMargin(new Insets(0, 0, 0, 0));
				button[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
				button[i][j].setIcon(iconChange[10]);
				button[i][j].addActionListener(this);
				button[i][j].addMouseListener(this);
				panel1.add(button[i][j]);
			}
		}
		panel1.revalidate();
	}

	// 添加组件
	public void addPart(int width, int height) {

		addCenterPanel(width, height);
		panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(45, panel1.getHeight()));
		panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension(panel1.getWidth(), 40));
		panel5 = new JPanel();
		panel5.setPreferredSize(new Dimension(45, panel1.getHeight()));
		add(panel1, BorderLayout.CENTER);
		add(panel4, BorderLayout.SOUTH);
		add(panel3, BorderLayout.WEST);
		add(panel5, BorderLayout.EAST);
		add(panel2, BorderLayout.NORTH);

	}

	// 居中显示
	public void showOnCenter() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	// 判断布雷是否重复
	public boolean check(int a, int[] b, int c) {
		for (int i = 0; i <= c; i++) {
			if (a == b[i])
				return true;
		}
		return false;
	}

	// 布雷
	public void arrangeMine() {
		count1 = new int[(row - 2) * (column - 2)];
		count2 = new int[mine];
		num1 = 0;
		num2 = 0;
		int num3 = 0;// 看布雷是否正确
		ron = new Random();
		for (int i = 0; i < mine; i++) {
			num2 = ron.nextInt((row - 2) * (column - 2));
			count2[i] = num2;
			flag = check(num2, count2, i - 1);
			while (flag) {
				num2 = ron.nextInt((row - 2) * (column - 2));
				count2[i] = num2;
				flag = check(num2, count2, i - 1);
			}
			count1[num2] = 10;
		}
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				isMine[i][j] = count1[num1];
				if (count1[num1] == 10) {
					num3++;
				}
				num1++;
			}
		}
		System.out.println(num3);
	}

	// 数雷
	public int countMine(int a, int b) {
		int number1 = 0;
		for (int i = a - 1; i < a + 2; i++) {
			for (int j = b - 1; j < b + 2; j++) {
				if (isMine[i][j] == 10) {
					number1++;
				}
			}
		}
		return number1;
	}

	// 数周围红旗数
	public int countFlag(int a, int b) {
		int number2 = 0;
		for (int i = a - 1; i < a + 2; i++) {
			for (int j = b - 1; j < b + 2; j++) {
				if (right[i][j] == 1) {
					number2++;
				}
			}
		}
		return number2;
	}

	// 鼠标左右击
	public void openFlag(int a, int b) {
		int num3 = 0;
		for (int i = a - 1; i < a + 2; i++) {
			for (int j = b - 1; j < b + 2; j++) {
				if (isEnable[i][j] != 1 && i >= 1 && j >= 1 && i < row - 1 && j < column - 1) {
					if (isMine[i][j] != 10 && right[i][j] != 1) {
						open(i, j);
					}
					if (isMine[i][j] == 10 && right[i][j] != 1)
						num3++;
					if (bonEnd == ((row - 2) * (column - 2)) - mine) {
						win();
						return;
					}
				}
			}
		}
		if (num3 != 0) {
			fail();
		}
	}

	// 鼠标左右击时旗数和显示数字不同
	public void openFlagFail(int a, int b, int c) {

		for (int i = a - 1; i < a + 2; i++) {
			for (int j = b - 1; j < b + 2; j++) {
				if (c == 1 && isEnable[i][j] != 1 && right[i][j] != 1 && i >= 1 && j >= 1 && i < row - 1
						&& j < column - 1) {
					button[i][j].setIcon(iconChange[0]);
					tt = true;
				}
				if (c == 0 && isEnable[i][j] != 1 && right[i][j] != 1 && i >= 1 && j >= 1 && i < row - 1
						&& j < column - 1) {
					button[i][j].setIcon(iconChange[10]);
					tt = false;
				}
			}
		}
	}

	// 掀开
	public void open(int a, int b) {
		num = 0;
		bonEnd++;
		isEnable[a][b] = 1;
		num = countMine(a, b);
		isMine[a][b] = num;
		button[a][b].setIcon(iconChange[num]);
		if (num == 0)
			isNull(a, b);

	}

	// 掀开的按钮周围没有雷
	public void isNull(int a, int b) {
		for (int i = a - 1; i < a + 2; i++) {
			for (int j = b - 1; j < b + 2; j++) {
				if ((i != a || j != b) && i >= 1 && j >= 1 && i < row - 1 && j < column - 1) {
					if (isEnable[i][j] != 1 && isMine[i][j] != 10 && right[i][j] != 1) {
						open(i, j);
					}
				}
			}
		}
	}

	// 掀开所有的雷
	public void openAllMine() {
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				if (isMine[i][j] == 10) {
					button[i][j].setIcon(iconChange[9]);
				}
			}
		}

	}

	// 胜利
	public void win() {
		if (Integer.parseInt(bon[3].getText()) >= 0) {
			aau[2].play();
			timer.stop();
			// record.writeNumber(level, 1);
			// record.writeTime(level, Integer.parseInt(bon[1].getText()));
			// new WinPane("游戏胜利", this);
		}

	}

	// 失败
	public void fail() {
		aau[3].play();
		openAllMine();
		timer.stop();
		// record.writeNumber(level, 0);
		// new FailPane("游戏失败", this);
	}

	// 新游戏
	public void newGame() {
		aau[4].play();
		isFirst = true;
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				button[i][j].setIcon(iconChange[10]);
				isEnable[i][j] = 0;
				right[i][j] = 0;
				rightClick[i][j] = 0;
				isMine[i][j] = 0;
			}
		}
		arrangeMine();
		mineEnd = 0;
		bonEnd = 0;
		flagCount = mine;
		bon[3].setText("" + mine);
		timer.stop();
		time = 0;
		bon[1].setText("0");
	}

	// 重新开始
	public void restart() {
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				button[i][j].setIcon(iconChange[10]);
				isEnable[i][j] = 0;
				right[i][j] = 0;
				rightClick[i][j] = 0;
			}
		}
		mineEnd = 0;
		bonEnd = 0;
		flagCount = mine;
		bon[3].setText("" + mine);
		timer.stop();
		time = 0;
		bon[1].setText("0");
	}

	// 第一次点时不遇雷
	public void firstClick(int a, int b) {
		int i;
		do {
			i = countMine(a, b);
			isFirst = false;
			if (i != 0) {
				arrangeMine();
				isFirst = true;
			}
		} while (isFirst);
		open(a, b);
	}

	// 计时
	public void countTime() {
		timer = new Timer(1000, this);
	}

	public void mouseClicked(MouseEvent e) {

	}

	// 鼠标移到
	public void mouseEntered(MouseEvent e) {

		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				if (isEnable[i][j] != 1 && rightClick[i][j] % 3 == 0) {
					if (e.getSource() == button[i][j])
						button[i][j].setIcon(iconChange[13]);
				}

			}
		}

	}

	// 鼠标离开
	public void mouseExited(MouseEvent e) {

		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				if (isEnable[i][j] != 1 && rightClick[i][j] % 3 == 0) {
					if (e.getSource() == button[i][j])
						button[i][j].setIcon(iconChange[10]);
				}
			}
		}

	}

	// 鼠标右击左右击事件
	public void mousePressed(MouseEvent e) {
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				// 鼠标左右击
				if (e.getModifiersEx() == (e.BUTTON3_DOWN_MASK + e.BUTTON1_DOWN_MASK) && e.getSource() == button[i][j]
						&& isEnable[i][j] == 1) {
					int number3 = countFlag(i, j);
					if (isMine[i][j] == number3) {
						openFlag(i, j);
					} else {
						aau[0].play();
						openFlagFail(i, j, 1);
					}
				}
				// 鼠标右击
				if (e.getSource() == button[i][j] && isEnable[i][j] != 1 && e.getModifiersEx() == e.BUTTON3_DOWN_MASK) {
					if (time == 0)
						timer.start();
					rightClick[i][j]++;
					if (rightClick[i][j] % 3 == 1) {
						button[i][j].setIcon(iconChange[11]);
						right[i][j] = 1;
						flagCount--;
						bon[3].setText("" + flagCount);
						if (isMine[i][j] == 10)
							mineEnd++;
						if (mineEnd == mine) {
							win();
						}
					}
					if (rightClick[i][j] % 3 == 2) {
						button[i][j].setIcon(iconChange[12]);
						right[i][j] = 0;
						flagCount++;
						bon[3].setText("" + flagCount);
						if (isMine[i][j] == 10)
							mineEnd--;
						if (mineEnd == mine) {
							win();
						}
					}
					if (rightClick[i][j] % 3 == 0)
						button[i][j].setIcon(iconChange[10]);
				}
			}
		}

		// 鼠标左击
		if (e.getModifiersEx() == e.BUTTON1_DOWN_MASK) {
			for (int i = 1; i < row - 1; i++) {
				for (int j = 1; j < column - 1; j++) {
					if (e.getSource() == button[i][j]) {
						if (time == 0)
							timer.start();
						if (isFirst == true) {
							firstClick(i, j);
						} else {
							if (isEnable[i][j] != 1 && right[i][j] != 1) {
								if (isMine[i][j] != 10)
									open(i, j);
								else {
									fail();
								}
								if (bonEnd == ((row - 2) * (column - 2)) - mine)
									win();
							}
						}
					}
				}
			}
		}

	}

	public void mouseReleased(MouseEvent e) {
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				// 鼠标左右击
				if (e.getSource() == button[i][j] && isEnable[i][j] == 1 && tt == true) {
					openFlagFail(i, j, 0);
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
