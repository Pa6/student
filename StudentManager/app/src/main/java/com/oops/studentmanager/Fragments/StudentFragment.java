package com.oops.studentmanager.Fragments;

/**
 * Created by i24sm on 11/23/2016.
 */

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.oops.studentmanager.Adapters.StudentViewHolder;
import com.oops.studentmanager.Constants.Constants;
import com.oops.studentmanager.Api.HttpHandler;
import com.oops.studentmanager.R;
import com.oops.studentmanager.Models.Record;
import com.oops.studentmanager.Models.Student;

import org.json.JSONObject;

import Security.Crypto;
import uk.co.ribot.easyadapter.EasyRecyclerAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public  class StudentFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public StudentFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static StudentFragment newInstance() {
        StudentFragment fragment = new StudentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    RecyclerView recyclerView;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
         recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        textView= (TextView)rootView.findViewById(R.id.encrypted_string) ;
        recyclerView.setLayoutManager(llm);

    new GetAllStudentsAsyncTask().execute(new String[]{Constants.STUDENTS_URL,"list"});




        return rootView;
    }


    private class GetAllStudentsAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String response = null;
            if (urls[0] != null ) {
                try {
                    Log.d("action", urls[1]);

                    JSONObject json = new JSONObject();
                    json.put("action", urls[1]);
                    response = new HttpHandler().GetText(urls[0],json.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


            return response;
        }


        @Override
        protected void onPostExecute(String result) {
            try
            {
                textView.setText(result);
                String decrypted=new Crypto() .decrypt(result.toString(), Constants.FIVE,Constants.SECRET_KEY);
                Gson gson = new Gson();
                Student student = gson.fromJson(decrypted.toString(), Student.class);
//Same as above but use a EasyRecyclerAdapter instead of EasyAdapter
                recyclerView.setAdapter(new EasyRecyclerAdapter<Record>(
                        getContext(),
                        StudentViewHolder.class,
                        student.getRecords()));

            }catch(Exception e)
            {
                e.printStackTrace();

            }



        }
    }
}

