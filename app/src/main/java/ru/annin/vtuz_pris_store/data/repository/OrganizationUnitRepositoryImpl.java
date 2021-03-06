package ru.annin.vtuz_pris_store.data.repository;

import android.support.annotation.NonNull;

import io.realm.RealmResults;
import ru.annin.vtuz_pris_store.data.util.RealmUtil;
import ru.annin.vtuz_pris_store.domain.model.OrganizationUnitModel;
import ru.annin.vtuz_pris_store.domain.model.TypeOrganizationUnitModel;
import ru.annin.vtuz_pris_store.domain.repository.OrganizationUnitRepository;
import ru.annin.vtuz_pris_store.domain.value.TypeOrganizationUnit;
import rx.Observable;

/**
 * <p>Реализация репозитория {@link OrganizationUnitRepository}.</p>
 *
 * @author Pavel Annin, 2016.
 */
public class OrganizationUnitRepositoryImpl implements OrganizationUnitRepository{

    @NonNull
    @Override
    public Observable<RealmResults<OrganizationUnitModel>> listOrganizationUnit() {
        return RealmUtil.getRealm().where(OrganizationUnitModel.class)
                .findAllSortedAsync(OrganizationUnitModel.FIELD_NAME)
                .asObservable()
                .filter(RealmResults::isLoaded);
    }

    @NonNull
    @Override
    public Observable<RealmResults<OrganizationUnitModel>> listStore() {
        return RealmUtil.getRealm().where(OrganizationUnitModel.class)
                .equalTo(OrganizationUnitModel.FIELD_TYPE + "." + TypeOrganizationUnitModel.FIELD_ID,
                        TypeOrganizationUnit.STORE.getId())
                .findAllSortedAsync(OrganizationUnitModel.FIELD_NAME)
                .asObservable()
                .filter(RealmResults::isLoaded);
    }

    @NonNull
    @Override
    public Observable<OrganizationUnitModel> getOrganizationUnitById(String id) {
        return RealmUtil.getRealm().where(OrganizationUnitModel.class)
                .equalTo(OrganizationUnitModel.FIELD_ID, id)
                .findFirstAsync()
                .asObservable();
    }
}
