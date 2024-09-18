package com.Dhiraj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        Character data;
        int cost; // frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public HuffmanCoder(String feeder) throws Exception{
        // creating a frequency map
        HashMap<Character, Integer> fMap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char cc = feeder.charAt(i);
            fMap.put(cc, fMap.getOrDefault(cc, 0)+1);
        }

        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = fMap.entrySet();
        // entry set = The set is: [20=Geeks, 25=Welcomes, 10=Geeks, 30=You, 15=4]

        for(Map.Entry<Character, Integer> entry : entrySet) {
            // create a new node and add it in Heap
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        while (minHeap.size() != 1){
            // remove first two min nodes
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            // combine the two nodes and add them in heap
            Node newNode = new Node('\0', first.cost+ second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.insert(newNode);
        }

        // full tree
        Node fT = minHeap.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(fT, "");
    }

    private void initEncoderDecoder(Node node, String osf) {
        if(node == null) {
            return;
        }
        // leaf node
        if(node.left == null && node.right == null) {
            this.encoder.put(node.data, osf);
            this.decoder.put(osf, node.data);
        }
        initEncoderDecoder(node.left, osf+"0");
        initEncoderDecoder(node.right, osf+"1");
    }

    public String encode(String source) {
        String ans = "";

        // Bitset can be used: like an array but with a bit at each index

        for(int i=0; i<source.length(); i++) {
            ans = ans + encoder.get(source.charAt(i));
        }

        return ans;
    }

    public String decode(String codedString) {
        String key = "";
        String ans = "";
        for(int i=0; i<codedString.length(); i++) {
            key = key + codedString.charAt(i);
            if(decoder.containsKey(key)) {
                ans = ans + decoder.get(key);
                key = "";
            }
        }
        return ans;
    }


}
