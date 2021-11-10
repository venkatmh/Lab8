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
    if (ae.getActionCommand().equals("Guess")){
      int guess = Integer.parseInt(field.getText());
      lastGuessLabel.setText("Last guess was: " + guess); 
      if(guess < random) {
      highLowLabel.setText("Guess higher!");
      }
      else if(guess > random) {
      highLowLabel.setText("Guess lower!");
      }
      else if(guess == random){
        highLowLabel.setText("You got it!");
      }
    }
    else if(ae.getActionCommand().equals("Play Again")){
      random = r.nextInt(100) + 1;
      highLowLabel.setText("");
      lastGuessLabel.setText("");
      field.setText("");
    }
    else{
      highLowLabel.setText("You pressed Enter. Please press the Guess Button");
    }
  }
}