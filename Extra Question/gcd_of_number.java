// solution - 3 way ( b-1, p-2 )

// example of optimal
// 48 % 18 = 12
// 18 % 12 = 6
// 12 % 6 = 0


//------------------------------ 1 ---------------------------------
// brute force 
static void gcd(int a, int b) {
    int gd = 0;

    int min = Math.min(a, b);

    for (int i = 1; i <= min; i++) {
        if (a % i == 0 && b % i == 0)
            gd = i;
    }

    System.out.println(gd);

}

// optimal's
//------------------------------ 2 ---------------------------------
// iterative
static void gcdOptimalIterative(int a, int b) {

    while (b > 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }

    System.out.println(a);

}


//------------------------------ 3 ---------------------------------
// reursive
static void gcdOptimalRecursive(int a, int b) {

    if (b <= 0) {
        System.out.println(a);
        return;
    }

    gcdOptimalRecursive(b, a % b);
}




