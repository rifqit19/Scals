package com.triginandri.scals;

import android.content.Context;
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

public class Square extends Fragment {

    TextInputEditText fld_height,fld_width;
    MaterialButton btn_clear,btn_calculate;
    TextView tv_luas, tv_keliling;
    LinearLayout lyt_result;
    float height,width;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.fragment_square, null);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_square, container, false);

        fld_height = view.findViewById(R.id.txtHeight);
        fld_width = view.findViewById(R.id.txtWidth);
        btn_calculate = view.findViewById(R.id.btnCalculate);
        btn_clear = view.findViewById(R.id.btnClear);
        tv_luas = view.findViewById(R.id.tv_luas);
        tv_keliling = view.findViewById(R.id.tv_keliling);
        lyt_result = view.findViewById(R.id.lyt_result);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fld_height.getText().toString().isEmpty() && fld_width.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show();

                }else{
                    lyt_result.setVisibility(View.VISIBLE);

                    height = Float.parseFloat(fld_height.getText().toString().trim());
                    width = Float.parseFloat(fld_width.getText().toString().trim());
                    tv_luas.setText(luas(height,width));
                    tv_keliling.setText(keliling(height,width));
                }

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lyt_result.setVisibility(View.GONE);
                fld_height.setText("");
                fld_width.setText("");
            }
        });

        return view;
    }

    public String luas(float panjang, float lebar){
        float luas = Math.round(panjang * lebar);
        return Float.toString(luas);
    }

    public String keliling(float panjang, float lebar){
        float keliling = Math.round((2*panjang) + (2*lebar));
        return Float.toString(keliling);
    }

}