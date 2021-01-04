package simplesigninwithcsv;

import java.io.BufferedReader;
import java.io.IOException;   
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 *
 * @author josh26zx
 */
public class SimpleSignInWithCSV {

       public static void main(String[] args) throws FileNotFoundException, IOException {
        //First Read Customer.csv with BufferedReader
         BufferedReader file = new BufferedReader(new FileReader("Account.csv"));
                //Declare Scanner input to receive input from user
		Scanner input = new Scanner(System.in);
		// Declare flag to identify whether the credentials entered matches with the credentials in Customer.csv file
		boolean flag = false;
                // Declare String array with index of 2 to store input from user
                String [] credentials = new String[2];
                //Prompt 
		System.out.println ("Sign in: ");
		System.out.print ("Enter your name: ");
                //The input will be stored as the first item in the credentials array 
		credentials[0] = input.nextLine();
			
		System.out.print ("Enter your password: ");
                //The input will be stored as the second item in the credentials array 
		credentials[1] = input.nextLine();
		// s is declared & reading the first line in the Customer.csv file
                String s = file.readLine();
                while(s!= null){
                        // Checking the credentials enter by thee user with the first line of credentials in Customer.csv
			if(s.equals(credentials[0]+","+credentials[1])) {
                            /* If the crdentials are matched with the one in Customer.csv, the flag will be assigned with to true and 
                            a message will be printed in the next line signalling succesful sign in by the user followed by the halt of the loop*/
				flag = true;
                                System.out.println ("Signed in successfully");
                                break;
			}
                        else{
                          // Variable s will read and check the next line in Customer.csv file and set flag to false
                            s= file.readLine();
                            flag = false;
                        }
	          
		}
                // Close the first BufferedReader of the Customer.csv
                 file.close();
                 //Infinite tries to sign in if the credentials does not match with the crdentials in Customer.csv
                 	while(flag == false){     
                        //Reopen the Customer.csv file
                        BufferedReader br = new BufferedReader(new FileReader("Account.csv"));
                        //Prompt input from user 
			System.out.println ("Incorrect name or password");
			System.out.println ("Try again");
                        System.out.print ("Enter your name: ");
                        credentials[0] = input.nextLine();
                        System.out.print ("Enter your password: ");
                        credentials[1] = input.nextLine();
                        
                       String read = br.readLine();
                        while(read!= null){    
			if(read.equals(credentials[0]+","+credentials[1])) {		
				flag = true;
                                System.out.println ("Signed in successfully");
                                break;
			}
                        else{
                           read = br.readLine();
                           flag = false;
                        }

		}
                // The next BufferedReader will be closed
                br.close();  
                } 
                     
                
               
                
    }
    
}
