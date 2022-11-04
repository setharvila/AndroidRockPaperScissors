package com.setharvila.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRock, btnPaper, btnScissors, btnReset;
    ImageButton btnRockImg, btnPaperImg, btnScissorsImg;
    TextView txtHumanChoice, txtComputerChoice, txtWinner, txtWinCount, txtTieCount, txtLooseCount;
    ImageView winnerImg, humanChoiceImg, computerChoiceImg;

    int winCount, tieCount, looseCount;



    enum Choice {ROCK, PAPER, SCISSORS}
    enum Winner {HUMAN, COMPUTER, TIE}

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winCount = 0;
        looseCount = 0;
        tieCount = 0;

        // Hooking up the buttons
        //btnRock = findViewById(R.id.btnRock);
       // btnPaper = findViewById(R.id.btnPaper);
        //btnScissors = findViewById(R.id.btnScissors);


        btnReset = findViewById(R.id.btnReset);

        btnRockImg = findViewById(R.id.btnRockImg);
        btnPaperImg = findViewById(R.id.btnPaperImg);
        btnScissorsImg = findViewById(R.id.btnScissorsImg);


        txtComputerChoice = findViewById(R.id.txtComputerChoice);
        txtHumanChoice = findViewById(R.id.txtHumanChoice);
        txtWinner = findViewById(R.id.txtWinner);
        txtWinCount = findViewById(R.id.txtWinCount);
        txtTieCount = findViewById(R.id.txtTieCount);
        txtLooseCount = findViewById(R.id.txtLooseCount);

        winnerImg = findViewById(R.id.winnerImg);
        humanChoiceImg = findViewById(R.id.humanChoiceImg);
        computerChoiceImg = findViewById(R.id.computerChoiceImg);

        // Button functions
        //////////////////////////////////////////////////////////////
       // btnRock.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View v) {
            //    Log.d("myMsg", "btnRock Pressed");
              //  playGame(Choice.ROCK);

            //}
        //}); // btnRock End
        btnRockImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myMsg", "btnRockImg Pressed...");
                playGame(Choice.ROCK);
            }
        });

        /*btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myMsg", "btnPaper Pressed");
                playGame(Choice.PAPER);

            }
        }); */ // btnPaper End

        btnPaperImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myMsg", "btnPaperImg Pressed");
                playGame(Choice.PAPER);
            }
        });

        /* btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myMsg", "btnScissors Clicked");
                playGame(Choice.SCISSORS);

            }
        }); // btnScissors End
        */


        btnScissorsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myMsg", "btnScissorsImg Clicked");
                playGame(Choice.SCISSORS);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winCount = 0;
                tieCount = 0;
                looseCount = 0;

                txtWinCount.setText("" + winCount);
                txtTieCount.setText("" + tieCount);
                txtLooseCount.setText("" + looseCount);

                winnerImg.setImageResource(R.drawable.thinkingimg);
                humanChoiceImg.setVisibility(View.INVISIBLE);
                computerChoiceImg.setVisibility(View.INVISIBLE);
            }
        });

        // End Button Functions
        /////////////////////////////////////////////////////////////////




    }

    // This is where game logic goes

    void playGame(Choice humanChoice) {

        //computerChoiceImg.setImageResource(R.drawable.thinkingimg);

        //SystemClock.sleep(2000);

        Log.d("myMsg", "Play game. Human Chose " + humanChoice);

        Choice computerChoice;

        Winner gameResult = Winner.TIE; // Has to be set to something.

        String stringHumanChoice = "";
        String stringComputerChoice = "";
        String stringWinner = "";

        int number = random.nextInt(3);
        //Log.d("myMsg", "Computer chose " + number);
        computerChoice = Choice.values()[number];
        Log.d("myMsg", "Computer chose Hello " + computerChoice);
        if (computerChoice == Choice.ROCK){
            Log.d("myMsg", "this worked!");
            computerChoiceImg.setVisibility(View.VISIBLE);
            //SystemClock.sleep(1000);
            computerChoiceImg.setImageResource(R.drawable.rocklogo);
        }

        if (computerChoice == Choice.PAPER){
            computerChoiceImg.setVisibility(View.VISIBLE);
            //SystemClock.sleep(1000);
            computerChoiceImg.setImageResource(R.drawable.paperlogo);
        }

        if (computerChoice == Choice.SCISSORS){
            computerChoiceImg.setVisibility(View.VISIBLE);
            //SystemClock.sleep(1000);
            computerChoiceImg.setImageResource(R.drawable.scissorslogo);
        }

        //SystemClock.sleep(4000);

        switch (humanChoice) {
            case ROCK:
                humanChoiceImg.setVisibility(View.VISIBLE);
                humanChoiceImg.setImageResource(R.drawable.rocklogo);
                stringHumanChoice = "Hard Rock";
                break;
            case PAPER:
                humanChoiceImg.setVisibility(View.VISIBLE);
                humanChoiceImg.setImageResource(R.drawable.paperlogo);
                stringHumanChoice = "Paper";
                break;
            case SCISSORS:
                humanChoiceImg.setVisibility(View.VISIBLE);
                humanChoiceImg.setImageResource(R.drawable.scissorslogo);
                stringHumanChoice = "Sharp Scissors";
                break;
            default: stringHumanChoice = "Error in humanChoice switch"; break;
        }

        switch (computerChoice) {
            case ROCK: stringComputerChoice = "Hard Rock"; break;
            case PAPER: stringComputerChoice = "Paper"; break;
            case SCISSORS: stringComputerChoice = "Sharp Scissors"; break;
            default: stringComputerChoice = "Error in humanChoice switch"; break;
        }

        txtHumanChoice.setText("You chose " + stringHumanChoice);
        txtComputerChoice.setText("Computer Chose " + stringComputerChoice);

        if (humanChoice == computerChoice){
            gameResult = Winner.TIE;
            tieCount += 1;
            txtTieCount.setText("" + tieCount);

        }

        if (humanChoice == Choice.ROCK && computerChoice == Choice.PAPER){
            gameResult = Winner.COMPUTER;
            looseCount += 1;
            txtLooseCount.setText("" + looseCount);
        }
        if (humanChoice == Choice.ROCK && computerChoice == Choice.SCISSORS){
            gameResult = Winner.HUMAN;
            winCount += 1;
            txtWinCount.setText("" + winCount);
        }

        if (humanChoice == Choice.PAPER && computerChoice == Choice.ROCK){
            gameResult = Winner.HUMAN;
            winCount += 1;
            txtWinCount.setText("" + winCount);
        }
        if (humanChoice == Choice.PAPER && computerChoice == Choice.SCISSORS){
            gameResult = Winner.COMPUTER;
            looseCount += 1;
            txtLooseCount.setText("" + looseCount);
        }

        if (humanChoice == Choice.SCISSORS && computerChoice == Choice.ROCK){
            gameResult = Winner.COMPUTER;
            looseCount += 1;
            txtLooseCount.setText("" + looseCount);
        }
        if (humanChoice == Choice.SCISSORS && computerChoice == Choice.PAPER){
            gameResult = Winner.HUMAN;
            winCount += 1;
            txtWinCount.setText("" + winCount);
        }

        switch (gameResult) {
            case TIE:
                stringWinner = "Tie game.";
                txtWinner.setTextColor(Color.parseColor("#808080"));
                winnerImg.setImageResource(R.drawable.tieimg);
                break;
            case HUMAN:
                stringWinner = "Human wins.";
                txtWinner.setTextColor(Color.parseColor("#00FF00"));
                winnerImg.setImageResource(R.drawable.winimg);
                break;
            case COMPUTER:
                stringWinner = "The Artificial Intelligence Rules again!";
                txtWinner.setTextColor(Color.parseColor("#FF0000"));
                winnerImg.setImageResource(R.drawable.looseimg);
                break;
            default:
                stringWinner = "Critical Error: switch (gameResult)";
                break;
        }

        txtWinner.setText(stringWinner);


    }


}