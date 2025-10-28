// solution - 2
// also we can use LL to solve this

// good but space is not fully used of array --- tc: O(1) sc: O(n)
class kStacks {
    private int[] arr;
    private int[] top;
    private int segSize;

    public kStacks(int n, int k) {
        segSize = n / k;
        arr = new int[n];
        top = new int[k];
        for (int i = 0; i < k; i++)
            top[i] = i * segSize - 1;
    }
  
    public void push(int x, int i) {
        int end = (i + 1) * segSize - 1;

        if (top[i] == end) {
            System.out.println("Stack " + i + " overflow");
            return;
        }

        top[i]++;
        arr[top[i]] = x;
    }

    public int pop(int i) {
        int start = i * segSize;

        if (top[i] < start) {
            System.out.println("Stack " + i + " underflow");
            return -1;
        }

        int val = arr[top[i]];
        top[i]--;
        return val;
    }
}
// -------------------------------- ( 2 ) -------------------------------------
// optimaed --- full use of space --- tc: O(1) sc: O(n)
class kStacks {

    private int[] arr;
    private int[] top;
    private int[] next;
    
    int freeSpace;
    
    int size = 0;

    public kStacks(int n, int k) {
        
        size = n/k;
        arr = new int[n];
        top = new int[k];
        next = new int[n];
        
        freeSpace = 0;
        
        Arrays.fill(top, -1);
        
        for(int i=0; i<n-1; i++){
            next[i] = i+1;
        }
        next[n-1] = -1;
    }

    public void push(int x, int i) {
        
        if(freeSpace == -1) return;
        
        int indx = freeSpace;
        
        freeSpace = next[indx];
        
        next[indx] = top[i];
        top[i] = indx;
        
        arr[indx] = x;
        
    }

    public int pop(int i) {
        
        if(top[i] == -1) return -1;
        
        int indx = top[i];
        top[i] = next[indx];
        
        next[indx] = freeSpace;
        freeSpace = indx;
        
        return arr[indx];
    }
}






