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
			/*
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("View.fxml"));
			final ViewController viewCtrl = (ViewController)root.getController();
			Scene scene = new Scene(root, 1000, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			*/
			final FXMLLoader ldr = new FXMLLoader(getClass().getResource("View.fxml"));
			final BorderPane root = (BorderPane)ldr.load();
			//final ViewController kerhoCtrl = (ViewController)ldr.getController();
			final Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("LoLBase");
			
			/*
			primaryStage.setOnCloseRequest((event) -> {
				if ( !kerhoCtrl.voikoSulkea() ) event.consume();
			});
			*/
			
			LoLBase lolbase = new LoLBase();
			//kerhoCtrl.setKerho(kerho);
			
			/*
			 	Application.Parameters params = getParameters();
43	            if ( params.getRaw().size() > 0 )
44	                kerhoCtrl.lueTiedosto(params.getRaw().get(0));
45	            else
46	                if ( !kerhoCtrl.avaa() ) Platform.exit();
			 */
			primaryStage.show();
			primaryStage.getIcons().add(new Image(getClass().getResource("Images/Temu.png").toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {	
		launch(args);
	}
}
