package com.example.questiongamefragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class MainScreenFragment extends Fragment {

    private int[] indexQuestion = new int[10];
    private int questionCount = 0;
    private int correctAnswerCount = 0;
    private Random random = new Random();

    public class object {
        public final MainScreenFragment newInstance() {
            return new MainScreenFragment();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_activity, container, false);
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