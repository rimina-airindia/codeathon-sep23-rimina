//Write a program to sort a string according to the frequency of character and return the final string.



import java.util.*;
public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a,Pair b){
                if(a.freq==b.freq){
                    return a.ch-b.ch;
                }
                return b.freq-a.freq;
            }
        });
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(new Pair((char)(i+'a'),freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>0){
            Pair rem = pq.remove();
            for(int i=0;i<rem.freq;i++){
                sb.append(rem.ch);
            }
        }
        System.out.println(sb.toString());
    }
    public static class Pair{
        char ch;
        int freq;
        Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}