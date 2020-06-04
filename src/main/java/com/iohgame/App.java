package com.iohgame;

import com.google.gson.JsonObject;
import com.iohgame.framework.utility.MainClass;
import com.iohgame.service.pubg.PubgServiceConnect;

/**
 * Hello world!
 */
public class App extends MainClass
{
    public App()
    {
        // List<Issue> issues = new NbaRakutenConnect().selectTodoTickets();
        // VisualPanel panel = VisualPanel.getGridBagLayoutPanel();
        // int i = 0;
        // for (Issue issue : issues)
        // {
        // LOG.info("Output JIRA ticket: " + issue.getKey());
        //
        // panel.setCons(0, i, 1, 1, 1, 0).addTextLabel(issue.getKey());
        // panel.setCons(1, i, 1, 1, 3, 0).addTextLabel(issue.getPriority().getName());
        // String summary = issue.getSummary();
        // if (summary.length() > 50)
        // {
        // summary = summary.substring(0, 47) + "...";
        // }
        // panel.setCons(2, i, 1, 1, 1, 0).addTextLabel(summary);
        // panel.setCons(3, i, 1, 1, 1, 0).addTextLabel(issue.getStatus().getName());
        // panel.setCons(4, i, 1, 1, 1,
        // 0).addTextLabel(issue.getAssignee().getEmailAddress());
        // i++;
        // }
        // VisualWindow.getInstance("Waiting for confirm JIRA
        // tickets").addScrollPane(panel).disp();
        PubgServiceConnect pubg = PubgServiceConnect.getInstance();
        JsonObject playersJson = pubg.getPlayersByName("Kinsama,EmperorYan,Shimakasepoi".split(","));
        System.out.println(playersJson);
    }

    public static void main(String[] args)
    {
        new App();
    }
}
