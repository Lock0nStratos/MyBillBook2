package com.zjt.mybillbook.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjt.mybillbook.Bean.BillItemBean;
import com.zjt.mybillbook.R;

import java.util.List;

import static com.zjt.mybillbook.Config.CLOTH;
import static com.zjt.mybillbook.Config.DAILY;
import static com.zjt.mybillbook.Config.EAT;
import static com.zjt.mybillbook.Config.GAME;
import static com.zjt.mybillbook.Config.GIFT;
import static com.zjt.mybillbook.Config.HONGBAO;
import static com.zjt.mybillbook.Config.SALARY;
import static com.zjt.mybillbook.Config.TOUZI;
import static com.zjt.mybillbook.Config.TRANS;

/**
 * Created by Y410P on 2018/3/15.
 */

public class BillListAdapter extends BaseAdapter {

    private List<BillItemBean> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public BillListAdapter(Context context,List<BillItemBean> list){
        mList=list;
        mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=mLayoutInflater.inflate(R.layout.bill_item,null);
            viewHolder.mIvBillIcon=convertView.findViewById(R.id.iv_bill_icon);
            viewHolder.mTvBillType=convertView.findViewById(R.id.tv_bill_type);
            viewHolder.mTvBillMoney=convertView.findViewById(R.id.tv_bill_money);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        BillItemBean billItemBean=mList.get(position);
        viewHolder.mTvBillType.setText(billItemBean.getType());
        viewHolder.mTvBillMoney.setText(billItemBean.getMoney());
        viewHolder.mIvBillIcon.setImageResource(findImage(billItemBean.getType()));
        return convertView;
    }
    private static class ViewHolder{
        private ImageView mIvBillIcon;
        private TextView mTvBillType;
        private TextView mTvBillMoney;
    }

    public int findImage(String type){
        int ImageId = 0;
        switch (type){
            case EAT:
                ImageId= R.drawable.eat;break;
            case CLOTH:
                ImageId=R.drawable.cloth;break;
            case DAILY:
                ImageId=R.drawable.daily;break;
            case TRANS:
                ImageId=R.drawable.transport;break;
            case GAME:
                ImageId=R.drawable.game;break;
            case SALARY:
                ImageId=R.drawable.salary;break;
            case HONGBAO:
                ImageId=R.drawable.hongbao;break;
            case TOUZI:
                ImageId=R.drawable.touzi;break;
            case GIFT:
                ImageId=R.drawable.gift;break;
            default:
                ImageId=R.drawable.type;
        }
        return  ImageId;
    }
}
