package com.lixinxinlove.algorithmsvisualization;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lixinxinlove.algorithmsvisualization.algo.BranchMoneyActivity;
import com.lixinxinlove.algorithmsvisualization.algo.GraphAllViewActivity;
import com.lixinxinlove.algorithmsvisualization.algo.PIActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void bm(View view) {
        startActivity(new Intent(this, BranchMoneyActivity.class));
    }

    public void pi(View view) {
        startActivity(new Intent(this, PIActivity.class));
    }

    public void graph(View view) {
        startActivity(new Intent(this, GraphAllViewActivity.class));
    }

}
