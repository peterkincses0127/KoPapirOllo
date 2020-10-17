package com.example.kopapirollo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView btnKo, btnPapir, btnOllo;
    private int emberPont, gepPont;

    private ImageView gepImage, emberImage;
    private int gepTipp, emberTipp;
    private TextView textEmberEredmeny;
    private TextView textGepEredmeny;
    private TextView textDontetlen;
    private  ImageView gheart1,gheart2,gheart3,eheart1,eheart2,eheart3;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emberImage.setImageResource(R.drawable.rock);
                emberTipp = 1;
                gepSzamit();
                eldont();
            }
        });
        btnPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emberImage.setImageResource(R.drawable.paper);
                emberTipp = 2;
                gepSzamit();
                eldont();
            }
        });
        btnOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emberImage.setImageResource(R.drawable.scissors);
                emberTipp = 3;
                gepSzamit();
                eldont();
            }
        });


    }


    private void init() {
        btnKo = findViewById(R.id.buttonKo);
        btnPapir = findViewById(R.id.buttonPapir);
        btnOllo = findViewById(R.id.buttonOllo);
        emberPont = 0;
        gepPont = 0;
        gepImage = findViewById(R.id.GepImage);
        emberImage = findViewById(R.id.EmberImage);
        // textEmberEredmeny = findViewById(R.id.textEredmenyEmber);
        //textGepEredmeny = findViewById(R.id.textEredmenyGep);
        textDontetlen = findViewById(R.id.DontetlenTxt);

        gheart1 = findViewById(R.id.imageViewGepHp1);
        gheart2 = findViewById(R.id.imageViewGepHp2);
        gheart3 = findViewById(R.id.imageViewGepHp3);

        eheart1 = findViewById(R.id.imageViewEmberHp1);
        eheart2 = findViewById(R.id.imageViewEmberHp2);
        eheart3 = findViewById(R.id.imageViewEmberHp3);
    }

    private int gepSzamit() {
        gepTipp = new Random().nextInt(3) + 1;
        if (gepTipp == 1) {
            gepImage.setImageResource(R.drawable.rock);
        } else if (gepTipp == 2) {
            gepImage.setImageResource(R.drawable.paper);
        } else if (gepTipp == 3) {
            gepImage.setImageResource(R.drawable.scissors);
        }

        return gepTipp;
    }

    // @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void eldont() {
        // Kő: 1  ---- Papír: 2 ---- Olló: 3 ----
        int dontetlen = 0;
        if (gepTipp == emberTipp) {
            Toast.makeText(this, "Döntetlen!", Toast.LENGTH_SHORT).show();
            dontetlen++;
            textDontetlen.setText("Döntetlenek száma: " + dontetlen);

        }
        if (gepTipp == 1 && emberTipp == 3) {
            gepPont++;
//            textGepEredmeny.setText("Gép: " + gepPont);

            Toast.makeText(this, "Gép nyert!", Toast.LENGTH_SHORT).show();


        }
        if (gepTipp == 1 && emberTipp == 2) {
            emberPont++;
//            textEmberEredmeny.setText("Ember: " + emberPont);
            Toast.makeText(this, "Embert nyert!", Toast.LENGTH_SHORT).show();
        }
        if (gepTipp == 2 && emberTipp == 1) {
            gepPont++;
//            textGepEredmeny.setText("Gép: " + gepPont);
            Toast.makeText(this, "Gép nyert!", Toast.LENGTH_SHORT).show();


        }
        if (gepTipp == 2 && emberTipp == 3) {
            emberPont++;
//            textEmberEredmeny.setText("Ember: " + emberPont);
            Toast.makeText(this, "Embert nyert!", Toast.LENGTH_SHORT).show();


        }
        if (gepTipp == 3 && emberTipp == 2) {
            gepPont++;
//            textGepEredmeny.setText("Gép: " + gepPont);
            Toast.makeText(this, "Gép nyert!", Toast.LENGTH_SHORT).show();


        }
        if (gepTipp == 3 && emberTipp == 1) {
            emberPont++;
//            textEmberEredmeny.setText("Ember: " + emberPont);
            Toast.makeText(this, "Embert nyert!", Toast.LENGTH_SHORT).show();


        }
        if (gepTipp == 1 && emberTipp == 3) {
            gepPont++;
//            textGepEredmeny.setText("Gép: " + gepPont);
            Toast.makeText(this, "Gép nyert!", Toast.LENGTH_SHORT).show();


        }
//        if (gepPont == 3 || emberPont == 3) {
//            Toast.makeText(this, "Vége", Toast.LENGTH_SHORT).show();
//            AlertDialog alertDialog = new AlertDialog.Builder(this)
//                    .setTitle("Vége a játéknak!")
//                    .setMessage("Újrakezdi a játékot?")
//                    .setCancelable(false)
//                    .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            gepPont = 0;
//                            emberPont = 0;
//                            textGepEredmeny.setText("Gép: " + gepPont);
//                            textEmberEredmeny.setText("Ember: " + emberPont);
//                        }
//                    })
//                    .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            System.exit(0);
//                        }
//                    })
//                    .show();
//        }
        switch (gepPont){
            case 1 : eheart1.setImageResource(R.drawable.heart1);
            break;
            case 2 : eheart2.setImageResource(R.drawable.heart1);
            break;
            case 3 : eheart3.setImageResource(R.drawable.heart1);
                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setTitle("Vége a játéknak!")
                        .setMessage("Újrakezdi a játékot?")
                        .setCancelable(false)
                        .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                eheart1.setImageResource(R.drawable.heart2);
                                eheart2.setImageResource(R.drawable.heart2);
                                eheart3.setImageResource(R.drawable.heart2);

                                gheart1.setImageResource(R.drawable.heart2);
                                gheart2.setImageResource(R.drawable.heart2);
                                gheart3.setImageResource(R.drawable.heart2);
                                gepPont = 0;
                                emberPont = 0;
                            }
                        })
                        .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        })
                        .show();
                break;
        }
        switch (emberPont){
            case 1 : gheart1.setImageResource(R.drawable.heart1);
                break;
            case 2 : gheart2.setImageResource(R.drawable.heart1);
                break;
            case 3 : gheart3.setImageResource(R.drawable.heart1);
                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setTitle("Vége a játéknak!")
                        .setMessage("Újrakezdi a játékot?")
                        .setCancelable(false)
                        .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                eheart1.setImageResource(R.drawable.heart2);
                                eheart2.setImageResource(R.drawable.heart2);
                                eheart3.setImageResource(R.drawable.heart2);

                                gheart1.setImageResource(R.drawable.heart2);
                                gheart2.setImageResource(R.drawable.heart2);
                                gheart3.setImageResource(R.drawable.heart2);
                                gepPont = 0;
                                emberPont = 0;
                            }
                        })
                        .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        })
                        .show();
                break;
        }


    }
}
