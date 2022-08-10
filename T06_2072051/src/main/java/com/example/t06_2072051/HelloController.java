package com.example.t06_2072051;

import com.example.t06_2072051.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import javafx.stage.FileChooser;

public class HelloController {
    public ListView<User> list1;
    public TextField txtUsername;
    public TextArea txtKomentar;
    public Button btnAdd;
    public Button btnSave1;
    public Button btnLoad1;
    public Button btnSave2;
    public Button btnLoad2;

    public void addData(ActionEvent actionEvent) {
        if (!txtUsername.getText().isEmpty() && !txtKomentar.getText().isEmpty()){
            User user = new User(
                    txtUsername.getText(),
                    txtKomentar.getText());
            list1.getItems().add(user);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Isi semua field");
            alert.show();
        }
        txtUsername.setText("");
        txtKomentar.setText("");
    }

    public void saveData1(ActionEvent actionEvent) {
        BufferedWriter writer;
        String filename = "data/text.txt";
        try {
            writer = new BufferedWriter(new FileWriter(filename));
//            ArrayList<String> tes = new ArrayList<>();
//            for (User user : list1.getItems()){
//                String json = "{" +
//                        "\"Username\":" + "\"" + user.getUsername() +
//                        "\"Komentar\":" + "\"" + user.getKomentar() + "}";
//                tes.add(json);
//            }
            Gson gson = new Gson();
            String jsonGson = gson.toJson(list1.getItems());
//            writer.write(String.valueOf(tes));
            writer.write(jsonGson);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadData1(ActionEvent actionEvent) {
        String p = "data/text.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(p));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String json = reader.readLine();
            Gson gson = new Gson();
            User[] list = gson.fromJson(json, User[].class);
            list1.getItems().addAll(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveData2(ActionEvent actionEvent) {
        Path p = Paths.get("data/text.txt");
        try {
            Gson gson = new Gson();
            Files.write(p, gson.toJson(list1.getItems()).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadData2(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(list1.getScene().getWindow());
        Path p = Paths.get(f.toURI());
//        Path p = Paths.get("data/text.txt");
        try {
            String baru = "";
            for (String something : Files.readAllLines(p)) {
                baru += something;
            }
            Gson gson = new Gson();
//            gson.toJson(list1.setItems(baru));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

