package com.oops.studentmanager.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by i24sm on 11/23/2016.
 */

public class Mark {

    @SerializedName("studentId")
    @Expose
    private Integer studentId;

    @SerializedName("physics")
    @Expose
    private Integer physics;

    @SerializedName("chemistry")
    @Expose
    private Integer chemistry;

    @SerializedName("math")
    @Expose
    private Integer math;

    @SerializedName("french")
    @Expose
    private Integer french;

    @SerializedName("english")
    @Expose
    private Integer english;


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPhysics() {
        return physics;
    }

    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    public Integer getChemistry() {
        return chemistry;
    }

    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getFrench() {
        return french;
    }

    public void setFrench(Integer french) {
        this.french = french;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }
}
