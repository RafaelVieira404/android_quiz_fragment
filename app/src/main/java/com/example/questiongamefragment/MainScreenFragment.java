package com.example.questiongamefragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainScreenFragment extends Fragment {

    private static final String EXTRA_QUESTION_INDEX = "EXTRA_QUESTION_INDEX";
    private static final String EXTRA_QUESTION_NUM = "EXTRA_QUESTION_NUM";

    private int[] indexQuestion = new int[10];
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
            fr.replace(R.id.container_root, new GameScreenFragment(), "game");
            fr.addToBackStack("game");
            fr.commit();
        });
        Button see_questions = view.findViewById(R.id.center_bottom_button_main);
        start_game.setOnClickListener(v -> {
            FragmentTransaction fr = this.getParentFragmentManager().beginTransaction();
            fr.replace(R.id.container_root, new GameScreenFragment(), "questions");
            fr.addToBackStack("questions");
            fr.commit();
        });
        Button setting = view.findViewById(R.id.left_bottom_button_main);
        start_game.setOnClickListener(v -> {
            FragmentTransaction fr = this.getParentFragmentManager().beginTransaction();
            fr.replace(R.id.container_root, new GameScreenFragment(), "settings");
            fr.addToBackStack("settings");
            fr.commit();
        });
    }

    public void savingDataForGame() {
        Fragment fragmentGet = new Fragment();
        Bundle bundle = new Bundle();
        setArguments(bundle, EXTRA_QUESTION_INDEX);
    }

    public void getAleatoryNumbers() {

        for (int i = 0; i <= indexQuestion.length; i += 1) {
            indexQuestion[i] += random.nextInt(20);
        }

        for (int i = 0; i <= indexQuestion.length; i += 1) {
            for (int a = i += 1; a <= i; a += 1) {
                if (indexQuestion[i] == indexQuestion[a]) {
                    indexQuestion[i] += random.nextInt(20);
                }
            }
        }
    }
}