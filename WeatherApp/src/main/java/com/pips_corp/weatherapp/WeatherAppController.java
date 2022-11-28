package com.pips_corp.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherAppController {

    @FXML
    private Button closbtn;

    @FXML
    private Label cloudsdata;

    @FXML
    private Label err;

    @FXML
    private  TextField data;

    @FXML
    private Label winddata;

    @FXML
    private Button getData;

    @FXML
    private Label humiditdata;

    @FXML
    private Label countrydata;

    @FXML
    private Label pressdata;

    @FXML
    private Label tempdata;

    @FXML
    void initialize() {
        getData.setOnAction(event ->{
            String getCity = data.getText().trim();
            String output = getURLcontent("https://api.openweathermap.org/data/2.5/weather?q=" + getCity + "&appid=e7f998d87b31bd0a5b36b00a1acab052&units=metric");
            System.out.println(output);

            if(!output.isEmpty()){
                JSONObject info = new JSONObject(output);
                countrydata.setText(String.valueOf(info.getJSONObject("sys").getString("country")));
                tempdata.setText(String.valueOf(info.getJSONObject("main").getInt("temp") + " С°"));
                humiditdata.setText(String.valueOf(info.getJSONObject("main").getDouble("humidity" )+ " %"));
                pressdata.setText(String.valueOf(info.getJSONObject("main").getDouble("pressure" )+  " mm Hg"));
                winddata.setText(String.valueOf(info.getJSONObject("wind").getDouble("speed" )+ " mps"));
                cloudsdata.setText(String.valueOf(info.getJSONObject("clouds").getDouble("all" )+ " %"));
            }
        });

        closbtn.setOnAction(event -> {
            Stage stage = (Stage) closbtn.getScene().getWindow();
            stage.close();
        });

    }

    public static String getURLcontent(String urlAdress){

        StringBuffer buffer = new StringBuffer();

        try{
            URL url = new URL(urlAdress);
            URLConnection urlConnection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line).append("\n");
            }
            reader.close();
        }catch (Exception exception){
           System.out.println("city not found");
        }
        return buffer.toString();
    }

}
