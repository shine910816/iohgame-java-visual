package com.iohgame;

import java.util.EnumSet;

import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.Utility;
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
        String[] titleColsContent = "枪械名,等级,进阶,总击败,单场最高击败,总伤害,单场最高伤害,最远击败距离,远距离击败数,总击杀,单场最高击杀,总击倒,单场最高击倒".split(",");
        for (int titleCols = 0; titleCols < titleColsContent.length; titleCols++)
        {
            panel.setCons(titleCols, 0, 1, 1, 1, 0).addTextLabel(titleColsContent[titleCols]);
        }
        int line = 1;
        EnumSet<Weapon> enumList = EnumSet.allOf(Weapon.class);
        for (Weapon weapon : enumList)
        {
            LOG.info("Output weapon mastery: " + weapon);
            WeaponMasteryDao w = uw.get(weapon);

            if (w != null)
            {
                panel.setCons(0, line, 1, 1, 1, 0).addTextLabel(weapon.getName());
                panel.setCons(1, line, 1, 1, 1, 0).addTextLabel("Lv." + w.level().toString());
                panel.setCons(2, line, 1, 1, 1, 0).addTextLabel(w.tier().getName());
                panel.setCons(3, line, 1, 1, 1, 0).addTextLabel(w.stats().defeats() + "");
                panel.setCons(4, line, 1, 1, 1, 0).addTextLabel(w.stats().mostDefeatsInAGame() + "");
                panel.setCons(5, line, 1, 1, 1, 0).addTextLabel(Utility.doubleFloor(w.stats().damagePlayer()) + "");
                panel.setCons(6, line, 1, 1, 1, 0).addTextLabel(Utility.doubleFloor(w.stats().mostDamagePlayerInAGame()) + "");
                panel.setCons(7, line, 1, 1, 1, 0).addTextLabel(Utility.doubleFloor(w.stats().longestDefeat()) + "");
                panel.setCons(8, line, 1, 1, 1, 0).addTextLabel(w.stats().longRangeDefeats() + "");
                panel.setCons(9, line, 1, 1, 1, 0).addTextLabel(w.stats().kills() + "");
                panel.setCons(10, line, 1, 1, 1, 0).addTextLabel(w.stats().mostKillsInAGame() + "");
                panel.setCons(11, line, 1, 1, 1, 0).addTextLabel(w.stats().groggies() + "");
                panel.setCons(12, line, 1, 1, 1, 0).addTextLabel(w.stats().mostGroggiesInAGame() + "");
            }
            else
            {
                panel.setCons(0, line, 1, 1, 1, 0).addTextLabel(weapon.getName());
                panel.setCons(1, line, 1, 1, 1, 0).addTextLabel("Lv.0");
                panel.setCons(2, line, 1, 1, 1, 0).addTextLabel("无");
                for (int cols = 3; cols <= 12; cols++)
                {
                    panel.setCons(cols, line, 1, 1, 1, 0).addTextLabel("0");
                }
            }
            line++;
        }
        VisualWindow.getInstance("Weapon mastery for " + accountId).addScrollPane(panel).disp();
    }

    public static void main(String[] args)
    {
        new App();
    }
}
