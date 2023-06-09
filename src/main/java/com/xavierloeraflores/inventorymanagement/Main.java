package com.xavierloeraflores.inventorymanagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

/**
 * Main class which starts the application
 * @author xavierloeraflores
 */
public class Main extends Application{
    /**
     * This functions adds sample data to the application so that it can be populated with data.
     */
    public static void  sampleData(){
        //Parts
        Part screen = new Outsourced(0, "Screen", 100.0, 20, 1, 20, "LG");
        Part keyboard = new InHouse(1, "Keyboard", 7.50, 150, 1, 3000, 2);
        Part cpu = new Outsourced(2, "CPU", 250.0, 5, 1, 20, "Intel");
        Part psu = new InHouse(3, "Power Supply", 40, 50, 1, 200, 3);

        //Products
        Product laptop = new Product(0, "Laptop", 2000, 20, 1, 30);
        laptop.addAssociatedPart(screen);
        laptop.addAssociatedPart(keyboard);
        laptop.addAssociatedPart(cpu);

        Product desktop = new Product(1, "Desktop", 1000, 3, 1, 10);
        desktop.addAssociatedPart(psu);
        desktop.addAssociatedPart(cpu);

        Product mouse = new Product(2, "Mouse", 5.50, 300, 1, 4000);

        Inventory.addPart(screen);
        Inventory.addPart(keyboard);
        Inventory.addPart(cpu);
        Inventory.addPart(psu);

        Inventory.addProduct(laptop);
        Inventory.addProduct(desktop);
        Inventory.addProduct(mouse);

    }
    /**
     * Displays the Main.FXML screen to start the application
     */
    public void start(Stage stage) throws Exception{
        Parent mainFXML = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene mainScene = new Scene(mainFXML);
        stage.setTitle("Inventory Management System");
        stage.setScene(mainScene);
        stage.show();
    }
    /**
     * Main function of the main class which starts the application.
     * It can also populate the inventory with data by calling the sampleData() function.
     */
    public static void main(String[] args){
        System.out.println("Inventory Management Application");
        sampleData();
        launch(args);
    }
}

