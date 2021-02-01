package com.pl.edu.prz.aplikacjadietetyczna;//pakowanie

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;//importujemy wsparcie v7
import android.view.LayoutInflater;// importowanie instalacji LayoutInflater
import android.view.View;// importowanie okna widokowego androida
import android.view.ViewGroup;//importowanie  grupy widoków  android
import android.widget.ImageView;// importowanie z panelu bocznego zasobów obrazu do aplikcji android
import android.widget.TextView;// importowanie z panelu bocznego pola tekstowego do aplikcji android

public class ListAdapter extends RecyclerView.Adapter{//klasa publiczna ListAdapter rozszerzenie działania adaptera RecyclerView
    private final ListFragment.OnSelectedInterface mListener;
    public ListAdapter(ListFragment.OnSelectedInterface listener) { mListener = listener; }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items , viewGroup , false); //pobranie widoku layout z list_items
        return new ListViewHolder(view); //zwrócenie nowego widoku ListViewHolder
    }
        @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i){
            ((ListViewHolder) viewHolder).bindView(i);
    }
    @Override
    public int getItemCount(){return Diets.names.length;}
    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTextView;//prywatny widok tekstu
        private ImageView mImageView;// prywatny widok obrazka
        private int mIndex;
        public ListViewHolder(@NonNull View itemView){
            super(itemView);
            mTextView=(TextView)itemView.findViewById(R.id.itemText);
            mImageView=(ImageView)itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }
        public void bindView(int position){
            mIndex = position;
            mTextView.setText(Diets.names[position]);
            mImageView.setImageResource(Diets.resourceIds[position]);
        }

        @Override
        public void onClick(View view){mListener.onListSelected(mIndex); }

        }
    }
