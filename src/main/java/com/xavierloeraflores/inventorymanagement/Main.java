package com.xavierloeraflores.inventorymanagement;
/**
 *
 * @author xavierloeraflores
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
public class Main extends Application{
    public void start(Stage stage) throws Exception{
        Parent mainFXML = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene mainScene = new Scene(mainFXML);
        stage.setTitle("Inventory Management System");
        stage.setScene(mainScene);
        stage.show();
    }
    public static void main(String[] args){
        System.out.println("Inventory Management Application");
        launch(args);
    }
}

