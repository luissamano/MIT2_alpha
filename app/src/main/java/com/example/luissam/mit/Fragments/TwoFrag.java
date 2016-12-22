package com.example.luissam.mit.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luissam.mit.R;

public class TwoFrag extends Fragment
        implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View myView;
    ImageView img;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;

    private OnFragmentInteractionListener mListener;

    public TwoFrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TwoFrag newInstance(String param1, String param2) {
        TwoFrag fragment = new TwoFrag();
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
        myView = inflater.inflate(R.layout.fragment_two, container, false);

        btn1 = (Button) myView.findViewById(R.id.btn1);
        btn2 = (Button) myView.findViewById(R.id.btn2);
        btn3 = (Button) myView.findViewById(R.id.btn3);
        btn4 = (Button) myView.findViewById(R.id.btn4);
        btn5 = (Button) myView.findViewById(R.id.btn5);
        btn6 = (Button) myView.findViewById(R.id.btn6);
        btn7 = (Button) myView.findViewById(R.id.btn7);
        btn8 = (Button) myView.findViewById(R.id.btn8);
        btn9 = (Button) myView.findViewById(R.id.btn9);
        btn10 = (Button) myView.findViewById(R.id.btn10);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);

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
    public void onClick(View view) {

        LayoutInflater inflater = getLayoutInflater(getArguments());
        View dialoglayout = inflater.inflate(R.layout.imagev, null);
        img = (ImageView) dialoglayout.findViewById(R.id.ImV) ;
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        switch (view.getId()) {

            case R.id.btn1:
                break;

            case R.id.btn2:
                img.setImageResource(R.drawable.oembmw);
                builder.setView(dialoglayout);
                builder.setCancelable(true);
                builder.show();
                break;

            case R.id.btn3:
                break;

            default:
                break;

        }

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
}
