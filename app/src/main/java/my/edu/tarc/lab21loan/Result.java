package my.edu.tarc.lab21loan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private TextView textViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewStatus = (TextView)findViewById(R.id.textViewStatus);

        //To get the intent
        Intent intent = getIntent(); //Asking "who called me?"
        double payment = intent.getDoubleExtra(MainActivity.LOAN_PAYMENT,0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);
        double totalInterest = intent.getDoubleExtra(MainActivity.LOAN_INTEREST,0);
        double totalLoan = intent.getDoubleExtra(MainActivity.TOTAL_LOAN,0);

        //TODO: display outputs
        ImageView image;

        if(status == "Approve"){
            image = (ImageView)findViewById(R.id.imageViewResult);
            image.setImageResource(R.drawable.thumbsup);
            textViewStatus.setText("Approved" + " Total Interest: " + String.format("%.2f",totalInterest)
            + " Total Loan: " + String.format("%.2f",totalLoan));
        }

        else{
            image = (ImageView)findViewById(R.id.imageViewResult);
            image.setImageResource(R.drawable.thumbsdown);
            textViewStatus.setText("Rejected" + " Total Interest: " + String.format("%.2f",totalInterest)
                    + " Total Loan: " + String.format("%.2f",totalLoan));
        }

    }

    public void closeActivity(View view){
        //Terminate an activity
        finish();
    }
}
