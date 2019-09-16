/*
author @ Harman Bath
*/
package content;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafinalproject.Main;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OptionsWindow extends Stage {

    ArrayList<Order> allOrders = Main.getOrderList();
    ArrayList<String> arrayList = new ArrayList();
    
    Stage addStage = new Stage();
    private Label lblOrderID = new Label("Order ID: ");
    private TextField txtOrderID = new TextField();
    boolean check = true;
    private Label lblName = new Label("Customer Name: ");
    private TextField txtName = new TextField();

    private Label lblAddress = new Label("Address: ");
    private TextField txtAddress = new TextField();

    private Label lblCity = new Label("City: ");
    private TextField txtCity = new TextField();

    private Label lblProduct = new Label("Product chosen: ");
    private RadioButton radHonda = new RadioButton("Honda Civic");
    private RadioButton radToyota = new RadioButton("Toyota Corolla");
    private RadioButton radBMW = new RadioButton("BMW 3 Series");
    private RadioButton radMercedes = new RadioButton("Mercedes C300");
    private RadioButton radLexus = new RadioButton("Lexus IS250");

    private Label lblQuantity = new Label("Quantity: ");
    private TextField txtQuantity = new TextField();

    private Label lblPrice = new Label("Price: ");
    private TextField txtPrice = new TextField();
    
    private Label lblSearch = new Label("Search: ");
    private TextField txtSearch = new TextField(); 
    private RadioButton radSearchOrderID = new RadioButton("Order ID");
    private RadioButton radSearchName = new RadioButton("Name");
    private RadioButton radSearchAddress = new RadioButton("Address");
    private RadioButton radSearchCity = new RadioButton("City");

    private Button btnFirst = new Button("First");
    private Button btnNext = new Button("Next");
    private Button btnPrev = new Button("Previous");
    private Button btnLast = new Button("Last");
    private Button btnUpdate = new Button("Update");
    private Button btnAdd = new Button("Add");
    private Button btnDelete = new Button("Delete");
    private Button btnConfirm = new Button("Confirm Update");
    private Button btnCancel = new Button("Cancel");
    private Button btnAddFinal = new Button("Add Order");
    private Button btnSearch = new Button("Search");
    private Label emptySpace = new Label(""); 
    private Label emptySpace2 = new Label("");
    private Label emptySpace3 = new Label(""); 
    private Label emptySpace4 = new Label("");

    
    GridPane pane = new GridPane();
    int count = 0;

    public OptionsWindow() throws FileNotFoundException, IOException {
        Tooltip updateTooltip = new Tooltip("Update Button");
        Tooltip.install(btnUpdate, updateTooltip);
        
        Tooltip searchTooltip = new Tooltip("Search Button");
        Tooltip.install(btnSearch, searchTooltip);

        Tooltip addTooltip = new Tooltip("Add Button");
        Tooltip.install(btnAdd, addTooltip);
        
        Tooltip deleteTooltip = new Tooltip("Delete Button");
        Tooltip.install(btnDelete, deleteTooltip);
        
        Tooltip confirmTooltip = new Tooltip("Confirm Button");
        Tooltip.install(btnConfirm, confirmTooltip);
        
        Tooltip cancelTooltip = new Tooltip("Cancel Button");
        Tooltip.install(btnCancel, cancelTooltip);
        
        Tooltip addFinalTooltip = new Tooltip("Add Final Button");
        Tooltip.install(btnAddFinal, addFinalTooltip);
        
        Tooltip firstTooltip = new Tooltip("First Button");
        Tooltip.install(btnFirst, firstTooltip);
        
        Tooltip lastTooltip = new Tooltip("Last Button");
        Tooltip.install(btnLast, lastTooltip);
        
        Tooltip nextTooltip = new Tooltip("Next Button");
        Tooltip.install(btnNext, nextTooltip);
        
        Tooltip prevTooltip = new Tooltip("Previous Button");
        Tooltip.install(btnPrev, prevTooltip);

        ArrayList<Order> orderList = Main.getOrderList();
        addStage.setTitle("Harmans Car Dealership");
        Scene MainScene = new Scene(getPane(), 1000, 600);
        addStage.setScene(MainScene);
        MainScene.getStylesheets().add("style/theStyle.css");
        addStage.show();
        txtOrderID.setText(orderList.get(count).getOrderID());
        txtName.setText(orderList.get(count).getName());
        txtAddress.setText(orderList.get(count).getAddress());
        txtCity.setText(orderList.get(count).getCity());
        setProduct(orderList.get(count).getProduct());
        txtPrice.setText(Double.toString(orderList.get(count).getPrice()));
        txtQuantity.setText(Integer.toString(orderList.get
        (count).getQuantity()));

        btnFirst.setOnAction(e -> {
            txtOrderID.setText(orderList.get(0).getOrderID());
            txtName.setText(orderList.get(0).getName());
            txtAddress.setText(orderList.get(0).getAddress());
            txtCity.setText(orderList.get(0).getCity());
            setProduct(orderList.get(0).getProduct());
            txtPrice.setText(Double.toString(orderList.get(0).getPrice()));
            txtQuantity.setText(Integer.toString
        (orderList.get(0).getQuantity()));
        });

        btnLast.setOnAction(e -> {
            txtOrderID.setText(orderList.get
        (orderList.size() - 1).getOrderID());
            txtName.setText(orderList.get(orderList.size() - 1).getName());
            txtAddress.setText(orderList.get
        (orderList.size() - 1).getAddress());
            txtCity.setText(orderList.get(orderList.size() - 1).getCity());
            setProduct(orderList.get(orderList.size() - 1).getProduct());
            txtPrice.setText(Double.toString(orderList.get
        (orderList.size() - 1).getPrice()));
            txtQuantity.setText(Integer.toString(orderList.get
        (orderList.size() - 1).getQuantity()));
        });

        btnNext.setOnAction(e -> {
            if (count < orderList.size() - 1) {
                count++;
                txtOrderID.setText(orderList.get(count).getOrderID());
                txtName.setText(orderList.get(count).getName());
                txtAddress.setText(orderList.get(count).getAddress());
                txtCity.setText(orderList.get(count).getCity());
                setProduct(orderList.get(count).getProduct());
                txtPrice.setText(Double.toString(orderList.get(count)
                        .getPrice()));
                txtQuantity.setText(Integer.toString(orderList.get(count)
                        .getQuantity()));
            }
        });

        btnPrev.setOnAction(e -> {
            if (count > 0) {
                count--;
                txtOrderID.setText(orderList.get(count).getOrderID());
                txtName.setText(orderList.get(count).getName());
                txtAddress.setText(orderList.get(count).getAddress());
                txtCity.setText(orderList.get(count).getCity());
                setProduct(orderList.get(count).getProduct());
                txtPrice.setText(Double.toString(orderList.get(count)
                        .getPrice()));
                txtQuantity.setText(Integer.toString(orderList.get
        (count).getQuantity()));
            }

        });
        
        btnAddFinal.setOnAction(e-> {
        try {
                Alert dlgConfirm = new Alert(Alert.AlertType.CONFIRMATION); 
                dlgConfirm.setTitle("Confirm"); 
                dlgConfirm.setHeaderText("Confirm: Add new order?");
                Optional<ButtonType> ifConfirm = dlgConfirm.showAndWait();
                if(ifConfirm.get() == ButtonType.OK){
                if(checkID(txtOrderID.getText())){
                FileWriter fw = new FileWriter("OrderInfo.dat", true);
                BufferedWriter bw = new BufferedWriter(fw);
                Order firstOrder = checkOrder();
                orderList.add(firstOrder);
                bw.write(makeOrder(firstOrder));
                bw.newLine();
                newOrder();
                bw.close();
                fw.close();
                Alert dlgCheck = new Alert(Alert.AlertType.INFORMATION);
                dlgCheck.setTitle("Information");
                dlgCheck.setHeaderText("Information added");
                dlgCheck.show();
                    }else{
                Alert dlgError = new Alert(Alert.AlertType.ERROR);
                dlgError.setTitle("Error");
                dlgError.setHeaderText("That ID Already Exists, please "
                        + "enter a new Order ID");
                txtOrderID.setText(null);
                txtOrderID.requestFocus();
                dlgError.show();                        
                    }       
                }
            }catch (IOException ex) {
            }catch (NumberFormatException ex) {
                Alert dlgNfError = new Alert(Alert.AlertType.ERROR);
                dlgNfError.setTitle("Error");
                dlgNfError.setHeaderText("Must be Integer");
                dlgNfError.show();
                txtQuantity.requestFocus();
            }catch(NullPointerException ex){
                Alert dlgEmptyBox = new Alert(Alert.AlertType.ERROR);
                dlgEmptyBox.setTitle("Error");
                dlgEmptyBox.setHeaderText("All fields must be filled"); 
                dlgEmptyBox.show();
                txtOrderID.requestFocus(); 
    }
        });

        btnAdd.setOnAction(e -> {
                newOrder();
                txtOrderID.requestFocus();
                boolean userMod = false;
                modField(true); 
                pane.add(btnAddFinal, 1, 16); 
                pane.add(btnCancel, 1, 17); 
        });
        
        btnUpdate.setOnAction(e -> {
            boolean userMod = false;
            modField(true);
            pane.add(btnConfirm, 1, 17);
            pane.add(btnCancel, 1, 18);
        });

        btnConfirm.setOnAction(e -> {
            Alert dlgConfirm = new Alert(Alert.AlertType.CONFIRMATION);
            dlgConfirm.setTitle("Update information");
            dlgConfirm.setHeaderText("Confirm: Update information?");
            Optional<ButtonType> confirmUpdate = dlgConfirm.showAndWait();
            if (confirmUpdate.get() == ButtonType.OK) {
                try {
                    if (isEmpty()) {
                        throw new NullPointerException();
                    } else {
                        allOrders.get(count).setName(getName());
                        allOrders.get(count).setAddress(getAddress());
                        allOrders.get(count).setCity(getCity());
                        allOrders.get(count).setProduct(getProduct());
                        allOrders.get(count).setPrice(getPrice());
                        allOrders.get(count).setQuantity(getQuantity());
                        pane.getChildren().remove(btnConfirm);
                        pane.getChildren().remove(btnCancel);
                        modField(false);
                        confirmUpdate(true);
                        boolean userMod = true;
                        Alert dlgConfirmed
                                = new Alert(Alert.AlertType.INFORMATION);
                        dlgConfirmed.setTitle("Information");
                        dlgConfirmed.setHeaderText("Information updated");
                        dlgConfirmed.show();
                    }
                } catch (NumberFormatException ex) {
                    Alert dlgNF = new Alert(Alert.AlertType.ERROR);
                    dlgNF.setTitle("Error");
                    dlgNF.setHeaderText("Input must be integer");
                    dlgNF.show();
                } catch (NullPointerException ex) {
                    Alert dlgN = new Alert(Alert.AlertType.ERROR);
                    dlgN.setTitle("Error");
                    dlgN.setHeaderText("Unfilled boxes");
                    dlgN.show();
                }
            }
            
        });
        
        btnCancel.setOnAction(e-> {
            modField(false);
            pane.getChildren().remove(btnConfirm);
            pane.getChildren().remove(btnCancel);
            pane.getChildren().remove(btnAddFinal); 
            boolean canMod = true; 
        });
        
        btnDelete.setOnAction(e-> {
            Alert dlgConfirm = new Alert(Alert.AlertType.CONFIRMATION);
            dlgConfirm.setTitle("Confirmation");
            dlgConfirm.setHeaderText("Delete Order?");
            Optional<ButtonType> confirmDelete = dlgConfirm.showAndWait();
            if (confirmDelete.get() == ButtonType.OK) {
                confirmUpdate(false);
                allOrders.remove(count);
                if (count >= allOrders.size() - 1) {
                    count--;
                } else {
                    count++;
                }
                customerInfo(allOrders.get(count));          
                Alert dlgDeleteConf = new Alert(Alert.AlertType.INFORMATION);
                dlgDeleteConf.setTitle("Information");
                dlgDeleteConf.setHeaderText("Order Deleted");
                dlgDeleteConf.show();
            }
        });
      
        btnSearch.setOnAction(e-> {
            if(radSearchOrderID.isSelected()){
             for(int sub = 0; sub < allOrders.size(); sub++){
                 Order orderID = allOrders.get(sub);
            if( orderID.getOrderID().equals(txtSearch.getText())){
            searchHelper(sub); } } 
            }
            
            if(radSearchName.isSelected()){
             for(int sub = 0; sub < allOrders.size(); sub++){
                 Order Name = allOrders.get(sub);
            if( Name.getName().equals(txtSearch.getText())){
                searchHelper(sub);}}
            }
            if(radSearchAddress.isSelected()){
             for(int sub = 0; sub <allOrders.size(); sub++){
                 Order Address = allOrders.get(sub);
            if( Address.getAddress().equals(txtSearch.getText())){
                searchHelper(sub);}}
           }
            if(radSearchCity.isSelected()){
             for(int sub = 0; sub<allOrders.size();sub++){
                 Order City = allOrders.get(sub);
            if( City.getCity().equals(txtSearch.getText())){
               searchHelper(sub);}}
            }
        });
   
    
    }
    private GridPane getPane() {
        pane.setAlignment(Pos.CENTER);
        ToggleGroup Tgroup = new ToggleGroup();
        radHonda.setToggleGroup(Tgroup);
        radToyota.setToggleGroup(Tgroup);
        radBMW.setToggleGroup(Tgroup);
        radMercedes.setToggleGroup(Tgroup);
        radLexus.setToggleGroup(Tgroup);
        
        ToggleGroup Sgroup = new ToggleGroup();
        radSearchOrderID.setToggleGroup(Tgroup);
        radSearchName.setToggleGroup(Tgroup);
        radSearchAddress.setToggleGroup(Tgroup);
        radSearchCity.setToggleGroup(Tgroup);

        VBox box = new VBox(radHonda, radToyota, radBMW, radMercedes, radLexus);  
        
        HBox sBox = new HBox(radSearchOrderID, radSearchName);
        
        HBox sBox2 = new HBox(radSearchCity, radSearchAddress);

        pane.add(sBox,0,0);
        pane.add(sBox2,1,0);
        pane.add(lblSearch, 0, 1);
        pane.add(txtSearch, 1, 1);
        pane.add(btnSearch, 2 , 1);
        pane.add(emptySpace, 0, 2);
        pane.add(emptySpace2, 0, 3);
        pane.add(lblOrderID, 0, 4);
        pane.add(txtOrderID, 1, 4);
        pane.add(lblName, 0, 5);
        pane.add(txtName, 1, 5);
        pane.add(lblAddress, 0, 6);
        pane.add(txtAddress, 1, 6);
        pane.add(lblCity, 0, 7);
        pane.add(txtCity, 1, 7);
        pane.add(lblProduct, 0, 8);
        pane.add(box, 0, 9);
        pane.add(lblPrice, 0, 10);
        pane.add(txtPrice, 1, 10);
        pane.add(lblQuantity, 0, 11);
        pane.add(txtQuantity, 1, 11);
        pane.add(emptySpace3, 0, 12);
        pane.add(emptySpace4, 0, 13);
        pane.add(btnFirst, 0, 14);
        pane.add(btnNext, 0, 15);
        pane.add(btnPrev, 1, 15);
        pane.add(btnLast, 1, 14);
        pane.add(btnAdd, 0, 16);
        pane.add(btnUpdate, 0, 17);
        pane.add(btnDelete, 0, 18);
   
        return pane;

    }
    public void setID(String ID){
        txtOrderID.setText(ID);
    }
    
    public void setName(String name){
        txtName.setText(name);
    }
    
    public void setAddress(String address){
        txtAddress.setText(address);
    }
    
    public void setCity(String city){
        txtCity.setText(city);
    }
    public void setQuantity(int quantity){
        txtQuantity.setText(Integer.toString(quantity));
    }
    
    public void setPrice(double price){
        txtPrice.setText(Double.toString(price));
    }
    
    public String getName(){
        return txtName.getText();
    }
    
    public String getCity(){
        return txtCity.getText();
    }
    
    public String getAddress(){
        return txtAddress.getText();
    }
    
    public int getQuantity(){
        return Integer.parseInt(txtQuantity.getText());
    }
    
    public double getPrice(){
        return Double.parseDouble(txtPrice.getText());
    }
    
    public void customerInfo(Order firstOrder) {
        setID(firstOrder.getOrderID());
        setName(firstOrder.getName());
        setAddress(firstOrder.getAddress());
        setCity(firstOrder.getCity());
        setProduct(firstOrder.getProduct());
        setPrice(firstOrder.getPrice());
        setQuantity(firstOrder.getQuantity());

    }
    
      private void getArray(boolean con) {
        try {
            arrayList = new ArrayList();
            FileReader fr = new FileReader("OrderInfo.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                arrayList.add(line);
                line = br.readLine();
            }
            br.close();
            fr.close();
            updateArray(count, con);
        } catch (IOException ex) {
        }
    }

    private void updateArray(int index, boolean upDate) {
        arrayList.remove(index);
        if(upDate){
            arrayList.add(index, makeOrder(allOrders.get(index)));
        }
    }
    
    public void confirmUpdate (boolean con) {
        try {
            getArray(con);
            FileWriter fw = new FileWriter("OrderInfo.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < arrayList.size(); i++) {
                bw.write(arrayList.get(i));
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
        }
    }

    public boolean isEmpty() {
        if (txtOrderID.getText().isEmpty()
                || txtName.getText().isEmpty()
                || txtAddress.getText().isEmpty()
                || txtCity.getText().isEmpty()
                || txtPrice.getText().isEmpty()
                || txtQuantity.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void modField(boolean canMod) {
        if (!canMod) {
            txtOrderID.setEditable(false);
            txtName.setEditable(false);
            txtAddress.setEditable(false);
            txtCity.setEditable(false);
            txtPrice.setEditable(false);
            txtQuantity.setEditable(false);
        } else {
            txtOrderID.setEditable(true);
            txtPrice.setEditable(true);
            txtName.setEditable(true);
            txtAddress.setEditable(true);
            txtCity.setEditable(true);
            txtQuantity.setEditable(true);
        }
    }

    public static String makeOrder(Order firstOrder) {
        String orderString = new String();
        orderString += firstOrder.getOrderID() + "," + firstOrder.getName()
                + "," + firstOrder.getAddress() + "," + firstOrder.getCity()
                + "," + firstOrder.getProduct() + ","
                + firstOrder.getPrice() + "," + firstOrder.getQuantity();
        return orderString;
    }

    public void newOrder() {
        txtOrderID.setText(null);
        txtOrderID.requestFocus();
        txtName.setText(null);
        txtAddress.setText(null);
        txtCity.setText(null);
        txtPrice.setText("");
        txtQuantity.setText("");
    }

    public boolean checkID(String OrderID) {
        boolean check1 = true;
        for (int sub = 0; sub < allOrders.size(); sub++) {
            if (OrderID.equals(allOrders.get(sub).getOrderID())) {
                check1 = false;
            }
        }
        return check1;
    }

    private Order checkOrder() {
        if (txtOrderID.getText().isEmpty() || txtName.getText().isEmpty()
                || txtAddress.getText().isEmpty() || txtCity.getText().isEmpty()
                || txtQuantity.getText().isEmpty()) {
            throw new NullPointerException();
        } else {
            Order firstOrder = new Order(txtOrderID.getText());
            firstOrder.setName(txtName.getText());
            firstOrder.setAddress(txtAddress.getText());
            firstOrder.setCity(txtCity.getText());
            firstOrder.setProduct(getProduct());
            firstOrder.setQuantity(Integer.parseInt(txtQuantity.getText()));
            firstOrder.setPrice(Double.parseDouble(txtPrice.getText()));
            return firstOrder;
        }
    }
    
    public void searchHelper(int count){
        this.count = count;
        Order firstOrder = allOrders.get(count); 
        txtOrderID.setText(firstOrder.getOrderID());
        txtName.setText(firstOrder.getName());
        txtAddress.setText(firstOrder.getAddress());
        txtCity.setText(firstOrder.getCity());   
        txtPrice.setText(Double.toString(firstOrder.getPrice()));
        txtQuantity.setText(Integer.toString(firstOrder.getQuantity()));
        
    }

    public String getProduct() {
        if (this.radHonda.isSelected()) {
            return "Honda Civic";
        } else if (this.radToyota.isSelected()) {
            return "Toyota Corolla";
        } else if (this.radBMW.isSelected()) {
            return "BMW 3 Series";
        } else if (this.radMercedes.isSelected()) {
            return "Mercedes C300";
        } else {
            return "Lexus IS250";
        }
    }

    public void setProduct(String product) {
        switch (product) {
            case "Honda Civic":
                radHonda.setSelected(true);
                break;
            case "Toyota Corolla":
                radToyota.setSelected(true);
                break;
            case "BMW 3 Series":
                radBMW.setSelected(true);
                break;
            case "Mercedes C300":
                radMercedes.setSelected(true);
                break;
            default:
                radLexus.setSelected(true);
                break;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
