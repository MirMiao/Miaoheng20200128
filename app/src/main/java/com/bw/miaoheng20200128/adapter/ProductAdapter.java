package com.bw.miaoheng20200128.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.miaoheng20200128.MainActivity;
import com.bw.miaoheng20200128.R;
import com.bw.miaoheng20200128.entity.CartEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    public Context context;
    public List<CartEntity.ResultBean.ShoppingCartListBean> list;


    public ProductAdapter(Context context, List<CartEntity.ResultBean.ShoppingCartListBean> list) {
        this.context = context;
        this.list = list;
    }

    public List<CartEntity.ResultBean.ShoppingCartListBean> getList() {
        return list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(View.inflate(context, R.layout.product_item_layout, null));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MainActivity mainActivity= (MainActivity) context;
        if(list.get(position).getProductChecked()){
           holder.cbProduct.setChecked(true);
        }else{
            holder.cbProduct.setChecked(false);
        }

       holder.tvProductName.setText(list.get(position).getCommodityName());
       holder.tvPrice.setText("￥"+list.get(position).getPrice());
        Glide.with(context).load(list.get(position).getPic()).into(holder.image);
        List<CartEntity.ResultBean> data = mainActivity.getData();
      /* holder.cbProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //判断是否选中
                 if(holder.cbProduct.isChecked()){
                        //选中的状态
                        list.get(position).setProductChecked(true);
                     for (int i = 0; i < data.size(); i++) {

                     }

                 }else{
                     //未选中
                     list.get(position).setProductChecked(false);

                 }
                 //计算价钱
                mainActivity.totlePrice();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cb_product)
        CheckBox cbProduct;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.tv_productName)
        TextView tvProductName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
