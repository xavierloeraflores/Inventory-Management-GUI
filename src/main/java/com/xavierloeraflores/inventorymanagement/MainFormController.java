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




public class MainFormController implements Initializable{

    @FXML
    private TableView<Part>  tablePart;
    @FXML
    private TableColumn<Part, Integer> columnPartId;
    @FXML
    private TableColumn<Part, String> columnPartName;
    @FXML
    private TableColumn<Part, Integer> columnPartStock;
    @FXML
    private TableColumn<Part, Double> columnPartPrice;
    @FXML
    private TextField fieldSearchPart;

    @FXML
    private TableView<Product>  tableProduct;
    @FXML
    private TableColumn<Part, Integer> columnProductId;
    @FXML
    private TableColumn<Part, String> columnProductName;
    @FXML
    private TableColumn<Part, Integer> columnProductStock;
    @FXML
    private TableColumn<Part, Double> columnProductPrice;
    @FXML
    private TextField fieldSearchProduct;

    @FXML
    private void deletePart(ActionEvent actionEvent){
        Part deletingPart = tablePart.getSelectionModel().getSelectedItem();
        if (deletingPart == null){
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
                Inventory.deletePart(deletingPart);
            }else {
                System.out.println("Part was not deleted");
            }
        }
    }

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
    public void openPage(ActionEvent actionEvent, String form) throws  IOException {
        Parent addPartFXML = FXMLLoader.load(getClass().getResource(form));
        Scene addPartScene = new Scene(addPartFXML);
        Stage addPartStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        addPartStage.setScene(addPartScene);
        addPartStage.show();
    }
    @FXML
    public void addPart(ActionEvent actionEvent) throws IOException {
        openPage(actionEvent, "AddPart.fxml");
    }
    @FXML
    public void modifyPart(ActionEvent actionEvent) throws IOException {
        openPage(actionEvent, "ModifyPart.fxml");
    }
    @FXML
    public void addProduct(ActionEvent actionEvent) throws IOException {
        openPage(actionEvent, "AddProduct.fxml");
    }
    @FXML
    public void modifyProduct(ActionEvent actionEvent) throws IOException {
        openPage(actionEvent, "ModifyProduct.fxml");
    }

    public void updateTableViews(){
        tablePart.setItems(Inventory.getAllParts());
        tableProduct.setItems(Inventory.getAllProducts());
    }
    public void mapTables(){
        columnPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPartStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columnPartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnProductId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnProductStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columnProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        mapTables();
        updateTableViews();

    }
}
