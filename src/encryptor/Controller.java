package encryptor;


import com.oracle.tools.packager.IOUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;


public class Controller {
    public TextField openText = new TextField();
    public TextField saveCode = new TextField();
    public TextField openCode = new TextField();
    public TextField saveText = new TextField();
    public TextArea encryptOutput = new TextArea();
    public TextArea encryptInput = new TextArea();
    public TextArea decryptOutput = new TextArea();
    public TextArea decryptInput = new TextArea();
    public CheckboardMap checkboardMap = new CheckboardMap();

    public Controller() throws IOException {
    }

    public void pressEncrypt(ActionEvent event){
        String text = encryptInput.getText();
        encryptOutput.setText(checkboardMap.encodeText(text));
    }

    public void pressDecrypt(ActionEvent event){
        String code = decryptInput.getText();
        decryptOutput.setText(checkboardMap.decodeText(code));
    }

    public void pressReadText(ActionEvent event) throws IOException {
       String text;
        try(BufferedReader br = new BufferedReader(new FileReader(openText.getText()))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            text = sb.toString();
        }
        String result = null;
        if ((text != null) && (text.length() > 0)) {
            result = text.substring(0, text.length() - 1);
        }
        encryptInput.setText(result);
    }
    public void pressSaveCode(ActionEvent event) throws IOException {
        String code = encryptOutput.getText();
        FileWriter fileWriter = new FileWriter(saveCode.getText());
        fileWriter.write(code);
        fileWriter.close();
    }
    public void pressReadCode(ActionEvent event){
        String code = null;
        try(BufferedReader br = new BufferedReader(new FileReader(openCode.getText()))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            code = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = null;
        if ((code != null) && (code.length() > 0)) {
            result = code.substring(0, code.length() - 1);
        }
        decryptInput.setText(result);
    }
    public void pressSaveText(ActionEvent event) throws IOException {
        String code = decryptOutput.getText();
        FileWriter codeWriter = new FileWriter(saveText.getText());
        codeWriter.write(code);
        codeWriter.close();
    }
}
