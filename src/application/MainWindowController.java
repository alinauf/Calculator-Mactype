package application;


import java.text.DecimalFormat;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainWindowController {

	private Main main;
	private Stage window;
	
	private Boolean[]operator= new Boolean[4];
	private double[]temporary = {0,0};
	
	private DecimalFormat df = new DecimalFormat("###.######");

	@FXML private Label display;
	@FXML private Button ac, conversion;
	
	
	
	
	
	public void setMain(Main main,Stage primaryStage){
		this.main=main;
		this.window=primaryStage;
		
		for (int i = 0; i < operator.length; i++) {
			operator[i]=false; // TO ensure all booleans are false when started
		}
		
	}
	
	
	public void result(){
		double result =0;
		temporary[1]=Double.parseDouble(display.getText()); // TO save value in temp[0]

		if (operator[0]) {
			result = temporary[0] + temporary[1];
		}
		else if(operator[1]){
			result = temporary[0] - temporary[1];
		}
		else if(operator[2]){
			result = temporary[0] * temporary[1];
		}
		else if(operator[3]){
			result = temporary[0] / temporary[1];
		}
		display.setText(df.format(result));

	}
	
	public void buttonPressed(Event event){
		Button btn = (Button)event.getSource(); //To get source
		
		if(display.getText().equals("0")){		
			ac.setText("C");
			display.setText("");
		}
		
		switch (btn.getId()) {
		case "one":
			display.setText(display.getText()+"1");
			break;
		case "two":
			display.setText(display.getText()+"2");
			break;
		
		case "three":
			display.setText(display.getText()+"3");
			break;
		case "four":
			display.setText(display.getText()+"4");
			break;
		case "five":
			display.setText(display.getText()+"5");
			break;
		case "six":
			display.setText(display.getText()+"6");
			break;
		case "seven":
			display.setText(display.getText()+"7");
			break;
		case "eight":
			display.setText(display.getText()+"8");
			break;
		case "nine":
			display.setText(display.getText()+"9");
			break;
		case "zero":
			display.setText(display.getText()+"0");
			break;
		case "comma":
			display.setText(display.getText()+",");
			break;

		default:
			break;
		}
		
	}
	
	@FXML
	public void operatorPressed(Event event){
		
		temporary[0]=Double.parseDouble(display.getText()); // TO save value in temp[0]
		
		Button btn = (Button)event.getSource(); //To get source
		
		switch (btn.getId()) {
		case "plus":
				operator[0]=true;
				System.out.println("plus");
			break;
		case "minus":
			operator[1]=true;
			System.out.println(display.getText()+"minus");
			break;
		
		case "times":
			operator[2]=true;
			System.out.println(display.getText()+"times");
			break;
		case "divide":
			operator[3]=true;
			System.out.println("divide");
			break;
			
		default:
			break;
			
		}
		display.setText("");

		
	}
	
	public void delete(){
		display.setText("0");
		for (int i = 0; i < operator.length; i++) {
			operator[i]=false; // TO ensure all booleans are false when deleted
		}
		
		for (int i = 0; i < temporary.length; i++) {
			temporary[i]=0; // TO ensure all temp entries are zero when deleted
		}
		
	}
	
	public void conversion(){
		if(!display.getText().equals("0")){		

		
		
		Double value = Double.parseDouble(display.getText());
		
		value*= -1;
		display.setText(df.format(value));
		}
	}
	
	public void percent(){
		
		Double value = Double.parseDouble(display.getText());
		
		value*=0.01;
		display.setText(df.format(value));

	}
	
	
}
