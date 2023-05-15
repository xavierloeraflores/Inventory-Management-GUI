package com.xavierloeraflores.inventorymanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddPartController implements Initializable {

    @FXML
    private RadioButton radioInHouse;
    @FXML
    private RadioButton radioOutsourced;
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldStock;
    @FXML
    private TextField fieldPrice;
    @FXML
    private TextField fieldMin;
    @FXML
    private TextField fieldMax;
    @FXML
    private Label labelSpecial;
    @FXML
    private TextField fieldSpecial;

    private boolean isOutsourced;
    private String errorMessage;
    private int partId;

    @FXML
    void setRadioInHouse(ActionEvent event) {
        isOutsourced = false;
        labelSpecial.setLayoutX(14.0);
        labelSpecial.setText("Machine ID");
        radioOutsourced.setSelected(false);
    }

    @FXML
    void setRadioOutsourced(ActionEvent event) {
        isOutsourced = true;
        labelSpecial.setLayoutX(-8.0);
        labelSpecial.setText("Company Name");
        radioInHouse.setSelected(false);
    }
    void mainScreen(ActionEvent actionEvent) throws IOException{
        Parent mainFXML = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene mainScene = new Scene(mainFXML);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Inventory Management System");
        stage.setScene(mainScene);
        stage.show();
    }
    /**
     * RUNTIME ERROR: errorMessage was not updating with the concat function.
     *
     */
    boolean validate(String name,  String priceString, String stockString, String minString, String maxString, String special,boolean isOutsourced ){
        boolean validated = true;
        errorMessage = "";
        
        if(name == ""){
            System.out.println("Bruh");
            validated = false;
            errorMessage=errorMessage.concat("\nName field can not be empty.");
        }
        if(priceString==""){
            validated = false;
            errorMessage=errorMessage.concat("\n Price field can not be empty.");
        }
        if(stockString==""){
            validated = false;
            errorMessage=errorMessage.concat("\n Stock field can not be empty.");
        }
        if(minString==""){
            validated = false;
            errorMessage=errorMessage.concat("\n Min field can not be empty.");
        }
        if(maxString==""){
            validated = false;
            errorMessage=errorMessage.concat("\n Max field can not be empty.");
        }
        if(special==""){
            validated = false;
            errorMessage=errorMessage.concat("\n Company name or machine Id can be empty.");
        }
        if(!validated){return false;}

        int stock =0;
        int min =0;
        int max=0;
        double price=0.0;
        int specialInt=0;


        try{

            try {stock= Integer.parseInt(stockString);}
            catch (NumberFormatException e){
                validated = false;
                errorMessage=errorMessage.concat("\n Part must have an valid stock integer value");
            }

            try {min = Integer.parseInt(minString);}
            catch (NumberFormatException e){
                validated = false;
                errorMessage=errorMessage.concat("\n Part must have an valid integer value");
            }

            try {max= Integer.parseInt(maxString);}
            catch (NumberFormatException e){
                validated = false;
                errorMessage=errorMessage.concat("\n Part must have an valid Max integer value ");
            }

            try {price= Double.parseDouble(priceString);}
            catch (NumberFormatException e){
                validated = false;
                errorMessage=errorMessage.concat("\n Part must have an valid Price double value ");
            }

            try {if (!isOutsourced){specialInt= Integer.parseInt(special);}}
            catch (NumberFormatException e){
                validated = false;
                errorMessage=errorMessage.concat("\n In house part must have an ID value number");
            }

        }catch (Exception e){
            return false;
        }




        if (stock < 0){
            validated = false;
            errorMessage=errorMessage.concat("\n Stock can not be negative.");
        }
        if (stock < min){
            validated = false;
            errorMessage=errorMessage.concat("\n Stock can not be less than min.");
        }
        if (stock > max){
            validated = false;
            errorMessage=errorMessage.concat("\n Stock can not be more than max.");
        }

        if(max < min){
            validated = false;
            errorMessage=errorMessage.concat("\n Max can not be less than min.");
        }
        if(min < 0){
            validated = false;
            errorMessage=errorMessage.concat("\n Min can not be less than 0.");
        }
        if(price < 0){
            validated = false;
            errorMessage=errorMessage.concat("\n Price must be a positive number.");
        }
        if(name == ""){
            validated = false;
            errorMessage=errorMessage.concat("\n Name field must not be empty.");
        }
        if (specialInt<0){
        validated = false;
        errorMessage=errorMessage.concat("\n In house part must have an ID value number");
        }


        return validated;
    }

    @FXML
    void handleSave(ActionEvent actionEvent) throws IOException {
        String partName = fieldName.getText();
        String partStock = fieldStock.getText();
        String partPrice = fieldPrice.getText();
        String partMin = fieldMin.getText();
        String partMax = fieldMax.getText();
        String partSpecial = fieldSpecial.getText();

        try {
            if(validate(partName, partPrice, partStock, partMin,partMax,partSpecial,isOutsourced)){
                String name = partName;
                int stock = Integer.parseInt(partStock);
                double price = Double.parseDouble(partPrice);
                int min = Integer.parseInt(partMin);
                int max = Integer.parseInt(partMax);

                if (!isOutsourced) {
                    int machineId = Integer.parseInt(partSpecial);
                    InHouse part = new InHouse(partId, name, price, stock, min, max,machineId);
                    Inventory.addPart(part);
                } else {
                    String companyName = partSpecial;
                    Outsourced part = new Outsourced(partId, name, price, stock, min, max, companyName);
                    Inventory.addPart(part);
                }
                mainScreen(actionEvent);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error Adding Part");
                alert.setContentText(errorMessage);
                alert.showAndWait();
            }
        }
        catch(NumberFormatException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error Adding Part");
            alert.setContentText("An error has occurred");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancel(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Cancel Add Part Confirmation");
        alert.setHeaderText("Confirm Cancellation");
        alert.setContentText("Are you sure you want to cancel adding this part?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {mainScreen(actionEvent);}
        else {System.out.println("Add Part Cancel has been denied.");}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioInHouse.setSelected(true);
        setRadioInHouse(new ActionEvent());
        partId = Inventory.getAllParts().size();
        fieldId.setText("Auto-Gen: " + partId);
    }
}
