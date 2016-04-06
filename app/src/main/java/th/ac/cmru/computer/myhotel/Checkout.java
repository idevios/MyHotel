package th.ac.cmru.computer.myhotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {
    CalendarView calendar;
    Button btnNext;
    String strCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Bundle bundle = getIntent().getExtras();
        final String strCheckin = bundle.getString("checkin");

        btnNext = (Button) findViewById(R.id.btnNext);
        calendar = (CalendarView) findViewById(R.id.calendar);

        // sets whether to show the week number.
        calendar.setShowWeekNumber(false);

        // sets the first day of week according to Calendar.
        // here we set Monday as the first day of the Calendar
        calendar.setFirstDayOfWeek(2);


        //sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), "CHECKOUT: "+day + "/" + month + "/" + year+
                        "\nCHECK-IN"+ strCheckin, Toast.LENGTH_LONG).show();
                strCheckout = day + "/" + month + "/" + year;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListRoom.class);
                intent.putExtra("checkin", strCheckin);
                intent.putExtra("checkout", strCheckout);
                startActivity(intent);
            }
        });



    }

}
