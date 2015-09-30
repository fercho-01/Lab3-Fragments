package co.edu.udea.cmovil.gr1.yambagr1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link blueColor_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link blueColor_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class blueColor_fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blue_color_fragment, container, false);
        // Inflate the layout for this fragment
        return v;
    }

}
