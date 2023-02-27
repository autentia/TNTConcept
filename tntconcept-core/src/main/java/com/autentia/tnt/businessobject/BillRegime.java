package com.autentia.tnt.businessobject;

import com.autentia.tnt.dao.ITransferObject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BillRegime implements Serializable, ITransferObject {

    private Integer id;
    private String code;
    private String name;
    private BillType associatedBillType;

    private Integer ownerId;
    private Integer departmentId;
    private Date insertDate;
    private Date updateDate;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BillType getAssociatedBillType() {
        return associatedBillType;
    }

    public void setAssociatedBillType(BillType associatedBillType) {
        this.associatedBillType = associatedBillType;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getOwnerId() {
        return ownerId;
    }

    @Override
    public Integer getDepartmentId() {
        return departmentId;
    }

    @Override
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public Date getInsertDate() {
        return insertDate;
    }

    @Override
    public Date getUpdateDate() {
        return updateDate;
    }

    private void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    private void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public List<Integer> getOwnersId() {
        return null;
    }
}
