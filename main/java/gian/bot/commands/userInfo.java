package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class userInfo implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent infoEmbed) {
        String username = String.valueOf(infoEmbed.getMessageAuthor().getId());
        String displayID = String.valueOf(infoEmbed.getMessageAuthor().getId());
        String section = "abc";


        //username is the sender's display name, use this to detect and determine his or her real name.
        if (username.equalsIgnoreCase("414362560909934592")) {
            username = "Gian Carlo Sitchon";
            section = "Descartes";
        } else {
            username = "I don't know you yet <(-_-)>";
        }

        //section if else statements



        EmbedBuilder embedBlue = new EmbedBuilder()
                .setTitle("Your Name is:")
                .setDescription(username)
                .setAuthor("Click me for fun!", "https://youtu.be/j8PxqgliIno", "https://cdn.discordapp.com/attachments/742762009778585631/824317577584836608/26220309_829115467259230_4833775892851768861_o.png")
                .addField("Roles", "*still struggling to code user.getRoles.api* == !NULL")
                .addInlineField("Gender", "Male")
                .addInlineField("Section", section )
                .setColor(Color.BLUE)
                .setFooter("Now you know who you are...", "https://cdn.discordapp.com/attachments/771182740024328235/825321716418215966/latest.png")
                .setImage(new File("S:\\Pictures\\Pasted Image - 5.png"))
                .setThumbnail(infoEmbed.getMessageAuthor().getAvatar());

        EmbedBuilder embedRed = new EmbedBuilder()
                .setTitle("Your Name is:")
                .setDescription(username)
                .setAuthor("Click me for fun!", "https://youtu.be/j8PxqgliIno", "https://cdn.discordapp.com/attachments/742762009778585631/824317577584836608/26220309_829115467259230_4833775892851768861_o.png")
                .addField("Roles", "*still struggling to code user.getRoles.api* == !NULL")
                .addInlineField("Gender", "Male")
                .addInlineField("Section", section )
                .setColor(Color.RED)
                .setFooter("Now you know who you are...", "https://cdn.discordapp.com/attachments/771182740024328235/825321716418215966/latest.png")
                .setImage(new File("S:\\Pictures\\Pasted Image - 5.png"))
                .setThumbnail(infoEmbed.getMessageAuthor().getAvatar());


        if (infoEmbed.getMessageContent().equals(Main.Prefix + "who am i?")) {
            infoEmbed.getChannel().type();
            infoEmbed.getChannel().sendMessage("idk :l");

        }
        if (infoEmbed.getMessageContent().equals(Main.Prefix + "WHO AM I?")) {
            //this next if statement is if the user have not registered yet
            if (username.equalsIgnoreCase("I don't know you yet <(-_-)>")) {
                infoEmbed.getChannel().type();
                new MessageBuilder()
                        .append("Sorry, it seems like you haven't registered your ")
                        .append("Display ID", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                        .append(" to <@414362560909934592> .")
                        .appendCode("java", "Your current Display ID is: " + displayID)
                        .setEmbed(new EmbedBuilder()
                                .setTitle("Please send your Display ID to ")
                                .setThumbnail(new File("S:\\Documents\\Desktop Folder\\School Stuff\\Hope\\Event\\Lei\\Discord.png"))
                                .setDescription("Beep, bop, boop!")
                                .setColor(Color.cyan))
                        .send(infoEmbed.getChannel());
            // if he or she is registered, this code runs:
            } if ("I don't know you yet <(-_-)>" != username) {
                if (section.equalsIgnoreCase("Descartes")) {

                    infoEmbed.getChannel().type();
                    infoEmbed.getChannel().sendMessage(embedBlue);
                    infoEmbed.getChannel().type();
                    new MessageBuilder()
                            .append("This is ")
                            .append("WHO", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                            .append(" you are... ( '-')")
                            .send(infoEmbed.getChannel());
                } if (section.equalsIgnoreCase("galilei")){
                    infoEmbed.getChannel().type();
                    infoEmbed.getChannel().sendMessage(embedRed);
                    infoEmbed.getChannel().type();
                    new MessageBuilder()
                            .append("This is ")
                            .append("WHO", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                            .append(" you are... ( '-')")
                            .send(infoEmbed.getChannel());
                }

            }
        }
    }
}
