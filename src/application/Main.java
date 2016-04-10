
package application;
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	private Stage window;
	
	@Override
	
	public void start(Stage primaryStage) {
		this.window = primaryStage; //To Set The Stage
		mainWindow(); // To call main window
		}
	
	public void mainWindow(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/application/MainWindowView.fxml"));//TO connect with the view
			AnchorPane pane = loader.load();
			
			MainWindowController mainWindowController = loader.getController(); //The fxml will connect to controller
			mainWindowController.setMain(this,this.window);
			
			Scene scene = new Scene(pane);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	
			//window.setFullScreen(true);
			window.setResizable(false);
			window.setScene(scene);
			window.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			e.getCause();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}