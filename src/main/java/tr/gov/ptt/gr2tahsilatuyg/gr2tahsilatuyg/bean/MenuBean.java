
package tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.*;
import tr.gov.ptt.gr2tahsilatuyg.gr2tahsilatuyg.entity.Menu;

@ManagedBean
@SessionScoped
public class MenuBean {
    @ManagedProperty(value="#{kisiBean}")
    private KisiBean kisiBean;

    public KisiBean getKisiBean() {
        return kisiBean;
    }

    public void setKisiBean(KisiBean kisiBean) {
        this.kisiBean = kisiBean;
    }
    private MenuModel menuModel;

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public MenuBean() {
        menuModel = new DefaultMenuModel();

    }
    @PostConstruct 
    public void initMenu(){
        
        DefaultSubMenu subMenu = new DefaultSubMenu("Menu İslemleri");
        DefaultMenuItem menuItem;
        
        List<Menu> menuListe = kisiBean.getKisi().getTip().getMenuList();
        
        for(Menu menu: menuListe){
            menuItem = new DefaultMenuItem();
            menuItem.setValue(menu.getBaslik());
            menuItem.setCommand(menu.getLink()+".xhtml?faces-redirect=true");
            subMenu.addElement(menuItem);
        }
 
        menuModel.addElement(subMenu);
    }

   
}
