package com.methasystems.pedidosandroidmethasystems.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.model.ProdutoVenda;

import java.util.ArrayList;
import java.util.List;

public class ProdutoVendaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProdutoVenda> mProdutosVenda = new ArrayList<>();
    private Context context;

    public ProdutoVendaAdapter (Context context, List<ProdutoVenda> produtosVenda){
        mProdutosVenda = produtosVenda;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_prod_venda, parent, false);

        ProdutoVendaAdapter.ViewHolder viewHolder = new ProdutoVendaAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).mNomeProduto.setText(mProdutosVenda.get(position).getNomeProduto());

        String qtd = "Qtde: " + mProdutosVenda.get(position).getQuantidade() +
                " " + mProdutosVenda.get(position).getUnidade();
        ((ViewHolder)holder).mQtd.setText(qtd);

        String valorUnit = "Vlr Unit: R$ " + mProdutosVenda.get(position).getValorUnitario();
        ((ViewHolder)holder).mValorUnit.setText(valorUnit);

        String valorTotal = "Total: R$ " + mProdutosVenda.get(position).getValorTotal();
        ((ViewHolder)holder).mValortotal.setText(valorTotal);


    }

    @Override
    public int getItemCount() {
        return mProdutosVenda.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mNomeProduto, mQtd, mValorUnit, mValortotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mNomeProduto = itemView.findViewById(R.id.txtNomeProdutoVenda);
            mQtd = itemView.findViewById(R.id.txtQtdProdVenda);
            mValorUnit = itemView.findViewById(R.id.txtValorUnitVenda);
            mValortotal = itemView.findViewById(R.id.txtValorTotalProdVenda);
        }
    }
}
