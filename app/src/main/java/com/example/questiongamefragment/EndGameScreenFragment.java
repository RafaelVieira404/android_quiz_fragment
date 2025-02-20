package com.example.questiongamefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        setUpOnBackPressed();
        return inflater.inflate(R.layout.fragment_end_game_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDataFromBundle();
        getQuestionsSetup();
        screenSetup(view);
        recyclerSetup(view);
    }

    public void getQuestionsSetup() {

        for (int i = 0; i < indexQuestion.length; i += 1) {
            quizQuestions = GameQuestions.getInstance().getQuestions(indexQuestion[i]);
            questionQuiz.add(quizQuestions);

        }
    }

    public void screenSetup(View view) {
        TextView count_correctAnswer = view.findViewById(R.id.correct_answers_result);
        FloatingActionButton return_button = view.findViewById(R.id.float_button_endGame);

            for (int i = 0; i < questionQuiz.size(); i += 1) {
                if (questionQuiz.get(i).getIsUserCorrectAnswer() == true) correctAnswerCount += 1;
            }

        count_correctAnswer.setText(correctAnswerCount + " " + "/" + " " + indexQuestion.length);

        return_button.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container_root, new MainScreenFragment()).commit();
        });


    }

    private void recyclerSetup(View view) {
        QuestionAdapter questionAdapter = new QuestionAdapter(questionQuiz);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_layout);
        recyclerView.setAdapter(questionAdapter);
    }

    public void getDataFromBundle() {
        if (getArguments() != null) {
            indexQuestion = getArguments().getIntArray("indexQuestion");
            correctAnswerCount = getArguments().getInt("correctAnswerCount");
        }
    }

    public void setUpOnBackPressed() {
        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (isEnabled()) {
                    setEnabled(false);
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container_root, new MainScreenFragment()).commit();
                }
            }
        });
    }

}
