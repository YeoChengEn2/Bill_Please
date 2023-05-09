package sg.edu.rp.c346.id22022416.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay1;
    TextView tvDisplay2;
    TextView tvDisplay3;
    TextView tvDisplay4;
    TextView tvDisplay5;
    EditText etInput1;
    EditText etInput2;
    EditText etInput3;
    ToggleButton tbtn1;
    ToggleButton tbtn2;
    Button btnDisplay1;
    Button btnDisplay2;
    RadioGroup rgPayment;
    RadioButton rbCash;
    RadioButton rbPayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay1 = findViewById(R.id.amountText);
        tvDisplay2 = findViewById(R.id.paxNoText);
        tvDisplay3 = findViewById(R.id.discountText);
        tvDisplay4 = findViewById(R.id.totalBill);
        tvDisplay5 = findViewById(R.id.eachPays);
        etInput1 = findViewById(R.id.amountEdit);
        etInput2 = findViewById(R.id.paxNoEdit);
        etInput3 = findViewById(R.id.discountEdit);
        tbtn1 = findViewById(R.id.noSvs);
        tbtn2 = findViewById(R.id.gst);
        btnDisplay1 = findViewById(R.id.split);
        btnDisplay2 = findViewById(R.id.reset);
        rgPayment = findViewById(R.id.paymentRadio);
        rbCash = findViewById(R.id.cashRadio);
        rbPayNow = findViewById(R.id.payNowRadio);


        etInput1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput1.getText();
                int intResponse1 = etInput1.getText().length();
                if(intResponse1 < 0)
                {
                    Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_LONG).show();
                }
                if(intResponse1 > 0)
                {

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Empty input",Toast.LENGTH_LONG).show();
                }
            }
        });

        etInput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput2.getText();
                int intResponse2 = etInput2.getText().length();
                if(intResponse2 < 0)
                {
                    Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_LONG).show();
                }
                if(intResponse2 > 0)
                {

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Empty input",Toast.LENGTH_LONG).show();
                }
            }
        });

        etInput3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput3.getText();
                float floatResponse = etInput3.getText().length();
                if(floatResponse < 0)
                {
                    Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_LONG).show();
                }
                if(floatResponse >= 0)
                {

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Empty input",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDisplay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = etInput1.getText().toString();
                double b = Double.parseDouble(a);
                String c = etInput2.getText().toString();
                int d = Integer.parseInt(c);
                String e = etInput3.getText().toString();
                double f = Double.parseDouble(e);
                double noSvs = 0;
                double gst = 0;
                double totalBill = 0;
                double eachPays = 0;

                if(tbtn1.isChecked() && tbtn2.isChecked())
                {
                    noSvs = 0.1 * b;
                    gst = 0.07 * b;
                    totalBill = ((noSvs + gst + b) * ((1 - f) / 100));
                }
                else if(tbtn1.isChecked())
                {
                    noSvs = 0.1 * b;
                    totalBill = (noSvs + (((1 - f) / 100) * b));
                }
                else if(tbtn2.isChecked())
                {
                    gst = 0.07 * b;
                    totalBill = (gst + (((1 - f) / 100) * b));
                }
                else
                {
                    totalBill = ((1 - f / 100) * b);
                }

                tvDisplay4.setText("Total Bill: $" + totalBill);
                eachPays = (totalBill / d);

                if(rbCash.isChecked())
                {
                    tvDisplay5.setText("Each Pays: $" + String.format("%.2f",eachPays) + " in cash");
                }
                else
                {
                    tvDisplay5.setText("Each Pays: $" + String.format("%.2f",eachPays) + " via PayNow to 912345678");
                }
            }
        });

        btnDisplay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tbtn1.setChecked(false);
                tbtn2.setChecked(false);
            }
        });
    }
}