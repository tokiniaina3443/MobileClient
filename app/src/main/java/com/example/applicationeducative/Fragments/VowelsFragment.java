package com.example.applicationeducative.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.applicationeducative.R;

/**
 * Vowels fragment.
 */
public class VowelsFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private TextView txtA, txtE, txtI, txtO, txtU;


    public VowelsFragment() {
        // Constructeur vide
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //
        View view = inflater.inflate(R.layout.fragment_vowels, container, false);

        txtA = view.findViewById(R.id.txtA);
        txtE = view.findViewById(R.id.txtE);
        txtI = view.findViewById(R.id.txtI);
        txtO = view.findViewById(R.id.txtO);
        txtU = view.findViewById(R.id.txtU);

        // click events
        txtA.setOnClickListener(this);
        txtE.setOnClickListener(this);
        txtI.setOnClickListener(this);
        txtO.setOnClickListener(this);
        txtU.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Button Clicked", "Item: " + v.getId());

        switch (v.getId()) {
            case R.id.txtA:
                playSound(R.raw.a);
                break;
            case R.id.txtE:
                playSound(R.raw.e);
                break;
            case R.id.txtI:
                playSound(R.raw.i);
                break;
            case R.id.txtO:
                playSound(R.raw.o);
                break;
            case R.id.txtU:
                playSound(R.raw.u);
                break;
        }
    }

    public void playSound (int sound) {
        mediaPlayer = MediaPlayer.create(getActivity(), sound);
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

