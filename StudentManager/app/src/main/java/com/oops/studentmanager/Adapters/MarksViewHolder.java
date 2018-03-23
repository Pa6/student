package com.oops.studentmanager.Adapters;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.oops.studentmanager.Models.Mark;
import com.oops.studentmanager.Models.Marks;
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
@LayoutId(R.layout.marks_item_layout)
public class MarksViewHolder extends ItemViewHolder<Mark> {


    @ViewId(R.id.textView_student_id)
    TextView textViewId;

    @ViewId(R.id.textView_chemistry)
    TextView textViewChemistry;

    @ViewId(R.id.textView_physics)
    TextView textViewPhysics;

    @ViewId(R.id.textView_math)
    TextView textViewMath;

    @ViewId(R.id.textView_french)
    TextView textViewFrench;

    @ViewId(R.id.textView_english)
    TextView textViewEnglish;

    //Extend ItemViewHolder and call super(view)
    public MarksViewHolder(View view) {
        super(view);
    }

    //Override onSetValues() to set the values of the items in the views.
    @Override
    public void onSetValues(Mark mark, PositionInfo positionInfo) {
       Log.d("student id", ""+mark.getStudentId());
        textViewId.setText("Student ID    :    "+mark.getStudentId());
        textViewChemistry.setText("Chemistry    :    "+mark.getChemistry());
        textViewEnglish.setText("English    :    "+mark.getEnglish());
        textViewFrench.setText("French    :    "+mark.getFrench());
        textViewMath.setText("Math    :    "+mark.getMath());
        textViewPhysics.setText("Physics    :    "+mark.getPhysics());

    }
}