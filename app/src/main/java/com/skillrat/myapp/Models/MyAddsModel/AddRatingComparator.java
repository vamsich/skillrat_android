package com.skillrat.myapp.Models.MyAddsModel;

import java.util.Comparator;

/**
 * Created by Qasim Ahmed on 01/06/2018.
 */

public class AddRatingComparator implements Comparator<MyAdds> {
    @Override
    public int compare(MyAdds add1, MyAdds add2) {
        if(add1.add_rating == add2.add_rating)
            return  0;
        return add1.add_rating > add2.add_rating  ? 1 :-1;
    }
}
