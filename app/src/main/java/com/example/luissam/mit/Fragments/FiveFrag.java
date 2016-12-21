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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FiveFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FiveFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FiveFrag extends Fragment
        implements AdapterView.OnItemSelectedListener{


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View myView;
    Spinner spinnerClient;
    ArrayAdapter<String> aaClient;

    String[] opcClient = new String [] {

            "Ediasa 4, MTM",
            "Ediasa 4",
            "Toyota Japan (TB Kyushu)",
            "Toyota Japan",
            "TB Chavez",
            "Lear La Cuesta, TB Torreón",
            "JCI Lerma, JCI Ediasa 3",
            "JCI Ediasa 1",
            "Magna Acuña",
            "JCI Ediasa 1, Grammer Qro.",
            "Magna Acuña, AFX, Kongsberg, Grammer Qro.",
            "Magna Acuña, IAC Saltillo",
            "JCI Ediasa 1, TTSaltillo, INOAC, MISC",
            "Irvin",
            "JCI Ramos II, JCI Qro.",
            "Tachi-S",
            "Faurecia",
            "Faurecia Ramos",
            "Hansuh",
            "Hansuh / KMIN",
            "Lear San Lorenzo",
            "JCI Ediasa 3",
            "Tricon  NVL",
            "Magna Allende, HFI, LLC",
            "Ediasa 3",
            "JCI Ediasa 4",
            "Lear La Cuesta, Magna Sabinas",
            "Magna Allende, HFI, LLC",
            "Lear Zacatecas",
            "Faurecia Hujotzingo",
            "Recaro, E3, CNI, JCI, JCI Qro, WPI, Daimay",
            "JCI Pue, Lear Pue, BOS Ira, Haas, Grammer",
            "Aunde Puebla"

    };


    private OnFragmentInteractionListener mListener;

    public FiveFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FiveFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static FiveFrag newInstance(String param1, String param2) {
        FiveFrag fragment = new FiveFrag();
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
        myView = inflater.inflate(R.layout.fragment_five, container, false);

        spinnerClient = (Spinner) myView.findViewById(R.id.spinnerClient);
        spinnerClient.setOnItemSelectedListener(this);

        aaClient = new ArrayAdapter <String> (this.getContext(), android.R.layout.simple_spinner_item, opcClient );
        spinnerClient.setAdapter(aaClient);

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
