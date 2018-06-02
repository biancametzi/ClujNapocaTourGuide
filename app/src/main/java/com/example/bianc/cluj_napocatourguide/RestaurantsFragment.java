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
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of hotels
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.samsara_food),
                getString(R.string.description_samsara_food),
                getString(R.string.address_samsara_food),
                getString(R.string.schedule_samsara_food),
                getString(R.string.phone_number_samsara_food),
                R.drawable.samsara_food));
        locations.add(new Location(getString(R.string.jaxx_food),
                getString(R.string.description_jaxx_food),
                getString(R.string.address_jaxx_food),
                getString(R.string.schedule_jaxx_food),
                getString(R.string.phone_number_jaxx_food),
                R.drawable.jaxx_food));
        locations.add(new Location(getString(R.string.joben_food),
                getString(R.string.description_joben_food),
                getString(R.string.address_joben_food),
                getString(R.string.schedule_joben_food),
                getString(R.string.phone_number_joben_food),
                R.drawable.joben_food));
        locations.add(new Location(getString(R.string.baracca_food),
                getString(R.string.description_baracca_food),
                getString(R.string.address_baracca_food),
                getString(R.string.schedule_baracca_food),
                getString(R.string.phone_number_baracca_food),
                R.drawable.baracca_food));
        locations.add(new Location(getString(R.string.klausen_food),
                getString(R.string.description_klausen_food),
                getString(R.string.address_klausen_food),
                getString(R.string.schedule_klausen_food),
                getString(R.string.phone_number_klausen_food),
                R.drawable.klausen_food));
        locations.add(new Location(getString(R.string.fabrica_food),
                getString(R.string.description_fabrica_food),
                getString(R.string.address_fabrica_food),
                getString(R.string.schedule_fabrica_food),
                getString(R.string.phone_number_fabrica_food),
                R.drawable.ursus_food));
        locations.add(new Location(getString(R.string.maimuta_food),
                getString(R.string.description_maimuta_food),
                getString(R.string.address_maimuta_food),
                getString(R.string.schedule_maimuta_food),
                getString(R.string.phone_number_maimuta_food),
                R.drawable.maimuta_food));
        locations.add(new Location(getString(R.string.euphoria_food),
                getString(R.string.description_euphoria_food),
                getString(R.string.address_euphoria_food),
                getString(R.string.schedule_euphoria_food),
                getString(R.string.phone_number_euphoria_food),
                R.drawable.euphoria_food));
        locations.add(new Location(getString(R.string.livada_food),
                getString(R.string.description_livada_food),
                getString(R.string.address_livada_food),
                getString(R.string.schedule_livada_food),
                getString(R.string.phone_number_livada_food),
                R.drawable.livada_food));
        locations.add(new Location(getString(R.string.carrousel_food),
                getString(R.string.description_carrousel_food),
                getString(R.string.address_carrousel_food),
                getString(R.string.schedule_carrousel_food),
                getString(R.string.phone_number_carrousel_food),
                R.drawable.carrousel_food));

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