package io.github.dunwu.ds.array;

//    【对角线遍历】

//
//    给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
//
//    示例:
//
//    输入:
//    [
//    [ 1, 2, 3 ],
//    [ 4, 5, 6 ],
//    [ 7, 8, 9 ]
//    ]
//
//    输出:  [1,2,4,7,5,3,6,8,9]
//
//    说明:
//
//    给定矩阵中的元素总数不会超过 100000 。

/**
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class DiagonalTraverse {

	public static int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return new int[0];
		}

		int x = 0, y = 0;
		final int M = matrix.length;
		final int N = matrix[0].length;
		int[] arr = new int[M * N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = matrix[x][y];
			if ((x + y) % 2 == 0) {
				if (y == N - 1) {
					x++;
				} else if (x == 0) {
					y++;
				} else {
					x--;
					y++;
				}
			} else {
				if (x == M - 1) {
					y++;
				} else if (y == 0) {
					x++;
				} else {
					x++;
					y--;
				}
			}
		}
		return arr;
	}

}
