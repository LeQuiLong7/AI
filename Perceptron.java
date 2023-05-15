public class Perceptron {

    public static void main(String[] args) {

		int[][] given = {{1,1}, {2,2}, {8,1}, {9,3}, {2,7}, {3,8}, {8,8}, {9,9}};
		int[][] t = {{0,0}, {0,0}, {1,0}, {1,0}, {0,1}, {0,1}, {1,1}, {1,1}};

		int[][] W = {{1,0}, {2,8}}; int[][] b = {{-6}, {-9}};

        while (true) {
            boolean check = true;
            for(int i = 0; i < given.length; i++){

                int[][] a = transform(plus(multiply(W, transpose(given[i])), b));

                if(!check(a, t[i])){
                    check = false;
                    int[][] e = plus(transpose(t[i]), multiply(-1, a));
                    W = plus(W, multiply(e, given[i]));
                    b = plus(b, e);

                }
            }
            if (check) break;
        }

        int[] test = {9, 2};
        int[][] a = transform(plus(multiply(W, transpose(test)), b));
        calc(a);
    }

    public static void calc(int[][] a) {
        if(a[0][0] == 0) System.out.print("Nho, ");
        if(a[0][0] == 1) System.out.print("To, ");
        if(a[1][0] == 0) System.out.println("Xanh");
        if(a[1][0] == 1) System.out.println("Chin");

    }


    public static int[][] transform(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++){
                a[i][j] = a[i][j] < 0 ? 0 : 1;
            }
        }

        return a;
    }


    public static boolean check(int[][] res, int[] expect) {

        return compare(res, transpose(expect));
    }


    public static boolean compare(int[][] a, int[][] b) {
        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < a[0].length; j++)
                if (a[i][j] != b[i][j])
                    return false;
        return true;
    }

    public static int[][] transpose(int[] matrix) {

        int[][] res = new int[matrix.length][1];

        for(int i = 0; i < res.length; i++)
                res[i][0] = matrix[i];

        return res;
    }


    public static int[][] transpose(int[][] matrix) {

        int[][] res = new int[matrix[0].length][matrix.length];

        for(int i = 0; i < res.length; i++)
            for (int j = 0; j < res[0].length; j++)
                res[i][j] = matrix[j][i];

        return res;
    }
    public static int[][] multiply(int[][] matrix1, int[] matrix2) {


        int[][] res = new int[matrix1.length][matrix2.length];

        for(int i = 0; i < res.length; i++)
            for(int j = 0; j < res[0].length; j++)
                res[i][j] = matrix1[i][0] * matrix2[i];

        return res;
    }

    public static int[][] plus(int[][] matrix1, int[][] matrix2) {

        int[][] res = new int[matrix1.length][matrix2[0].length];

        for(int i = 0; i < matrix1.length; i++)
            for(int j = 0; j < matrix2[0].length; j++)
                res[i][j] = matrix1[i][j] + matrix2[i][j];

        return res;
    }


    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int[][] res = new int[matrix1.length][matrix2[0].length];

        for(int i = 0; i < matrix1.length; i++)
            for(int j = 0; j < matrix2[0].length; j++)
                for(int k = 0; k < matrix1[0].length; k++)
                    res[i][j] += matrix1[i][k] * matrix2[k][j];

        return res;
    }


    public static int[][] multiply(int n, int[][] matrix2) {

        int[][] res = new int[matrix2.length][matrix2[0].length];

        for(int i = 0; i < matrix2.length; i++)
            for(int j = 0; j < matrix2[0].length; j++)
                res[i][j] = n * matrix2[i][j];

        return res;
    }

    public static void  print(int[][] matrix) {

        for (int[] i : matrix) {
            for (int k : i)
                System.out.print(k + " ");
            System.out.println();
        }
    }
}
