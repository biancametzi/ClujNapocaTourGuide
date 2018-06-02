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
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of parks
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.central_park),
                getString(R.string.description_central_park),
                getString(R.string.address_central_park),
                getString(R.string.schedule_central_park),
                getString(R.string.phone_number_central_park),
                R.drawable.central_park));
        locations.add(new Location(getString(R.string.botanical_garden),
                getString(R.string.description_botanical_garden),
                getString(R.string.address_botanical_garden),
                getString(R.string.schedule_botanical_garden),
                getString(R.string.phone_number_botanical_garden),
                R.drawable.botanical_garden));
        locations.add(new Location(getString(R.string.cetatuie_hill),
                getString(R.string.description_cetatuie_hill),
                getString(R.string.address_cetatuie_hill),
                getString(R.string.schedule_cetatuie_hill),
                R.drawable.cetatuie_hill));
        locations.add(new Location(getString(R.string.hatieganu_park),
                getString(R.string.description_hatieganu_park),
                getString(R.string.address_hatieganu_park),
                getString(R.string.schedule_hatieganu_park),
                R.drawable.hatieganu_park));
        locations.add(new Location(getString(R.string.iulius_park),
                getString(R.string.description_iulius_park),
                getString(R.string.address_iulius_park),
                getString(R.string.schedule_iulius_park),
                R.drawable.iulius_park));
        locations.add(new Location(getString(R.string.adrenalin_park),
                getString(R.string.description_adrenalin_park),
                getString(R.string.address_adrenalin_park),
                getString(R.string.schedule_adrenalin_park),
                getString(R.string.phone_number_adrenalin_park),
                R.drawable.adrenalin_park));

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