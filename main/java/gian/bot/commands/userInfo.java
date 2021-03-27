package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class userInfo implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent infoEmbed) {
    String username = String.valueOf(infoEmbed.getMessageAuthor().getDisplayName());
    //username is the sender's display name, use this to detect and determine his or her real name.
    if (username.equalsIgnoreCase("def not gian")) {
        username = "Gian Carlo S. Sitchon";
    } if (username.equalsIgnoreCase("ulolololl")) {
        username = "Gabriel Carl Crisostomo";
        } if (username.equalsIgnoreCase("BIG D DEAN")) {
        username = "Dean Andrei Palma";
        } if (username.equalsIgnoreCase("fucking tim (plv)")) {
            username = "Timothy Jerome Feraro";
        } if (username.equalsIgnoreCase("xand")) {
            username = "Xandre Jover Duncan";
        } if (username.equalsIgnoreCase("asset ng pdea")){
            username = "Miguel Inigo Pingol";
        } else {
        username = "I have no idea who you are, dad is that you?";
        }


        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Your Name is:")
                .setDescription(username)
                .setAuthor("Click me for fun!", "https://youtu.be/j8PxqgliIno", "https://cdn.discordapp.com/attachments/742762009778585631/824317577584836608/26220309_829115467259230_4833775892851768861_o.png")
                .addField("!NULL", "!NULL")
                .addInlineField("!NULL", "!NULL")
                .addInlineField("Section: ", "!NULL")
                .setColor(Color.BLUE)
                .setFooter("Now you know who you are...", "https://cdn.discordapp.com/attachments/771182740024328235/825321716418215966/latest.png")
                .setImage(new File("S:\\Pictures\\Pasted Image - 5.png"))
                .setThumbnail(new File("S:\\Pictures\\Pasted Image - 5.png"));

        if (infoEmbed.getMessageContent().equals(Main.Prefix + "who am i?")) {
            infoEmbed.getChannel().type();
            infoEmbed.getChannel().sendMessage("idk :l");

        } if (infoEmbed.getMessageContent().equals(Main.Prefix + "WHO AM I?")) {
            infoEmbed.getChannel().type();
            infoEmbed.getChannel().sendMessage(embed);
            infoEmbed.getChannel().type();
            new MessageBuilder()
                    .append("This is ")
                    .append("WHO", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                    .append(" you are... ( '-')")
                    .send(infoEmbed.getChannel());

        }
    }
}
