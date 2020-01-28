package com.bw.miaoheng20200128.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.miaoheng20200128.MainActivity;
import com.bw.miaoheng20200128.R;
import com.bw.miaoheng20200128.entity.CartEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    public Context context;
    public List<CartEntity.ResultBean> list;
    private ProductAdapter productAdapter;

    public CartAdapter(Context context, List<CartEntity.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    public List<CartEntity.ResultBean> getList() {
        return list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(View.inflate(context, R.layout.cart_item_layout, null));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         MainActivity mainActivity= (MainActivity) context;
         if(list.get(position).getCartChecked()){
              holder.cbProduct.setChecked(true);
        }else{
             holder.cbProduct.setChecked(false);
         }

          holder.tvCartName.setText(list.get(position).getCategoryName());
          holder.cartRv.setLayoutManager(new LinearLayoutManager(context));
        productAdapter = new ProductAdapter(context, list.get(position).getShoppingCartList());
        holder.cartRv.setAdapter(productAdapter);
       /* for (CartEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : productAdapter.getList()) {
            if(shoppingCartListBean.getProductChecked()){
               holder.cbProduct.setChecked(true);
            }else{
                holder.cbProduct.setChecked(true);
            }
        }*/
          holder.cbProduct.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                    if(holder.cbProduct.isChecked()){
                       list.get(position).setCartChecked(true);
                        //当前是选中状态
                        for (CartEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : list.get(position).getShoppingCartList()) {
                               shoppingCartListBean.setProductChecked(true);
                        }
                    }else{
                        list.get(position).setCartChecked(false);
                        for (CartEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : list.get(position).getShoppingCartList()) {
                            shoppingCartListBean.setProductChecked(false);
                        }
                    }
                    notifyDataSetChanged();
                  mainActivity.totlePrice();
              }
          });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cb_product)
        CheckBox cbProduct;
        @BindView(R.id.tv_CartName)
        TextView tvCartName;
        @BindView(R.id.cart_rv)
        RecyclerView cartRv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
    private CartAdapterCallBack cartAdapterCallBack;

    public void setCartAdapterCallBack(CartAdapterCallBack cartAdapterCallBack) {
        this.cartAdapterCallBack = cartAdapterCallBack;
    }

    public interface CartAdapterCallBack {
      void getCartList(List<CartEntity.ResultBean> list);
    }
}
