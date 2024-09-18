package com.Dhiraj;

public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);
        }
        System.out.println(builder.toString()); // already toString() is applied hence the blur
        // note .toString() feature only avaible in intellij it won't be automatically
        // set to other id's like online compiler leetcode or hackerrank etc

        builder.deleteCharAt(0);
        System.out.println(builder);

        System.out.println(builder.indexOf("c"));
        ;

        builder.reverse();
        System.out.println(builder);

        String s = "Arindham";
        StringBuilder builder2 = new StringBuilder();

        builder2.append(s);
        // replaces the string
        builder2.replace(1, 2, "T");

        // length of the builder increases with insert method
        builder2.insert(0, "a");

        // clear the builder i.e. remove ALL character from the builder

        int co = ' ';
        System.out.println(co);

    }
}
