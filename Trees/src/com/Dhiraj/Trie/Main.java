package com.Dhiraj.Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("API");
        trie.insert("APIS");
        System.out.println("API exist "+ trie.search("API"));
        System.out.println(trie.search("APIS"));
        System.out.println(trie.search("AP"));
        trie.delete("API");
        System.out.println("API exist "+ trie.search("API"));
    }
    
}
