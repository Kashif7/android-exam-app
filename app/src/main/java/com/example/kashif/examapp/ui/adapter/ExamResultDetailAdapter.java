package com.example.kashif.examapp.ui.adapter;

/**
 * Created by mininduwiorchana on 3/30/18.
 */
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.kashif.examapp.R;
import com.example.kashif.examapp.data.model.Question;

import java.util.List;

public class ExamResultDetailAdapter extends RecyclerView.Adapter<ExamResultDetailAdapter.MyViewHolder> {

    private List<Question> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView questionList;
        public RadioButton rbAnswerOne, rbAnswerTwo, rbAnswerThree, rbAnswerFour;

        public MyViewHolder(View view) {
            super(view);
            questionList = view.findViewById(R.id.tvQuestionText);
            rbAnswerOne = view.findViewById(R.id.rbAnswerOne);
            rbAnswerTwo = view.findViewById(R.id.rbAnswerTwo);
            rbAnswerThree = view.findViewById(R.id.rbAnswerThree);
            rbAnswerFour = view.findViewById(R.id.rbAnswerFour);
        }
    }


    public ExamResultDetailAdapter(List<Question> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_question_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Question question = moviesList.get(position);
        holder.questionList.setText(question.getQuestionText());
        holder.rbAnswerOne.setText(question.getAnswerOptionOne());
        holder.rbAnswerTwo.setText(question.getAnswerOptionTwo());
        holder.rbAnswerThree.setText(question.getAnswerOptionThree());
        holder.rbAnswerFour.setText(question.getAnswerOptionFour());

        holder.rbAnswerOne.setClickable(false);
        holder.rbAnswerTwo.setClickable(false);
        holder.rbAnswerThree.setClickable(false);
        holder.rbAnswerFour.setClickable(false);

        holder.rbAnswerOne.setButtonDrawable(R.drawable.radio_button_selector);
        holder.rbAnswerTwo.setButtonDrawable(R.drawable.radio_button_selector);
        holder.rbAnswerThree.setButtonDrawable(R.drawable.radio_button_selector);
        holder.rbAnswerFour.setButtonDrawable(R.drawable.radio_button_selector);


        switch (question.getUsersAnswer()){
            case 1:
                holder.rbAnswerOne.setBackgroundColor(Color.parseColor("#00fff0"));
                break;
            case 2:
                holder.rbAnswerTwo.setBackgroundColor(Color.parseColor("#00fff0"));
                break;
            case 3:
                holder.rbAnswerThree.setBackgroundColor(Color.parseColor("#00fff0"));
                break;
            case 4:
                holder.rbAnswerFour.setBackgroundColor(Color.parseColor("#00fff0"));
                break;
        }


        switch (question.getCorrectAnswer()){
            case 1:
                holder.rbAnswerOne.setChecked(true);
//                holder.rbAnswerOne.setButtonTintList(ColorStateList.valueOf(Color.GREEN));
//                holder.rbAnswerTwo.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerThree.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerFour.setButtonTintList(ColorStateList.valueOf(Color.RED));
                break;
            case 2:
                holder.rbAnswerTwo.setChecked(true);
//                holder.rbAnswerOne.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerTwo.setButtonTintList(ColorStateList.valueOf(Color.GREEN));
//                holder.rbAnswerThree.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerFour.setButtonTintList(ColorStateList.valueOf(Color.RED));
                break;
            case 3:
                holder.rbAnswerThree.setChecked(true);
//                holder.rbAnswerOne.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerTwo.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerThree.setButtonTintList(ColorStateList.valueOf(Color.GREEN));
//                holder.rbAnswerFour.setButtonTintList(ColorStateList.valueOf(Color.RED));
                break;
            case 4:
                holder.rbAnswerFour.setChecked(true);
//                holder.rbAnswerOne.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerTwo.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerThree.setButtonTintList(ColorStateList.valueOf(Color.RED));
//                holder.rbAnswerFour.setButtonTintList(ColorStateList.valueOf(Color.GREEN));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}