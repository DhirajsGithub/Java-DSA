package com.Dhiraj;

public class PatternQue {
    public static void main(String[] args) {

        int n = 5;
//        patter1(n);
//        System.out.println();
//        patter2(n);
//        patter3(n);
//        patter4(n);
//        patter5(n);
//        patter6(n);
//        System.out.println(factorial(5));
//        pascalPatter7(n);
//        pattern8(n);
//        pattern9(n);
//        pattern10(n);
//        pattern11(n);
//        pattern12(n);
//        pattern13(n);
//        pattern14(n);
//        pattern15(n);
//        pattern16(n);
//        pattern17(n);
//        pattern18(n);
//        pattern19(n);
//        pattern20(n);
//        pattern21(n);
//        pattern22(n);
//        pattern23(n);

//        pascalTriangle(5);


    }
    static void patter1(int n){
        for(int i=1; i<=n ; i++){
            for (int j=n-i+1; j>0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void patter2(int n){
        for (int i=1; i<=2*n-1; i++){
//            System.out.println();
            for (int j=1; j<i+1; j++){
                if (i > (2*n-1)/2+1){
                    break;
                }
                System.out.print("* ");
            }

            if (i > (2*n-1)/2+1){
                for(int k=(2*n-1) - i+1 ; k>0; k--){
                    System.out.print("* ");
                }
            }
            System.out.println();


        }
    }
    static void patter3 (int n){
        for (int i=1; i<= 2*n-1; i++){
            // ternary operator
            // condition ? expression1 : expression2
            int col = i <=n ? i : 2*n -i;
            int spaces = i<=n ? n-i : i -n;
            for(int j=1; j<= spaces; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=col; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void patter4 (int n){
        n = n *2;
        for (int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                int atEveryIndex = n/2 - Math.min(Math.min(i, j), Math.min(n-i, n-j));
                System.out.print(atEveryIndex+ " ");
            }
            System.out.println();
        }
    }

    static void patter5 (int n ){
        // couter loop
        for (int i=1; i<=n; i++){
//            for (int i=n; i>=1; i--){  // tilted triangle

            // spaces
            for (int j=i; j<n; j++){
                System.out.print(" ");
            }
            // stars
            for(int j=1; j<=2*(i-1) + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void patter6(int n ){
        for(int i=0; i<2*n; i++){
            int col = i<n ? n-i : i+1-n;
            int spaces = i<n ? i : 2*n-i-1;

            // spaces
            for (int j=1; j<=spaces; j++){
                System.out.print(" ");
            }
            // stars
            for(int j=1; j<=col; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pascalPatter7(int n){
        for (int i=0; i<=n; i++){
            // spaces
            for(int j=n-1; j>=i; j--){
                System.out.print(" ");
            }
            // cols
            for (int j=0; j<=i; j++){
                int ans = factorial(i)/factorial(j)/factorial(i-j);
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }

    static int factorial(int n){
        int i = 1;

        if (n <= 1){
            return 1;
        }


        return n*factorial(n-1);
    }

    static void pattern8(int n ){
        // outer spaces

        for(int i=0; i< n; i++){

            for (int j= 0; j<2*n-1; j++){
                if(j == n-i-1 || j == n+i-1 || i==n-1  ){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println();


//            System.out.println("*");
            
        }
    }

    static void pattern9 (int n){
        for(int i=0; i<2*n -1 ; i++){
            if(i <=n-1){
                for (int j=0; j<2*n-1; j++){
                    if (j==n-i-1 || j==n+i-1 ){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }else{
                for (int j=0; j<2*n-1; j++){
                    if (j==i-n+1 || j==2*n - (i%n)-3 ){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

    }
    static void pattern10(int n){
        for(int i=1; i<=n-1; i++){

            for(int j=0; j<n-i-1; j++){
                // spaces
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            for(int j=i; j>=2; j--){
                System.out.print(j);
            }
            System.out.println();
        }
        for(int i=1; i<n-1; i++){
            // spaces
            for(int j=1; j<=i; j++){
                System.out.print(" ");
            }
            for(int j=n-i-1; j>=1; j--){
                System.out.print(j);
            }
            for(int j=2; j<=n-i-1; j++){
                System.out.print(j);
            }
            System.out.println();

        }
    }

    static void pattern11(int n){
        for(int i=0; i<2*n; i++){
            if(i<n){
                // starts left upper part
                for(int j=0; j<n-i; j++){
                    System.out.print("*");
                }
                for(int j=0; j<2*i; j++){
                    System.out.print(" ");
                }

                for(int j=0; j<n-i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }else{
                for(int j=0; j<i%n+1; j++){
                    System.out.print("*");
                }
                for(int j=0; j<2*(n-(i%n+1)); j++){
                    System.out.print(" ");
                }
                for(int j=0; j<i%n+1; j++){
                    System.out.print("*");
                }
                System.out.println();
            }

        }
    }

    static void pattern12(int n){
        for(int i=0; i<2*n; i++){
            if(i<n){
                for(int j=0; j<i; j++){
                    System.out.print("*");
                }
                for(int j=0; j<2*(n-i); j++){
                    System.out.print(" ");
                }
                for(int j=0; j<i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
            else{
                for(int j=0; j<n-(i%n); j++){
                    System.out.print("*");
                }
                for(int j=0; j<2*(i-n); j++){
                    System.out.print(" ");
                }
                for(int j=0; j<n-(i%n); j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    static void pattern13 (int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || i==n-1 || j==0 || j==n-1){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    static void pattern14(int n){
        int c = 1;
        for (int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                System.out.print(c);
                c ++ ;
            }
            System.out.println();
        }
    }

    static void pattern15(int n){

        for (int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
               if((i-j-1)%2 == 0){
                   System.out.print(1);
               }else{
                   System.out.print(0);
               }
            }
            System.out.println();
        }
    }
    static void pattern16(int n) {
        n = 3;
        for(int i=0; i<3; i++){
            // spaces
            for(int j=i; j<n-1; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            if(i >0){
                // internal spaces
                for(int j=0; j<(2*(i-1) + 1); j++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();

        }

    }



    static void pattern17 (int n){
        for(int i=0; i<2*n ; i++){
            for(int j=0; j<2*n; j++){
                if(j==0 || j==2*n-1 || i==j || i+j == 2*n-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void pattern18(int n){
        String k = " ";
        String l = "*";
        for(int i=0; i<n; i++){
            // outer spaces

            for(int j=0; j<n-i-1; j++){
                System.out.print(k);
            }
            System.out.print("*");
            if(i==0 || i==n-1){
                for(int j=0; j<n; j++){
                    System.out.print(l);
                }
            }else{
                for(int j=0; j<n; j++){
                    System.out.print(k);
                }
            }
            System.out.print(l);

            System.out.println();
        }
    }

    static void pattern19(int n){
        int c=1;

        int k = 4*n-n+1;
        for (int i=0; i<n-1; i++){
            int p = 0;
            // spaces
            for(int j=0; j<i; j++){
                System.out.print("  ");
            }
            for(int j=0; j<n-1-i; j++){
                System.out.print(c+"  ");
                c++;
            }
            for(int j=1; j<n-i; j++){
                p++;
                System.out.print(k+j+"  ");
            }
            k = k-p+1;
            System.out.println();
        }
    }


    static void pattern20(int n){


        for(int i=0; i<n; i++){
            for(int j=i; j>=0; j--){
            char c = (char)(65+n-1-j);
                System.out.print(c);

            }
            System.out.println();

        }

    }

    static void pattern21(int n){
        char c;
        int o = 0;
        for (int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
               if(o%2==0){
                   c = (char)(97+o);
               }else{
                   c = (char)(65+o);
               }
                System.out.print(c);
               o++;
            }
            System.out.println();
        }
    }

    static void pattern22 (int n){
        for(int i=0; i<n-1; i++){
            for(int j=1; j<=i+1; j++){
                System.out.print(j);
            }
            // spaces
            for(int j=0; j<2*n-4-2*i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i+1; j++){
                System.out.print(j);
            }
            System.out.println();

        }
    }
    static void pattern23(int n){

    }

    // solving using pascal triangle


    static void pascalTriangle(int n){
        for(int i=0; i<=n; i++){        // all r's
            for(int j=n; j>i; j--){
                System.out.print(" ");
            }
            for(int k=0; k<=i; k++){
                System.out.print(formula(i, k) + " ");
            }
            System.out.println();
        }
    }

    static int formula(int n, int r){
        int numerator = 1;
        for(int i=0; i<r; i++){
            numerator = numerator*(n-i);
        }
        int denomenator = 1;
        for(int i=1; i<=r; i++){
            denomenator = denomenator*i;
        }
        return numerator/denomenator;
    }


    // doubts pattern 16 (mountain) and pattern  23 (spiral type)


}



/*

approach:
1. no of lines = no of rows = no of timea after loop will run
2. identify for every row no. how many cols are there. types of element in cols
3. what do you need to print
4. try to find formula using row and col


*/