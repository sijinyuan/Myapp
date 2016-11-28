package com.bwie.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.Toast;

import com.bwie.test.adapter.MyRecyclerAdapter;
import com.bwie.test.bean.Books;
import com.bwie.test.utils.OkHttp;
import com.bwie.test.utils.Tools;
import com.bwie.test.view.PullBaseView;
import com.bwie.test.view.PullRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * 1.
 * 2.作者：佀晋元 2016/11/23
 */
public class Main2Activity extends AppCompatActivity implements PullBaseView
.OnHeaderRefreshListener,PullBaseView.OnFooterRefreshListener{

    private PullRecyclerView mrecyclerview;
//    private String path="http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37 &page=2&pagesize=10&sort=asc&time=1418745237";
    private List<Books.ResultBean.DataBean> data;
    private MyRecyclerAdapter recycleAdapter;
    private List<Books.ResultBean.DataBean> list=new ArrayList<>();
    private int page=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initData();
        mrecyclerview=(PullRecyclerView)findViewById(R.id.recycler);
        mrecyclerview.setOnHeaderRefreshListener(this);//设置下拉监听
        mrecyclerview.setOnFooterRefreshListener(this);//设置上拉监听
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        mrecyclerview.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);

    }

    private void initData() {
        page ++;

        OkHttp.getAsync("http://japi.juhe.cn/joke/content/list.from?key=%20874ed931559ba07aade103eee279bb37%20&page="+page+"&pagesize=10&sort=asc&time=1418745237", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {

                Books books = Tools.parseJsonWithGson(result, Books.class);
                data = books.getResult().getData();

                recycleAdapter= new MyRecyclerAdapter(data,Main2Activity.this);
                mrecyclerview.setAdapter(recycleAdapter);
                page ++;
                recycleAdapter.setmOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(Main2Activity.this, "click " + data.get(position), Toast.LENGTH_SHORT).show();
                    }
                });

                recycleAdapter.setmOnItemLongClickListener(new MyRecyclerAdapter.OnItemLongClickListener() {
                    @Override
                    public void onItemLongClick(View view, final int position) {
                        Toast.makeText(Main2Activity.this, "Long click " + data.get(position), Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                        builder.setMessage("确认删除吗？");
                        builder.setTitle("提示");
                        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                recycleAdapter.notifyDataSetChanged();
                                data.remove(position);
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
                    }
                });

            }
        });

    }

    @Override
    public void onFooterRefresh(final PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mDatas.add("TEXT更多");
                data.addAll(list);
                recycleAdapter.notifyDataSetChanged();
                mrecyclerview.onFooterRefreshComplete();
                list.clear();
            }
        }, 2000);
    }

    @Override
    public void onHeaderRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  mDatas.add(0, "TEXT新增");
                initData();
                recycleAdapter.notifyDataSetChanged();
                mrecyclerview.onHeaderRefreshComplete();
                list.addAll(data);
            }
        }, 3000);
    }
}
