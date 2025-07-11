import java.util.Scanner;
import java.awt.*;
import java.net.URI;
import javax.swing.*;

// Student Name: Julho César Moreira de Oliveira 
// Student Id: 72396 
// Student Email: 72396@student.dorset-college.ie


public class BloodTypeCon
 {
    public static void main(String[] args) {

        // Define arrays of blood types and their compatibilities
        String[] bloodTypes = {"A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-", "a+", "o+", "b+", "ab+", "a-", "o-", "b-", "ab-"};
        String[][] compatibility = {
            {"A+", "AB+"},
            {"O+", "A+", "B+", "AB+"},
            {"B+", "AB+"},
            {"AB+"},
            {"A+", "A-", "AB+", "AB-"},
            {"O+", "O-", "A-", "B-", "AB-"},
            {"B+", "B-", "AB+", "AB-"},
            {"AB-", "A-", "B-", "O-"},

            { "a+", "ab+"},
            { "o+", "a+", "b+","ab+"},
            {"b+","ab+",},
            {"ab+"},
            {"a+", "a-", "ab+", "ab-"},
            {"o+","o-","a-","b-","ab-"},
            {"b+", "b-", "ab+", "ab-"},
            {"ab-","a-","b-","o-"},
        };

        Scanner input = new Scanner(System.in);

        // Set the minimum size of the JOptionPane pane
        UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));


        // Display a message to the user
        JOptionPane.showMessageDialog(null,"Hello, how are you? \n\n\n I AM A BLOOD TYPE COMPATIBILITY SYSTEM.\n Here I have all the information about blood type.\n How can I help you?\n\n If you want to know more, follow the instructions!");
        
        // Ask the user for their first name
        String name = JOptionPane.showInputDialog("What is your first name? ");
        // Ask the user for their last name
        String Lname = JOptionPane.showInputDialog("What is your last name? ");

        
        // Display a message to the user to see blood types
        JOptionPane.showMessageDialog(null,"Please, provide blood type (A+, O+, B+, AB+, A-, O-, B-, AB-):");

        //Ask the user for their blood type
        String bloodType = JOptionPane.showInputDialog("Please, provide blood type (A+, O+, B+, AB+, A-, O-, B-, AB-):");

        
        //// Check if the provided blood type is valid
        while (!isValidBloodType(bloodType, bloodTypes)) {
            JOptionPane.showMessageDialog(null,"Blood type code doesn’t exist, please try again!");

            bloodType = JOptionPane.showInputDialog("Please, provide blood type:");
           
        }

        // Ask the user if they want to know about giving or receiving
        JOptionPane.showMessageDialog(null,"Do you want to know about giving or receiving (1 >> for Gives and 2 >> for Receives):");
            
        int optionBlood = Integer.parseInt(JOptionPane.showInputDialog("  "));

        
        
        // Check if the provided option is valid
        while (optionBlood != 1 && optionBlood != 2) {
            JOptionPane.showMessageDialog(null,"Choice doesn't exist, please try again!");
            
             optionBlood = Integer.parseInt(JOptionPane.showInputDialog("  "));

        }

        // Print the result give or receive
        if (optionBlood == 1) {
            int index = getIndex(bloodType, bloodTypes);
            JOptionPane.showMessageDialog(null,"Hello " + name +" " + Lname + " !" +  "\n The blood type for  '" +  bloodType  +  "'  to give are:  '" + String.join(", ", compatibility[index]));


        } else {
            int index = getIndex(bloodType, bloodTypes);
            JOptionPane.showMessageDialog(null,"Hello " + name +" " + Lname + "! " +" The blood type for  "  +  bloodType  +  "'  to receive are:  '" + String.join(", ", compatibility[index]));

            
        }


        // Ask if the user wants to learn about blood types
        int confir = JOptionPane.showConfirmDialog(null,name + Lname + ", WOULD LIKE TO LEARN ABOUT BLOODY TYPE? " );

        // If the user wants to learn about blood types, open the link
        if(confir == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Welcome " + name + " INFORMARTION CHANGES LIVES!");
            try{
                URI link = new URI("www.redcrossblood.org/donate-blood/blood-types.html");
                Desktop.getDesktop().browse(link);
            }catch(Exception erro){
                    System.out.println(erro);
                }
        }




        input.close();
    }

    //function to check if the blood type is valid
    public static boolean isValidBloodType(String bloodType, String[] bloodTypes) {
        for (String type : bloodTypes) {
            if (type.equals(bloodType)) {
                return true;
            }
        }
        return false;
    }

    //function to get the index of the blood type in the array
    public static int getIndex(String bloodType, String[] bloodTypes) {
        for (int i = 0; i < bloodTypes.length; i++) {
            if (bloodTypes[i].equals(bloodType)) {
                return i;
            }
        }
        return -1;
    }

    
}
