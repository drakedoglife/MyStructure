package SparseArray;

import java.io.*;
import java.util.ArrayList;

public class ReadAlgorithm {
    private int[][] sparseArray;
    private int[][] chessArray;
    private String filePath;
    private ArrayList<String> strSparseArray = new ArrayList<String>();

    //构造函数
    public ReadAlgorithm(String path) {
        this.filePath = path;
    }

    //读取文件内容、稀疏数组
    public void readSparseArray() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    new FileInputStream(this.filePath)
            ));
            String line;
            while ((line = in.readLine()) != null) {
                this.strSparseArray.add(line);
            }
            this.sparseArray = new int[this.strSparseArray.size()][3];
            String[] temp;
            for (int row = 0; row < this.strSparseArray.size(); ++row) {
                temp = this.strSparseArray.get(row).split("\t|\n");
                for (int count = 0; count < 3; ++count) {
                    this.sparseArray[row][count] = Integer.parseInt(temp[count]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //返回稀疏数组
    public int[][] returnSparseArray() {
        return this.sparseArray;
    }

    //打印取得的稀疏数组
    public void displaySparse() {
        for (int[] row :
                this.sparseArray) {
            for (int data :
                    row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }

    //将稀疏数组恢复为原数组
    public void rebuildChessArray() {
        this.chessArray = new int[this.sparseArray[0][0]][this.sparseArray[0][1]];
        for (int row = 0; row < this.chessArray.length; ++row) {
            for (int col = 0; col < this.chessArray[0].length; ++col) {
                this.chessArray[row][col] = 0;
            }
        }
        for (int row = 1; row < this.sparseArray.length; ++row) {
            this.chessArray[this.sparseArray[row][0]][this.sparseArray[row][1]] = this.sparseArray[row][2];
        }
    }

    //打印原数组
    public void printRebuildChessArray() {
        for (int[] row :
                this.chessArray) {
            for (int data :
                    row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }
}
