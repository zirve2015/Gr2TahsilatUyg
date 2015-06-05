package tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.entity.Kisi;
import tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.facade.KisiFacade;

@Stateless
public class KisiService {
    @EJB
    private KisiFacade kisiFacade;
    
    public Kisi girisKontrol(Kisi p_kisi) {
        return kisiFacade.girisKontrol(p_kisi);
    }

}
