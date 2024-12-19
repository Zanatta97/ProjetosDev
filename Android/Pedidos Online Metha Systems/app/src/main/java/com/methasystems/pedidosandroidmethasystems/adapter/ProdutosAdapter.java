package com.methasystems.pedidosandroidmethasystems.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;
import com.methasystems.pedidosandroidmethasystems.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    private List<Produto> mProdutos = new ArrayList<>();
    private List<Produto> mProdutosFiltrados = new ArrayList<>();
    private Context mContext;
    private ItemFilter mFilter = new ItemFilter();

    public ProdutosAdapter (Context context, List<Produto> produtos) {
        mProdutos = produtos;
        mProdutosFiltrados = produtos;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_produtos, parent, false);

        ProdutosAdapter.ViewHolder viewHolder = new ProdutosAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).mNome.setText(mProdutosFiltrados.get(position).getNome());

        String estoque = mContext.getString(R.string.estoque_produto) + mProdutosFiltrados.get(position).getEstoque() +
                " " + mProdutos.get(position).getUnidade();
        ((ViewHolder)holder).mEstoque.setText(estoque);

        String valor = mContext.getString(R.string.valor_produto) + mProdutosFiltrados.get(position).getValor();
        ((ViewHolder)holder).mValor.setText(valor);

        String codigo = mContext.getString(R.string.codigo) + mProdutosFiltrados.get(position).getCodGefims();
        ((ViewHolder)holder).mCodigo.setText(codigo);

        String referencia = mContext.getString(R.string.referencia) + mProdutosFiltrados.get(position).getReferencia();
        ((ViewHolder)holder).mReferencia.setText(referencia);
    }

    @Override
    public int getItemCount() {
        return mProdutosFiltrados.size();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mNome, mEstoque, mValor, mCodigo, mReferencia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mNome = itemView.findViewById(R.id.txtNomeProduto);
            mEstoque = itemView.findViewById(R.id.txtEstoqueProduto);
            mValor = itemView.findViewById(R.id.txtValorUnit);
            mCodigo = itemView.findViewById(R.id.txtCodigoProduto);
            mReferencia = itemView.findViewById(R.id.txtReferencia);

        }
    }

    private class ItemFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();

            final List<Produto> produtoList = mProdutos;
            int count = produtoList.size();

            final List<Produto> novaLista = new ArrayList<>();

            String nomeProduto;

            for (int i = 0; i < count; i++){
                nomeProduto = produtoList.get(i).getNome();
                if (nomeProduto.toLowerCase().contains(filterString)) {
                    novaLista.add(produtoList.get(i));
                }
            }

            results.values = novaLista;
            results.count = novaLista.size();



            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mProdutosFiltrados = (ArrayList<Produto>) results.values;
            notifyDataSetChanged();

        }
    }
}
