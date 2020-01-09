package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gameRule.Listener;

import gameRule.MineButton;
import tool.StaticTool;

public class BombJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameFrame gameFrame;
	MineButton[][] buttons = new MineButton[StaticTool.allrow][StaticTool.allcol];
	private Listener listener = null;

	public BombJPanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		this.setLayout(new GridLayout(StaticTool.allrow, StaticTool.allcol));
		init();

	}


	private void init() {

		listener = new Listener(buttons,this.gameFrame);

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new MineButton(i, j);

				//buttons[i][j].setPreferredSize(new Dimension(0, 35));
				buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.black,0));
				buttons[i][j].setFocusPainted(false);// 不绘制内容区
				buttons[i][j].setMargin(new Insets(0, 0, 0, 0));// 设置按钮边框与边框内容之间的像素数
				buttons[i][j].setBorderPainted(false);// 不绘制焦点
				buttons[i][j].setContentAreaFilled(false);// 设置焦点控制
				buttons[i][j].setIcon(StaticTool.iconBlank);
				buttons[i][j].addMouseListener(listener);
				buttons[i][j].setFocusable(true);
				this.add(buttons[i][j]);
			}
		}

		Border borderLow = BorderFactory.createLoweredBevelBorder();
		Border borderEmpty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border borderCom = BorderFactory.createCompoundBorder(borderEmpty, borderLow);
		this.setBorder(borderCom);

	}

	
}
