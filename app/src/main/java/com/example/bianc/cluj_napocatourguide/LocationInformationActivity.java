package com.example.bianc.cluj_napocatourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class LocationInformationActivity extends AppCompatActivity {

    private ImageView mlocationImage;
    private TextView mlocationName;
    private TextView mlocationDescription;
    private TextView mlocationAddress;
    private TextView mlocationSchedule;
    private TextView mlocationPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_information);

        mlocationImage = (ImageView) findViewById(R.id.location_image);
        mlocationName = (TextView) findViewById(R.id.location_name);
        mlocationDescription = (TextView) findViewById(R.id.location_description);
        mlocationAddress = (TextView) findViewById(R.id.location_address);
        mlocationSchedule = (TextView) findViewById(R.id.location_schedule);
        mlocationPhoneNumber = (TextView) findViewById(R.id.location_phone_number);

        Intent locationSelected = getIntent();
        Location location = locationSelected.getParcelableExtra("Location");

        int locationImage = location.getImageResourceId();
        String locationName = location.getLocationName();
        String locationDescription = location.getLocationDescription();
        final String locationAddress = location.getLocationAddress();
        String locationSchedule = location.getlocationSchedule();
        String locationPhoneNumber = location.getlocationPhoneNumber();

        this.setTitle(locationName);

        mlocationImage.setImageResource(locationImage);
        mlocationDescription.setText(locationDescription);
        mlocationAddress.setText(locationAddress);
        mlocationSchedule.setText(locationSchedule);
        mlocationPhoneNumber.setText(locationPhoneNumber);

        // OnClickListener that open intent with location address in Google Maps
        mlocationAddress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + locationAddress);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }

}
