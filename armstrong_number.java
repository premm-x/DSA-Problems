// solution - 3
// 1. string + Math.pow
// 2. Math.pow
// 3. manually



// --------------------------------- 1 -----------------------------------
//  with using -- string, pow function
static void armStrong(int num) {

    int original = num;
    int digits = String.valueOf(num).length();
    int sum = 0;

    while (num > 0) {
        int digit = num % 10;
        sum += Math.pow(digit, digits);
        num /= 10;
    }

    System.out.println(sum == original);

}

// --------------------------------- 2 -----------------------------------
//with using --  pow function
static void armStrongWithoutString(int num) {

    int original = num;
    int temp = num;
    int digits = 0;

    while (temp > 0) {
        digits++;
        temp /= 10;
    }

    int sum = 0;

    while (num > 0) {
        int digit = num % 10;
        sum += Math.pow(digit, digits);
        num /= 10;
    }

    System.out.println(sum == original);

}

// --------------------------------- 3 -----------------------------------
// without anything support - independent
static void armStrongwithoutSupport(int num) {
    int original = num;
    int digits = 0;

    while (num > 0) {
        digits++;
        num /= 10;
    }

    num = original;
    int sum = 0;

    while (num > 0) {
        int digit = num % 10;

        int power = 1;
        for (int i = 0; i < digits; i++) {
            power *= digit;
        }

        sum += power;

        num /= 10;
    }

    System.out.println(sum == original);

}







