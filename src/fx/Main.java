package fx;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import lolbase.LoLBase;

/**
 * Default JavaFX class for creating primary window
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			final FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
			final BorderPane root = (BorderPane)loader.load();
			
			LoLBase lolbase = new LoLBase();
			final ViewController controller = (ViewController)loader.getController();
			controller.setLoLBase(lolbase);
			lolbase.readAll();
			controller.updateListViewChampions(lolbase.getChampionList());
			
			//BorderPane OLD = (BorderPane)FXMLLoader.load(getClass().getResource("View.fxml"));
			final Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("LoLBase");
			
			primaryStage.show();
			primaryStage.getIcons().add(new Image(getClass().getResource("/Images/Temu.png").toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {	
		launch(args);
	}
}
