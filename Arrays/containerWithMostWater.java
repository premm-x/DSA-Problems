// brute --- O(n) --- two pointers

int h[] = { 1,8,6,2,5,4,8,3,7 };  
int n = h.length;

int st = 0, end = n-1, ans = Integer.MIN_VALUE;

while(st < end){

  int height = Math.min(h[st], h[end]);
  int width = end - st;

  ans = Math.max(ans, (height*width));

  if(h[st] == height) st++;
  else end--;
            
}
System.out.println(ans);

// ------------------------------------------
