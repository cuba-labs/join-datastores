package com.company.joinds.service;

import com.haulmont.cuba.core.entity.KeyValueEntity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.ValueLoadContext;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service(JoinService.NAME)
public class JoinServiceBean implements JoinService {

    @Inject
    private DataManager dataManager;


    @Override
    public Collection<KeyValueEntity> getEntities() {

        Collection<KeyValueEntity> collection = new HashSet<>();

        ValueLoadContext accContext = ValueLoadContext.create()

                // Explicitly set the additional datastore name

                .setStoreName("account")
                .setQuery(ValueLoadContext.createQuery("select a.company, a.countryCode from joinds$Account a"))
                .addProperty("company")
                .addProperty("countryCode");
        List<KeyValueEntity> accList = dataManager.loadValues(accContext);

        for (KeyValueEntity entity : accList) {
            ValueLoadContext pubContext = ValueLoadContext.create()

                    // Explicitly set the additional datastore name

                    .setStoreName("publisher")
                    .setQuery(ValueLoadContext.createQuery("select p.siteName from joinds$PublisherSite p where p.countryCode = :countryCode")
                            .setParameter("countryCode", entity.getValue("countryCode")))
                    .addProperty("siteName");
            List<KeyValueEntity> siteList = dataManager.loadValues(pubContext);

            for (KeyValueEntity siteEntity : siteList) {
                KeyValueEntity resultEntity = new KeyValueEntity();
                resultEntity.setValue("company", entity.getValue("company"));
                resultEntity.setValue("countryCode", entity.getValue("countryCode"));
                resultEntity.setValue("siteName", siteEntity.getValue("siteName"));
                collection.add(resultEntity);
            }
        }
        return collection;
    }
}