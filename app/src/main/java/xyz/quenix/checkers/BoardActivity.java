package xyz.quenix.checkers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import xyz.quenix.checkers.methods.Render;

public class BoardActivity extends AppCompatActivity {

    private Context context;
    private int orientation;

    private Render render;
    private ConstraintLayout boardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        context = this;
        orientation = context.getResources().getConfiguration().orientation;

        boardLayout = findViewById(R.id.board_layout);

        render = new Render();

        boardLayout.post(new Runnable() {
            @Override
            public void run() {

                if (Configuration.ORIENTATION_PORTRAIT == orientation) {
                    boardLayout.getLayoutParams().height = boardLayout.getWidth();
                    render.setItemsSize(boardLayout.getWidth());
                } else {
                    boardLayout.getLayoutParams().width = boardLayout.getHeight();
                    render.setItemsSize(boardLayout.getHeight());
                }

                boardLayout.setBackgroundColor(getResources().getColor(R.color.boardBackground));

                render.push(context, boardLayout);

                Toast.makeText(context, boardLayout.getHeight() + "x" + boardLayout.getWidth() + "", Toast.LENGTH_LONG).show();
            }
        });

    }

}