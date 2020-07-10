package com.company;

import javafx.animation.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Animation {
    public static void onStartAnimation(Ellipse ellipse) {
        FadeTransition ft = new FadeTransition(Duration.millis(2000), ellipse);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
    public static void startAnimationClicked(Ellipse ellipse) {
            ScaleTransition st = new ScaleTransition(Duration.millis(250), ellipse);
            st.setToX(1.2f);
            st.setToY(1.2f);
            st.setAutoReverse(true);
            st.setCycleCount(2);
            st.play();
    }
    public static void OnRemoveAnimation(Ellipse ellipse) {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), ellipse);
        ft.setFromValue(1);
        ft.setToValue(0);
        ScaleTransition st = new ScaleTransition(Duration.seconds(1), ellipse);
        st.setToX(1.5f);
        st.setToY(1.5f);

        ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(ft, st);
        pt.play();
    }
}
