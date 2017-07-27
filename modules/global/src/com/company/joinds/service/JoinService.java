package com.company.joinds.service;


import com.haulmont.cuba.core.entity.KeyValueEntity;

import java.util.Collection;

public interface JoinService {
    String NAME = "joinds_JoinService";

    Collection<KeyValueEntity> getEntities();
}