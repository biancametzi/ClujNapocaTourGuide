package com.example.bianc.cluj_napocatourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of hotels
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.hampton_hotel),
                getString(R.string.description_hampton_hotel),
                getString(R.string.address_hampton_hotel),
                getString(R.string.schedule_hampton_hotel),
                getString(R.string.phone_number_hampton_hotel),
                R.drawable.hampton_hotel));
        locations.add(new Location(getString(R.string.golden_tulip_hotel),
                getString(R.string.description_golden_tulip),
                getString(R.string.address_golden_tulip),
                getString(R.string.schedule_golden_tulip),
                getString(R.string.phone_number_golden_tulip),
                R.drawable.golden_tulip));
        locations.add(new Location(getString(R.string.grand_italia_hotel),
                getString(R.string.description_grand_italia),
                getString(R.string.address_grand_italia),
                getString(R.string.schedule_grand_italia),
                getString(R.string.phone_number_grand_italia),
                R.drawable.grand_italia));
        locations.add(new Location(getString(R.string.ramada_hotel),
                getString(R.string.description_ramada_hotel),
                getString(R.string.address_ramada_hotel),
                getString(R.string.schedule_ramada_hotel),
                getString(R.string.phone_number_ramada_hotel),
                R.drawable.ramada_hotel));
        locations.add(new Location(getString(R.string.belvedere_hotel),
                getString(R.string.description_belvedere_hotel),
                getString(R.string.address_belvedere_hotel),
                getString(R.string.schedule_belvedere_hotel),
                getString(R.string.phone_number_belvedere_hotel),
                R.drawable.belvedere_hotel));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        GridView gridView = (GridView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        gridView.setAdapter(adapter);

        // OnClickListener that send selected object with Parcelable to LocationActivity
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Location location = locations.get(position);
                Intent selectedLocation = new Intent(getActivity(), LocationInformationActivity.class);
                selectedLocation.putExtra("Location", location);
                startActivity(selectedLocation);
            }
        });

        return rootView;
    }

}