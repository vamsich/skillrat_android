package com.skillrat.myapp.Models.MyAddsModel;

/**
 * Created by Qasim Ahmed on 01/06/2018.
 */
import java.util.*;

public class AddTitleComparator implements Comparator<MyAdds> {
    @Override
    public int compare(MyAdds add1, MyAdds add2) {
        return add1.add_title.compareTo(add2.add_title);
    }
}
