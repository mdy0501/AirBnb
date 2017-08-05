package com.android.airbnb.main;


import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.airbnb.R;
import com.bumptech.glide.Glide;

import static com.android.airbnb.R.id.main_container;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment implements View.OnClickListener{

    private MessageNoticeFragment messageNoticeFragment;
    private MessageStorageFragment messageStorageFragment;

    private Main2Activity main2Activity;
    private TextView txtTitle, txtMessageTitle, txtMessageContent, txtMessageQuestion;
    private ConstraintLayout layoutMessage;
    private ImageView imgProfile;
    private ImageButton imgBtnNotice, imgBtnStorage;


    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        main2Activity = (Main2Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        setFragments();
        setViews(view);
        setListeners();
        return view;
    }

    private void setViews(View view){
        txtTitle = (TextView) view.findViewById(R.id.txtTitle1);
        txtMessageTitle = (TextView) view.findViewById(R.id.txtMessageTitle);
        txtMessageContent = (TextView) view.findViewById(R.id.txtMessageContent);
        txtMessageQuestion = (TextView) view.findViewById(R.id.txtMessageQuestion);
        imgProfile = (ImageView) view.findViewById(R.id.imgProfile);
        Glide.with(main2Activity.getBaseContext())
                .load(R.drawable.douwe)
//                .bitmapTransform(new CropCircleTransformation(main2Activity.getBaseContext()))
                .into(imgProfile);
        imgBtnNotice = (ImageButton) view.findViewById(R.id.imgBtnNotice);
        imgBtnStorage = (ImageButton) view.findViewById(R.id.imgBtnStorage);
        layoutMessage = (ConstraintLayout) view.findViewById(R.id.layoutMessage);
    }

    private void setListeners(){
        imgBtnNotice.setOnClickListener(this);
        imgBtnStorage.setOnClickListener(this);
        layoutMessage.setOnClickListener(this);
    }

    private void setFragments(){
        messageNoticeFragment = new MessageNoticeFragment();
        messageStorageFragment = new MessageStorageFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBtnStorage:
                main2Activity.getSupportFragmentManager().beginTransaction()
                        .add(main_container, messageStorageFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.imgBtnNotice:
                main2Activity.getSupportFragmentManager().beginTransaction()
                        .add(main_container, messageNoticeFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.layoutMessage :
                Toast.makeText(main2Activity.getBaseContext(), "메시지 클릭", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
