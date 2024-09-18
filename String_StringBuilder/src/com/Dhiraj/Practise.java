package com.Dhiraj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Practise {
    public static void main(String[] args) {
        String a = "1010";
        String b  = "1011";

        int aa =  Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        int mul = 1;
        int ans = 0;
        while(aa > 0 || bb > 0){
            ans += (aa%10 + bb%10) *  mul;
            mul = mul * 10;
            aa = aa/10;
            bb = bb/10;
        }

        StringBuilder me = new StringBuilder();
        me.append('f');
        me.append('f');
        me.append('u');
        me.deleteCharAt(1);
        me.deleteCharAt(1);
//        System.out.println(me);
//        System.out.println(removeDuplicates("xxxx"));

        System.out.println(isValid("([{}])()"));

//        System.out.println(reverseWords("Let's take LeetCode contest "));
//        System.out.println(strStr("bhccdfkf", "ck"));
//        System.out.println(numOfStrings(new String [] {"e","ulhjriiikuwwi","odtbmiyiv","iiku","o","nao","ilrbdhfvndjaxohexcynpgocoqorifjngaurokumcqqkirqp","zmt","tuxulhjriiikuwwibjpodtbmiyiv","lhjriiikuwwibjpodtbmiyi","qjnwwkfqhztiyqayiabjjzyqhumh","lhjriiikuwwibjpodtbmiyiv","oyaloibpkqpyubftinknjraptsuqgejucpfigc","fdqvajkfornietcdvxltbktlkg","bcxslqwrjaabvywpynzfojetmnnwrurimjgwl","ncvvyhbznxrxoonfrzfmecfdnrvikffpvrc","gxvzmtuxulhjriiikuwwibjpodtbmiyi","ozuwzgetoddakvjwiwzocpwpiavcyclxhlguhfqtpbk","ktwqukguxobakxvbitkkdemvlmqypd","gxvzmtuxulhjri","xulhjriiiku","sjemhhtbqastmbtbvsfnuygqfypmmi","gqfmyqbjcvuxsjdaeffwthlelb","kuwwibjpodtbmiyivse","ydwiabsimbkdwmsvgp","ixrzoktohtadgblem","uicfykignmptxodjd","kecqujgjynq","sruqpwjevngokrbyi","rijyzrhrygxvzmtuxulhjriii","gsljxjrmkzbwaqdgmwysnblp","arkmbbafkziemddeqripnyjoavmoaxtn","gxhijktottj","ibjpodtbmiyivse","j","qzvmjstehwibuqcqlzdam","ikuwwibjpodt","mnrp","pduagikyudhcvdnqoaadqvvmhluywfsstqnawfmq","vse","iyiv","miyivs","qdfrbkhffkksgtjpnbgvqtrnigbnoacmqkepllouhqpgskpupy","wxbqfmzvmmffwtwjhjpuitcfmknnuwdtamtutiukmpsxzu","odtbmiyi","hrygxvzmtuxulhjriiiku","yzrhrygxvzmtuxu","se","gixgfjtunbltzcwgkrheavilcvektnsizvrrabmysx","hjriiikuwwibj","ahaeorlnaqkk","gvnyr","tynqzmrvdjaznuji","jbwybcttaspwsbieawybfqxsiwxulwkouezkhbauadatb","uwwibjpodt","gxv","zrhrygxvzmtuxulhjriiikuwwib","wivvuywmwchszzctw","lijcroypqr","mrx","m","ygngqghhza","riiikuwwibjpodtbmiyivs","tymtjqykindweexrfztizyagijnxntrcrcy","vse","kntxszudqpmtlrxzspcfivbrwonejzywv","ygxvzmtuxulh","wsnnrijyzrhrygxvzmtuxulhjriiik","zpymedyxskwqddvxlycxvq","qdkm","gxvzmtuxu","snnrijyzrhrygxvzmtuxulhjriiikuwwibjpo","iyivserr","yzrhrygxvzmt","rygxvzmtuxulhjrii","snnrijyzrhrygxvzmtuxul","gxvzmtuxulhjriiikuwwibjpodtbmiyivserr","kuwwibjpodt","ibjpodtbmiy","mtuxulhjriii","zrhrygxvzmtu","qxjvgdyuqt","rygxv","gnwmvzqhrodzqdvdexgupqbzogcpmtfq","oleibiotmojkqexnnlx","dtb","jjividhfhdixcvyduyunoiiipyvi","podtb","jpodtbmiyi","iiku","od","kuwwibjpodtb","b","irugjrzvsfp","wsnnrijyzrhrygxvzmtuxulhjrii","jriiikuwwibjpodtbmi"}, "wsnnrijyzrhrygxvzmtuxulhjriiikuwwibjpodtbmiyivserr"));
//        System.out.println(isSubstring("afab", "aaab"));

//        System.out.println(isLongPressedName("alex", "aaleex"));

//        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));

    }

    // abbaca
    public static String removeDuplicates(String s) {
        if(s.length() <= 1){
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            ans.append(s.charAt(i));
            if (ans.length()>1 && ans.charAt(k-1) == ans.charAt(k) ){
                ans.deleteCharAt(k-1);
                ans.deleteCharAt(k-1);
                k --;
            }else{
                k++;
            }
        }
        return ans.toString();
    }

//    https://leetcode.com/problems/valid-parentheses/submissions/1066155411/
    public static boolean isValid (String s){
        HashMap<Character, Character> hs = new HashMap<>();
        hs.put('(', ')');
        hs.put('[', ']');
        hs.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(hs.containsKey(c)){
                stack.push(c);
            }
            else if(hs.containsValue(c) && !stack.isEmpty() && c == hs.get(stack.peek())){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static char isValidChar (char c){
        switch (c){
            case  ')' :
                return '(';
            case  '}' :
                return '{';
            case  ']' :
                return '[';
            default:
                return '0';
        }
    }

//    https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
    public static int numOfStrings(String [] patterns, String word){
        int count = 0;

        for(String s : patterns){
            if(word.indexOf(s) != -1){
                count ++;
            }
        }
        return count;
    }

    public static boolean isSubstring(String str1, String str2){
        // find if str1 is substring of str2
//            int j=0;
//            int i=0;
//            while (i<str1.length() && j<str2.length()){
//                boolean isPresent = false;
//                while(i<str1.length() && j<str2.length() && str1.charAt(i) == str2.charAt(j)){
//                    i++;
//                    isPresent = true;
//                    j++;
//                    if(i == str1.length()){
//                        return true;
//                    }
//                }
//                i=0;
//                if(!isPresent){
//                    j++;
//                }else {
//                    j--;
//                }
//
//            }
//            return false;

//        return str2.indexOf(str1) == -1 ? false: true;    // if -1 then it is not substring

        return str2.contains(str1);

    }


    public static String reverseString(String s, int i, int j){
        // i is starting index, j is ending index make sure j<s.length()
        StringBuilder builder = new StringBuilder(s);
        while (i<j){
            char temp = builder.charAt(i);
            builder.replace(i, i+1, builder.charAt(j)+"");
            builder.replace(j, j+1, (temp)+"");
            i++;
            j--;
        }
        return builder.toString();
    }

//    https://leetcode.com/problems/reverse-words-in-a-string-iii/
    public static String reverseWords(String s){
        int i=0;
        int j=0;
        StringBuilder builder = new StringBuilder(s);
        while (j< s.length()){
            while(j<s.length() && s.charAt(j) != ' '){
                j++;
            }
            if(j == s.length()){
                break;
            }

            StringBuilder tempBuilder = new StringBuilder( s.substring(i, j));
            String p = tempBuilder.reverse().toString();
            builder.replace(i, j, p);
            i = j+1;
            j++;

        }
        StringBuilder tempBuilder = new StringBuilder( s.substring(i, j));
        String p = tempBuilder.reverse().toString();
        builder.replace(i, j, p);
        return builder.toString();

    }

//    https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
    public static int strStr(String haystack, String needle){
        int j = 0;
        boolean found = false;
        for (int i = 0; i < needle.length() && j<haystack.length(); i++) {
            while( j<haystack.length() && needle.charAt(i) != haystack.charAt(j)){
                j++;
                i=0;
            }
            System.out.println(j);


//            needle.charAt(i) == needle.charAt(j)
        }
        if(j - needle.length() < 0){
            return -1;
        }else{
            return j - needle.length();
        }

    }

    public static boolean isLongPressedName(String name, String typed){
        int i=0;
        int j=0;
//        for name to be valid, all of the chracters of name must be present in typed
        // no need to sort as keys are double press and name and typed must be already sorted in any order, so can go with two pointers
        // pointer of typed must reach at end to be valid
//        while (j<name.length() && i<typed.length()){
//            if(name.charAt(j) == typed.charAt(i)){
//                i++;
//            }else{
//                j++;
//            }
//            if(j== name.length()){
//                return false;
//            }
//            if(i== typed.length()){
//                return true;
//            }
//        }
//        return false;

        if(name.length()> typed.length()){
            return false;
        }

        while (j<typed.length()){
            if(i<name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
            }else if(j==0 || typed.charAt(j) != typed.charAt(j-1)){
                // if first char is not matching return false
                // if character are not matching then then will be long typed
                return false;
            }
            j++;
        }

        return i==name.length();

    }

    public static boolean validPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        boolean isDeleted = false;
        while (i<=j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return helperOfValidPalindrom (s, i+1, j) || helperOfValidPalindrom(s, i, j-1);
            }
        }
        return true;
    }

    public static boolean helperOfValidPalindrom(String s, int i, int j){
        while (i<=j ) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int maxRepeating(String sequence, String word){
        int count = 0;
        int i=0;
        // instead of finding word we will increase word to word+= word so that we can reach to maximum substring
        String wordToFind = word;
        String p;
        while (i<sequence.length()){

            p = sequence.substring((i));
            if(p.indexOf(wordToFind) == -1){
                break;
            }else{
                count ++;
                i = p.indexOf(wordToFind);
                wordToFind += word;

            }
        }

        return count;

    }
}
