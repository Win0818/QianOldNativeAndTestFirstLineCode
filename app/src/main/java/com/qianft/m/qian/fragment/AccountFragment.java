package com.qianft.m.qian.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.qianft.m.qian.R;
import com.qianft.m.qian.activity.AccountCreditorActivity;
import com.qianft.m.qian.activity.AccountInfoActivity;
import com.qianft.m.qian.activity.AccountSecurityActivity;
import com.qianft.m.qian.activity.AccumulatedIncomeActivity;
import com.qianft.m.qian.activity.BankcardActivity;
import com.qianft.m.qian.activity.FinancialAdvisorActivity;
import com.qianft.m.qian.activity.FinancialPlannerActivity;
import com.qianft.m.qian.activity.FundMgmtActivity;
import com.qianft.m.qian.activity.MyRateCouponActivity;
import com.qianft.m.qian.activity.MyRedpacketActivity;
import com.qianft.m.qian.adapter.AccountGridAdapter;
import com.qianft.m.qian.utils.LogUtil;
import com.qianft.m.qian.utils.Util;
import com.qianft.m.qian.view.MyGridView;
import com.qianft.m.qian.view.TopBar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AccountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment implements AdapterView.OnItemClickListener, TopBar.topBarClickListenter{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String[] img_text = { "体验标", "天天赚", "债权宝", "累计收益", "资金管理", "账户安全",
            "账户信息", "银行卡", "我的红包", "我是理财师","理财顾问","我的加息券", "车险投保", "投保记录"};
    private static final int EXPERIENCE_OBJECT = 0;
    private static final int EVERY_DAY_MAKE = 1;
    private static final int CREDITOR_TREASURE = 2;
    private static final int ACCUMULATED_INCOME = 3;
    private static final int FUND_MGMT = 4;
    private static final int ACCOUNT_SECURE = 5;
    private static final int ACCOUNT_INFO = 6;
    private static final int ACCOUNT_BANKCARD = 7;
    private static final int MY_REDPACKET = 8;
    private static final int FINANCIAL_PLANNER = 9;
    private static final int FINANCIAL_SOUNSELOR = 10;
    private static final int MY_RATE_COUPON = 11;
    private static final int AUTO_INSURANCE = 12;
    private static final int INSURANCE_RECORD = 13;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MyGridView gridview;

    private OnFragmentInteractionListener mListener;
    private TopBar mMyAccountTopBar;
    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        gridview = (MyGridView) view.findViewById(R.id.my_account_gridview);
        gridview.setAdapter(new AccountGridAdapter(getActivity()));
        gridview.setOnItemClickListener(this);
        mMyAccountTopBar = (TopBar) view.findViewById(R.id.my_account_topbar);
        mMyAccountTopBar.setOnTopbarClickListner(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(getActivity(), "position:  " + position, Toast.LENGTH_SHORT).show();
        LogUtil.d("Wing", "position: " + position);
            switch (position) {
                case EXPERIENCE_OBJECT:
                   // Intent intent = new Intent(getActivity(), )
                    Toast.makeText(getActivity(), "体验标", Toast.LENGTH_SHORT).show();
                    break;
                case EVERY_DAY_MAKE:
                    Toast.makeText(getActivity(), "天天赚", Toast.LENGTH_SHORT).show();
                    break;
                case CREDITOR_TREASURE:
                    Toast.makeText(getActivity(), "债权宝", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), AccountCreditorActivity.class));
                    break;
                case ACCUMULATED_INCOME:
                    Toast.makeText(getActivity(), "累计收益", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), AccumulatedIncomeActivity.class));
                    break;
                case FUND_MGMT:
                    Toast.makeText(getActivity(), "资金管理", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), FundMgmtActivity.class));
                    break;
                case ACCOUNT_SECURE:
                    Toast.makeText(getActivity(), "账户安全", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), AccountSecurityActivity.class));
                    break;
                case ACCOUNT_INFO:
                    Toast.makeText(getActivity(), "账户信息", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), AccountInfoActivity.class));
                    break;
                case ACCOUNT_BANKCARD:
                    Toast.makeText(getActivity(), "银行卡", Toast.LENGTH_SHORT).show();
                    getActivity().startActivity(new Intent(getActivity(), BankcardActivity.class));
                    break;
                case MY_REDPACKET:
                    getActivity().startActivity(new Intent(getActivity(), MyRedpacketActivity.class));
                    Toast.makeText(getActivity(), "我的红包", Toast.LENGTH_SHORT).show();
                    break;
                case FINANCIAL_PLANNER:

                    Toast.makeText(getActivity(), "我是理财师", Toast.LENGTH_SHORT).show();
                    getActivity().startActivity(new Intent(getActivity(), FinancialPlannerActivity.class));
                    break;
                case FINANCIAL_SOUNSELOR:
                    Toast.makeText(getActivity(), "理财顾问", Toast.LENGTH_SHORT).show();
                    getActivity().startActivity(new Intent(getActivity(), FinancialAdvisorActivity.class));
                    break;
                case MY_RATE_COUPON:
                    Toast.makeText(getActivity(), "我的加息券", Toast.LENGTH_SHORT).show();
                    getActivity().startActivity(new Intent(getActivity(), MyRateCouponActivity.class));
                    break;
                case AUTO_INSURANCE:
                    Toast.makeText(getActivity(), "车险投保", Toast.LENGTH_SHORT).show();
                    break;
                case INSURANCE_RECORD:
                    Toast.makeText(getActivity(), "投保记录", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onLeftClick() {

    }

    @Override
    public void onRightClick() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
