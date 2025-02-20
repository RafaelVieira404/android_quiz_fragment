package com.example.questiongamefragment;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionAdapterViewHolder> {

    private final ArrayList<ParcelableGame> questionQuiz;

    public QuestionAdapter(ArrayList<ParcelableGame> questionQuiz) {
        this.questionQuiz = questionQuiz;
    }


    @NonNull
    @Override
    public QuestionAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_view_questions_end_game, parent, false);

        return new QuestionAdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull QuestionAdapterViewHolder holder, int position) {
        ParcelableGame question = questionQuiz.get(position);
        holder.bind(question);
    }


    @Override
    public int getItemCount() {
        return questionQuiz.size();
    }

    class QuestionAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView user_answer;
        TextView questionGame;
        TextView question_answer1;
        TextView question_answer2;
        TextView question_answer3;
        TextView question_answer4;


        public QuestionAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            user_answer = itemView.findViewById(R.id.user_answer);
            questionGame = itemView.findViewById(R.id.question_endGame);
            question_answer1 = itemView.findViewById(R.id.question_answer1);
            question_answer2 = itemView.findViewById(R.id.question_answer2);
            question_answer3 = itemView.findViewById(R.id.question_answer3);
            question_answer4 = itemView.findViewById(R.id.question_answer4);

        }

        public void bind(ParcelableGame question) {

            user_answer.setText("Your Answer: " + question.getUserSelectedAnswer());
            questionGame.setText(question.getQuestionGame());
            question_answer1.setText(question.getQuestionOptionOne());
            question_answer2.setText(question.getQuestionOptionTwo());
            question_answer3.setText(question.getQuestionOptionThree());
            question_answer4.setText(question.getQuestionOptionFour());

            if (questionQuiz.get(getAdapterPosition()).getIsUserCorrectAnswer() == true) {
                questionGame.setBackgroundResource(R.drawable.square_round_top_result_correct);

                if (questionQuiz.get(getAdapterPosition()).getQuestionOptionOne().equals(questionQuiz.get(getAdapterPosition()).getUserSelectedAnswer())) {
                    question_answer1.setBackgroundResource(R.drawable.square_result_correct);
                    question_answer2.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
                } else question_answer1.setBackgroundResource(R.drawable.square_result_correct);

                if (questionQuiz.get(getAdapterPosition()).getQuestionOptionTwo().equals(questionQuiz.get(getAdapterPosition()).getQuestionAnswer())) {
                    question_answer2.setBackgroundResource(R.drawable.square_result_correct);
                    question_answer2.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
                } else question_answer2.setBackgroundResource(R.drawable.square_result_correct);

                if (questionQuiz.get(getAdapterPosition()).getQuestionOptionThree().equals(questionQuiz.get(getAdapterPosition()).getQuestionAnswer())) {
                    question_answer3.setBackgroundResource(R.drawable.square_result_correct);
                    question_answer3.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
                } else question_answer3.setBackgroundResource(R.drawable.square_result_correct);


                if (questionQuiz.get(getAdapterPosition()).getQuestionOptionFour().equals(questionQuiz.get(getAdapterPosition()).getQuestionAnswer())) {
                    question_answer4.setBackgroundResource(R.drawable.square_round_bottom_result_correct);
                    question_answer4.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
                } else
                    question_answer4.setBackgroundResource(R.drawable.square_round_bottom_result_correct);

                //                questionQuiz.get(i).getQuestionAnswer().equals(
//                        questionQuiz.get(i).getQuestionOptionOne()) ? question_answer1.setBackgroundColor() : question_answer1.setBackgroundColor();
//
//                questionQuiz.get(i).getQuestionAnswer().equals(
//                        questionQuiz.get(i).getQuestionOptionTwo()) ? question_answer2.setBackgroundColor() : question_answer2.setBackgroundColor();
//
//                questionQuiz.get(i).getQuestionAnswer().equals(
//                        questionQuiz.get(i).getQuestionOptionThree()) ? question_answer3.setBackgroundColor() : question_answer3.setBackgroundColor();
//
//                questionQuiz.get(i).getQuestionAnswer().equals(
//                        questionQuiz.get(i).getQuestionOptionFour()) ? question_answer4.setBackgroundColor() : question_answer4.setBackgroundColor();

            } else {
                questionGame.setBackgroundResource(R.drawable.square_round_top_result_wrong);
                if (questionQuiz.get(getAdapterPosition()).getQuestionOptionOne().equals(questionQuiz.get(getAdapterPosition()).getQuestionAnswer())) {
                    question_answer1.setBackgroundResource(R.drawable.square_result_correct);
                    question_answer1.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
                } else question_answer1.setBackgroundResource(R.drawable.square_result_wrong);

                if (questionQuiz.get(getAdapterPosition()).getQuestionOptionTwo().equals(questionQuiz.get(getAdapterPosition()).getQuestionAnswer())) {
                    question_answer2.setBackgroundResource(R.drawable.square_result_correct);
                    question_answer2.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
                } else question_answer2.setBackgroundResource(R.drawable.square_result_wrong);

                if (questionQuiz.get(getAdapterPosition()).getQuestionOptionThree().equals(questionQuiz.get(getAdapterPosition()).getQuestionAnswer())) {
                    question_answer3.setBackgroundResource(R.drawable.square_result_correct);
                    question_answer3.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
                } else question_answer3.setBackgroundResource(R.drawable.square_result_wrong);

                if (questionQuiz.get(getAdapterPosition()).getQuestionOptionFour().equals(questionQuiz.get(getAdapterPosition()).getQuestionAnswer())) {
                    question_answer4.setBackgroundResource(R.drawable.square_round_bottom_result_correct);
                    question_answer4.setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
                } else question_answer4.setBackgroundResource(R.drawable.square_round_bottom_result_wrong);
            }
        }
    }

}

