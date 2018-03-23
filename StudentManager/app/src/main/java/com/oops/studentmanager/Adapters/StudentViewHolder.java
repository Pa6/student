package com.oops.studentmanager.Adapters;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.oops.studentmanager.R;
import com.oops.studentmanager.Models.Record;

import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

/**
 * Created by i24sm on 11/23/2016.
 */

//Annotate the class with the layout ID of the item.
@LayoutId(R.layout.student_item_layout)
public class StudentViewHolder extends ItemViewHolder<Record> {


    @ViewId(R.id.textView_name)
    TextView textViewName;

    @ViewId(R.id.textView_email)
    TextView textViewEmail;

    @ViewId(R.id.textView_department)
    TextView textViewDept;

    @ViewId(R.id.textView_number)
    TextView textViewNumber;

    //Extend ItemViewHolder and call super(view)
    public StudentViewHolder(View view) {
        super(view);
    }

    //Override onSetValues() to set the values of the items in the views.
    @Override
    public void onSetValues(Record record, PositionInfo positionInfo) {
        Log.d("name", record.getName());
        textViewName.setText("Name: "+record.getName());
        textViewEmail.setText("Email: "+record.getEmailId());
        textViewDept.setText("DepT: "+record.getDepartment());
        textViewNumber.setText("Student No: "+record.getStudentId()+"");
    }
}
