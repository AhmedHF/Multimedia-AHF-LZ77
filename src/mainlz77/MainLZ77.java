/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlz77;

import java.util.Scanner;

/**
 *
 * @author Ahmed Hassan
 */
public class MainLZ77 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Expreetion : ");
        String str = input.next();
        lzGUI gui=new lzGUI();
        
        LZ77 lz = new LZ77();
        System.out.println(" "+ lz.Compress(str));
        System.out.println(" "+lz.DeCompress());
    }

}
