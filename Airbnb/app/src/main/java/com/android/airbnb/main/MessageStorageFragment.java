package com.android.airbnb.main;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.airbnb.R;

import static com.android.airbnb.R.id.main_container;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageStorageFragment extends Fragment implements View.OnClickListener{

    private MessageFragment messageFragment;

    private Main2Activity main2Activity;
    private TextView txtTitle, txtContent1, txtContent2;
    private ImageButton imgBtnBack;

    public MessageStorageFragment() {
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
        View view = inflater.inflate(R.layout.fragment_message_storage, container, false);
        setFragments();
        setViews(view);
        setListeners();
        return view;
    }

    private void setViews(View view){
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtContent1 = (TextView) view.findViewById(R.id.txtContent1);
        txtContent2 = (TextView) view.findViewById(R.id.txtContent2);
        imgBtnBack = (ImageButton) view.findViewById(R.id.imgBtnBack);
    }

    private void setListeners(){
        imgBtnBack.setOnClickListener(this);
    }

    private void setFragments(){
        messageFragment = new MessageFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBtnBack :
                main2Activity.getSupportFragmentManager().beginTransaction()
                        .replace(main_container, messageFragment)
                        .commit();
                break;
        }
    }
}
