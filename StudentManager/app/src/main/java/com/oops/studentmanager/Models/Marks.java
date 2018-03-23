package com.oops.studentmanager.Models;

/**
 * Created by i24sm on 11/23/2016.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Marks {

    @SerializedName("Records")
    @Expose
    private List<Mark> marks = new ArrayList<Mark>();
    @SerializedName("Result")
    @Expose
    private String result;

    public List<Mark> getMarks() {
        return marks;
    }

    public String getResult() {
        return result;
    }
}
