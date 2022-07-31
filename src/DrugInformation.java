import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class DrugInformation {

    String [] malariaDrugInfos = {"artemether / lumefantrine", "9.7", "Coartem", "9.7", "chloroquine", "10", "mefloquine", "2.8"};
    String [] typhoidDrugInfos = {"ciprofloxacin", "9.5", "ceftriaxone", "9.0", "azithromycin", "10", "Cipro", "9.0"};
    String [] feverDrugInfos = {"Paracetamol", "7.8", "acetaminophen", "7.8", "Tylenol", "6.8", "ibuprofenibuprofen", "9.6"};
    String [] unavailableDrugInfos = {"Unavailable", "None"};

    void drugSearch(){

        // Create Frame for the entire page
        JFrame pageFrame = new JFrame();
        pageFrame.setSize(800, 1000);
        pageFrame.setLayout(new GridLayout(3, 1));

        // Label
        JLabel label = new JLabel("Search Any Illeness(e.g malaria, typhoid, fever): ");
        pageFrame.add(label);

        // Input
        JTextField search = new JTextField();
        pageFrame.add(search);

        // Submission Button
        JButton button = new JButton("search for drugs");
        pageFrame.add(button);

        // Make frame visible
        pageFrame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageFrame.setVisible(false);

                // Check what the user searched for to know information to display
                if (search.getText().equals("malaria")){
                    drugInformation(malariaDrugInfos);
                } else if (search.getText().equals("typhoid")) {
                    drugInformation(typhoidDrugInfos);
                } else if (search.getText().equals("fever")) {
                    drugInformation(feverDrugInfos);
                } else {
                    drugInformation(unavailableDrugInfos);
                }
            }
        });

    }

    void drugInformation(String [] drugArray){
        // Another frame
        JFrame infoFrame = new JFrame();
        infoFrame.setSize(800, 1000);
        infoFrame.setLayout(new GridLayout(7, 2));

        // Label: Drugs & Ratings
        JLabel labelForDrugs = new JLabel("Drugs");
        JLabel labelForRatings = new JLabel("Ratings");
        infoFrame.add(labelForDrugs);
        infoFrame.add(labelForRatings);

        // Set Frame Visible
        infoFrame.setVisible(true);

        for (int i = 0; i < drugArray.length; i++) {
            String text = drugArray[i];

            // Create Buttons
            JButton button = new JButton(text);
            infoFrame.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        FileWriter file = new FileWriter("cart.txt");

                        // write if length of text is greater than 3
                        file.write("You are intrested in the drug: " + text);

                        file.close();
                    } catch (Exception u) {

                    }
                }
            });
        }

        // Close
        JButton close = new JButton();
        infoFrame.add(close);
    }


}
