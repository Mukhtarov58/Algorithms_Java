package Sem_1;

public class Sem_1 {
    public static void main(String[] args) {
//        findPrimes(10);
//        findCountCombos1(6,6,0);
        long start = System.currentTimeMillis();
  findFib(56);
        long over = System.currentTimeMillis();
        System.out.println(over - start);

        start = System.currentTimeMillis();
 findFibRec(56);
        over = System.currentTimeMillis();
        System.out.println(over - start);
    }

    public static int sum(int n) {
        int res = 0;
        for (int i = 0; i < n; res += 1, i++) ;
        return res;
    }

    public static void findPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }

    public static int findCountCombos(int n) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int findCountCombos1(int k, int n, int count) {
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                count++;
            }
        } else {
            return 0;
        }
        System.out.println(count);
        return count + findCountCombos1(--k, n, 0);
    }

    private static long findCountCombos2(int k, int N, int count) {
        if (k == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += findCountCombos2(k - 1, N, count + i);
        }
        return sum;
    }

    public static int findFib(int n) {
        int a = 1;
        int b = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static int findFibRec(int n) {
        if (n == 1 || n == 2) //****
        {
            return 1;
        }

        return findFibRec(n - 1) + findFibRec(n - 2);
    }


}


