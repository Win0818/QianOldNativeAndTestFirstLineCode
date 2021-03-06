package com.qianft.m.test_demo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qianft.m.test_demo.R;
import com.qianft.m.test_demo.activity.DownloadActivity;
import com.qianft.m.test_demo.activity.MaterialTestActivity;
import com.qianft.m.test_demo.activity.NavigationActivity;
import com.qianft.m.test_demo.activity.NetworkTestActivity;
import com.qianft.m.test_demo.activity.ServiceTestActivity;

/**
 * Created by Administrator on 2017/2/13.
 */

public class SecondFragment extends Fragment {

    public static final String TAG = "SecondFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        Button OpenNetworkTestActivity = (Button) view.findViewById(R.id.OpenNetworkTestActivity);
        OpenNetworkTestActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NetworkTestActivity.class));
            }
        });
        Button OpenServiceTestActivity = (Button) view.findViewById(R.id.OpenServiceTestActivity);
        OpenServiceTestActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ServiceTestActivity.class));
            }
        });

        Button OpenDownlodActivity = (Button) view.findViewById(R.id.OpenDownlodActivity);
        OpenDownlodActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DownloadActivity.class));
            }
        });
        Button OpenMaterialActivity = (Button) view.findViewById(R.id.OpenMaterialActivity);
        OpenMaterialActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MaterialTestActivity.class));
            }
        });
        Button OpenNavigationActivity = (Button) view.findViewById(R.id.OpenNavigationActivity);
        OpenNavigationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NavigationActivity.class));
            }
        });

        Log.d(TAG, "onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}
