package com.example.questiongamefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EndGameScreenFragment extends Fragment {

    private static ParcelableGame quizQuestions;
    private final ArrayList<ParcelableGame> questionQuiz = new ArrayList<>();

    private int[] indexQuestion;
    private int correctAnswerCount;


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

    public void getQuestionsSetup() {
        for (int i = 0; i < 10; i += 1) {
            quizQuestions = GameQuestions.getInstance().getQuestions(indexQuestion[i]);
            questionQuiz.add(quizQuestions);
        }
    }



    private void recyclerSetup(View view) {
        questionAdapter = new QuestionAdapter(questionQuiz);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_layout);
        recyclerView.setAdapter(questionAdapter);
    }


}
