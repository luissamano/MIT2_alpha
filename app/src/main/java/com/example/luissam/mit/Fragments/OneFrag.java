package com.example.luissam.mit.Fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.example.luissam.mit.Clases.Lista_Pem;
import com.example.luissam.mit.Clases.Lista_adaptador;
import com.example.luissam.mit.Clases.Lista_entrada;
import com.example.luissam.mit.Conexion.CONN;
import com.example.luissam.mit.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneFrag extends Fragment
        implements View.OnClickListener{


    ArrayList<Lista_Pem> alPem = new ArrayList<Lista_Pem>();
    private ProgressDialog progress_dialog;
    private String resultado="";
    TextView txv1,txv2,txv3,txv4,txv5;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btnOK;
    View myView;
    int i = 0;
    CONN connectionClass;
    ListView listD;
    ImageView img;

    int numpem;
    String Pem[];




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

        OneFrag.HiloBusqDatos tarea = new OneFrag.HiloBusqDatos();
        tarea.execute();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_one, container, false);

        listD = (ListView) myView.findViewById(R.id.listD);

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
        txv1 = (TextView) dialoglayout.findViewById(R.id.txv1);
        txv2 = (TextView) dialoglayout.findViewById(R.id.txv2);
        txv3 = (TextView) dialoglayout.findViewById(R.id.txv3);
        txv4 = (TextView) dialoglayout.findViewById(R.id.txv4);

        img = (ImageView) dialoglayout.findViewById(R.id.ImV) ;
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());



        switch (view.getId()){

            case R.id.btn1:


                /*txv1.setText("Pem\nArturo Avila");
                txv2.setText("Oem\nChrysler");
                txv3.setText("Constrution\n-Capri -McKinley  -Nappa\n-Natura Plus -Bristol\nNatura Plus Chrome - Free");
                txv4.setText("Location\nLeon");*/


                img.setImageResource(R.drawable.arturoavila);

                builder.setView(dialoglayout);
                builder.show();

                break;

            case R.id.btn2:

                //txv1.setText("Pem\nCarlos Gonzalez");
                //txv2.setText("Oem\nDaimier");
                //txv3.setText("Constrution\n-Lugano -Locarno\n-Nappa");
                //txv4.setText("Location\nS/I");

                img.setImageResource(R.drawable.carlosgonzalez);
                builder.setView(dialoglayout);
                builder.show();

                break;

            case R.id.btn3:

                /*txv1.setText("Pem\nClaudia Manrique");
                txv2.setText("Oem\nToyota");
                txv3.setText("Constrution\n-Sovereign -Luxor Savant -Noble II\n-Sovereign II -Noble II Athens");
                txv4.setText("Location\nS/I");*/

                img.setImageResource(R.drawable.marique);
                builder.setView(dialoglayout);
                builder.show();

                break;

            case R.id.btn4:

                /*txv1.setText("Pem\nMiguel Ochoa");
                txv2.setText("Oem\nBMW");
                txv3.setText("Constrution\n-Nevada -Dakota\n-Vernazca -Merino");
                txv4.setText("Location\nS/I");*/

                img.setImageResource(R.drawable.miguelochoa);
                builder.setView(dialoglayout);
                builder.show();

                break;


            case R.id.btn5:

                /*txv1.setText("Pem\nAntonio Ortega");
                txv2.setText("Oem\n-Ford\n-GM\n-VW");
                txv3.setText("Constrution\nFord: Verona\n\nGM: -Meridian -Kiesel NA -Soleli Kiesel\n-Naunce -Athens -Mulan\n\nVW:Vienna");
                txv4.setText("Location\nS/I");*/

                img.setImageResource(R.drawable.antonioortega);
                builder.setView(dialoglayout);
                builder.show();

                break;

            case R.id.btn6:

                /*txv1.setText("Pem\nRidardo Reyes");
                txv2.setText("Oem\n-NISSAN -KIA -HYUNDAI\n-HONDA -INFINITI -ACURA");
                txv3.setText("Constrution\nNISSAN: -Ascot - Bison -Camden\n-Duke -Oxford -Walknappa\n\nACURA: -Shelf 2\n\nHONDA: -Abbot\nHYUNDAI: Genoa\nINFINITY: -Asot KIA: -Momaco -Vnatto");
                txv4.setText("Location\nS/I");*/


                img.setImageResource(R.drawable.ricardo);
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



    public void SpinnerNum (String COMANDOSQL){

        ResultSet rs;

        connectionClass = new CONN();
        try{

            Connection conn = connectionClass.CONN();
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(COMANDOSQL);

            if (conn == null) {

                Toast.makeText(OneFrag.this.getContext(), "DB not connected", Toast.LENGTH_LONG).show();

            } else {

                while(rs.next()) {

                    numpem = rs.getInt("NumeroCampos");

                }//while(rs.next())

            }

        }catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e){
            Log.e("SpinnerNum",e.getMessage());
        }


    }// public void CalcularMesSpinner(String COMANDOSQL)

    public void SpinnerNombres (String COMANDOSQL){

        ResultSet rs;
        i = 0;

        connectionClass = new CONN();
        try{

            Connection conn = connectionClass.CONN();
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(COMANDOSQL);

            if (conn == null) {

                Toast.makeText(OneFrag.this.getContext(), "DB not connected", Toast.LENGTH_LONG).show();

            } else {

                while(rs.next()) {

                    Pem[i] = rs.getString("Pem");
                    i++;

                }//while(rs.next())

            }

        }catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e){
            Log.e("SpinnerNum",e.getMessage());
        }


    }// public void CalcularMesSpinner(String COMANDOSQL)

    private class HiloBusqDatos extends AsyncTask<String, Void, String> {

        private HiloBusqDatos() { }

        protected String doInBackground(String... paramVarArgs) {

            SpinnerNum("SELECT COUNT(*) As NumeroCampos FROM (SELECT DISTINCT Pem FROM TechMap ) as Num");
            Pem = new String[numpem];
            SpinnerNombres("SELECT DISTINCT Pem FROM TechMap");
            return "Ready!!";

        }

        protected void onPostExecute(String paramString) {
            OneFrag.this.progress_dialog.dismiss();
            if (OneFrag.this.resultado.equals("ERROR DE CONEXION")) {
                Toast.makeText(OneFrag.this.getContext(), "ERROR", Toast.LENGTH_LONG).show();
                return;
            }
            Log.e("------->", paramString);
            if (!paramString.equals("Nologin")) {

                LlenarVista();
                return;

            }
        }

        protected void onPreExecute() {

            progress_dialog = new ProgressDialog(OneFrag.this.getContext());
            OneFrag.this.progress_dialog.setMessage("Please wait...");
            OneFrag.this.progress_dialog.setProgressStyle(0);
            OneFrag.this.progress_dialog.setCancelable(false);
            OneFrag.this.progress_dialog.show();

        }

        protected void onProgressUpdate(Void... paramVarArgs) {
            Toast.makeText(OneFrag.this.getContext(), "Progreso del hilo", Toast.LENGTH_LONG).show();
        }

    }// private class HiloBusqDatos extends AsyncTask <String, Void, String>



    public void LlenarVista () {

        i = 0;

        do {
            alPem.add(new Lista_Pem( Pem[i]));
            i++;
        } while (i < numpem);

        listD = (ListView) myView.findViewById(R.id.listD);
        listD.setAdapter(new Lista_adaptador(OneFrag.this.getContext(), R.layout.modelo_entrada_pem, alPem){
            @Override
            public void onEntrada(Object modelo_entrada_pem, View view) {
                if (modelo_entrada_pem != null) {

                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.txvTitulo);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_Pem) modelo_entrada_pem).get_texto());

                }

            }
        });

        listD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_Pem elegido = (Lista_Pem) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido.get_texto();
                Toast toast = Toast.makeText(OneFrag.this.getContext(), texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }



}
