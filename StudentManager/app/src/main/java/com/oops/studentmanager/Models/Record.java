package com.oops.studentmanager.Models;

/**
 * Created by i24sm on 11/23/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {

    @SerializedName("studentId")
    @Expose
    private Integer studentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("username")
    @Expose
    private String username;

    /**
     *
     * @return
     * The studentId
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     *
     * @param studentId
     * The studentId
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The department
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     * @param department
     * The department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     *
     * @return
     * The emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     *
     * @param emailId
     * The emailId
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
