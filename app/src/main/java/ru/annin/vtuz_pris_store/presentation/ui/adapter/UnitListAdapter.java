package ru.annin.vtuz_pris_store.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.annin.vtuz_pris_store.R;
import ru.annin.vtuz_pris_store.domain.model.UnitModel;

/**
 * <p>Адаптер "Единиц измерения".</p>
 *
 * @author Pavel Annin, 2016.
 */
public class UnitListAdapter extends RealmRecyclerAdapter<UnitModel, UnitListAdapter.ItemViewHolder> {

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View vItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unit_list, parent, false);
        return new ItemViewHolder(vItem);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final UnitModel model = realmResults.get(position);
        if (model != null && model.isValid()) {
            holder.showName(model.getName(), model.getSymbol());
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        // View's
        private final TextView txtName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(android.R.id.text1);
        }

        public ItemViewHolder showName(String name, String symbol) {
            String format = txtName.getResources().getString(R.string.item_unit_list_format, name, symbol);
            txtName.setText(format);
            return this;
        }
    }
}
