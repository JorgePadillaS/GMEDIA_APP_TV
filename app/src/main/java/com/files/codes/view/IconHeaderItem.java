package com.files.codes.view;


import androidx.leanback.widget.HeaderItem;

public class IconHeaderItem extends HeaderItem {


    private static final String TAG = IconHeaderItem.class.getSimpleName();
    public static final int ICON_NONE = -1;

    /**
     * Hold an icon resource id
     */
    private int mIconResId = ICON_NONE;

    public IconHeaderItem(long id, String name, int iconResId) {
        super(id, name);
        mIconResId = iconResId;
    }

    public IconHeaderItem(long id, String name) {
        this(id, name, ICON_NONE);
    }

    public IconHeaderItem(String name) {
        super(name);
    }

    public int getIconResId() {
        return mIconResId;
    }

    public void setIconResId(int iconResId) {
        this.mIconResId = iconResId;
    }
}