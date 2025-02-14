package com.example.questiongamefragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class GameScreenFragment extends Fragment {

    private int[] indexQuestion = new int[10];
    private int questionCount = 0;
    private int correctAnswerCount = 0;
    private ParcelableGame currentQuestion;

    public static GameScreenFragment newInstance() {
        return new GameScreenFragment();
    }

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_activity, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDataFromBundle();
        setupDisplay(view);


    }

    public void setupDisplay(View view){
        TextView question_text = view.findViewById(R.id.question_text);
        ImageView question_image = view.findViewById(R.id.image_question);
        RadioButton radio_button1 = view.findViewById(R.id.game_activity_radio_top);
        RadioButton radio_button2 = view.findViewById(R.id.game_activity_radio_below_top);
        RadioButton radio_button3 = view.findViewById(R.id.game_activity_radio_above_bottom);
        RadioButton radio_button4 = view.findViewById(R.id.game_activity_radio_bottom);
        Button next_question = view.findViewById(R.id.next_button);
        Button back_question = view.findViewById(R.id.return_button);

        question_text.setText(GameQuestions.getInstance().getQuestions(indexQuestion[questionCount]).getQuestionGame());

        radio_button1.setText(GameQuestions.getInstance().getQuestions(indexQuestion[questionCount]).getQuestionOptionOne());
        radio_button2.setText(GameQuestions.getInstance().getQuestions(indexQuestion[questionCount]).getQuestionOptionTwo());
        radio_button3.setText(GameQuestions.getInstance().getQuestions(indexQuestion[questionCount]).getQuestionOptionThree());
        radio_button4.setText(GameQuestions.getInstance().getQuestions(indexQuestion[questionCount]).getQuestionOptionFour());

        next_question.setOnClickListener(v -> {
            if (!answerValidation()) return;
            if (questionCount >= indexQuestion.length){
                navigateToEndGameFragment();
            }
            nextQuestionFragment();
        });


    }

        private boolean answerValidation() {
            RadioGroup radioGroup = view.findViewById(R.id.radio_group);

            if (radioGroup.getCheckedRadioButtonId() == R.id.game_activity_radio_top){
                if (currentQuestion.getQuestionAnswer() == currentQuestion.getQuestionOptionOne()) currentQuestion.setIsUserCorrectAnswer(true);
                currentQuestion.setUserSelectedAnswer(currentQuestion.getQuestionOptionOne());
                questionCount += 1;
                return true;
            }
            if (radioGroup.getCheckedRadioButtonId() == R.id.game_activity_radio_below_top){
                if (currentQuestion.getQuestionAnswer() == currentQuestion.getQuestionOptionTwo()) currentQuestion.setIsUserCorrectAnswer(true);
                currentQuestion.setUserSelectedAnswer(currentQuestion.getQuestionOptionTwo());
                questionCount += 1;
                return true;

            }
            if (radioGroup.getCheckedRadioButtonId() == R.id.game_activity_radio_above_bottom){
                if (currentQuestion.getQuestionAnswer() == currentQuestion.getQuestionOptionThree()) currentQuestion.setIsUserCorrectAnswer(true);
                currentQuestion.setUserSelectedAnswer(currentQuestion.getQuestionOptionThree());
                questionCount += 1;
                return true;

            }
            if (radioGroup.getCheckedRadioButtonId() == R.id.game_activity_radio_bottom){
                if (currentQuestion.getQuestionAnswer() == currentQuestion.getQuestionOptionThree()) currentQuestion.setIsUserCorrectAnswer(true);
                currentQuestion.setUserSelectedAnswer(currentQuestion.getQuestionOptionThree());
                questionCount += 1;
                return true;

            } else return false;

        }

    public void getDataFromBundle() {
        if (getArguments() != null) {
            indexQuestion = getArguments().getIntArray("indexQuestion");
            questionCount = getArguments().getInt("questionCount");
            correctAnswerCount = getArguments().getInt("correctAnswerCount");
            for (int i = 0; i < indexQuestion.length; i += 1) {
                Log.i("getDataFomBundle", "Teste: " + String.valueOf(indexQuestion[i]));
            }

        }
    }

    public void nextQuestionFragment() {
        savingDataBundle();
        FragmentTransaction fr = this.getParentFragmentManager().beginTransaction();
        fr.replace(R.id.container_root, newInstance(), "game");
        fr.addToBackStack("game");
        fr.commit();

    }

    public void savingDataBundle() {
        Bundle bundle = new Bundle();
        bundle.putIntArray("indexQuestion", indexQuestion);
        bundle.putInt("correctAnswerCount", correctAnswerCount);
        bundle.putInt("questionCount", questionCount);
        newInstance().setArguments(bundle);
    }

    public void navigateToEndGameFragment() {

    }

}
