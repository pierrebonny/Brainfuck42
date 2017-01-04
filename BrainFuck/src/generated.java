import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class Main{

   private static int[] tab = new int[30000];
   private static int pointeur = 0;
   private static File fileIn;
   private static BufferedWriter fileOut;

   public static void main(String[] args) throws IOException{
       int nbArgs = args.length;
       int i = 0;
       while (i <= nbArgs - 1) {
            if (args[i].equals("-i")) {
                fileIn = new File(args[i+1]);
            }
            else if (args[i].equals("-o")){
                fileOut = new BufferedWriter(new FileWriter(args[i+1]));
            }
            i++;
       }
       tab[pointeur] += 10;
       while(tab[pointeur] != 0){
           pointeur += 1;
           tab[pointeur] += 7;
       while(tab[pointeur] != 0){
           if (fileOut == null){
               System.out.print((char)tab[pointeur]);
           }
           else{
               fileOut.write((char)tab[pointeur]);
           }
       }
       pointeur += 1;
       tab[pointeur] += 10;
       pointeur += 1;
       tab[pointeur] += 3;
       pointeur += 1;
       tab[pointeur] += 1;
       pointeur -= 4;
       tab[pointeur] -= 1;
       }
       pointeur += 1;
       tab[pointeur] += 2;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       pointeur += 1;
       tab[pointeur] += 1;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       tab[pointeur] += 7;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       tab[pointeur] += 3;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       pointeur += 1;
       tab[pointeur] += 2;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       pointeur -= 2;
       tab[pointeur] += 15;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       pointeur += 1;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       tab[pointeur] += 3;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       tab[pointeur] -= 6;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       tab[pointeur] -= 8;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       pointeur += 1;
       tab[pointeur] += 1;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
       pointeur += 1;
       if (fileOut == null){
           System.out.print((char)tab[pointeur]);
       }
       else{
           fileOut.write((char)tab[pointeur]);
       }
   }
}