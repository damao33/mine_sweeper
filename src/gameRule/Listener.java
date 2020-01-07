package gameRule;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener implements MouseListener {
	MineButton[][] minebutton;
	private boolean isDoublePress = false;

	public Listener(MineButton[][] buttons, MainFrame mianFrame) {
		super();
		this.minebutton = buttons;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		MineButton mineButton = (MineButton) e.getSource();

		int row = mineButton.getRowx();
		int col = mineButton.getColy();

		if (e.getModifiersEx() == InputEvent.BUTTON1_DOWN_MASK + InputEvent.BUTTON3_DOWN_MASK) {
			isDoublePress = true;
			//doublePress(row, col);

		} else if (e.getModifiers() == InputEvent.BUTTON1_MASK && mineButton.isFlagTag() == false) {
			if (mineButton.isExpendTag() == false) {
				mineButton.setIcon(StaticTool.icon0);

			}
		} else if (e.getModifiers() == InputEvent.BUTTON3_MASK && mineButton.isExpendTag() == false) {
			if (mineButton.getRightClickCount() == 0) {
				mineButton.setIcon(StaticTool.flagIcon);
				mineButton.setRightClickCount(1);
				mineButton.setFlagTag(true);
				StaticTool.bombCount--;

			} else if (mineButton.getRightClickCount() == 1) {
				mineButton.setIcon(StaticTool.askIcon);
				mineButton.setRightClickCount(2);
				mineButton.setFlagTag(false);
				StaticTool.bombCount++;

			} else {
				mineButton.setIcon(StaticTool.iconBlank);
				mineButton.setRightClickCount(0);
			}

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
