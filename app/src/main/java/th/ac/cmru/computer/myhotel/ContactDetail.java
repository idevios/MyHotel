package th.ac.cmru.computer.myhotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactDetail extends AppCompatActivity {
    EditText txtName, txtPhone, txtEmail;
    Button btnBook;
    DBHelper myDB;
    String strCheckin, strCheckout, roomName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Bundle bundle = getIntent().getExtras();
        final String strCheckin = bundle.getString("checkin");
        final String strCheckout = bundle.getString("checkout");
        final String roomName = bundle.getString("roomname");

        txtName = (EditText) findViewById(R.id.name);
        txtPhone = (EditText) findViewById(R.id.phone);
        txtEmail = (EditText) findViewById(R.id.email);
        myDB = new DBHelper(this);

        btnBook = (Button) findViewById(R.id.btnBook);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtName.getText().toString() == "" || txtPhone.getText().toString() == "" || txtEmail.getText().toString() == ""){
                    Toast.makeText(getApplicationContext(), "Fill in all data", Toast.LENGTH_SHORT).show();
                }else{
                    myDB.insertData(strCheckin, strCheckout, roomName);
                    myDB.insertUser(txtName.getText().toString(),txtPhone.getText().toString(),txtEmail.getText().toString());
                }

                Intent intent = new Intent(getApplicationContext(), ReservationSummary.class);
                startActivity(intent);

            }
        });

    }
}
