package com.example.shoppingcart;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] maintitle ={
            "Яблоко","Апельсин",
            "Банан","Манго",
            "Виноград",
    };

    String[] subtitle ={
            "Руб: 200","Руб: 80",
            "Руб: 50","Руб: 60",
            "Руб: 100",
    };

    Integer[] imgid={
            R.drawable.download_1,R.drawable.download_2,
            R.drawable.download_3,R.drawable.download_4,
            R.drawable.download_5,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] total = {0};
        final int[] appleCount = {0};
        final int[] bananaCount={0};
        final int[] orangeCount={0};
        final int[] grapeCount={0};
        final int[] mangoCount={0};


        final MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid);
        list= findViewById(R.id.list);
        list.setAdapter(adapter);
    list.setOnItemClickListener(
            (parent, view, position, id) -> {
                if (position == 0) {

                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder
                      .setMessage("Добавить в корзину?")
                      .setTitle("Подтвердить")
                      .setPositiveButton(
                          "Да",
                              (dialog, which) -> {
                                appleCount[0]++;
                                total[0] += 200;
                                Toast.makeText(
                                        MainActivity.this, appleCount[0]+" Яблоко добавлено в корзину", Toast.LENGTH_SHORT)
                                    .show();
                                Log.e("TAG", "всего: " + total[0]);
                                Log.e("TAG", "яблок: " + appleCount[0]);
                              })
                      .setNegativeButton(
                          "Нет",
                              (dialog, which) -> {
                                // ничего не происходит
                              })
                      .show();

                } else if (position == 1) {

                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder
                      .setMessage("Добавить в корзину?")
                      .setPositiveButton(
                          "Да",
                              (dialog, which) -> {
                                orangeCount[0]++;
                                total[0] += 80;
                                Toast.makeText(
                                        MainActivity.this, orangeCount[0]+" Апельсин добавлен в корзину", Toast.LENGTH_SHORT)
                                    .show();
                                Log.e("TAG", "всего: " + total[0]);
                                Log.e("TAG", "яблок: " + orangeCount[0]);
                              })
                      .setNegativeButton(
                          "Нет",
                              (dialog, which) -> {
                                // ничего не происходит
                              })
                      .show();

                } else if (position == 2) {

                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder
                      .setMessage("Добавить в корзину?")
                      .setPositiveButton(
                          "Да",
                              (dialog, which) -> {
                                bananaCount[0]++;
                                total[0] += 50;
                                Toast.makeText(
                                        MainActivity.this, bananaCount[0]+" Банан добавлен в корзину", Toast.LENGTH_SHORT)
                                    .show();
                                Log.e("TAG", "всего: " + total[0]);
                                Log.e("TAG", "яблок: " + bananaCount[0]);
                              })
                      .setNegativeButton(
                          "Нет",
                              (dialog, which) -> {
                                // ничего не происходит
                              })
                      .show();

                } else if (position == 3) {

                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder
                      .setMessage("Добавить в корзину?")
                      .setPositiveButton(
                          "Да",
                              (dialog, which) -> {
                                mangoCount[0]++;
                                total[0] += 60;
                                Toast.makeText(
                                        MainActivity.this, mangoCount[0]+" Манго добавлено в корзину", Toast.LENGTH_SHORT)
                                    .show();
                                Log.e("TAG", "всего: " + total[0]);
                                Log.e("TAG", "яблок: " + mangoCount[0]);
                              })
                      .setNegativeButton(
                          "Нет",
                              (dialog, which) -> {
                                // ничего не происходит
                              })
                      .show();

                } else if (position == 4) {

                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder
                      .setMessage("Добавить в корзину?")
                      .setPositiveButton(
                          "Да",
                              (dialog, which) -> {
                                grapeCount[0]++;
                                total[0] += 100;
                                Toast.makeText(
                                        MainActivity.this, grapeCount[0]+" Виноград добавлен в корзину", Toast.LENGTH_SHORT)
                                    .show();
                                Log.e("TAG", "всего: " + total[0]);
                                Log.e("TAG", "яблок: " + grapeCount[0]);
                              })
                      .setNegativeButton(
                          "Нет",
                              (dialog, which) -> {
                                  // ничего не происходит
                              })
                      .show();
                }

            });
        Button check =findViewById(R.id.checkBill);
        check.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this,BillActivity.class);

            i.putExtra("TOTAL",total[0]);
            i.putExtra("A_COUNT",appleCount[0]);
            i.putExtra("O_COUNT",orangeCount[0]);
            i.putExtra("B_COUNT",bananaCount[0]);
            i.putExtra("M_COUNT",mangoCount[0]);
            i.putExtra("G_COUNT",grapeCount[0]);
            startActivity(i);
        });
    }

}