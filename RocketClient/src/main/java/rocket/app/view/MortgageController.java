package rocket.app.view;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketData.LoanRequest;
import javafx.scene.control.Label;

public class MortgageController {

	@FXML TextField txtCreditScore;
	@FXML Label lblMortgageAmt;
	@FXML TextField txtHouseCost;
	@FXML TextField txtAnnualIncome;
	@FXML TextField txtMonthlyExpenses;
	@FXML Label lblDownPayment;
	@FXML ComboBox Cbox;
	
	
	private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void initialize(URL location, ResourceBundle resources){
		Cbox.getItems().addAll("15", "30");
		Cbox.getSelectionModel().select("15");
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
		
		LoanRequest lq = new LoanRequest();
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setIncome(Double.parseDouble(txtAnnualIncome.getText()));
		lq.setExpenses(Double.parseDouble(txtMonthlyExpenses.getText()));
		lq.setdPayment(Double.parseDouble(txtHouseCost.getText()));
		lq.setiTerm(Integer.parseInt(Cbox.getSelectionModel().getSelectedItem().toString()));
		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		lblDownPayment.setText(Double.toString(lRequest.getiDownPayment()));
		
		lblMortgageAmt.setText(Double.toString(lRequest.getdPayment()));
		}	
			
	}

