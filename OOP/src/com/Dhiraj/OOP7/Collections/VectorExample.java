package com.Dhiraj.OOP7.Collections;

import java.util.List;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {

        List<Integer> list = new Vector<>();
        list.add(2);
        list.add(45);
        list.remove(45);
        System.out.println(list);

    }
}


/*
Synchronization: Vector is synchronized, which means only one thread at a time can access the code, while ArrayList is not synchronized, which means multiple threads can work on ArrayList at the same time.
For example, if one thread is performing an add operation, then there can be another thread performing a remove operation in a multithreading environment.
If multiple threads access ArrayList concurrently, then we must synchronize the block of the code which modifies the list structurally or allow simple element modifications.
Structural modification means the addition or deletion of element(s) from the list. Setting the value of an existing element is not a structural modification.

Performance: ArrayList is faster. Since it is non-synchronized, while vector operations give slower performance since they are synchronized (thread-safe),
if one thread works on a vector, it has acquired a lock on it, which forces any other thread wanting to work on it to have to wait until the lock is released.

 */