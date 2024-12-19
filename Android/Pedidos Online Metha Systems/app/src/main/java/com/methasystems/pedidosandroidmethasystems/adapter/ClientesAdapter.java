package com.methasystems.pedidosandroidmethasystems.adapter;

import android.content.ClipData;
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
import com.methasystems.pedidosandroidmethasystems.util.MaskEditUtil;
import com.methasystems.pedidosandroidmethasystems.util.UtilAplicativo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ClientesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    private List<Cliente> mClientes = new ArrayList<>();
    private List<Cliente> mClientesFiltrados = new ArrayList<>();
    private Context mContext;
    private ItemFilter mFilter = new ItemFilter();


    public ClientesAdapter (Context context, List<Cliente> clientes){
        mClientes = clientes;
        mClientesFiltrados = clientes;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_clientes, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).mNome.setText(mClientesFiltrados.get(position).getNome());

        if (mClientesFiltrados.get(position).getCnpj() == null || mClientesFiltrados.get(position).getCnpj().equals("NULL")) {
            String cpf = mContext.getString(R.string.cpf) + MaskEditUtil.mascaraCPF(mClientesFiltrados.get(position).getCpf());
            ((ViewHolder)holder).mCnpjCpf.setText(cpf);
        } else {

            String cnpj = mContext.getString(R.string.cnpj) + MaskEditUtil.mascaraCNPJ(mClientesFiltrados.get(position).getCnpj());
            ((ViewHolder)holder).mCnpjCpf.setText(cnpj);
        }

        String codigo = mContext.getString(R.string.codigo) + mClientesFiltrados.get(position).getCodGefims();
        ((ViewHolder)holder).mCodigo.setText(codigo);

    }

    @Override
    public int getItemCount() {
        return mClientesFiltrados.size();
    }

    /*public int getCount() {
        return mClientesFiltrados.size();
    }

    public Object getItem(int position) {
        return mClientesFiltrados.get(position);
    }

    public long getItemId(int position) {
        return position;
    }*/

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mNome, mCnpjCpf, mCodigo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mNome = itemView.findViewById(R.id.txtNomeCliente);
            mCnpjCpf = itemView.findViewById(R.id.txtCnpjCpfCliente);
            mCodigo = itemView.findViewById(R.id.txtCodigoCliente);
        }
    }

    private class ItemFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();

            final List<Cliente> clienteList = mClientes;
            int count = clienteList.size();

            final List<Cliente> novaLista = new ArrayList<>();

            String nomeCliente;

            for (int i = 0; i < count; i++){
                nomeCliente = clienteList.get(i).getNome();
                if (nomeCliente.toLowerCase().contains(filterString)) {
                    novaLista.add(clienteList.get(i));
                }
            }

            results.values = novaLista;
            results.count = novaLista.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mClientesFiltrados = (ArrayList<Cliente>) results.values;
            notifyDataSetChanged();

        }
    }
}
