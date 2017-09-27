/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlz77;

import java.util.ArrayList;

/**
 *
 * @author Ahmed Hassan
 */
public class LZ77 {

    private int pointer;
    private int length;
    private char nextchar;
    public ArrayList<String> list = new ArrayList();

    public LZ77() {
        this.pointer = 0;
        this.length = 0;
        this.nextchar = ' ';
    }

    public String Compress(String str) {
        String check = " ", cut;
        int store = 0, count = 1;
        char ch = str.charAt(0);
        list.add("<0,0," + ch + ">");
        for (int i = 1; i < str.length(); i++) {
            ch = str.charAt(i);
            check += ch;
            cut = str.substring(0, count);
            int firstmatch = cut.lastIndexOf(check);
            if (firstmatch >= 0) { 
                store = firstmatch;
                this.length++;
                if (i == str.length() - 1) {//aba
                    this.pointer = i - (length - 1) - firstmatch;
                    list.add("<" + pointer + "," + length + "," + "Null" + ">");
                }
            } else {
                if (this.length == 0) {//first occurance for character
                    list.add("<0,0," + ch + ">");
                    check = "";
                    count++;//  last index  of string that search in it
                } else if (this.length > 0) {
                    this.pointer = i - length - store;
                    list.add("<" + pointer + "," + length + "," + ch + ">");
                    check = "";
                    length = 0;
                    count = i + 1;
                }
            }
        }
        String strg = "";
        for (String ss : list) {
            //System.out.println(ss);
            strg += ss;
        }
        return strg;
    }

    public String DeCompress() {
        String show = "";
        for (String ss : list) {
            char c = ss.charAt(1);
            if (c == '0') {
                c = ss.charAt(5);
                show += c;
            } else {
                int x = c - 48;
                char z = ss.charAt(2);
                if (z == ',') {
                    z = ss.charAt(3);
                    int len = show.length() - x;
                    x = z - 48;
                    while (x > 0) {
                        c = show.charAt(len);
                        show += c;
                        len++;
                        x--;
                    }
                    char ch;
                    ch = ss.charAt(5);
                    if (ch == 'N') {
                        break;
                    }
                    show += ch;
                } else {
                    int y = 0, f = 0;
                    f = c - 48;
                    f = f * 10;
                    y = z - 48;
                    x = f + y;
                    int len1 = show.length() - x;
                    c = ss.charAt(4);
                    x = c - 48;
                    while (x > 0) {
                        c = show.charAt(len1);
                        show += c;
                        len1++;
                        x--;
                    }
                    char ch;
                    ch = ss.charAt(6);
                    if (ch == 'N') {
                        break;
                    }
                    show += ch;
                }
            }//abaababaabbbbbbbbbbbba
        }
        return show;
    }

}
