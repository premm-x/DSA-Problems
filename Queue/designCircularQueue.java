// solution - 2
// ( 1-brute, 2-optimal )

// brute force (my approch) --- tc: O(1) sc: O(k)
class MyCircularQueue {
    int[] arr;
    int n;
    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        n = arr.length;
    }
    int front = 0, rear = -1;

    public boolean enQueue(int value) {
        rear++;
        if(rear == n) rear = 0;
        if(arr[rear] != -1) {
            rear = rear == 0 ? rear = n-1 : rear-1;
            return false;
        }
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(arr[front] == -1) return false;
        arr[front] = -1;
        front++;
        if(front == n) front = 0;
        return true;
    }
    
    public int Front() {
        return arr[front];
    }
    
    public int Rear() {
        if(rear == -1) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return arr[front] == -1;
    }
    
    public boolean isFull() {
        int last = rear + 1;
        if(last >= n || arr[last] != -1) return true;
        else return false;
    }
}

//--------------------------------------- ( 2 ) -------------------------------------------
// optimal ( clearer and readable ) --- tc: O(1) sc: O(k+1)

class MyCircularQueue {
    int[] arr;
    int front, rear, n;
    public MyCircularQueue(int k) {
        arr = new int[k+1];
        n = arr.length;
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1) % n;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front + 1) % n;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return arr[(rear + n-1) % n];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % n == front;
    }
}
