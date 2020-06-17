/*稀疏数组
    使用五子棋游戏来测试稀疏数组
 */
package SparseArray;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        int[][] chessArray = new int[11][11];//棋盘大小为11x11
//        chessArray[1][2] = 1;//棋盘第二行第三列摆放黑棋
//        chessArray[2][3] = 2;//棋盘第三行第四列摆放白棋
//
//        //构造稀疏数组并存储
//        Algorithm al = new Algorithm(chessArray);//构造稀疏数组算法
//        al.printChess();//打印原始棋盘
//        al.setSparseArray();//生成稀疏数组
//        al.printSparseArray();//打印稀疏数组
//        al.storageSparseArray();//存储稀疏数组为txt文件

        //读取稀疏数组并还原成原数组
        System.out.println("-------------");
        ReadAlgorithm rg = new ReadAlgorithm("稀疏数组.txt");//构造读入对象
        rg.readSparseArray();//读取稀疏数组
        rg.rebuildChessArray();//重建原数组
        rg.printRebuildChessArray();//打印原数组
    }
}
