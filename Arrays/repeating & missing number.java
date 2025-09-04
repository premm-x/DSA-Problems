// brute - on sorted data 

int arr[] = { 1, 2, 2,3, 5 };
int n = arr.length;

int st = 0, end = 1, sum = 0, rep = -1;

while (st < n) {

    sum += arr[st];

    if(end >= n) break;

    if (arr[st] == arr[end]) {
          rep = arr[st];
          st++;
          end++;
    }

      st++;
      end++;
    }

int nsum = (n * (n+1)) / 2;

System.out.println("missing = " + (nsum - sum ));
System.out.println("repeating = " + rep);



