package sample;


import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;


public class Controller {
    public TextArea encryptOutput = new TextArea();
    public TextArea encryptInput = new TextArea();
    public CheckboardMap checkboardMap = new CheckboardMap();
    public void pressEncrypt(ActionEvent event){
        System.out.println("Hello");

        String text = encryptInput.getText();

        encryptOutput.setText(text);
    }

}
