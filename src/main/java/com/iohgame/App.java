package com.iohgame;

import java.util.EnumSet;

import com.iohgame.framework.utility.MainClass;
import com.iohgame.service.pubg.PubgServiceImpl;
import com.iohgame.service.pubg.property.Weapon;
import com.iohgame.service.pubg.property.WeaponMasteryDao;
import com.iohgame.service.pubg.property.parameters.PubgService;
import com.iohgame.service.pubg.property.parameters.WeaponMastery;
import com.iohgame.visual.property.VisualPanel;
import com.iohgame.visual.property.VisualWindow;

/**
 * Hello world!
 */
public class App extends MainClass
{
    public App()
    {
        String accountId = "account.7ddf7b9cb6ac4d7296a281ffd6cf6536";
        PubgService pubg = new PubgServiceImpl();
        WeaponMastery uw = pubg.weaponMastery(accountId);
        VisualPanel panel = VisualPanel.getGridBagLayoutPanel();
        panel.setCons(0, 0, 1, 1, 1, 0).addTextLabel("枪械名");
        panel.setCons(1, 0, 1, 1, 1, 0).addTextLabel("等级");
//        panel.setCons(2, 0, 1, 1, 1, 0).addTextLabel("击败");
//        panel.setCons(3, 0, 1, 1, 1, 0).addTextLabel("伤害");
        int i = 1;
        EnumSet<Weapon> enumList = EnumSet.allOf(Weapon.class);
        for (Weapon weapon : enumList)
        {
            LOG.info("Output weapon mastery: " + weapon);
            WeaponMasteryDao w = uw.get(weapon);

            if (w != null)
            {
                panel.setCons(0, i, 1, 1, 1, 0).addTextLabel(weapon.getName());
                panel.setCons(1, i, 1, 1, 1, 0).addTextLabel("Lv."+w.level().toString());
                panel.setCons(2, i, 1, 1, 1, 0).addTextLabel(w.stats().defeats() + "");
                panel.setCons(3, i, 1, 1, 1, 0).addTextLabel(w.stats().mostDefeatsInAGame() + "");
                panel.setCons(4, i, 1, 1, 1, 0).addTextLabel(Math.floor(w.stats().damagePlayer()) + "");
                panel.setCons(5, i, 1, 1, 1, 0).addTextLabel(Math.floor(w.stats().mostDamagePlayerInAGame()) + "");
                panel.setCons(6, i, 1, 1, 1, 0).addTextLabel(Math.floor(w.stats().longestDefeat()) + "m");
                panel.setCons(7, i, 1, 1, 1, 0).addTextLabel(w.stats().longRangeDefeats() + "");
                panel.setCons(8, i, 1, 1, 1, 0).addTextLabel(w.stats().kills() + "");
                panel.setCons(9, i, 1, 1, 1, 0).addTextLabel(w.stats().mostKillsInAGame() + "");
                panel.setCons(10, i, 1, 1, 1, 0).addTextLabel(w.stats().groggies() + "");
                panel.setCons(11, i, 1, 1, 1, 0).addTextLabel(w.stats().mostGroggiesInAGame() + "");
            }
            else {
                panel.setCons(0, i, 1, 1, 1, 0).addTextLabel(weapon.getName());
                panel.setCons(1, i, 1, 1, 1, 0).addTextLabel("Lv.0");
                panel.setCons(2, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(3, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(4, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(5, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(6, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(7, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(8, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(9, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(10, i, 1, 1, 1, 0).addTextLabel("0");
                panel.setCons(11, i, 1, 1, 1, 0).addTextLabel("0");
            }
            i++;
        }
        VisualWindow.getInstance("Weapon mastery for " + accountId).addScrollPane(panel).disp();
    }

    public static void main(String[] args)
    {
        new App();
    }
}
