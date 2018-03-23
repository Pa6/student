package com.oops.studentmanager.Models;

/**
 * Created by i24sm on 11/23/2016.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("Records")
    @Expose
    private List<Record> records = new ArrayList<Record>();
    @SerializedName("Result")
    @Expose
    private String result;

    /**
     *
     * @return
     * The records
     */
    public List<Record> getRecords() {
        return records;
    }

    /**
     *
     * @param records
     * The Records
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }

    /**
     *
     * @return
     * The result
     */
    public String getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The Result
     */
    public void setResult(String result) {
        this.result = result;
    }

}
