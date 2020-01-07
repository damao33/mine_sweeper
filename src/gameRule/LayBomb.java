package gameRule;

import java.util.Random;

public class LayBomb {
	public static void lay(MineButton[][] button, int row, int col) {

		int count = 0;
		Random random = new Random();
		while (count < StaticTool.allcount) {
			int x = random.nextInt(StaticTool.allrow);
			int y = random.nextInt(StaticTool.allcol);
			if (button[x][y].isMineTag() == false && !(x == row && y == col)) {
				button[x][y].setMineTag(true);
				button[x][y].setCounAround(9);

				count++;
			}

		}

		computeBomb(button);
	}

	public static void computeBomb(MineButton button[][]) {

		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				if (button[i][j].isMineTag() == false) {
					int count = 0;
					for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1, i + 1); x++) {
						for (int y = Math.max(0, j - 1); y <= Math.min(StaticTool.allcol - 1, j + 1); y++) {
							if (button[x][y].isMineTag() == true) {
								count++;

							}
						}
					}

					button[i][j].setCounAround(count);

				}

			}

		}

	}
}
