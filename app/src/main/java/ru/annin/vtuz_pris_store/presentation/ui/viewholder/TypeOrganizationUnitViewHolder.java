package ru.annin.vtuz_pris_store.presentation.ui.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;

import io.realm.RealmResults;
import ru.annin.vtuz_pris_store.R;
import ru.annin.vtuz_pris_store.domain.model.TypeOrganizationUnitModel;
import ru.annin.vtuz_pris_store.presentation.common.BaseViewHolder;
import ru.annin.vtuz_pris_store.presentation.ui.adapter.TypeOrganizationUnitListAdapter;

/**
 * <p>ViewHolder экрана "Типы подразделений предприятия".</p>
 *
 * @author Pavel Annin, 2016.
 */
public class TypeOrganizationUnitViewHolder extends BaseViewHolder {

    // View's
    private final Toolbar vToolbar;
    private final RecyclerView rcList;
    private final View vEmpty;

    // Adapter's
    private final TypeOrganizationUnitListAdapter adapter;

    private OnInteractionListener listener;

    public TypeOrganizationUnitViewHolder(@NonNull View view) {
        super(view);
        vToolbar = (Toolbar) vRoot.findViewById(R.id.toolbar);
        rcList = (RecyclerView) vRoot.findViewById(android.R.id.list);
        vEmpty = vRoot.findViewById(android.R.id.empty);

        // Setup
        adapter = new TypeOrganizationUnitListAdapter();
        adapter.setViewEmpty(vEmpty);
        rcList.setAdapter(adapter);

        RxToolbar.navigationClicks(vToolbar).subscribe(aVoid -> {if (listener != null) listener.onBackClick();});
    }

    public TypeOrganizationUnitViewHolder showTypeOrganizationUnit(RealmResults<TypeOrganizationUnitModel> data) {
        adapter.updateRealmResults(data);
        return this;
    }

    public void setOnInteractionListener(OnInteractionListener listener) {
        this.listener = listener;
    }

    public interface OnInteractionListener {
        void onBackClick();
    }
}
