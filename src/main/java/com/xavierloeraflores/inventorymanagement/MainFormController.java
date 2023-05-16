package com.xavierloeraflores.inventorymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;

import javafx.event.ActionEvent;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Modality;

import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.Optional;



/**
 * Controller class for the Main.fmxl form.
 * Implements Initializable
 * @author xavierloeraflores
 */
public class MainFormController implements Initializable{
    /**
     * The [tablePart] which displays Inventory Parts.
     */
    @FXML
    private TableView<Part>  tablePart;

    /**
     * The [columnPartId] which displays Inventory Parts' Id.
     */
    @FXML
    private TableColumn<Part, Integer> columnPartId;

    /**
     * The [columnPartName] which displays Inventory Parts' Name.
     */
    @FXML
    private TableColumn<Part, String> columnPartName;

    /**
     * The [columnPartStock] which displays Inventory Parts' Stock.
     */
    @FXML
    private TableColumn<Part, Integer> columnPartStock;

    /**
     * The [columnPartPrice] which displays Inventory Parts' Price.
     */
    @FXML
    private TableColumn<Part, Double> columnPartPrice;

    /**
     * The [fieldSearchPart] takes in input from the user for searching for parts.
     */
    @FXML
    private TextField fieldSearchPart;


    /**
     * The [columnProductId] which displays Inventory Products' Id.
     */
    @FXML
    private TableView<Product>  tableProduct;

    /**
     * The [columnProductId] which displays Inventory Products' Id.
     */
    @FXML
    private TableColumn<Part, Integer> columnProductId;

    /**
     * The [columnProductName] which displays Inventory Products' Name.
     */
    @FXML
    private TableColumn<Part, String> columnProductName;

    /**
     * The [columnProductStock] which displays Inventory Products' Stock.
     */
    @FXML
    private TableColumn<Part, Integer> columnProductStock;

    /**
     * The [columnProductPrice] which displays Inventory Products' Price.
     */
    @FXML
    private TableColumn<Part, Double> columnProductPrice;

    /**
     * The [fieldSearchProduct] takes in input from the user for searching for products.
     */
    @FXML
    private TextField fieldSearchProduct;


    /**
     * The [selectedPart] which will be modified by the user.
     */
    static private Part selectedPart;

    /**
     * The [selectedProduct] which will be modified by the user.
     */
    static private Product selectedProduct;

    /**
     * Returns the selectedPart, so it can be accessed on the modification screen.
     * @return [Product] the selectedPart to be modified
     */
    public static Part getSelectedPart() {
        return selectedPart;
    }

    /**
     * Returns the selectedProduct, so it can be accessed on the modification screen.
     * @return [Product] the selectedProduct to be modified
     */
    public static Product getSelectedProduct() {
        return selectedProduct;
    }


    /**
     * Handles the delete Part functionality when a user presses the delete button.
     * It will delete the part if the user confirms deletion
     * @param actionEvent JavaFX action event
     * @throws IOException
     * FUTURE ENHANCEMENT : Automatically remove references to this part from all Product associated parts
     */
    @FXML
    private void deletePart(ActionEvent actionEvent){
        selectedPart = tablePart.getSelectionModel().getSelectedItem();
        if (selectedPart == null){
            Alert alert = new Alert((Alert.AlertType.WARNING));
            alert.initModality(Modality.NONE);
            alert.setTitle("Warning");
            alert.setHeaderText("No Part Selected");
            alert.setContentText("You must select a part.");
            alert.show();
        } else{
            Alert alert = new Alert((Alert.AlertType.CONFIRMATION));
            alert.initModality(Modality.NONE);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Confirm Delete");
            alert.setContentText("Are you sure you want to delete the part?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK) {
                Inventory.deletePart(selectedPart);
                selectedPart = null;
            }
        }
    }

