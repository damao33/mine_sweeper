package msg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import gameRule.*;
import tool.StaticTool;

public class ServerMineButton extends Msg
{
	public ServerMineButton (Msg msg)
	{
		this.setMsg(msg);
		this.setMsgType("ServerMineButton");
	}
	private MineButton[][] initMineButton()
	{
		MineButton[][] buttons = new MineButton[StaticTool.allrow][StaticTool.allcol];
		Listener listener = new Listener(buttons);

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new MineButton(i, j);
				
				buttons[i][j].setPreferredSize(new Dimension(0,35));
				buttons[i][j].setMargin(new Insets(0, 0, 0, 0));
				buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
				buttons[i][j].setFocusPainted(false);
				buttons[i][j].setIcon(StaticTool.iconBlank);
				buttons[i][j].addMouseListener(listener);
			}
		}
		LayBomb.lay(buttons,new Random().nextInt(20)+1, new Random().nextInt(20)+1);
		return buttons;
	}
}
