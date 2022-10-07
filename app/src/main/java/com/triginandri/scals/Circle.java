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

public class Circle extends Fragment {

    TextInputEditText fld_diameter;
    MaterialButton btn_clear,btn_calculate;
    TextView tv_luas, tv_keliling;
    LinearLayout lyt_result;
    float diameter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle, container, false);

        fld_diameter = view.findViewById(R.id.txtDiameter);
        btn_calculate = view.findViewById(R.id.btnCalculate);
        btn_clear = view.findViewById(R.id.btnClear);
        tv_luas = view.findViewById(R.id.tv_luas);
        tv_keliling = view.findViewById(R.id.tv_keliling);
        lyt_result = view.findViewById(R.id.lyt_result);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fld_diameter.getText().toString().isEmpty() ){
                    Toast.makeText(getActivity(), "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show();

                }else{
                    lyt_result.setVisibility(View.VISIBLE);

                    diameter = Float.parseFloat(fld_diameter.getText().toString());
                    Log.d("Luas keliling", luas(diameter)+" "+keliling(diameter));
                    tv_luas.setText(luas(diameter));
                    tv_keliling.setText(keliling(diameter));


                }

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lyt_result.setVisibility(View.GONE);
                fld_diameter.setText("");

            }
        });

        return view;
    }

    public String luas(float diameter){
        float luas = Math.round ((float) (Math.PI * Math.pow(diameter/2, 2)));
        return Float.toString(luas);
    }

    public String keliling(float diameter){
        float keliling = Math.round((float) (2* Math.PI * (diameter/2)));
        return Float.toString(keliling);
    }
}