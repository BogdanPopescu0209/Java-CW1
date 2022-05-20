package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        String fileLocation = System.getProperty("user.dir");

        String encrypted = fileLocation + File.separator + "datafile.txt";

        String decrypted = fileLocation + File.separator + "result.txt";

        File fileEncrypted = new File(encrypted);

        File fileDecrypted = new File(decrypted);

        Scanner input = null;

        PrintWriter output = null;

        try {

            input = new Scanner(fileEncrypted);

            output = new PrintWriter(fileDecrypted);

            while (input.hasNextLine()) {

                String encryptedTxt = input.nextLine().trim();

                //Vowels
                String[] encryptedV = {"V12", "V11", "V10", "V9", "V8", "V7", "V6", "V5", "V4", "V3", "V2", "V1"};
                String[] vowels = {"Y", "y", "U", "u", "O", "o", "I", "i", "E", "e", "A", "a"};
                
                //Check text and replace the encrypted letters with the corresponding vowels
                for(int i = 0; i < vowels.length; i += 1){
                    encryptedTxt = encryptedTxt.replace(encryptedV[i], vowels[i]);
                }
                
                //Consonants
                String[] encryptedC = {"C40", "C39", "C38", "C37", "C36", "C35", "C34", "C33", "C32", "C31", "C30", "C29", "C28", "C27", "C26", "C25", "C24", "C23", "C22", "C21", "C20", "C19", "C18", "C17", "C16", "C15", "C14", "C13", "C12", "C11", "C10", "C9", "C8", "C7", "C6", "C5", "C4", "C3", "C2", "C1"};
                String[] consonants = {"Z", "z", "X", "x", "W", "w", "V", "v", "T", "t", "S", "s", "R", "r", "Q", "q", "P", "p", "N", "n", "M", "m", "L", "l", "K", "k", "J", "j", "H", "h", "G", "g", "F", "f", "D", "d", "C", "c", "B", "b"};
                
                //Check text and replace the encrypted letters with the corresponding consonants
                for(int i = 0; i < consonants.length; i += 1){
                    encryptedTxt = encryptedTxt.replace(encryptedC[i], consonants[i]);
                }
                
                //Output in console decrypted text
                System.out.println(encryptedTxt);
                
                //Ouput in result.txt decrypted text
                output.println(encryptedTxt);

            }

        } catch (FileNotFoundException FNF) {

            System.out.println("File not found!");
            System.exit(0);

        } finally {

            input.close();
            output.close();
        }

    }

}
