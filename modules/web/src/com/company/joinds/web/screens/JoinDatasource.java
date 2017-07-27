package com.company.joinds.web.screens;

import com.company.joinds.service.JoinService;
import com.haulmont.cuba.core.entity.KeyValueEntity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomValueCollectionDatasource;

import java.util.Collection;
import java.util.Map;

public class JoinDatasource extends CustomValueCollectionDatasource {

    private JoinService service = AppBeans.get(JoinService.NAME);

    @Override
    protected Collection<KeyValueEntity> getEntities(Map<String, Object> params) {
        return service.getEntities();
    }
}
