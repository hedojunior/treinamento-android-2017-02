package com.hedo.troopersapp.util;

import com.hedo.troopersapp.R;
import com.hedo.troopersapp.model.Affiliation;

/**
 * Criado por hedo.junior em 18/11/2017.
 */

public class ResourceUtil {

    public static int
    getResourceBasedOnAffiliation(Affiliation affiliation) {
        switch (affiliation) {
            case GALACTIC_REPUBLIC:
                return R.drawable.galactic_republic;
            case GALACTIC_EMPIRE:
                return R.drawable.galactic_empire;
            case FIRST_ORDER:
                return R.drawable.first_order;
            default:
                return 0;
        }
    }
}
