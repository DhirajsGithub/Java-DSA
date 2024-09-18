package com.Dhiraj;

public class DynamicCircularQueue extends CircularQueue{
    public DynamicCircularQueue() {
        super();
    }

    public DynamicCircularQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {

        if (this.isFull()){
            // double the size of an array
            int temp [] = new int[data.length*2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front+i)%data.length];          // if some elements are removed the front position would have been changed, hence to the old array elements to new one they should be starting front where the pointer fron
                // data = [1, 2, 3, 4, 5]
                // front is at index 2 then in new array
                // temp = [3, 4, 5, 1, 2]    since 1 and 2 items are added after 5
            }
            front = 0;
            end  = data.length;
            data = temp;

        }

        return super.insert(item);
    }
}
