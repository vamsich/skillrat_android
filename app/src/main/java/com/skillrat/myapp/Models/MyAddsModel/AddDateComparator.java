package com.skillrat.myapp.Models.MyAddsModel;

import java.util.Comparator;

/**
 * Created by Qasim Ahmed on 01/06/2018.
 */

public class AddDateComparator implements Comparator<MyAdds> {
    @Override
    public int compare(MyAdds add1, MyAdds add2) {
        if (add1.getDateTime().before(add2.getDateTime())) {
            return -1;
        } else if (add1.getDateTime().after(add2.getDateTime())) {
            return 1;
        } else {
            return 0;
        }
    }
}
