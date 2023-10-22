package tec.ispc.workflix.views.ui.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.MainActivity;
import tec.ispc.workflix.views.ui.guardar_datos.guardar_datos;
import tec.ispc.workflix.views.ui.perfil.Perfil;


public class ContactMail extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_mail, container, false);




    }

    public void btenviar (View view) {
        Intent intent = new Intent(requireContext(), guardar_datos.class);
        startActivity(intent);
    }





}