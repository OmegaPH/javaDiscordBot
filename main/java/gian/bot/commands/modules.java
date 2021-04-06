package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;

import java.awt.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class modules implements MessageCreateListener {
    //global
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        int[] options = {1};
        String displayID = String.valueOf(event.getMessageAuthor().getId());

        EmbedBuilder KomPan = new EmbedBuilder()
                .setTitle("KomPan Modules | Gng. Rosalina Molines")
                .setDescription("Here are the modules that have been provided by Gng so far...")
                .setAuthor("ICTHS Official Facebook Page", "https://www.facebook.com/ICTHS/", "https://cdn.discordapp.com/attachments/825351550545035285/828887019798659102/fb_icon_325x325.png")
                .addField("__**1st Week**__", "```https://docs.google.com/document/d/1iwO3wIK7x2tY-xfCIkfHSgVLrftCesjLGUzK6pYrdIg/edit?usp=sharing``` \n For further notes type >notes")
                .addField("__**2nd Week**__", "```https://docs.google.com/document/d/1mn6qLdRrMAo8aAHPGAB9ZDDH3pNtDGr10jwgp5DhtFE/edit?usp=sharing``` \n For further notes type >notes")
                .addField("__**3rd Week**__", "```https://docs.google.com/document/d/1dU2qsMU2O-8b7Lfp6dKdjG4JyYn_5JrBUUPchbE2oZw/edit?usp=sharing``` \n For further notes type >notes")
                .setColor(Color.white)
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
            event.getChannel().sendMessage("*Here are the list of subjects available on my database:*\n```1) KomPan```");
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
                    public void onMessageCreate(MessageCreateEvent event) {

                        if (event.getMessageContent().equalsIgnoreCase("1")) {
                            event.getChannel().type();
                            event.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617>");
                            event.getChannel().sendMessage(KomPan);
                            lm[0].remove();

                        } else if (String.valueOf(event.getMessageContent()) != String.valueOf(options)) {
                            event.getChannel().type();
                            event.getChannel().sendMessage("Error ```Option not found, please call the command >modules again and select a valid option```" );
                            lm[0].remove();

                        }
                    }
                });
            });
        }
    }
}
