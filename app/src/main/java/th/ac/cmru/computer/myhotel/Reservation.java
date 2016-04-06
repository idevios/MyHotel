package th.ac.cmru.computer.myhotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Reservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Reservation.this.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

}
