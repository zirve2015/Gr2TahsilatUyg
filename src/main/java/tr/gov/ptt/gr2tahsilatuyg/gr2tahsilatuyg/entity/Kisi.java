/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "THS_KISI")
@NamedQueries({
    @NamedQuery(name = "Kisi.findAll", query = "SELECT k FROM Kisi k"),
    @NamedQuery(name = "Kisi.findByNo", query = "SELECT k FROM Kisi k WHERE k.no = :no"),
    @NamedQuery(name = "Kisi.girisKontrol",
            query = "SELECT k FROM Kisi k WHERE k.kullaniciAd = :kullaniciAd and k.sifre = :sifre"),
    @NamedQuery(name = "Kisi.findByAd", query = "SELECT k FROM Kisi k WHERE k.ad = :ad"),
    @NamedQuery(name = "Kisi.findBySoyad", query = "SELECT k FROM Kisi k WHERE k.soyad = :soyad"),
    @NamedQuery(name = "Kisi.findByDogtar", query = "SELECT k FROM Kisi k WHERE k.dogtar = :dogtar"),
    @NamedQuery(name = "Kisi.findByMaas", query = "SELECT k FROM Kisi k WHERE k.maas = :maas"),
    @NamedQuery(name = "Kisi.findByKullaniciAd", query = "SELECT k FROM Kisi k WHERE k.kullaniciAd = :kullaniciAd"),
    @NamedQuery(name = "Kisi.findBySifre", query = "SELECT k FROM Kisi k WHERE k.sifre = :sifre")})
public class Kisi implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
      @SequenceGenerator(name="kisiseq",
                       sequenceName="SEQ_THS_KISI",
                       initialValue=1,
                       allocationSize=1)
    @GeneratedValue( generator="kisiseq",
            strategy = GenerationType.SEQUENCE)
    private BigDecimal no;
    @Size(max = 30)
    @Column(name = "AD")
    private String ad;
    @Size(max = 30)
    @Column(name = "SOYAD")
    private String soyad;
    @Column(name = "DOGTAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dogtar;
    @Column(name = "MAAS")
    private BigDecimal maas;
    @Size(max = 30)
    @Column(name = "KULLANICI_AD")
    private String kullaniciAd;
    @Size(max = 30)
    @Column(name = "SIFRE")
    private String sifre;
    @JoinColumn(name = "TIPNO", referencedColumnName = "NO")
    @ManyToOne(cascade=CascadeType.ALL)
    private Tip tip;

    public Kisi() {
    }

    public Kisi(BigDecimal no) {
        this.no = no;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Date getDogtar() {
        return dogtar;
    }

    public void setDogtar(Date dogtar) {
        this.dogtar = dogtar;
    }

    public BigDecimal getMaas() {
        return maas;
    }

    public void setMaas(BigDecimal maas) {
        this.maas = maas;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kisi)) {
            return false;
        }
        Kisi other = (Kisi) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.entity.Kisi[ no=" + no + " ]";
    }
    
}
