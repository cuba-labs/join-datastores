package com.company.joinds.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.global.DesignSupport;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.Versioned;
import com.haulmont.cuba.core.entity.SoftDelete;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.Creatable;

@DesignSupport("{'imported':true}")
@NamePattern("%s|siteName")
@Table(name = "pub_publisher_site")
@Entity(name = "joinds$PublisherSite")
public class PublisherSite extends BaseUuidEntity implements Versioned, SoftDelete, Updatable, Creatable {
    private static final long serialVersionUID = -6189296769454823866L;

    @Column(name = "site_name")
    protected String siteName;

    @Column(name = "country_code")
    protected String countryCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_ts")
    protected Date createTs;

    @Column(name = "created_by", length = 50)
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delete_ts")
    protected Date deleteTs;

    @Column(name = "deleted_by", length = 50)
    protected String deletedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_ts")
    protected Date updateTs;

    @Column(name = "updated_by", length = 50)
    protected String updatedBy;

    @Version
    @Column(name = "version", nullable = false)
    protected Integer version;

    @Override
    public Boolean isDeleted() {
        return deleteTs != null;
    }


    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    @Override
    public Date getCreateTs() {
        return createTs;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setDeleteTs(Date deleteTs) {
        this.deleteTs = deleteTs;
    }

    @Override
    public Date getDeleteTs() {
        return deleteTs;
    }

    @Override
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public String getDeletedBy() {
        return deletedBy;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Integer getVersion() {
        return version;
    }


}