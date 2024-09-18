package com.Dhiraj;

public class DynamicStack extends CustomStack{

    // all other method will remain same for DynamciStack

    public DynamicStack() {
        super();     // will call constructor of parent class of default size
    }

    public DynamicStack(int size){
        super(size);   // wil call constructor of paretn class of dunamic size
    }

    // overriding CustomStack push method

    @Override
    public boolean push(int val) throws StackException {

        if (this.isFull()){
            // double the size of an array
            int temp [] = new int[data.length*2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
//            System.arraycopy(data, 0, temp, 0, data.length);


            data = temp;

        }

        // here array is not full hence insert item
        // now with help of parent class CustomStack we are pushing val in the stack
        return super.push(val);
    }
}
