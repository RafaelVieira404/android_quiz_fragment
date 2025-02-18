package com.example.questiongamefragment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GameQuestions implements Parcelable {
    public static final GameQuestions instance = new GameQuestions();

    private List<ParcelableGame> parcelableGameList;

    public GameQuestions() {
        parcelableGameList = new ArrayList<>();
        parcelableGameList.add(new ParcelableGame(
                "Qual é o nome completo de Chandler Bing?",
                "Chandler Muriel Bing",
                "Chandler Jonathan Bing",
                "Chandler Jason Bing",
                "Chandler Michael Bing",
                "Chandler Muriel Bing",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Em qual cidade os amigos moram?",
                "Los Angeles",
                "Miami",
                "Chicago",
                "Nova York",
                "Nova York",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "O que Ross faz de profissão?",
                "Advogado",
                "Pediatra",
                "Paleontólogo",
                "Astrônomo",
                "Paleontólogo",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Qual o nome do famoso bar onde os amigos costumam se encontrar?",
                "Central Perk",
                "Monica's Cafe",
                "The Coffee Spot",
                "The One Coffee Shop",
                "Central Perk",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Quem tem uma irmã chamada Amy?",
                "Rachel",
                "Monica",
                "Phoebe",
                "Janice",
                "Rachel",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Em qual episódio Chandler diz: 'Could I BE any more...?'",
                "The One with the Prom Video",
                "The One with the Jellyfish",
                "The One with Ross's Sandwich",
                "The One with the Thanksgiving Flashbacks",
                "The One with the Jellyfish",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Qual é o nome do filme que Phoebe faz uma participação?",
                "The Wedding Singer",
                "The Ugly Truth",
                "The Princess Diaries",
                "The One with the Cop",
                "The Wedding Singer",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Qual é o nome da ex-esposa de Ross que se casou com Carol?",
                "Susan",
                "Emily",
                "Rachel",
                "Julie",
                "Susan",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Quem foi o primeiro amigo a se casar?",
                "Joey",
                "Ross",
                "Monica",
                "Phoebe",
                "Ross",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Qual é o nome do macaco de Ross?",
                "Capuchinho",
                "Marcel",
                "Rocco",
                "Milo",
                "Marcel",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Quem foi o amigo que sempre teve problemas com relacionamentos?",
                "Monica",
                "Joey",
                "Ross",
                "Chandler",
                "Ross",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Em que temporada Chandler e Monica começam a namorar?",
                "Temporada 5",
                "Temporada 4",
                "Temporada 6",
                "Temporada 7",
                "Temporada 4",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Qual era o nome da mãe de Ross e Monica?",
                "Judith",
                "Amy",
                "Judy",
                "Helen",
                "Judy",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "O que Phoebe canta na primeira vez que canta no Central Perk?",
                "Smelly Cat",
                "Goodbye Little World",
                "I’ll Be There for You",
                "New York, New York",
                "Smelly Cat",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Quem é o último amigo a saber que Chandler e Monica estavam namorando?",
                "Phoebe",
                "Ross",
                "Rachel",
                "Joey",
                "Joey",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Quem era o ex-marido de Rachel?",
                "Barry",
                "Danny",
                "Paul",
                "David",
                "Barry",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Quem tem um famoso apelido de 'Geller Cup'?",
                "Chandler",
                "Ross",
                "Monica",
                "Rachel",
                "Monica",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "O que aconteceu com o relacionamento de Joey e Rachel?",
                "Eles se casaram",
                "Eles se separaram rapidamente",
                "Eles ficaram juntos por muito tempo",
                "Eles nunca se beijaram",
                "Eles se separaram rapidamente",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Onde Joey diz que aprendeu a fazer seu famoso grito de 'How you doin'?'",
                "Na faculdade",
                "Com seus amigos",
                "No set de filmagens",
                "Com uma mulher",
                "Com uma mulher",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Qual é o nome do famoso musical em que Phoebe canta a música 'Smelly Cat'?",
                "The Lion King",
                "Cats",
                "Chicago",
                "Rent",
                "Cats",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Qual é o nome do restaurante onde Monica trabalhava no início da série?",
                "Monica's Diner",
                "Moon Dance Diner",
                "Mel's Diner",
                "The One Restaurant",
                "Moon Dance Diner",
                "answer",
                false
        ));

        parcelableGameList.add(new ParcelableGame(
                "Quem foi o último personagem a se tornar pai na série?",
                "Ross",
                "Chandler",
                "Joey",
                "Phoebe",
                "Chandler",
                "answer",
                false
        ));
    }



    public static GameQuestions getInstance() {
        return instance;
    }

    protected GameQuestions(Parcel in) {
        parcelableGameList = in.createTypedArrayList((Creator<ParcelableGame>) parcelableGameList);
    }

    public static final Creator<GameQuestions> CREATOR = new Creator<GameQuestions>() {
        @Override
        public GameQuestions createFromParcel(Parcel in) {
            return new GameQuestions(in);
        }

        @Override
        public GameQuestions[] newArray(int size) {
            return new GameQuestions[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeTypedList(parcelableGameList);
    }

    public ParcelableGame getQuestions(int aux) {
        return parcelableGameList.get(aux);
    }

}

