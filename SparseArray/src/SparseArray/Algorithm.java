package SparseArray;

import java.io.*;

//稀疏数组算法
public class Algorithm {
    private int[][] chessArray;
    private int[][] sparseArray;

    //构造函数
    public Algorithm(int[][] chessArray) {//将棋盘传入算法
        this.chessArray = chessArray;
    }

    //打印原始棋盘
    public void printChess() {
        for (int[] row :
                this.chessArray) {
            for (int data :
                    row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    //生成稀疏数组
    public void setSparseArray() {
        //找到棋盘上共有sum个棋子
        int sum = 0;
        for (int row[] :
                this.chessArray) {
            for (int data :
                    row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        //初始化稀疏数组
        this.sparseArray = new int[sum + 1][3];
        this.sparseArray[0][0] = this.chessArray.length;
        this.sparseArray[0][1] = this.chessArray[0].length;
        this.sparseArray[0][2] = sum;

        //生成稀疏数组
        int count = 0;//记录第几个非零棋子
        for (int row = 0; row < this.chessArray.length; ++row) {
            for (int col = 0; col < this.chessArray[0].length; ++col) {
                if (this.chessArray[row][col] != 0) {
                    ++count;
                    this.sparseArray[count][0] = row;
                    this.sparseArray[count][1] = col;
                    this.sparseArray[count][2] = this.chessArray[row][col];
                }
            }
        }
    }

    //打印生成的稀疏数组
    public void printSparseArray() {
        for (int row = 0; row < this.sparseArray.length; ++row) {
            System.out.printf("%d\t%d\t%d\t\n", this.sparseArray[row][0], this.sparseArray[row][1],
                    this.sparseArray[row][2]);
        }
    }

    //返回稀疏数组
    public int[][] getSparseArray() {
        return this.sparseArray;
    }

    //稀疏数组存储为txt文件
    public void storageSparseArray() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("稀疏数组.txt"))));
            for (int row[] :
                    this.sparseArray) {
                for (int data :
                        row) {
                    out.write(data + "\t");
                }
                out.write("\n");
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
