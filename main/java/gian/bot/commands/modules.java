package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;
import org.javacord.api.util.logging.ExceptionLogger;

import java.awt.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class modules implements MessageCreateListener {
    //global
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        int[] options = {1, 2};
        String displayID = String.valueOf(event.getMessageAuthor().getId());

        //ignore this
        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "module")) {
            event.getChannel().type();
            event.getChannel().sendMessage("> You mean \">moduleS\"?");
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/412710366062182421/743739082185900072/Hmm48.gif");
        }
        //ok continue now

        EmbedBuilder KomPan = new EmbedBuilder()
                .setTitle("KomPan Modules | Gng. Rosalina Molines")
                .setDescription("Here are the modules that have been provided by Gng so far...")
                .setAuthor("ICTHS Official Facebook Page", "https://www.facebook.com/ICTHS/", "https://cdn.discordapp.com/attachments/825351550545035285/828887019798659102/fb_icon_325x325.png")
                .addField("__**1st Week**__", "```https://docs.google.com/document/d/1iwO3wIK7x2tY-xfCIkfHSgVLrftCesjLGUzK6pYrdIg/edit?usp=sharing```  For further notes, type >notes")
                .addField("__**2nd Week**__", "```https://docs.google.com/document/d/1mn6qLdRrMAo8aAHPGAB9ZDDH3pNtDGr10jwgp5DhtFE/edit?usp=sharing```  For further notes, type >notes")
                .addField("__**3rd Week**__", "```https://docs.google.com/document/d/1dU2qsMU2O-8b7Lfp6dKdjG4JyYn_5JrBUUPchbE2oZw/edit?usp=sharing```  For further notes, type >notes")
                .setColor(Color.white)
                .setFooter("\"Inspiration is perishable, act now or it's already too late.\"", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        EmbedBuilder USCP = new EmbedBuilder()
                .setTitle("USCP Modules/PPT | Ma'am Jennee Rose Urbano")
                .setDescription("Here are the modules and PPTs that have been provided by Ma'am so far...")
                .setAuthor("ICTHS Official Facebook Page", "https://www.facebook.com/ICTHS/", "https://cdn.discordapp.com/attachments/825351550545035285/828887019798659102/fb_icon_325x325.png")
                .addField("__**Anthropology, Sociology and Political Science PPT**__", "> ```https://drive.google.com/file/d/17LIusSxyAZLeNiqh_edFKtQ889XWN7wC/view?usp=sharing```  For further notes, type >notes")
                .setColor(Color.pink)
                .setFooter("\"Inspiration is perishable, act now or it's already too late.\"", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        EmbedBuilder Stat = new EmbedBuilder()
                .setTitle("Probabilty & Statistics Modules/PPTs | Sir  Baking")
                .setDescription("Here are the modules and PPTs that have been provided by Sir so far...")
                .setAuthor("ICTHS Official Facebook Page", "https://www.facebook.com/ICTHS/", "https://cdn.discordapp.com/attachments/825351550545035285/828887019798659102/fb_icon_325x325.png")
                .addField("__**Lesson 1**__", "```(Exploring_Random_Variables) https://drive.google.com/file/d/1a5Rogm1LVSHSgU-SHZfVwoS7lDrIjQKI/view?usp=sharing```  For further notes, type >notes")
                .addField("__**Lesson 2**__", "```(Constructing_Probability_Distributions) https://drive.google.com/file/d/17McL50UrYSxUVzZbjN3fDvCc8O4lfIXt/view?usp=sharing```  For further notes, type >notes")
                .addField("__**Lesson 3**__", "```(Computing_the_Mean_of_a_Discrete_Probability_Distribution) https://drive.google.com/file/d/1fT-5r7rhf_YxXTf979Uovzsi03bMmDJ6/view?usp=sharing```  For further notes, type >notes")
                .setColor(Color.pink)
                .setFooter("\"Inspiration is perishable, act now or it's already too late.\"", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");


        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "modules")) {
            event.getChannel().type();
            event.getChannel().sendMessage("Hey there <@" + displayID + ">, you are currently asking for the modules of what subject?");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getChannel().sendMessage(">>> *Here are the list of subjects available on my database:*\n```1) KomPan\n2) USCP\n3) Probability & Statistics```");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getChannel().type();
            event.getChannel().sendMessage("\nEnter the dedicated __*number*__ of the subject that you want to select after this message...");

            event.getMessageAuthor().asUser().ifPresent(user ->{ final ListenerManager[] lm = new ListenerManager[1];
                lm[0] = user.addMessageCreateListener(new MessageCreateListener() {
                    //private
                    @Override
                    public void onMessageCreate(MessageCreateEvent eventM) {

                        if (eventM.getMessageContent().equalsIgnoreCase("1")) {
                            eventM.getChannel().type();
                            eventM.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617> ||Updated 04/06/2021|| ");
                            eventM.getChannel().sendMessage(KomPan);
                            event.getChannel().type();
                            event.getChannel().sendMessage("This transaction will be deleted in __**15**__ seconds to avoid confusion for future updates on my data. <:PAMPANGASBEST:785916602277298187>");
                            try {
                                TimeUnit.SECONDS.sleep(15);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().sendMessage("Conversation with <@" + displayID + "> have been swept under the rug :eyes:");
                            lm[0].remove();

                        } else if (eventM.getMessageContent().equalsIgnoreCase("2")) {
                            eventM.getChannel().type();
                            eventM.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617> ||Updated 04/07/2021|| ");
                            eventM.getChannel().sendMessage(USCP);
                            event.getChannel().type();
                            event.getChannel().sendMessage("This transaction will be deleted in __**15**__ seconds to avoid confusion for future updates on my data. <:PAMPANGASBEST:785916602277298187>");
                            try {
                                TimeUnit.SECONDS.sleep(15);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().sendMessage("Conversation with <@" + displayID + "> have been swept under the rug :eyes:");
                            lm[0].remove();

                        } else if (eventM.getMessageContent().equalsIgnoreCase("3")) {
                        eventM.getChannel().type();
                        eventM.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617> ||Updated 04/07/2021|| ");
                        eventM.getChannel().sendMessage(Stat);
                            event.getChannel().type();
                            event.getChannel().sendMessage("This transaction will be deleted in __**15**__ seconds to avoid confusion for future updates on my data. <:PAMPANGASBEST:785916602277298187>");
                            try {
                                TimeUnit.SECONDS.sleep(15);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().type();
                            event.getChannel().sendMessage("Conversation with <@" + displayID + "> have been swept under the rug :eyes:");
                            lm[0].remove();

                        } else {
                            lm[0].remove();
                            eventM.getChannel().type();
                            eventM.getChannel().sendMessage("> Option not found...\n>>> Please call the command >notes again and select a valid option." );


                        }
                    }
                });
            });
        }
    }
}

