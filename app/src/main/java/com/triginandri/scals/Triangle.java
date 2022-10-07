package com.triginandri.scals;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Triangle extends Fragment {


    TextInputEditText fld_height,fld_alas;
    MaterialButton btn_clear,btn_calculate;
    TextView tv_luas, tv_keliling;
    LinearLayout lyt_result;
    float height, alas;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_triangle, container, false);


        fld_height = view.findViewById(R.id.txtHeight);
        fld_alas = view.findViewById(R.id.txtAlas);
        btn_calculate = view.findViewById(R.id.btnCalculate);
        btn_clear = view.findViewById(R.id.btnClear);
        tv_luas = view.findViewById(R.id.tv_luas);
        tv_keliling = view.findViewById(R.id.tv_keliling);
        lyt_result = view.findViewById(R.id.lyt_result);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fld_height.getText().toString().isEmpty() && fld_alas.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show();
                }else{
                    lyt_result.setVisibility(View.VISIBLE);
                    height = Float.parseFloat(fld_height.getText().toString());
                    alas = Float.parseFloat(fld_alas.getText().toString());
                    tv_luas.setText(luas(alas, height));
                    tv_keliling.setText(keliling(alas, height));
                }

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lyt_result.setVisibility(View.GONE);
                fld_height.setText("");
                fld_alas.setText("");

            }
        });

        return  view;
    }

    public String luas(float alas, float tinggi){
        float luas = Math.round((float) (0.5 * alas * tinggi));
        return Float.toString(luas);
    }

    public String keliling(float tinggi, float alas){
        float miring = Math.round((float) Math.sqrt(Math.pow(alas,2) + Math.pow(tinggi,2)));
        //rumus keliling segitiga sama kaki
//        float keliling = alas + miring + miring;
        //rumus keliling segitiga sama sisi
//        float keliling = alas + miring + alas;
        //rumus keliling segitiga siku2
        float keliling = alas + tinggi + miring;
        return Float.toString(keliling);
    }
}