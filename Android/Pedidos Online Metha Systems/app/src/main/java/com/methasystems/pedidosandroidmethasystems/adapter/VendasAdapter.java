package com.methasystems.pedidosandroidmethasystems.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.controller.ClienteController;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;
import com.methasystems.pedidosandroidmethasystems.model.Venda;
import com.methasystems.pedidosandroidmethasystems.ui.vendas.VendasFragment;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

public class VendasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    private List<Venda> mVendas = new ArrayList<>();
    private List<Venda> mVendasFiltradas = new ArrayList<>();
    private Context mContext;
    private FragmentManager mFragmentManager;
    private FiltroData filtroData = new FiltroData();

    public VendasAdapter(Context context, List<Venda> vendas, FragmentManager fragmentManager) {
        mVendas = vendas;
        mVendasFiltradas = vendas;
        mContext = context;
        mFragmentManager = fragmentManager;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_vendas, parent, false);

        VendasAdapter.ViewHolder viewHolder = new VendasAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        ClienteController clienteController = new ClienteController(mContext);
        Cliente cliente = clienteController.getCliente(mVendas.get(position).getCliente());
        ((ViewHolder)holder).mCliente.setText(cliente.getNome());

        String pedido = "Nro Pedido: " + mVendas.get(position).getNumPedido();
        ((ViewHolder)holder).nNroPedido.setText(pedido);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(mVendas.get(position).getData());
        String data = "Data: " + formattedDate;
        ((ViewHolder)holder).mData.setText(data);

        String valorTotal = "Valor Total: R$ " + mVendas.get(position).getTotal();
        ((ViewHolder)holder).mTotal.setText(valorTotal);

        String vencimentos = "Vencimentos: " + mVendas.get(position).getNumParcelas();
        ((ViewHolder)holder).mVencimentos.setText(vencimentos);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                VendasFragment vendasFragment = new VendasFragment();

                //mFragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putInt("codVenda", mVendas.get(position).getCodigo());
                vendasFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.nav_host_fragment, vendasFragment, "teste");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                //navController.navigate(R.id.nav_vendas, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mVendas.size();
    }

    @Override
    public Filter getFilter() {
        return filtroData;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mCliente, nNroPedido, mData, mTotal, mVencimentos;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mCliente = itemView.findViewById(R.id.txtClienteVenda);
            nNroPedido = itemView.findViewById(R.id.txtNroPedido);
            mData = itemView.findViewById(R.id.txtDataVenda);
            mTotal = itemView.findViewById(R.id.txtVlrTotalVenda);
            mVencimentos = itemView.findViewById(R.id.txtQtdVencimentosVenda);
        }
    }

    private class FiltroData extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            String[] datas = constraint.toString().split(" ", 1);
            Date dataInicial = Date.valueOf(datas[0]);
            Date dataFinal = Date.valueOf(datas[1]);
            FilterResults results = new FilterResults();

            final List<Venda> vendaList = mVendas;
            int count = vendaList.size();

            final List<Venda> novaLista = new ArrayList<>();

            String dataVenda;
            Date data;
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            for (int i = 0; i < count; i++){
                data = Date.valueOf(vendaList.get(i).getData().toString());
                if (!data.after(dataFinal) && data.before(dataInicial)){
                    novaLista.add(vendaList.get(i));
                }

                /*dataVenda = df.format(vendaList.get(i).getData().toString());
                if (dataVenda.toLowerCase().contains(filterString)) {
                    novaLista.add(vendaList.get(i));
                }*/
            }

            results.values = novaLista;
            results.count = novaLista.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mVendasFiltradas = (ArrayList<Venda>) results.values;
            notifyDataSetChanged();

        }
    }
}
