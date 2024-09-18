package com.Dhiraj;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
//        Heap<Integer> heap = new Heap<>();
//
//        heap.insert(34);
//        heap.insert(45);
//        heap.insert(22);
//        heap.insert(89);
//        heap.insert(76);
//
//        ArrayList list = heap.heapSort();
//        System.out.println(list);


        // Huffman coder note to comment above

        String str= "abbccda";
        HuffmanCoder hf = new HuffmanCoder(str);
        String codedStr = hf.encode(str);
        System.out.println(codedStr);
        String decodedStr = hf.decode(codedStr);
        System.out.println(decodedStr);

    }
}
