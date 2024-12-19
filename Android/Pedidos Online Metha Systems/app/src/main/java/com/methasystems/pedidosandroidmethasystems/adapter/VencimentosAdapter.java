package com.methasystems.pedidosandroidmethasystems.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.model.Produto;
import com.methasystems.pedidosandroidmethasystems.model.Vencimento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VencimentosAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Vencimento> mVencimentos = new ArrayList<>();
    private Context mContext;

    public VencimentosAdapter (Context context, List<Vencimento> vencimentos) {
        mContext = context;
        mVencimentos = vencimentos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_vencimentos, parent, false);

        VencimentosAdapter.ViewHolder viewHolder = new VencimentosAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(mVencimentos.get(position).getDataVencimento());

        String dataVencimento = "Data Vencimento: " + formattedDate;
        String valorVencimento = "Valor: R$ " + mVencimentos.get(position).getValorParcela();

        ((ViewHolder)holder).mData.setText(dataVencimento);
        ((ViewHolder)holder).mValor.setText(valorVencimento);

    }

    @Override
    public int getItemCount() {
        return mVencimentos.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        TextView mData, mValor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mData = itemView.findViewById(R.id.txtDataVencimento);
            mValor = itemView.findViewById(R.id.txtValorVencimento);

        }
    }
}
