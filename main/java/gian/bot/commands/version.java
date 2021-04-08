package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class version implements MessageCreateListener {
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

        }
    }
}
