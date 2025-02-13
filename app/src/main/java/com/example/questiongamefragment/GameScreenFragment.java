package com.example.questiongamefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class GameScreenFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_activity, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupDisplay(view);

    }

    public void setupDisplay(View view){
        TextView question_text = view.findViewById(R.id.question_text);
        ImageView question_image = view.findViewById(R.id.image_question);
        RadioGroup radio_group = view.findViewById(R.id.radio_group);
        RadioButton radio_button1 = view.findViewById(R.id.game_activity_radio_below_top);
        RadioButton radio_button2 = view.findViewById(R.id.game_activity_radio_below_top);
        RadioButton radio_button3 = view.findViewById(R.id.game_activity_radio_above_bottom);
        RadioButton radio_button4 = view.findViewById(R.id.game_activity_radio_bottom);

        question_text.setText();


    }
}
