package loanCalculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.text.DecimalFormat;

public class loanCalculator extends Application{
	//private variables
	private Label lblMessage1 = new Label("This calculates ");
	private Label lblMessage2 = new Label("Loan payments");

	private Label loanLength = new Label(" Enter loan length (years): ");
	private Label loanInterest = new Label(" Enter loan interest rate: ");
	private Label loanAmount = new Label(" Enter total loan amount: ");

	private Label lblAnswer = new Label(" ???  ");

	private TextField tfLength = new TextField();
	private TextField tfInterest = new TextField();
	private TextField tfAmount = new TextField();

	private TextField tfAnswer = new TextField();

	private Button btLoanPayment = new Button("Calculate Monthly Payment");

	@Override

	public void start(Stage primaryStage)
	{
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(15, 15, 15, 15));
		pane.setHgap(10);
		pane.setVgap(10);
		//
		pane.add(lblMessage1, 0, 5);
		pane.add(lblMessage2, 1, 5);

		pane.add(loanLength, 0, 0);
		pane.add(tfLength, 1, 0);
		pane.add(loanInterest, 0, 1);
		pane.add(tfInterest, 1, 1);
		pane.add(loanAmount, 0, 2);
		pane.add(tfAmount, 1, 2);


		pane.add(lblAnswer, 0, 4);
		pane.add(tfAnswer, 1, 4);

		pane.add(btLoanPayment, 1, 3);

		//
		btLoanPayment.setOnAction(e -> calculateLoanPay());

		//
		//
		GridPane.setHalignment(btLoanPayment, HPos.LEFT);

		tfLength.setEditable(true);
		tfInterest.setEditable(true);
		tfAmount.setEditable(true);

		tfAnswer.setEditable(true);


		//set scene and stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Loan Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}//end start

	private void calculateLoanPay()
	{
		DecimalFormat fmt = new DecimalFormat("$###,###.##");

		String strLength = tfLength.getText();
		double loanLength = Double.parseDouble(strLength);

		String strInterest = tfInterest.getText();
		double loanInterest = Double.parseDouble(strLength);

		String strAmount = tfAmount.getText();
		double loanAmount = Double.parseDouble(strLength);
		double tempLoanAmount = loanAmount;

		double loanLengthMonths = loanLength *12;
		double interest = loanInterest*100;
		double monthlyPayment;

		while(tempLoanAmount!=0) {

			//double monthlyBalance = loanAmount / loanLengthMonths;

			//double interest = (monthlyBalance * loanInterest) / 100;
			monthlyPayment = tempLoanAmount * interest;
			//monthlyPayment = (monthlyBalance + interest);
			tempLoanAmount = tempLoanAmount - monthlyPayment;
			loanAmount = monthlyPayment + loanAmount;
		}

		monthlyPayment = loanAmount/loanLengthMonths;

		lblAnswer.setText("The payment is ");
		tfAnswer.setText(fmt.format(monthlyPayment));


	}
	 public static void main (String[] args) {

		 Application.launch(args);
	 }
}