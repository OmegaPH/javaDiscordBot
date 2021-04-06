package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;

import java.awt.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class notes implements MessageCreateListener {
    //global
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        int[] options = {1};
        String displayID = String.valueOf(event.getMessageAuthor().getId());

        EmbedBuilder KomPan = new EmbedBuilder()
                .setTitle("KomPan Notes :zzz: ")
                .setDescription("Here are the available notes for the subject __KomPan__")
                .setAuthor("SHING", "https://www.youtube.com/watch?v=WDhkKeS4NfI", "https://cdn.discordapp.com/attachments/698520297585770536/828952303578251264/unknown.png")
                .addField("__**1st & 2nd Week**__", "```https://docs.google.com/document/d/1iwO3wIK7x2tY-xfCIkfHSgVLrftCesjLGUzK6pYrdIg/edit?usp=sharing``` \n Courtesy of: **Unknown o.o**")
                .setColor(Color.GREEN)
                .setFooter("Thanks to the people who have contributed! Sipag niyo <:WOO:785916519775076393>", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "notes")) {
            event.getChannel().type();
            event.getChannel().sendMessage(":notepad_spiral: ||Notes for the 2nd Sem of ICTHS||");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getChannel().sendMessage("*I have collected notes for the following subjects, pick one to study!*\n```1) KomPan```");
            try {
                TimeUnit.SECONDS.sleep(1);
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
                            event.getChannel().sendMessage("> Option not found...\n>>> Please call the command >notes again and select a valid option." );
                            lm[0].remove();

                        }
                    }
                });
            });
        }
    }
}
