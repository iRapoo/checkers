package xyz.quenix.checkers.methods;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import xyz.quenix.checkers.R;

/**
 * Класс отрисовки игрового поля и фигур
 */
public class Render {

    /**
     * Количество слотов для ходов и фигурок
     */
    private int allSlots = 64;
    private int emptySlots = 16;
    private int oneSideItems = getOneSideItems();
    private int itemSize = 0;

    /**
     * Расчет количества фишек на одной стороне
     *
     * @return int
     */
    private int getOneSideItems() {
        return (allSlots - emptySlots) / 2;
    }

    /**
     * Расчет размеров одного слота на поле
     *
     * @param size int
     * @return int
     */
    public Render setItemsSize(int size) {
        itemSize = size / allSlots;
        return this;
    }

    private int generateSlot(Context context, ConstraintLayout renderLayout, int parentTop, int parentLeft) {
        ConstraintSet set = new ConstraintSet();
        int newViewId = View.generateViewId();

        LinearLayout slot = new LinearLayout(context);
        slot.setBackgroundColor(context.getResources().getColor(R.color.blackItems));
        slot.setId(newViewId);
        renderLayout.addView(slot);

        set.connect(slot.getId(), ConstraintSet.TOP, parentTop, ConstraintSet.TOP, 0);
        set.connect(slot.getId(), ConstraintSet.LEFT, parentLeft, ConstraintSet.LEFT, 5);

        set.constrainHeight(slot.getId(), Convert.DpToPixel(itemSize, context));
        set.constrainWidth(slot.getId(), Convert.DpToPixel(itemSize, context));
        set.applyTo(renderLayout);

        return slot.getId();
    }

    public Render push(Context context, ConstraintLayout renderLayout) {

        int viewId = 0;

        for (int i = 0; i < 4; i++) {

            if (viewId == 0) {
                viewId = generateSlot(context, renderLayout, ConstraintSet.PARENT_ID, ConstraintSet.PARENT_ID);
            } else {
                viewId = generateSlot(context, renderLayout, ConstraintSet.PARENT_ID, viewId);
            }

        }

        /*Button button = new Button(context);
        button.setText("Hello");
        button.setId(View.generateViewId());
        layout.addView(button);
        set.connect(button.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        set.connect(button.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(button.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(button.getId(), 200);
        set.applyTo(layout);


        Button newButton = new Button(context);
        newButton.setText("Yeeey");
        newButton.setId(View.generateViewId());
        layout.addView(newButton);
        set.connect(newButton.getId(), ConstraintSet.BOTTOM, button.getId(), ConstraintSet.TOP, 0);
        set.connect(newButton.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(newButton.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(newButton.getId(), 200);
        set.applyTo(layout);*/

        return this;
    }

}
