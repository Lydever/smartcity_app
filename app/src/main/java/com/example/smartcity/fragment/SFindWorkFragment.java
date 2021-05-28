package com.example.smartcity.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.smartcity.R;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: SFindWorkFragment
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/6 11:15
 */
public class SFindWorkFragment extends BaseFragment {
    private EditText edSearch;



    @Override
    public View initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.service_findwork,null);
        edSearch = view.findViewById(R.id.ed_search);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
