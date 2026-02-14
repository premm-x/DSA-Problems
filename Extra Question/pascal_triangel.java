
// 2 questions---------
//print all pascal
//print specific row of pascal


//----------------------------- 1 -----------------------------------
// print all pascal
static void printPascal(int n) {

    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int j = 0; j <= i; j++) {
            if (j == 0 || j == i) {
                list.add(1);
            } else {
                list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
        }

        ans.add(list);
    }

    for (List<Integer> i : ans) {
        System.out.println(i);
    }
}

// ---------------------------- 2 ---------------------------------
//print specific row of pascal
static void rowOfPascal(int row) { // 0 index bases

    ArrayList<Integer> ans = new ArrayList<>();
    int value = 1;

    for (int i = 0; i <= row; i++) {
        ans.add(value);
        value = value * (row - i) / (i + 1);
    }

    System.out.println(ans);
}






