package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PrincipalController implements Initializable {
    @FXML
    private RadioButton rbtnMasc, rbtnFem;
    
    @FXML
    private TextField txtFldPeso,txtFldAltura;
    
    @FXML
    private Button btnCalcular;
    
    @FXML
    private Label lblIMC,lblCond;
    
    @FXML
    private void btnCalcularEvnt(ActionEvent event){
        double imc = (Double.parseDouble(txtFldPeso.getText()))/(Math.pow(Double.parseDouble(txtFldAltura.getText()),2));
        System.out.println(imc);
        lblIMC.setText("IMC: "+String.valueOf(imc));
        if(rbtnMasc.isSelected()){
            if(imc<20.7){
                lblCond.setText("Condição: abaixo do peso");
            }else if(imc>=20.7&&imc<26.4){
                      lblCond.setText("Condição: no peso normal");
                  }else if(imc>=26.4&&imc<27.8){
                            lblCond.setText("Condição: marginalmente acima do peso");
                        }else if(imc>=27.8&&imc<31.1){
                                lblCond.setText("Condição: acima do peso ideal");
                              }else{
                                  lblCond.setText("Condição: obeso");
                              }
        }else{
            if(imc<19.1){
                lblCond.setText("Condição: abaixo do peso");
            }else if(imc>=19.1&&imc<25.8){
                      lblCond.setText("Condição: no peso normal");
                  }else if(imc>=25.8&&imc<27.3){
                            lblCond.setText("Condição: marginalmente acima do peso");
                        }else if(imc>=27.3&&imc<32.3){
                                lblCond.setText("Condição: acima do peso ideal");
                              }else{
                                  lblCond.setText("Condição: obeso");
                              }
            
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final ToggleGroup sexo = new ToggleGroup();
        rbtnMasc.setToggleGroup(sexo);
        rbtnFem.setToggleGroup(sexo);
        btnCalcular.setDisable(true);
        
        
        txtFldAltura.textProperty().addListener((ObservableValue<? extends String> ov, String t, String t1) -> {
            System.out.println("Mudando "+ t +" "+ t1);
            if(t1.matches("\\d*\\.\\d*")||t1.matches("\\d*")){
                txtFldAltura.setText(t1);
                if(!txtFldPeso.getText().equals("")){
                    btnCalcular.setDisable(false);
                }
            }else{
                txtFldAltura.setText(t);
                btnCalcular.setDisable(true);
            }
            if(txtFldAltura.getText().equals("")||txtFldPeso.getText().equals("")){
                btnCalcular.setDisable(true);
            }
        });
        
        txtFldPeso.textProperty().addListener((ObservableValue<? extends String> ov, String t, String t1) -> {
            System.out.println("Mudando "+ t +" "+ t1);
            if(t1.matches("\\d*\\.\\d*")||t1.matches("\\d*")){
                txtFldPeso.setText(t1);
                if(!txtFldAltura.getText().equals("")){
                    btnCalcular.setDisable(false);
                }
            }else{
                txtFldPeso.setText(t);
                btnCalcular.setDisable(true);
            } if(txtFldAltura.getText().equals("")||txtFldPeso.getText().equals("")){
                btnCalcular.setDisable(true);
            }
        });
        
    }    
}
