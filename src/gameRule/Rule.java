package gameRule;

import java.util.Random;

public class Rule {
	boolean flag;
	int row, column, mine;
	int[] count1, count2;
	int num, num1, num2, mineEnd, bonEnd, level;
	int[][] isMine;
	Random ron;

	// 设置行数
	public void setRow(int row) {
		this.row = row;
	}

	// 设置列数
	public void setColumn(int column) {
		this.column = column;
	}

	// 设置雷数
	public void setMine(int mine) {
		this.mine = mine;
	}

	// 获得行数
	public int getRow() {
		return row;
	}

	// 获得列数
	public int getColumn() {
		return column;
	}

	// 获得雷数
	public int getMine() {
		return mine;
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

	
}


