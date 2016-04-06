package th.ac.cmru.computer.myhotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReservationSummary extends AppCompatActivity {

    TextView roomName, contactName;
    DBHelper myDB;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_summary);

        roomName = (TextView) findViewById(R.id.roomName);
        contactName = (TextView) findViewById(R.id.contactName);
//        checkinDate = (TextView) findViewById(R.id.checkinDate);
//        checkoutDate = (TextView) findViewById(R.id.checkoutDate);
//        roomPrice = (TextView) findViewById(R.id.roomPrice);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);

        myDB = new DBHelper(this);
        int numRows = myDB.numberOfRows();

        ArrayList arrayList = myDB.getAllData(numRows);
        roomName.setText(arrayList.toString());

        ArrayList arrayListUser = myDB.getUserData(numRows);
        contactName.setText(arrayListUser.toString());

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
