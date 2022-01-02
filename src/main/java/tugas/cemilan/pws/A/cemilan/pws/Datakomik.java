/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.cemilan.pws.A.cemilan.pws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author FADHIL
 */
@Entity
@Table(name = "datakomik")
@NamedQueries({
    @NamedQuery(name = "Datakomik.findAll", query = "SELECT d FROM Datakomik d"),
    @NamedQuery(name = "Datakomik.findByIdkomik", query = "SELECT d FROM Datakomik d WHERE d.idkomik = :idkomik"),
    @NamedQuery(name = "Datakomik.findByJudulkomik", query = "SELECT d FROM Datakomik d WHERE d.judulkomik = :judulkomik"),
    @NamedQuery(name = "Datakomik.findByPengarang", query = "SELECT d FROM Datakomik d WHERE d.pengarang = :pengarang"),
    @NamedQuery(name = "Datakomik.findByPenerbit", query = "SELECT d FROM Datakomik d WHERE d.penerbit = :penerbit"),
    @NamedQuery(name = "Datakomik.findByTahunterbit", query = "SELECT d FROM Datakomik d WHERE d.tahunterbit = :tahunterbit")})
public class Datakomik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idkomik")
    private String idkomik;
    @Column(name = "judulkomik")
    private String judulkomik;
    @Column(name = "pengarang")
    private String pengarang;
    @Column(name = "penerbit")
    private String penerbit;
    @Column(name = "tahunterbit")
    private String tahunterbit;

    public Datakomik() {
    }

    public Datakomik(String idkomik) {
        this.idkomik = idkomik;
    }

    public String getIdkomik() {
        return idkomik;
    }

    public void setIdkomik(String idkomik) {
        this.idkomik = idkomik;
    }

    public String getJudulkomik() {
        return judulkomik;
    }

    public void setJudulkomik(String judulkomik) {
        this.judulkomik = judulkomik;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTahunterbit() {
        return tahunterbit;
    }

    public void setTahunterbit(String tahunterbit) {
        this.tahunterbit = tahunterbit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkomik != null ? idkomik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datakomik)) {
            return false;
        }
        Datakomik other = (Datakomik) object;
        if ((this.idkomik == null && other.idkomik != null) || (this.idkomik != null && !this.idkomik.equals(other.idkomik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.cemilan.pws.A.cemilan.pws.Datakomik[ idkomik=" + idkomik + " ]";
    }
    
}
