import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class empty{

   private static int[] tab = new int[30000];
   private static int pointeur = 0;
   private static File fileIn;
   private static BufferedWriter fileOut;

   private static void hello(int p){
       while(tab[pointeur] != 0){
           pointeur += 1;
           tab[pointeur] += 7;
           pointeur += 1;
           tab[pointeur] += 10;
           pointeur += 1;
           tab[pointeur] += 3;
           pointeur += 1;
           tab[pointeur] += 1;
           pointeur -= 4;
           tab[pointeur] -= 1;
       }
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
   }
}