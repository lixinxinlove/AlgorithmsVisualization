package com.lixinxinlove.algorithmsvisualization.algo;

import android.graphics.Point;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lixinxinlove.algorithmsvisualization.R;
import com.lixinxinlove.algorithmsvisualization.view.PiView;

import java.util.LinkedList;
import java.util.List;

public class PIActivity extends AppCompatActivity {


    private PiView piView;

    private final int N = 10000;

    private List<Point> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi);
        piView = findViewById(R.id.pi_view);
        data = new LinkedList<>();
    }

}
