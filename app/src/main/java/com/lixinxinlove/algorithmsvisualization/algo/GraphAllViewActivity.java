package com.lixinxinlove.algorithmsvisualization.algo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lixinxinlove.algorithmsvisualization.R;
import com.lixinxinlove.algorithmsvisualization.view.GraphAllView;

public class GraphAllViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_all_view);
    }

    public void add(View view) {
        ((GraphAllView) view).add();
    }
}
