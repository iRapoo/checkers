package xyz.quenix.checkers.methods;

import android.content.Context;

import androidx.constraintlayout.widget.ConstraintLayout;

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

    public Render setItemsSize(int size) {
        itemSize = size / allSlots;
        return this;
    }

    public Render board(Context context, ConstraintLayout renderZone) {


        return this;
    }

}
