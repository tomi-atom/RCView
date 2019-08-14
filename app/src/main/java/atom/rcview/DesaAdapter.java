package atom.rcview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DesaAdapter extends RecyclerView.Adapter<DesaAdapter.ListViewHolder> {
    private ArrayList<Desa> listDesa;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    public DesaAdapter(ArrayList<Desa> list) {
        this.listDesa = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_desa, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Desa desa = listDesa.get(position);
        Glide.with(holder.itemView.getContext())
                .load(desa.getFoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.foto);
        holder.judul.setText(desa.getJudul());
        holder.detail.setText(desa.getDetail());
    }

    @Override
    public int getItemCount() {
        return listDesa.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView judul, detail;
        ListViewHolder(View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.foto);
            judul = itemView.findViewById(R.id.judul);
            detail = itemView.findViewById(R.id.detail);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Desa desa);
    }
}