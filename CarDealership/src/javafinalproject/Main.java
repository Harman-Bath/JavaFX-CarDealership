/*
author @ Harman Bath
*/

package javafinalproject;

import content.OptionsWindow;
import content.Order;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
        
    private Label lblUser = new Label("Username: "); 
    private TextField txtUser = new TextField();
    private Label lblPassword = new Label("Password: "); 
    private TextField txtPassword = new TextField();
    private PasswordField pwBox = new PasswordField(); 
    private Button btnLogin = new Button("Login"); 
    private static ArrayList <Order> orderList = new ArrayList();
    Alert dlgLogin = new Alert(Alert.AlertType.CONFIRMATION);
    Alert dlgFailed = new Alert(Alert.AlertType.ERROR);
                    
    @Override
    
    public void start(Stage primaryStage) {
        
        
        Tooltip loginTooltip = new Tooltip("Login Button");
        Tooltip.install(btnLogin, loginTooltip);
        
        showOrder();
        
        GridPane loginPane = new GridPane(); 
        loginPane.setAlignment(Pos.CENTER); 
        loginPane.setVgap(18);
        loginPane.setHgap(18);
        loginPane.setPadding(new Insets(10));
        txtUser.requestFocus(); 
        
        Text welcomeText = new Text("HB's Dealership"); 
        welcomeText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
       
        txtUser.setPromptText("username");
        pwBox.setPromptText("password"); 
        
        loginPane.add(welcomeText, 0, 0);
        loginPane.add(lblPassword, 0, 2);
        loginPane.add(pwBox, 1, 2);
        loginPane.add(lblUser, 0, 1); 
        loginPane.add(txtUser, 1, 1); 
        loginPane.add(btnLogin, 1, 3); 
        
        Scene LoginScene = new Scene(loginPane, 1000, 600); 
        primaryStage.setScene(LoginScene);
        primaryStage.setTitle("Harman's Car Dealership");
        LoginScene.getStylesheets().add("style/theStyle.css");
        primaryStage.show(); 
        
        btnLogin.setOnAction(e->{
             if(txtUser.getText().equals("Harman") && pwBox.getText().
                     equals("123Java")){ 
                dlgLogin.setTitle("Information");
                dlgLogin.setHeaderText("Login Succesful");
                dlgLogin.show();
                    try {
                        OptionsWindow one = new OptionsWindow();
                    } catch (IOException ex) {
                    }
            }else {    
                    dlgFailed.setTitle("Error");
                    dlgFailed.setHeaderText("Incorrect Username or Password");
                    dlgFailed.show();
                    txtUser.requestFocus(); 
             }});
        
}
       
    public void showOrder(){
        try{
            FileReader fr = new FileReader("OrderInfo.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                StringTokenizer st = new StringTokenizer(line,",");
                Order firstOrder = new Order(st.nextToken());
                firstOrder.setName(st.nextToken());
                firstOrder.setAddress(st.nextToken());
                firstOrder.setCity(st.nextToken());
                firstOrder.setProduct(st.nextToken());
                firstOrder.setPrice(Double.parseDouble(st.nextToken()));
                firstOrder.setQuantity(Integer.parseInt(st.nextToken()));
                orderList.add(firstOrder);
                line = br.readLine();
                
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static ArrayList getOrderList(){
        return orderList;
    }
 
    public void addOrder(Order firstOrder){
        orderList.add(firstOrder);
        }
        

    public static void main(String[] args) {
        launch(args);
    }
    


}
