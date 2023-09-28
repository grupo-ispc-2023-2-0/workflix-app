package tec.ispc.workflix.views.ui.catalogo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import tec.ispc.workflix.R;

public class CatalogoActivity extends AppCompatActivity {

    private HorizontalScrollView horizontalScrollView;
    private ImageView arrowLeft;
    private ImageView arrowRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        horizontalScrollView = findViewById(R.id.horizontalScrollView);
        arrowLeft = findViewById(R.id.arrowLeft);
        arrowRight = findViewById(R.id.arrowRight);

        horizontalScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (horizontalScrollView.canScrollHorizontally(1)) {

                    arrowRight.setVisibility(View.VISIBLE);
                } else {

                    arrowRight.setVisibility(View.INVISIBLE);
                }

                if (horizontalScrollView.getScrollX() > 0) {

                    arrowLeft.setVisibility(View.VISIBLE);
                } else {

                    arrowLeft.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
