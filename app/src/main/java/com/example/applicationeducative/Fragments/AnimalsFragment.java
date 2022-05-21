package com.example.applicationeducative.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.applicationeducative.R;

/**
 * Animals fragment.
 */
public class AnimalsFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private ImageButton imageButtonDog, imageButtonCat, imageButtonLion,
            imageButtonCow, imageButtonSheep, imageButtonMonkey;

    public AnimalsFragment() {
        // Constructeur vide
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        imageButtonDog      = view.findViewById(R.id.imageButtonDog);
        imageButtonCat      = view.findViewById(R.id.imageButtonCat);
        imageButtonLion     = view.findViewById(R.id.imageButtonLion);
        imageButtonCow      = view.findViewById(R.id.imageButtonCow);
        imageButtonSheep    = view.findViewById(R.id.imageButtonSheep);
        imageButtonMonkey   = view.findViewById(R.id.imageButtonMonkey);

        // click events
        imageButtonDog.setOnClickListener(this);
        imageButtonCat.setOnClickListener(this);
        imageButtonLion.setOnClickListener(this);
        imageButtonCow.setOnClickListener(this);
        imageButtonSheep.setOnClickListener(this);
        imageButtonMonkey.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Button Clicked", "Item: " + v.getId());

        switch (v.getId()) {
            case R.id.imageButtonDog:
                playSound(R.raw.dog);
                break;
            case R.id.imageButtonCat:
                playSound(R.raw.cat);
                break;
            case R.id.imageButtonLion:
                playSound(R.raw.lion);
                break;
            case R.id.imageButtonCow:
                playSound(R.raw.cow);
                break;
            case R.id.imageButtonSheep:
                playSound(R.raw.sheep);
                break;
            case R.id.imageButtonMonkey:
                playSound(R.raw.monkey);
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
