package com.resttutor.prostiraccapp.ui.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.resttutor.prostiraccapp.R;
import com.resttutor.prostiraccapp.models.Account;
import com.resttutor.prostiraccapp.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter  extends RecyclerView.Adapter<AccountAdapter.AccountViewHolder> {

    private List<Account> accountList = new ArrayList<>();
    OnItemClickListener.OnItemClickCallback onItemClickCallback;

    public void setData(List<Account> accountList) {
        this.accountList = accountList;
        notifyDataSetChanged();
    }

    public AccountAdapter(OnItemClickListener.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account, parent, false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder accountViewHolder, int position) {
        Account account = accountList.get(position);
        accountViewHolder.bind(position, account);
    }

    @Override
    public int getItemCount() {
        return (accountList != null ? accountList.size() : 0);
    }

    class AccountViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView totpTv;
        TextView serviceTv;

        AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.card_view_acc);
            this.totpTv = itemView.findViewById(R.id.device_tv);
            this.serviceTv = itemView.findViewById(R.id.date_tv);
        }

        void bind(int position, Account account) {
            cardView.setOnClickListener(new OnItemClickListener(position,onItemClickCallback));
            totpTv.setText(account.getTotpCode());
            serviceTv.setText(account.getService());
        }

    }

}
