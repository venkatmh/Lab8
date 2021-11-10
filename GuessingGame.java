import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionListener;

public class GuessingGame implements ActionListener {
  //text field
  JTextField field; 
  
  //2 buttons
  JButton guess;
  JButton playAgain;

  //3 labels
  JLabel enterGuessLabel;
  JLabel highLowLabel;
  JLabel lastGuessLabel;

  //Random number
  Random r = new Random();

  //random int 
  int random = 0;

  GuessingGame(){
    random = r.nextInt(100) + 1;

    //GuessGame Frame
    JFrame frame = new JFrame("Guessing Game"); 

    //Layout
    frame.setLayout(new FlowLayout()); 

    //Size 
    frame.setSize(240, 120);

    //Text field 
    field = new JTextField(10); 
    field.setActionCommand("myTF"); 

    //Buttons
    guess = new JButton("Guess"); 
    playAgain = new JButton("Play Again");

    //Action listeners
    field.addActionListener(this); 
    guess.addActionListener(this); 
    playAgain.addActionListener(this); 

    //Labels
    enterGuessLabel = new JLabel("Enter your guess: "); 
    highLowLabel = new JLabel("");
    lastGuessLabel = new JLabel("");

    //Add to frame
    frame.add(enterGuessLabel); 
    frame.add(field); 
    frame.add(guess); 
    frame.add(highLowLabel);
    frame.add(lastGuessLabel);
    frame.add(playAgain); 

    // Display the frame. 
    frame.setVisible(true); 

  }

  public void actionPerformed(ActionEvent ae) { 
    if(ae.getActionCommand().equals("Guess")) { 
      
      String guess = enterGuessLabel.getText();
      int guess1 = 0;
      if(guess != ""){
        guess1 = Integer.parseInt(guess);
      }
      //Integer.parseInt(enterGuessLabel.getText());
      if(guess1 < random){
        highLowLabel.setText("Too low!");
      }else if(guess1 > random){
        highLowLabel.setText("Too high!");
      }else{
        highLowLabel.setText("You got it!");
      }
    }else if(ae.getActionCommand().equals("Play Again")){
      random = r.nextInt(100) + 1;

      enterGuessLabel.setText("Enter your guess: "); 
      highLowLabel.setText("");
      lastGuessLabel.setText("");
      field.setText("");
    }else if(ae.getActionCommand().equals("")){
      highLowLabel.setText("You pressed Enter. Please press the Guess Button.");
    }
  }

}