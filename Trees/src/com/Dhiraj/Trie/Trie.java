package com.Dhiraj.Trie;
import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
        System.out.println("Trie created");
    }

    // time and space will be O(N)
    public void insert(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            // move poiner to next character
            current = node;
        }
        current.endOfString = true;
        System.out.println("Inserted " + word);
    }


    // time will be O(N) & space will be O(1)
    public boolean search(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return current.endOfString;
    }


    
    private boolean delete(TrieNode parentNode, String word, int index){
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisBeDelted;

        // 1. some other prefix of a string is same as the one that we want to delete (API, APPLE)
        if(currentNode.children.size() > 1){
            delete(currentNode, word, index+1);
            return false;
        }

        // 2. the string is prefix of another string (API, APIS)
        if(index == word.length()-1){
            if(currentNode.children.size() >=1){
                currentNode.endOfString = false;
                return false;
            }else{
                parentNode.children.remove(ch);
                return true;
            }

        }

        // 3. other sring is prefix of this string (API, AP)
        if(currentNode.endOfString == true){
            delete(currentNode, word, index+1);
            return false;
        }

        // 4. not any node dependent on this string(API)
        canThisBeDelted = delete(currentNode, word, index+1);
        if(canThisBeDelted == true){
            parentNode.children.remove(ch);
            return true;
        }else{
            return false;
        }


    }

    public void delete(String word){
        if(search(word)){
            delete(this.root, word, 0);
        }
    }


    
}















