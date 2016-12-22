package com.example.luissam.mit.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luissam.mit.Clases.Lista_adaptador;
import com.example.luissam.mit.Clases.Lista_entrada;
import com.example.luissam.mit.Conexion.CONN;
import com.example.luissam.mit.MainActivity;
import com.example.luissam.mit.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicialFrag extends Fragment
    implements View.OnClickListener,
        AdapterView.OnItemSelectedListener{
    // TODO: Rename parameter arguments, choose names that match


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    int i = 0;
    String var[] = new String[20];
    String arrNombre [] = new String[20];
    Spinner spNombre;
    View myView;
    ImageButton ibtnBuscar;
    int selec;



    SimpleAdapter AD;
    private ListView lista;
    String resultado = "";
    CONN connectionClass;
    private ProgressDialog progress_dialog;

    ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();

    ArrayList<String> OEM = new ArrayList<String>();
    ArrayList<String> ConsFi = new ArrayList<String>();
    ArrayList<String> ConsSt = new ArrayList<String>();
    ArrayList<String> Orig = new ArrayList<String>();
    ArrayList<String> SupplierA = new ArrayList<String>();
    ArrayList<String> SupplierB = new ArrayList<String>();
    ArrayList<String> RetanForm = new ArrayList<String>();
    ArrayList<String> Drying = new ArrayList<String>();
    ArrayList<String> ProgModel = new ArrayList<String>();
    ArrayList<String> ProgModelSt = new ArrayList<String>();
    ArrayList<String> AppR = new ArrayList<String>();
    ArrayList<String> AppF = new ArrayList<String>();
    ArrayList<String> StanPef = new ArrayList<String>();
    ArrayList<String> SingleStr = new ArrayList<String>();
    ArrayList<String> LinealPerf = new ArrayList<String>();
    ArrayList<String> Lamination = new ArrayList<String>();
    ArrayList<String> ScreenPr = new ArrayList<String>();
    ArrayList<String> DigitalPr = new ArrayList<String>();
    ArrayList<String> Tipping = new ArrayList<String>();
    ArrayList<String> Woven = new ArrayList<String>();
    ArrayList<String> Seat = new ArrayList<String>();
    ArrayList<String> Laser = new ArrayList<String>();
    ArrayList<String> Embroidery = new ArrayList<String>();
    ArrayList<String> Single = new ArrayList<String>();
    ArrayList<String> CustomSt = new ArrayList<String>();
    ArrayList<String> Ironmoss = new ArrayList<String>();
    ArrayList<String> CustomEm = new ArrayList<String>();
    ArrayList<String> Branding = new ArrayList<String>();
    ArrayList<String> Deembossin = new ArrayList<String>();
    ArrayList<String> Skiving = new ArrayList<String>();
    ArrayList<String> EdgeSki = new ArrayList<String>();
    ArrayList<String> FoamBon = new ArrayList<String>();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InicialFrag() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static InicialFrag newInstance(String param1, String param2) {
        InicialFrag fragment = new InicialFrag();
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
        myView = inflater.inflate(R.layout.fragment_inicial, container, false);

        ibtnBuscar = (ImageButton) myView.findViewById(R.id.ibtnBuscar);
        ibtnBuscar.setOnClickListener(this);

        spNombre = (Spinner) myView.findViewById(R.id.spNombre);
        spNombre.setOnItemSelectedListener(this);

        SpinnerNombres("SELECT DISTINCT Pem FROM TechMap");

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

        switch (view.getId()) {

            case R.id.ibtnBuscar:

                selec = spNombre.getSelectedItemPosition();
                HiloBusqDatos tarea = new HiloBusqDatos();
                tarea.execute();
                SpinnerNombres("SELECT DISTINCT Pem FROM TechMap");

                break;

            default:
                break;

        }

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











    //Consultas


    public void SpinnerNombres (String COMANDOSQL){

        ResultSet rs;
        i = 0;

        connectionClass = new CONN();
        try{

            Connection conn = connectionClass.CONN();
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(COMANDOSQL);

            if (conn == null) {

                Toast.makeText(InicialFrag.this.getContext(), "DB not connected", Toast.LENGTH_LONG).show();

            } else {

                List<Map<String, String>> data = null;
                data = new ArrayList<Map<String,String>>();

                while(rs.next()) {

                    Map<String, String> datanum = new HashMap<String, String>();
                    datanum.put("A", rs.getString("Pem"));
                    data.add(datanum);

                    String[] from = {"A"};
                    int[] views = {R.id.tvMod};
                    AD = new SimpleAdapter(InicialFrag.this.getContext(), data, R.layout.modelo, from, views);
                    spNombre.setAdapter(AD);

                    arrNombre[i] = rs.getString("Pem");
                    i++;

                }//while(rs.next())


            }

        }catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e){
            Log.e("SpinnerNombres",e.getMessage());
        }


    }// public void CalcularMesSpinner(String COMANDOSQL)

    public void ListViewSQL (String COMANDOSQL){

        ResultSet rs;
        i = 0;

        connectionClass = new CONN();
        try{

            Connection conn = connectionClass.CONN();
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(COMANDOSQL);

            if (conn == null) {

                Toast.makeText(InicialFrag.this.getContext(), "DB not connected", Toast.LENGTH_LONG).show();

            } else {

                while(rs.next()) {

                    OEM.add(rs.getString("OEM"));
                    ConsFi.add(rs.getString("Construction / Finishing Family"));
                    ConsSt.add(rs.getString("Construction Status"));
                    Orig.add(rs.getString("Origin"));
                    SupplierA.add(rs.getString("Supplier A"));
                    SupplierB.add(rs.getString("Supplier B"));
                    RetanForm.add(rs.getString("Retan Formula"));
                    Drying.add(rs.getString("Drying"));
                    ProgModel.add(rs.getString("Program/Model"));
                    ProgModelSt.add("Program/Model Status");
                    AppR.add(rs.getString("Application-Roller"));
                    AppF.add(rs.getString("Application-Foam"));
                    StanPef.add(rs.getString("Standard Perf"));
                    SingleStr.add(rs.getString("Single Stroke Perf"));
                    LinealPerf.add(rs.getString("Lineal Perf"));
                    Lamination.add(rs.getString("Lamination"));
                    ScreenPr.add(rs.getString("Screen printing"));
                    DigitalPr.add(rs.getString("Digital Printing"));
                    Tipping.add(rs.getString("Tipping / Antiquing"));
                    Woven.add(rs.getString("Woven Leather"));
                    Seat.add(rs.getString("Seat Maping"));
                    Laser.add("Laser Etching");
                    Embroidery.add("Embroidery");
                    Single.add(rs.getString("Single Stitching"));
                    CustomSt.add(rs.getString("Custom Stitching"));
                    Ironmoss.add(rs.getString("Ironmossback"));
                    CustomEm.add(rs.getString("Custom Emboss"));
                    Branding.add(rs.getString("Branding / Emboss"));
                    Deembossin.add(rs.getString("Deembossing Logo"));
                    Skiving.add(rs.getString("Skiving"));
                    EdgeSki.add(rs.getString("Edge Skiving"));
                    FoamBon.add(rs.getString("Foam Bonding"));

                }//while(rs.next())

            }

        }catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e){
            Log.e("SpinnerNombres",e.getMessage());
        }


    }// public void ListViewSQL(String COMANDOSQL)

    //Otras

    public void llenar_lista ( ) {


        if (OEM.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "OEM", OEM.toString() ));
        } else {}
        if (ConsFi.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Construction / Finishing Family", ConsFi.toString() ));
        }    else {}
        if (ConsSt.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Construction Status", ConsSt.toString() ));
        }    else {}
        if (Orig.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Origin", Orig.toString() ));
        }    else {}
        if (SupplierA.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Supplier A", SupplierA.toString() ));
        }    else {}
        //if (SupplierB.size() != 0 ){
        //datos.add(new Lista_entrada(R.drawable.person, "Supplier B", SupplierB.toString() ));
        //}    else {}
        if (RetanForm.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Retan Formula", RetanForm.toString() ));
        }    else {}
        if (Drying.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Drying", Drying.toString() ));
        }    else {}
        if (ProgModel.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Program/Model", ProgModel.toString() ));
        }    else {}
        if (ProgModelSt.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Program/Model Status", ProgModelSt.toString() ));
        } else {}
        if (AppR.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Application-Roller", AppR.toString() ));
        } else {}
        if (AppF.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Application-Foam", AppF.toString() ));
        } else {}
        if (StanPef.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Standard Perf", StanPef.toString() ));
        } else {}
        if (SingleStr.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Single Stroke Perf", SingleStr.toString() ));
        } else {}
        if (LinealPerf.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Lineal Perf", LinealPerf.toString() ));
        } else {}
        if (Lamination.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Lamination", Lamination.toString() ));
        } else {}
        if (ScreenPr.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Screen printing", ScreenPr.toString() ));
        } else {}
        if (DigitalPr.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Digital Printing", DigitalPr.toString() ));
        } else {}
        if (Tipping.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Tipping / Antiquing", Tipping.toString() ));
        } else {}
        if (Woven.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Woven Leather", Woven.toString() ));
        } else {}
        if (Seat.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Seat Maping", Seat.toString() ));
        } else {}
        if (Laser.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Laser Etching", Laser.toString() ));
        } else {}
        if (Embroidery.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Embroidery", Embroidery.toString() ));
        } else {}
        if (Single.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Single Stitching", Single.toString() ));
        } else {}
        if (CustomSt.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Custom Stitching", CustomSt.toString() ));
        } else {}
        if (Branding.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Branding / Emboss", Branding.toString() ));
        } else {}
        if (Deembossin.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Deembossing Logo", Deembossin.toString() ));
        } else {}
        if (Skiving.size() != 0 ){
            datos.add(new Lista_entrada(R.drawable.person, "Skiving", Skiving.toString() ));
        } else {}
        if (EdgeSki.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Edge Skiving", EdgeSki.toString() ));
        } else {}
        if (FoamBon.size() != 0){
            datos.add(new Lista_entrada(R.drawable.person, "Foam Bonding", FoamBon.toString() ));
        }
        else  {}

        lista = (ListView) myView.findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(InicialFrag.this.getContext(), R.layout.modelo_entrada, datos){
            @Override
            public void onEntrada(Object modelo_entrada, View view) {
                if (modelo_entrada != null) {

                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.txvTitulo);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) modelo_entrada).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.tvList);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Lista_entrada) modelo_entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);

                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_entrada) modelo_entrada).get_idImagen());

                }

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(InicialFrag.this.getContext(), texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });


    }//public void llenar_lista ()


    //Hilos de ejecucion

    private class HiloBusqDatos extends AsyncTask<String, Void, String> {

        private HiloBusqDatos() { }

        protected String doInBackground(String... paramVarArgs) {

            ListViewSQL("SELECT * FROM TechMap WHERE Pem = '"+arrNombre[selec]+"' ");
            return "Ready!!";

        }

        protected void onPostExecute(String paramString) {
            InicialFrag.this.progress_dialog.dismiss();
            if (InicialFrag.this.resultado.equals("ERROR DE CONEXION")) {
                Toast.makeText(InicialFrag.this.getContext(), "ERROR", Toast.LENGTH_LONG).show();
                return;
            }
            Log.e("------->", paramString);
            if (!paramString.equals("Nologin")) {

                llenar_lista();
                return;

            }
        }

        protected void onPreExecute() {

            progress_dialog = new ProgressDialog(InicialFrag.this.getContext());
            InicialFrag.this.progress_dialog.setMessage("Please wait...");
            InicialFrag.this.progress_dialog.setProgressStyle(0);
            InicialFrag.this.progress_dialog.setCancelable(false);
            InicialFrag.this.progress_dialog.show();

        }

        protected void onProgressUpdate(Void... paramVarArgs) {
            Toast.makeText(InicialFrag.this.getContext(), "Progreso del hilo", Toast.LENGTH_LONG).show();
        }

    }// private class HiloBusqDatos extends AsyncTask <String, Void, String>




}
