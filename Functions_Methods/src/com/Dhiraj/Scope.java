package com.Dhiraj;

public class Scope {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        String name = "Kunal";            // name ----> Kunal

//        System.out.println(num);      // cannot resolve num   1.scope functional scope, if you define any variable inside a non public function you can only access it inside that function only
//        System.out.println(marks);

        swap(a, b);
        System.out.println(a +" "+ b);     // 10  20


        // Block scope
        {
//            int a = 100;  // already initialised outside the block in the same, hence you cannot initialised again. coz define in the block scope of same function
            a = 100;            // reassigning the original reference variable to some other value
            name = "Rahul";           // name -----> Rahul
            System.out.println(name);
            System.out.println(a);

            System.out.println(b);            // can be used caz b is define in the same method as well, and it's also in public function hence it can be access from anywhere

            int c = 50;
            // Values initiallised inside the block remain inside the block
            System.out.println(c);
        }
        System.out.println(name);  //        name ---> Rahul
        System.out.println(a);            //   a ----> 100
//        c = 45;                   // uninitialised
//        System.out.println(c);



        // Scoping in for loop
        for (int i=0; i<5; i++){
            int num = 45;
//            int a = 34;            // cannot initialised a as it's already initialiased in the method of for loop
        }
//        System.out.println(i);        // i is initialised in block of for loop hence it can't be used outside the loop

        int j = 0;
        for (j=0; j<5; j++){
            int num = 13;
        }
        System.out.println("j " +j);         // 5   caz j is initialised in the method and not the block of for loop hence it can be updated
    }
    static void random(int marks){
//        System.out.println(a);      // cannot resolve a
        int num = 32;
        System.out.println(num);

    }

    // in short whatever values are already define in the scope of the function of for loop or the block, you cannot initialised those again
    // anything that is initialsed outside you can use it inside the block as well
    // anything which is initialised inside (porvided that same is not beign initialised outside) cannot be used outside
    // a, b, name can be used anywhere inside the bloack a, b, name

    static void swap(int a, int b){
        int temp = a;                     // temp is initialized to store the real value of a itself     // int a ---->10   int b ---->20
        a = b;
        b = temp;
        // this change is valid for this functional scope only

    }

}
