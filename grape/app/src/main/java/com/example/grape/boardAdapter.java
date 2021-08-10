package com.example.grape;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class boardAdapter extends RecyclerView.Adapter<boardAdapter.ViewHolder> {
    public static ArrayList<board> items=new ArrayList<>();
    private Context context;

    public boardAdapter(ArrayList<board> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.board, parent, false);
        return new ViewHolder(itemView,context);
    }

    @Override
    public void onBindViewHolder(@NonNull boardAdapter.ViewHolder holder, int position) {
        board item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView type;
        private TextView title;
        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            type=itemView.findViewById(R.id.tv_type);
            title=itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast t=Toast.makeText(context,"글로 이동",Toast.LENGTH_SHORT);
                    t.show();
                }
            });

        }

        void setItem(board data){
            type.setText("\u003c"+data.getPostType()+"\u003e");
            title.setText(data.getTitle());
        }
    }
}
