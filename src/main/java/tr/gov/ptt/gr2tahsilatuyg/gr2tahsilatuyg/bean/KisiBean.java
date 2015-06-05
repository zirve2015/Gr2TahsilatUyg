
package tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.entity.Kisi;
import tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.service.KisiService;
import tr.gov.ptt.gr2tahsilatuyg.util.JSFUtil;

@ManagedBean
@SessionScoped
public class KisiBean {
   private Kisi kisi; 

   @EJB
   private KisiService kisiService;
   
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public KisiBean() {
       kisi = new Kisi();
    }
   public String girisKontrol(){
       Kisi vtKisi=kisiService.girisKontrol(this.kisi);
       if (vtKisi != null) {
           
           this.kisi = vtKisi;
             HttpSession session = JSFUtil.getSession();
           session.setAttribute("username",vtKisi.getKullaniciAd());
           
           return "menu.xhtml?faces-redirect=true";
       } else {
           JSFUtil.hataMEssajiEkle("Yanlis Giris!", "Kullanici adi ya da sifre yanlis");
           return "giris.xhtml?faces-redirect=true";
       }
      
   }
}
