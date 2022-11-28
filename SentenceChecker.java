package Code;
import java.util.Scanner;

public class SentenceChecker{
    public static void main(String args[])
    {
    //New Scanner to receive the string from the user
    Scanner string_input = new Scanner(System.in);
    System.out.println("Please enter a sentence to be tested ");
    String sentence = string_input.nextLine();

    //Run the method to check if the string is valid and output whether it has returned true or not
    if (isSentence(sentence) == true){
        System.out.println("That is a valid sentence");
    }
    else{System.out.println("That is not a valid sentence");}
    string_input.close();
    }

    public static Boolean isSentence(String sentence){
        //declaration of variables that will be used throughout the code
        int quotationcount = 0;
        char nextletter = 0;
       //for loop to loop through the string and check every letter 
        for (int i = 0; i < sentence.length(); i++){  
            //making a letter of type character equal to the position in the string
            char letter = sentence.charAt(i);
            //checks that the string isn't null
            if(sentence.isEmpty() || sentence == null) {return false;}
            //stores the next letter if it isn't at the final character
            if (i != sentence.length()-1) {nextletter = sentence.charAt(i+1);}
            //nested if statement to check if the first letter is a capital
            if(i == 0){
                if(!Character.isUpperCase(letter)){return false;}             
            }
            
            //checks if the character is a quotation mark and if so adds one to the count
            if (letter =='"') { quotationcount +=1;}
            //checks if the number of quotation marks is even or odd
            if(quotationcount % 2 != 0) {return false;}
            //checks if the character is the last position and if so checks if it is equal to ".","?","!"
            if(i == sentence.length()) {
            	if(letter != '.' || letter!='?' || letter!= '!') {return false;}
            }
            //else statement checks if the character is not the last character but still equals a period
            else {if(i == '.') {return false;} }
            
            //checks if the character is below 13 and not spelled out
            if (Character.isDigit(letter)) {
            	//converts the character to a number
            	int num = Character.getNumericValue(letter);
            	//if the value of the number is one, system checks the value of the next number
            	if(num == 1) {
            		if(Character.isDigit(nextletter)) {
                    	//converts the character to a number
                    	int num2 = Character.getNumericValue(nextletter);
                    	if(num2 >= 0 && num2 <= 2) {
                    		return false;
                    	}
            		}
                	else if (num > 1 && num <= 9) {
                		return false;
                	}
            	}
            }
        }
        //returns true as the default value if the function successfully leaves the loop
        return true;
    }

}
