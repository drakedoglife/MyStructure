package ArrayQueue;

class RuntimesException extends Throwable {

}

public class ArrayQueue {
    private int MAX_SIZE;//队列最大容量
    private int front;//首指针(指向首元素前一个位置)
    private int rear;//尾指针(指向尾元素的位置)
    private int[] arr;

    //队列构造函数
    public ArrayQueue(int max_size) {
        this.MAX_SIZE = max_size;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[this.MAX_SIZE];
    }

    //判断队列是否为空
    private boolean isEmpty() {
        return this.front == this.rear;
    }

    //判断队列是否为满
    private boolean isFull() {
        return this.rear == this.MAX_SIZE - 1;
    }

    //入队列
    public void addData(int number) throws RuntimeException {
        if (this.isFull()) {
            throw new RuntimeException("队列已满，无法添加数据");
        }
        this.arr[++this.rear] = number;
    }

    //出队列并返回第一个数据
    public int deleteData() throws RuntimeException {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，无法删除数据");
        }
        return this.arr[++front];
    }

    //显示队列
    public void showQueue() throws RuntimeException {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，无法显示数据");
        }
        for (int n:
             this.arr) {
            System.out.println(n);
        }
    }
}
