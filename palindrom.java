/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrom;

/**
 *
 * @author Nik
 */
public class Palindrom {
    
    
    public static String findPalindrom(String input){
        String max = "";
        int start = 0;
        int i1 = 0;
        int j1 = input.length() - 1;
        String tmpl = "";
        String tmpr = "";
        char x;
        for (int i = i1; i < input.length(); i++) {
            x = input.charAt(i);
            for (int j = j1; j > i; j--) {
                if (x == input.charAt(j)) {
                    tmpl += x;
                    tmpr += x;
                    j1 = j - 1;
                    break;
                }
                if (x != input.charAt(j)) {
                    tmpr = "";
                    tmpl = "";
                    i = i1;
                    j1 = j;
                    x = input.charAt(i);
                    continue;
                }
            }
            if (j1 == i || j1 == i + 1) {
                if (tmpl.length() > 0 && tmpl.length()*2 >= max.length()) {
                    if (j1 == i + 1) {
                        max = tmpl + input.charAt(i + 1) + new StringBuilder(tmpr).reverse().toString();
                    }
                    else if (j1 == i) {
                        max = tmpl + new StringBuilder(tmpr).reverse().toString();
                    }
                    tmpl = "";
                    tmpr = "";
                }
                i1++;
                j1 = input.length() - 1;
            }
        }
        return max;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "1221KabxbaO1221";
        System.out.println(findPalindrom(input));
    }
    
}
