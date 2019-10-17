package sample;


import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;


public class Controller {
    public TextArea encryptOutput = new TextArea();
    public TextArea encryptInput = new TextArea();
    public TextArea decryptOutput = new TextArea();
    public TextArea decryptInput = new TextArea();
    public CheckboardMap checkboardMap = new CheckboardMap();
    public void pressEncrypt(ActionEvent event){
        String text = encryptInput.getText();
        encryptOutput.setText(checkboardMap.encodeText(text));
    }

    public void pressDecrypt(ActionEvent event){
        String code = decryptInput.getText();
        decryptOutput.setText(checkboardMap.decodeText(code));
    }

}
