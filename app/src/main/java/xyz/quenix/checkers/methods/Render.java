package xyz.quenix.checkers.methods;

import android.content.Context;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

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
     * @param int size
     * @return int
     */
    public Render setItemsSize(int size) {
        itemSize = size / allSlots;
        return this;
    }

    public Render push(Context context, ConstraintLayout renderZone) {
        ConstraintSet set = new ConstraintSet();

        return this;
    }

}
