package com.doodlepie.neighbourlycloneapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;


public class ItemViewFragment extends Fragment {


    // TODO: Rename and change types and number of parameters
    public static ItemViewFragment newInstance() {
        ItemViewFragment fragment = new ItemViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = null;

        final boolean[] isAnimationFirstTime = {false};




            view = inflater.inflate(R.layout.fragment_item_view, container, false);


            final TextView[] textView = {view.findViewById(R.id.answer)};
            final CircleImageView circleImageView = view.findViewById(R.id.circluar_image);
            final EditText et_cmnt = (EditText) view.findViewById(R.id.et_cmnt);
            final ImageView img_cmnt = (ImageView) view.findViewById(R.id.img_cmnt);
            final ImageView send = (ImageView) view.findViewById(R.id.send);
            textView[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    circleImageView.setVisibility(View.VISIBLE);
                    et_cmnt.setVisibility(View.VISIBLE);
                    img_cmnt.setVisibility(View.VISIBLE);
                    textView[0].setVisibility(View.GONE);
                }
            });

            et_cmnt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().trim().length() == 0) {
                        // start fade out animation
                        circleImageView.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_in));
                        //Make the elements invisible
//                       Animation btthree = AnimationUtils.loadAnimation(getContext(), R.anim.btthree);
//                        circleImageView.startAnimation(btthree);
                        circleImageView.setVisibility(View.VISIBLE);
                        img_cmnt.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_left));
                        send.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.pus_up_out));
                        et_cmnt.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_left));
                        send.setVisibility(View.GONE);
                        isAnimationFirstTime[0] = false;

                    } else {
                        // Make fade in elements Visible first
//                       Animation  bttone = AnimationUtils.loadAnimation(getContext(), R.anim.bttone);
//                        circleImageView.startAnimation(bttone);
                        if (!isAnimationFirstTime[0]) {
                            et_cmnt.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right));
                            img_cmnt.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right));
                            circleImageView.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.pus_up_out));
                            circleImageView.setVisibility(View.GONE);
                            send.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_in));
                            send.setVisibility(View.VISIBLE);
                            isAnimationFirstTime[0] = true;
                        }
                        // start fade in animation

                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        return view;
    }


}
