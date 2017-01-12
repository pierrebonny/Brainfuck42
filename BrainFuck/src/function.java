import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class function{

   private static int[] tab = new int[30000];
   private static int pointeur = 0;
   private static File fileIn;
   private static BufferedWriter fileOut;

   private static void procIncr(int p){
       tab[pointeur] += 8;
   }

   private static int test2(int p){
       pointeur += 6;
       tab[pointeur] += 2;
       return tab[pointeur];
   }

   private static int test(int p){
       pointeur += 5;
       tab[pointeur] += 4;
       return tab[pointeur];
   }

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
       pointeur += 2;
       tab[pointeur] += 1;
       tab[pointeur] = test(-1);
       pointeur += 1;
       tab[pointeur] += 3;
       pointeur += 2;
       procIncr(-1);
       tab[pointeur] = test2(2);
   }
}