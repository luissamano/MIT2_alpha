package com.example.luissam.mit.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.luissam.mit.R;


public class SixFrag extends Fragment
        implements AdapterView.OnItemSelectedListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View myView;
    Spinner spinnerCons;
    ArrayAdapter<String> aaCons;

    String[] opcCons = new String [] {

            "Abbot",
            "Ascot",
            "Athens",
            "Bison",
            "Camden",
            "Capri",
            "Dakota",
            "Duke",
            "Genoa",
            "Kiesel NA",
            "Locarno",
            "Lugano",
            "Luxor",
            "Luxor Kiesel",
            "Luxor Savant",
            "Majesty II",
            "McKinley",
            "Meridian",
            "Merino",
            "Monaco",
            "Mulan",
            "Nappa",
            "Natura Plus",
            "Natura Plus Chrome Free",
            "Nevada",
            "Noble - Regular",
            "Noble - Sport",
            "Noble II",
            "Noble II Athens",
            "Nuance",
            "Oxford",
            "Shelf 2",
            "Soleil Kiesel",
            "Sovereign",
            "Sovereign II",
            "Venetto",
            "Vernazca",
            "Verona",
            "Vienna",
            "Walknappa"

    };

    private OnFragmentInteractionListener mListener;

    public SixFrag() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SixFrag newInstance(String param1, String param2) {
        SixFrag fragment = new SixFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_six, container, false);

        spinnerCons = (Spinner) myView.findViewById(R.id.spinnerCons);
        spinnerCons.setOnItemSelectedListener(this);

        aaCons = new ArrayAdapter <String> (this.getContext(), android.R.layout.simple_spinner_item, opcCons );
        spinnerCons.setAdapter(aaCons);

        return myView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
