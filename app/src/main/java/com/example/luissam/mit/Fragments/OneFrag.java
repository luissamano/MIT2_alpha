package com.example.luissam.mit.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.luissam.mit.R;

public class OneFrag extends Fragment
        implements View.OnClickListener{

    TextView txv1,txv2,txv3,txv4,txv5;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btnOK;
    View myView;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public OneFrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static OneFrag newInstance(String param1, String param2) {
        OneFrag fragment = new OneFrag();
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
        myView = inflater.inflate(R.layout.fragment_one, container, false);

        btn1 = (Button) myView.findViewById(R.id.btn1);
        btn2 = (Button) myView.findViewById(R.id.btn2);
        btn3 = (Button) myView.findViewById(R.id.btn3);
        btn4 = (Button) myView.findViewById(R.id.btn4);
        btn5 = (Button) myView.findViewById(R.id.btn5);
        btn6 = (Button) myView.findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

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

        Drawable bitmap;

        LayoutInflater inflater = getLayoutInflater(getArguments());
        View dialoglayout = inflater.inflate(R.layout.dialogomuestra, null);
        txv1 = (TextView) dialoglayout.findViewById(R.id.txv1);
        txv2 = (TextView) dialoglayout.findViewById(R.id.txv2);
        txv3 = (TextView) dialoglayout.findViewById(R.id.txv3);
        txv4 = (TextView) dialoglayout.findViewById(R.id.txv4);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());



        switch (view.getId()){

            case R.id.btn1:


                txv1.setText("Pem\nArturo Avila");
                txv2.setText("Oem\nChrysler");
                txv3.setText("Constrution\n-Capri -McKinley  -Nappa\n-Natura Plus -Bristol\nNatura Plus Chrome - Free");
                txv4.setText("Location\nLeon");


                builder.setView(dialoglayout);
                builder.show();

                break;

            case R.id.btn2:

                txv1.setText("Pem\nCarlos Gonzalez");
                txv2.setText("Oem\nDaimier");
                txv3.setText("Constrution\n-Lugano -Locarno\n-Nappa");
                txv4.setText("Location\nS/I");


                builder.setView(dialoglayout);
                builder.show();

                break;

            case R.id.btn3:

                txv1.setText("Pem\nClaudia Manrique");
                txv2.setText("Oem\nToyota");
                txv3.setText("Constrution\n-Sovereign -Luxor Savant -Noble II\n-Sovereign II -Noble II Athens");
                txv4.setText("Location\nS/I");


                builder.setView(dialoglayout);
                builder.show();

                break;

            case R.id.btn4:

                txv1.setText("Pem\nMiguel Ochoa");
                txv2.setText("Oem\nBMW");
                txv3.setText("Constrution\n-Nevada -Dakota\n-Vernazca -Merino");
                txv4.setText("Location\nS/I");


                builder.setView(dialoglayout);
                builder.show();

                break;


            case R.id.btn5:

                txv1.setText("Pem\nAntonio Ortega");
                txv2.setText("Oem\n-Ford\n-GM\n-VW");
                txv3.setText("Constrution\nFord: Verona\n\nGM: -Meridian -Kiesel NA -Soleli Kiesel\n-Naunce -Athens -Mulan\n\nVW:Vienna");
                txv4.setText("Location\nS/I");


                builder.setView(dialoglayout);
                builder.show();

                break;

            case R.id.btn6:

                txv1.setText("Pem\nRidardo Reyes");
                txv2.setText("Oem\n-NISSAN -KIA -HYUNDAI\n-HONDA -INFINITI -ACURA");
                txv3.setText("Constrution\nNISSAN: -Ascot - Bison -Camden\n-Duke -Oxford -Walknappa\n\nACURA: -Shelf 2\n\nHONDA: -Abbot\nHYUNDAI: Genoa\nINFINITY: -Asot KIA: -Momaco -Vnatto");
                txv4.setText("Location\nS/I");


                builder.setView(dialoglayout);
                builder.show();

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