    /**
     * Handles the delete Product functionality when a user presses the delete button.
     * It will delete the product if the user confirms deletion
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    private void deleteProduct(ActionEvent actionEvent){
        Product deletingProduct = tableProduct.getSelectionModel().getSelectedItem();
        if (deletingProduct == null){
            Alert alert = new Alert((Alert.AlertType.WARNING));
            alert.initModality(Modality.NONE);
            alert.setTitle("Warning");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("You must select a product.");
            alert.show();
        } else{
            if(deletingProduct.getAllAssociatedParts().size()>0){
                Alert alert = new Alert((Alert.AlertType.ERROR));
                alert.initModality(Modality.NONE);
                alert.setTitle("Error");
                alert.setHeaderText("Product has associating parts");
                alert.setContentText("You must first remove all associating parts.");
                alert.show();
            }
            else{
                Alert alert = new Alert((Alert.AlertType.CONFIRMATION));
                alert.initModality(Modality.NONE);
                alert.setTitle("Delete Confirmation");
                alert.setHeaderText("Confirm Delete");
                alert.setContentText("Are you sure you want to delete the product?");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK) {
                    Inventory.deleteProduct(deletingProduct);
                }
            }
        }

    }

    /**
     * Exits the program when the user presses the exit button.
     * Will exit upon confirmation for exiting.
     * @param actionEvent JavaFX action event
     */
    @FXML
    private void exit(ActionEvent actionEvent){
        Alert alert = new Alert((Alert.AlertType.CONFIRMATION));
        alert.initModality(Modality.NONE);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Confirm Exit");
        alert.setContentText("Are you sure you want to exit the application?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    /**
     * Utility function that is used to switch between pages
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    public void openPage(ActionEvent actionEvent, String form) throws  IOException {
        Parent addPartFXML = FXMLLoader.load(getClass().getResource(form));
        Scene addPartScene = new Scene(addPartFXML);
        Stage addPartStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        addPartStage.setScene(addPartScene);
        addPartStage.show();
    }

    /**
     * Sends the user back to the add Part screen.
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    public void addPart(ActionEvent actionEvent) throws IOException {
        openPage(actionEvent, "AddPart.fxml");
    }

    /**
     * Sends the user back to the modifyPart screen.
     * This function also sets the selectedPart.
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    public void modifyPart(ActionEvent actionEvent) throws IOException {
        selectedPart = tablePart.getSelectionModel().getSelectedItem();
        if (selectedPart == null){
            Alert alert = new Alert((Alert.AlertType.WARNING));
            alert.initModality(Modality.NONE);
            alert.setTitle("Warning");
            alert.setHeaderText("No Part Selected");
            alert.setContentText("You must select a part.");
            alert.show();
        } else{
            openPage(actionEvent, "ModifyPart.fxml");
        }
    }


    /**
     * Handles the search part functionality when the user enters a search query.
     * It will populate the table with the search results or bring up a dialog box if no searches found
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    private void handleSearchPart(ActionEvent actionEvent) throws IOException{
        String search = fieldSearchPart.getText();
        ObservableList<Part> searchResults = FXCollections.observableArrayList();
        int partId = -1;
        Boolean isInt = true;

        try{partId = Integer.parseInt(search);}
        catch (NumberFormatException e){isInt = false;}

        if(isInt){
            Part foundPart = Inventory.lookupPart(partId);
            searchResults.add(foundPart);
        }

        ObservableList<Part> foundParts = Inventory.lookupPart(search);
        for(int i =0; i<foundParts.size(); i++){searchResults.add(foundParts.get(i));}

        if(searchResults.size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Found");
            alert.setHeaderText("No Matching Results");
            alert.setContentText("No parts found matching the search query");
            alert.showAndWait();
        }else{
            tablePart.setItems(searchResults);
        }
    }



    /**
     * Handles the search part functionality when the user enters a search query.
     * It will populate the table with the search results or bring up a dialog box if no searches found
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    private void handleSearchProduct(ActionEvent actionEvent) throws IOException{
        String search = fieldSearchProduct.getText();
        ObservableList<Product> searchResults = FXCollections.observableArrayList();
        int productId = -1;
        Boolean isInt = true;

        try{productId = Integer.parseInt(search);}
        catch (NumberFormatException e){isInt = false;}

        if(isInt){
            Product foundProduct = Inventory.lookupProduct(productId);
            searchResults.add(foundProduct);
        }

        ObservableList<Product> foundProducts = Inventory.lookupProduct(search);
        for(int i =0; i<foundProducts.size(); i++){searchResults.add(foundProducts.get(i));}

        if(searchResults.size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Found");
            alert.setHeaderText("No Matching Results");
            alert.setContentText("No products found matching the search query");
            alert.showAndWait();
        }else{
            tableProduct.setItems(searchResults);
        }
    }


    /**
     * Sends the user back to the add Product screen.
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    public void addProduct(ActionEvent actionEvent) throws IOException {
        openPage(actionEvent, "AddProduct.fxml");
    }


    /**
     * Sends the user back to the modifyProduct screen.
     * This function also sets the selectedProduct.
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    public void modifyProduct(ActionEvent actionEvent) throws IOException {
        selectedProduct = tableProduct.getSelectionModel().getSelectedItem();
        if (selectedProduct == null){
            Alert alert = new Alert((Alert.AlertType.WARNING));
            alert.initModality(Modality.NONE);
            alert.setTitle("Warning");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("You must select a product.");
            alert.show();
        } else{
            openPage(actionEvent, "ModifyProduct.fxml");
        }
    }

    /**
     * Handles setting up all the tables and populates them with the data.
     * This function also maps all the columns with properties from the Part and Product class.
     */
    public void mapTables(){
        columnPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPartStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columnPartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnProductId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnProductStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columnProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tablePart.setItems(Inventory.getAllParts());
        tableProduct.setItems(Inventory.getAllProducts());
    }


    /**
     * Initializes the FXML Screen and sets the selectedPart and selectedProduct to null.
     * @param url parameter for the FXML Screen
     * @param resourceBundle parameter for the FXML Screen
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        selectedPart = null;
        selectedProduct = null;

        mapTables();

    }
}
