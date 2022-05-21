package com.example.applicationeducative.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.applicationeducative.R;

/**
 * Numbers fragment.
 */
public class NumbersFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private ImageButton imageButtonOne, imageButtonTwo, imageButtonThree,
            imageButtonFour, imageButtonFive, imageButtonSix;

    public NumbersFragment() {
        // Constructeur vide
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        imageButtonOne      = view.findViewById(R.id.imageButtonOne);
        imageButtonTwo      = view.findViewById(R.id.imageButtonTwo);
        imageButtonThree    = view.findViewById(R.id.imageButtonThree);
        imageButtonFour     = view.findViewById(R.id.imageButtonFour);
        imageButtonFive     = view.findViewById(R.id.imageButtonFive);
        imageButtonSix      = view.findViewById(R.id.imageButtonSix);

        // click events
        imageButtonOne.setOnClickListener(this);
        imageButtonTwo.setOnClickListener(this);
        imageButtonThree.setOnClickListener(this);
        imageButtonFour.setOnClickListener(this);
        imageButtonFive.setOnClickListener(this);
        imageButtonSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Button Clicked", "Item: " + v.getId());

        switch (v.getId()) {
            case R.id.imageButtonOne:
                playSound(R.raw.one);
                break;
            case R.id.imageButtonTwo:
                playSound(R.raw.two);
                break;
            case R.id.imageButtonThree:
                playSound(R.raw.three);
                break;
            case R.id.imageButtonFour:
                playSound(R.raw.four);
                break;
            case R.id.imageButtonFive:
                playSound(R.raw.five);
                break;
            case R.id.imageButtonSix:
                playSound(R.raw.six);
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
