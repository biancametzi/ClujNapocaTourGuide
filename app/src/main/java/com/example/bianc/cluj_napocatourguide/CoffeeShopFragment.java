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
public class CoffeeShopFragment extends Fragment {


    public CoffeeShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of hotels
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.coffee_addicts),
                getString(R.string.description_coffee_addicts),
                getString(R.string.address_coffee_addicts),
                getString(R.string.schedule_coffee_addicts),
                getString(R.string.phone_number_coffee_addicts),
                R.drawable.coffee_addicts));
        locations.add(new Location(getString(R.string.q_caffe),
                getString(R.string.description_q_caffe),
                getString(R.string.address_q_caffe),
                getString(R.string.schedule_q_caffe),
                getString(R.string.phone_number_q_caffe),
                R.drawable.q_caffe));
        locations.add(new Location(getString(R.string.teo_cafe),
                getString(R.string.description_teo_cafe),
                getString(R.string.address_teo_cafe),
                getString(R.string.schedule_teo_cafe),
                getString(R.string.phone_number_teo_cafe),
                R.drawable.teo_cafe));
        locations.add(new Location(getString(R.string.narcoffee),
                getString(R.string.description_narcoffee),
                getString(R.string.address_narcoffee),
                getString(R.string.schedule_narcoffee),
                getString(R.string.phone_number_narcoffee),
                R.drawable.narcoffee));
        locations.add(new Location(getString(R.string.phil_coffee),
                getString(R.string.description_phil_coffee),
                getString(R.string.address_phil_coffee),
                getString(R.string.schedule_phil_coffee),
                getString(R.string.phone_number_phil_coffee),
                R.drawable.phil_coffee));

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
