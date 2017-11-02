package my.edu.tarc.lab21loan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSalary,editTextPrice,
            editTextDownpayment,editTextInterestRate, editTextRepaymentMonth;

    public static final String LOAN_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";
    public static final String LOAN_INTEREST = "interest";
    public static final String TOTAL_LOAN = "totalLoan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSalary = (EditText)findViewById(R.id.editTextSalary);
        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextDownpayment = (EditText)findViewById(R.id.editTextDownpayment);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextRepaymentMonth = (EditText)findViewById(R.id.editTextRepaymentMonth);
    }

    public void calculateLoan(View view){
        //TODO: Calculate Repayment amount & determine status
        double salary, price, downpayment, interestRate, repaymentMonth,
                totalInterest, totalLoan, monthlyPayment, partSalary;
        String status;

        salary = Double.parseDouble(editTextSalary.getText().toString());
        price = Double.parseDouble(editTextPrice.getText().toString());
        downpayment = Double.parseDouble(editTextDownpayment.getText().toString());
        interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        repaymentMonth = Double.parseDouble(editTextRepaymentMonth.getText().toString());

        totalInterest = (price - downpayment) * (interestRate/100) * (repaymentMonth/12);
        totalLoan = (price - downpayment) + totalInterest;
        monthlyPayment = totalLoan / totalInterest;

        partSalary = salary * 0.3;

        if(monthlyPayment > partSalary)
            status = "Reject";
        else
            status = "Approve";

        //Define an Intent object
        //This is an Explicit Intent
        Intent intent = new Intent(this,Result.class);

        //Use the putExtra method to pass data
        //format: putExtra(TAG,value);
        intent.putExtra(LOAN_INTEREST, totalInterest);
        intent.putExtra(TOTAL_LOAN,totalLoan);

        intent.putExtra(LOAN_PAYMENT,monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);

        startActivity(intent);
    }
}
