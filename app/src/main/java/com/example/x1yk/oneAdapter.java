package com.example.x1yk;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
public class oneAdapter extends RecyclerView.Adapter<oneAdapter.ViewHolder>{
    private Context context;
    public  static boolean isChecked=false;
    private List<Bean.DataBean> mDatas;
    public oneAdapter(Context context, List<Bean.DataBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_one, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Bean.DataBean bean = mDatas.get(position);
        Glide.with(context).load(bean.getPic()).into(holder.iv);
        holder.tv1.setText(bean.getTitle());
        holder.tv2.setText(bean.getNum()+"");
        if (isChecked){
            holder.checkBox.setChecked(true);
        }else {
            holder.checkBox.setChecked(false);
        }
    }
    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1, tv2;
        CheckBox checkBox;
        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.item_iv);
            tv1 = itemView.findViewById(R.id.name);
            tv2 = itemView.findViewById(R.id.item_tv_price);
            checkBox=itemView.findViewById(R.id.box);
        }}}