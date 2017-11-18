package com.hedo.mytroopers.util;

import com.hedo.mytroopers.R;
import com.hedo.mytroopers.domain.Affiliation;

/**
 * Criado por hedo.junior em 16/11/2017.
 */

public class DrawableUtil {
    public static int getAffiliationDrawable(Affiliation affiliation) {
        switch (affiliation) {
            case EMPIRE:
                return R.drawable.galactic_empire;
            case REPUBLIC:
                return R.drawable.galactic_republic;
            case FIRST_ORDER:
                return R.drawable.first_order;
            default:
                return 0;
        }
    }
}
