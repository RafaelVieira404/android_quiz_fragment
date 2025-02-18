package com.example.questiongamefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EndGameScreenFragment extends Fragment {

    public static EndGameScreenFragment endGameInstance(int[] indexQuestion, int correctAnswerCount) {
        Bundle bundle = new Bundle();
        EndGameScreenFragment endGameScreenFragment = new EndGameScreenFragment();
        bundle.putIntArray("indexQuestion", indexQuestion);
        bundle.putInt("correctAnswerCount", correctAnswerCount);
        endGameScreenFragment.setArguments(bundle);
        return endGameScreenFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_end_game_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setupScreen() {

    }
}
