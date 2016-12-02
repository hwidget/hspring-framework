package com.ryan.spring.web.blog.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Rayn on 2016/2/5 9:15
 * @email liuwei412552703@163.com
 */
@Entity
@Table(name = "etl_supplier")
public class SupplierEntity
{
    private String supplierId;
    private String supplierName;
    private String detail;
    private String shortName;
    private Timestamp createdAt;

    @Id
    @Column(name = "supplier_id")
    public String getSupplierId()
    {
        return supplierId;
    }

    public void setSupplierId(String supplierId)
    {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "supplier_name")
    public String getSupplierName()
    {
        return supplierName;
    }

    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    @Basic
    @Column(name = "short_name")
    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt)
    {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierEntity that = (SupplierEntity) o;

        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (supplierName != null ? !supplierName.equals(that.supplierName) : that.supplierName != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = supplierId != null ? supplierId.hashCode() : 0;
        result = 31 * result + (supplierName != null ? supplierName.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
