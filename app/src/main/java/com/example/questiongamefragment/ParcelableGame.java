package com.example.questiongamefragment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ParcelableGame implements Parcelable {

    private final String questionGame;
    private final String questionOptionOne;
    private final String questionOptionTwo;
    private final String questionOptionThree;
    private final String questionOptionFour;
    private final String questionAnswer;
    private String userSelectedAnswer;
    private boolean isUserCorrectAnswer;
    
    
    public ParcelableGame(String questionGame, String questionOptionOne, String questionOptionTwo, String questionOptionThree, String questionOptionFour, String questionAnswer, String userSelectedAnswer, boolean isUserCorrectAnswer) {
        this.questionGame = questionGame;
        this.questionOptionOne = questionOptionOne;
        this.questionOptionTwo = questionOptionTwo;
        this.questionOptionThree = questionOptionThree;
        this.questionOptionFour = questionOptionFour;
        this.questionAnswer = questionAnswer;
        this.userSelectedAnswer = userSelectedAnswer;
        this.isUserCorrectAnswer = isUserCorrectAnswer;
    }



    protected ParcelableGame(Parcel in) {
        questionGame = in.readString();
        questionOptionOne = in.readString();
        questionOptionTwo = in.readString();
        questionOptionThree = in.readString();
        questionOptionFour = in.readString();
        questionAnswer = in.readString();
        userSelectedAnswer = in.readString();
        isUserCorrectAnswer = in.readInt() != 0;
    }

    public static final Creator<ParcelableGame> CREATOR = new Creator<ParcelableGame>() {
        @Override
        public ParcelableGame createFromParcel(Parcel in) {
            final ParcelableGame parcelableGame = new ParcelableGame(
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readInt() == 1
            );

            return parcelableGame;
        }

        @Override
        public ParcelableGame[] newArray(int size) {
            return new ParcelableGame[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(questionGame);
        dest.writeString(questionOptionOne);
        dest.writeString(questionOptionTwo);
        dest.writeString(questionOptionThree);
        dest.writeString(questionOptionFour);
        dest.writeString(questionAnswer);
        dest.writeString(userSelectedAnswer);
        dest.writeByte((byte)(isUserCorrectAnswer ? 1 : 0));

    }

    public String getQuestionGame() {
        return questionGame;
    }
    public String getQuestionOptionOne() {
        return questionOptionOne;
    }
    public String getQuestionOptionTwo() {
        return questionOptionTwo;
    }
    public String getQuestionOptionThree() {
        return questionOptionThree;
    }
    public String getQuestionOptionFour() {
        return questionOptionFour;
    }
    public String getQuestionAnswer() {
        return questionAnswer;
    }
    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }
    public boolean getIsUserCorrectAnswer() {
        return isUserCorrectAnswer;
    }

    public void setIsUserCorrectAnswer(Boolean isUserCorrectAnswer){
        this.isUserCorrectAnswer = isUserCorrectAnswer;
    }
    public void setUserSelectedAnswer(String userSelectedAnswer){
        this.userSelectedAnswer = userSelectedAnswer;
    }
}
