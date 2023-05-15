package com.xavierloeraflores.inventorymanagement;
/**
 *
 * @author xavierloeraflores
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCamera;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
public class Main extends Application{
    public static void  sampleData(){
        //Parts
        Part screen = new Outsourced(1, "Screen", 100.0, 20, 1, 20, "LG");
        Part keyboard = new InHouse(2, "Keyboard", 7.50, 150, 1, 3000, 2);
        Part cpu = new Outsourced(3, "CPU", 250.0, 5, 1, 20, "Intel");
        Part psu = new InHouse(4, "Power Supply", 40, 50, 1, 200, 3);

        //Products
        Product laptop = new Product(1, "Laptop", 2000, 20, 1, 30);
        laptop.addAssociatedPart(screen);
        laptop.addAssociatedPart(keyboard);
        laptop.addAssociatedPart(cpu);

        Product desktop = new Product(2, "Desktop", 1000, 3, 1, 10);
        desktop.addAssociatedPart(psu);
        desktop.addAssociatedPart(cpu);

        Product mouse = new Product(3, "Mouse", 5.50, 300, 1, 4000);

        Inventory.addPart(screen);
        Inventory.addPart(keyboard);
        Inventory.addPart(cpu);
        Inventory.addPart(psu);

        Inventory.addProduct(laptop);
        Inventory.addProduct(desktop);
        Inventory.addProduct(mouse);

    }
    public void start(Stage stage) throws Exception{
        Parent mainFXML = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene mainScene = new Scene(mainFXML);
        stage.setTitle("Inventory Management System");
        stage.setScene(mainScene);
        stage.show();
    }
    public static void main(String[] args){
        System.out.println("Inventory Management Application");
        sampleData();

        launch(args);
    }
}

