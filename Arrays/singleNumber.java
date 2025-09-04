// brute - on sorted data --- O(n) --- two pointer

int arr1[] = { 1,1,2,2,3,4,4,5,5 };
int arr2[] = { 1,2,2,3,3,4,4,5,5 };
int arr[] = { 1,1,2,2,3,3,4,4,5 };
int n = arr.length;

int s=0, end = 1;

while (end < n) {
            
    if(arr[s] != arr[end]){
        System.out.println(arr[s]);
        break;
    }
    s+=2;
    end+=2;
}

if(end >= n) System.out.println(arr[s]);

// ---------------------( 2 )------------------------

// xor - also on unsorted work --- O(n) --- XOR

int arr[] = { 1,1,2,2,3,3,4,4,5 };
int n = arr.length;

int sum = 0;

for (int i = 0; i < arr.length; i++) {
   sum = arr[i] ^ sum;
}

System.out.println(sum);




