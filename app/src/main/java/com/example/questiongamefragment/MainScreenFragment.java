package com.example.questiongamefragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class MainScreenFragment extends Fragment {

    private int[] indexQuestion = new int[5];
    private int questionCount = 0;
    private int correctAnswerCount = 0;
    private Random random = new Random();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getAleatoryNumbers();
        setup(view);
    }

    public void setup(View view){

        Button start_game = view.findViewById(R.id.start_bottom_button_main);
        start_game.setOnClickListener(v -> {
            FragmentTransaction fr = this.getParentFragmentManager().beginTransaction();
            fr.replace(R.id.container_root, GameScreenFragment.newInstance(indexQuestion, correctAnswerCount, questionCount), "game");
            fr.addToBackStack("game");
            fr.commit();
        });
//        Button see_questions = view.findViewById(R.id.center_bottom_button_main);
//        start_game.setOnClickListener(v -> {
//            FragmentTransaction fr = this.getParentFragmentManager().beginTransaction();
//            fr.replace(R.id.container_root, GameScreenFragment, "questions");
//            fr.addToBackStack("questions");
//            fr.commit();
//        });
//        Button setting = view.findViewById(R.id.left_bottom_button_main);
//        start_game.setOnClickListener(v -> {
//            FragmentTransaction fr = this.getParentFragmentManager().beginTransaction();
//            fr.replace(R.id.container_root, GameScreenFragment, "settings");
//            fr.addToBackStack("settings");
//            fr.commit();
//        });
    }

    public void savingDataBundle() {

    }

    public void getAleatoryNumbers() {

        for (int i = 0; i < indexQuestion.length; i += 1) {
            indexQuestion[i] += random.nextInt(22);
        }

        for (int i = 0; i < indexQuestion.length; i += 1) {
            for (int a = 1 + i; a < indexQuestion.length; a += 1) {
                if (indexQuestion[i] == indexQuestion[a]) {
                    indexQuestion[i] = random.nextInt(22);
                }
            }
        }
    }
}