package ru.itlab.tenderhackbe.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Cte {
    private Long cteId;
    private String cteName;
    private String cteCategory;
    private String kpgzCode;
    private String characteristics;

    @Id
    @Column(name = "cte_id", nullable = false)
    public Long getCteId() {
        return cteId;
    }

    public void setCteId(Long cteId) {
        this.cteId = cteId;
    }

    @Basic
    @Column(name = "CTEName", nullable = true, length = -1)
    public String getCteName() {
        return cteName;
    }

    public void setCteName(String cteName) {
        this.cteName = cteName;
    }

    @Basic
    @Column(name = "CTECategory", nullable = true, length = -1)
    public String getCteCategory() {
        return cteCategory;
    }

    public void setCteCategory(String cteCategory) {
        this.cteCategory = cteCategory;
    }

    @Basic
    @Column(name = "KPGZCode", nullable = true, length = -1)
    public String getKpgzCode() {
        return kpgzCode;
    }

    public void setKpgzCode(String kpgzCode) {
        this.kpgzCode = kpgzCode;
    }

    @Basic
    @Column(name = "Characteristics", nullable = true, length = -1)
    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cte cte = (Cte) o;

        if (cteId != null ? !cteId.equals(cte.cteId) : cte.cteId != null) return false;
        if (cteName != null ? !cteName.equals(cte.cteName) : cte.cteName != null) return false;
        if (cteCategory != null ? !cteCategory.equals(cte.cteCategory) : cte.cteCategory != null) return false;
        if (kpgzCode != null ? !kpgzCode.equals(cte.kpgzCode) : cte.kpgzCode != null) return false;
        if (characteristics != null ? !characteristics.equals(cte.characteristics) : cte.characteristics != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cteId != null ? cteId.hashCode() : 0;
        result = 31 * result + (cteName != null ? cteName.hashCode() : 0);
        result = 31 * result + (cteCategory != null ? cteCategory.hashCode() : 0);
        result = 31 * result + (kpgzCode != null ? kpgzCode.hashCode() : 0);
        result = 31 * result + (characteristics != null ? characteristics.hashCode() : 0);
        return result;
    }
}
