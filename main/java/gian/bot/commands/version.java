package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;
import org.javacord.api.util.logging.ExceptionLogger;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class version implements MessageCreateListener {

    long start = System.currentTimeMillis();

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        Date dateTime = new Date();
        EmbedBuilder date = new EmbedBuilder()
                .setTitle("**I was last updated on...**")
                .setDescription("__**" + dateTime + "**__")
                .setImage("https://media1.tenor.com/images/5291ed709e29d9401915bb07ce2e5c87/tenor.gif?itemid=13716448")
                .setFooter("Beep... bop.. boop~", "https://media.discordapp.net/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png?width=677&height=676");


        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "version")) {
            event.getChannel().type();
            event.getChannel().sendMessage(date);
            event.getChannel().type();
            long end = System.currentTimeMillis();
            long elapsed = (end - start) / 1000;
            event.getChannel().sendMessage(">>> It has been **" + elapsed + "." + (end - start) % 1000 + " seconds** since the bot was last updated.\nSince Gian is a dumb dumb and doesn't know how to seperate minutes and hours from seconds in the code...\nHere is a miliseconds to minutes calculator, type in __**>mili**__");
        }
            if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "mili")) {
                String displayID = String.valueOf(event.getMessageAuthor().getId());
                event.getChannel().type();
                event.getChannel().sendMessage("<@" + displayID + ">, enter the __value of seconds__ you want to convert to __minutes__.");
                event.getMessageAuthor().asUser().ifPresent(user -> {
                    final ListenerManager[] lm = new ListenerManager[1];
                    lm[0] = user.addMessageCreateListener(new MessageCreateListener() {
                        @Override
                        public void onMessageCreate(MessageCreateEvent event) {
                            try {
                                float value = Float.valueOf(String.valueOf(event.getMessageContent()));

                                if (value > 0) {
                                    event.getChannel().type();
                                    event.getChannel().sendMessage("Converted seconds received to __" + value / 60 + " minutes__");
                                    lm[0].remove();
                                }
                            } catch (NumberFormatException e) {
                                event.getChannel().type();
                                event.getChannel().sendMessage(String.valueOf("```java\n" + e + "\n```"));
                                event.getChannel().type();
                                event.getChannel().sendMessage("**Please input a valid and the ** **__EXACT NUMBER__** **of seconds**");
                                lm[0].remove();
                            }
                        }
                    });
                });
            }
        }
    }

