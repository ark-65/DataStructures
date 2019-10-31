package com.datastructures.sparsearray;


/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/10/31
 * Time: 11:23 下午
 **/

public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组  11*11
        // 五子棋棋盘
        // 0表示没有妻子，1 标识黑子，2 表示篮子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 二维数组转成稀疏数组
        // 1.先遍历二维数组，得到非 0 数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length ; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int[][] sparseArr = new int[sum +1][3];
        // 给稀疏数组赋值
        // 第一行二维数组记录棋盘信息，11 行 11 列 sum 个有效数据
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 遍历二维数组，将非 0 的值存放到 sparseArr （稀疏数组）中
        // count 用于记录记录第几个非 0 数据
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length ; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);;
        }

        // 稀疏数组 恢复成二维数组
        /**
         *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
         *  2. 再读取稀疏数组后几行的数据，并赋给原始的二维数组即可
         */

        // 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2. 再读取稀疏数组后几行的数据(从第二行开始)，并赋给原始的二维数组即可
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
