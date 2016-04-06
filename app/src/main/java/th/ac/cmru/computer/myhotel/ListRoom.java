package th.ac.cmru.computer.myhotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_room);

        Bundle bundle = getIntent().getExtras();
        final String strCheckin = bundle.getString("checkin");
        final String strCheckout = bundle.getString("checkout");

        int[] resId = { R.drawable.pic_room
                , R.drawable.pic_room, R.drawable.pic_room
                , R.drawable.pic_room, R.drawable.pic_room
                , R.drawable.pic_room, R.drawable.pic_room
                , R.drawable.pic_room, R.drawable.pic_room
                , R.drawable.pic_room, R.drawable.pic_room };

        final String[] listRoom = { "Superior Room 1\n 1,500", "Deluxe Room 1\n 2,500", "Suite Room 1\n 3,000"
                , "Double BedRoom 1\n 3,200", "Single BedRoom 1\n 2,700","Superior Room 2\n 1,600", "Deluxe Room 2\n 2,600", "Suite Room 2\n 3,100"
                , "Double BedRoom 2\n 3,300", "Single BedRoom 2\n 2,800"};

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), listRoom, resId);

        ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), ContactDetail.class);
                intent.putExtra("checkin", strCheckin);
                intent.putExtra("checkout", strCheckout);
                intent.putExtra("roomname", listRoom[position]);
                startActivity(intent);

            }
        });

    }
}
