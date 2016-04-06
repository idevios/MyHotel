package th.ac.cmru.computer.myhotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReservationSummary extends AppCompatActivity {

    TextView roomName, checkinDate, checkoutDate, roomPrice;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_summary);

        roomName = (TextView) findViewById(R.id.roomName);
        checkinDate = (TextView) findViewById(R.id.checkinDate);
        checkoutDate = (TextView) findViewById(R.id.checkoutDate);
        roomPrice = (TextView) findViewById(R.id.roomPrice);

        myDB = new DBHelper(this);

        ArrayList arrayList = myDB.getAllData();
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arrayList);

        roomName.setText(arrayList.toString());

    }

    public void showData(){

    }

}
