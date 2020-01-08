package gameRule;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.GameFrame;
import tool.StaticTool;

public class Listener implements MouseListener {
	MineButton[][] mineButton;
	private boolean isDoublePress = false;

	public Listener(MineButton[][] buttons) {
		super();
		this.mineButton = buttons;
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
			doublePress(row, col);

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
		MineButton mineButton = (MineButton) e.getSource();
		int row = mineButton.getRowx();
		int col = mineButton.getColy();
		if (isDoublePress) {
			isDoublePress = false;
			if (mineButton.isExpendTag() == false && mineButton.isFlagTag() == false) {
				backIcon(row, col);
			} else {

				boolean isEquals = isEquals(row, col);
				if (isEquals) {
					doubleExpend(row, col);
				} else {
					backIcon(row, col);

				}

			}

		} else if (e.getModifiers() == InputEvent.BUTTON1_MASK && mineButton.isFlagTag() == false) {
			if (StaticTool.isStart == false) {
				LayBomb.lay(this.mineButton, row, col);

				StaticTool.isStart = true;

			}

			if (mineButton.isMineTag() == true) {

				bombAction(row, col);

				mineButton.setIcon(StaticTool.bloodIcon);
			} else {
				expand(row, col);

			}

		}

		isWin();
	}

	private void bombAction(int row, int col) {

		for (int i = 0; i < mineButton.length; i++) {
			for (int j = 0; j < mineButton[i].length; j++) {
				if (mineButton[i][j].isMineTag()) {
					if (mineButton[i][j].isFlagTag() == false) {
						mineButton[i][j].setIcon(StaticTool.blackBombIcon);
					}
				} else {
					if (mineButton[i][j].isFlagTag()) {
						mineButton[i][j].setIcon(StaticTool.errorBombIcon);
					}
				}
			}

		}

		// mainFrame.getTimer().stop();

		for (int i = 0; i < mineButton.length; i++) {
			for (int j = 0; j < mineButton[i].length; j++) {
				mineButton[i][j].removeMouseListener(this);

			}
		}

	}

	private void expand(int x, int y) {

		int count = mineButton[x][y].getCounAround();

		if (mineButton[x][y].isExpendTag() == false && mineButton[x][y].isFlagTag() == false) {

			if (count == 0) {
				mineButton[x][y].setIcon(StaticTool.num[count]);
				mineButton[x][y].setExpendTag(true);
				for (int i = Math.max(0, x - 1); i <= Math.min(mineButton.length - 1, x + 1); i++) {
					for (int j = Math.max(0, y - 1); j <= Math.min(mineButton[x].length - 1, y + 1); j++) {
						expand(i, j);

					}

				}

			} else {

				mineButton[x][y].setIcon(StaticTool.num[count]);
				mineButton[x][y].setExpendTag(true);

			}

		}

	}

	private void backIcon(int i, int j) {
		for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1, i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(StaticTool.allcol - 1, j + 1); y++) {
				if (mineButton[x][y].isFlagTag() == false && mineButton[x][y].isExpendTag() == false) {
					int rightClickCount = mineButton[x][y].getRightClickCount();
					if (rightClickCount == 2) {
						mineButton[x][y].setIcon(StaticTool.askIcon);
					} else {
						mineButton[x][y].setIcon(StaticTool.iconBlank);

					}
				}
			}
		}

	}

	private boolean isEquals(int i, int j) {
		int count = mineButton[i][j].getCounAround();
		int flagCount = 0;
		for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1, i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(StaticTool.allcol - 1, j + 1); y++) {
				if (mineButton[x][y].isFlagTag()) {
					flagCount++;
				}
			}
		}
		if (count == flagCount) {
			return true;
		}
		return false;
	}

	private void doublePress(int i, int j) {
		for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1, i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(StaticTool.allcol - 1, j + 1); y++) {
				if (mineButton[x][y].isExpendTag() == false && mineButton[x][y].isFlagTag() == false) {
					int rightClickCount = mineButton[x][y].getRightClickCount();
					if (rightClickCount == 1) {
						mineButton[x][y].setIcon(StaticTool.askPressIcon);

					} else {
						mineButton[x][y].setIcon(StaticTool.icon0);

					}
				}
			}
		}
	}

	private void doubleExpend(int i, int j) {
		for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1, i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(StaticTool.allcol - 1, j + 1); y++) {
				if (mineButton[x][y].isMineTag()) {
					if (mineButton[x][y].isFlagTag() == false) {
						bombAction(x, y);

					}
				} else {

					if (mineButton[x][y].isFlagTag() == false) {
						expand(x, y);
					}

				}

			}
		}

	}

	private void isWin() {

		int needCount = StaticTool.allrow * StaticTool.allcol - StaticTool.allcount;
		int expendCount = 0;
		for (int i = 0; i < mineButton.length; i++) {
			for (int j = 0; j < mineButton[i].length; j++) {
				if (mineButton[i][j].isExpendTag()) {
					expendCount++;
				}

			}

		}
		if (needCount == expendCount) {
			for (int i = 0; i < mineButton.length; i++) {
				for (int j = 0; j < mineButton[i].length; j++) {
					if (mineButton[i][j].isMineTag() && mineButton[i][j].isFlagTag() == false) {
						mineButton[i][j].setIcon(StaticTool.flagIcon);
						mineButton[i][j].setFlagTag(true);
					}

				}

			}

			// mainFrame.getTimer().stop();
			for (int i = 0; i < mineButton.length; i++) {
				for (int j = 0; j < mineButton[i].length; j++) {
					mineButton[i][j].removeMouseListener(this);

				}
			}

		}

	}

}
