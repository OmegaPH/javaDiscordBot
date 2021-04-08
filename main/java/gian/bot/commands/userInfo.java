package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
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
        String displayName = String.valueOf(infoEmbed.getMessageAuthor().getDisplayName());
        String username = String.valueOf(infoEmbed.getMessageAuthor().getId());
        String displayID = String.valueOf(infoEmbed.getMessageAuthor().getId());
        String section = "abc";
        String gender = "abc";
        String userRoles = "abc";
        String idkMsg = "I don't know you yet <(-_-)>";
        String z = "Outsider";
        User u = infoEmbed.getMessageAuthor().asUser().get();
        List<Role> roles = infoEmbed.getServer().get().getRoles(u);
        String output = "\n";

        for (Role r : roles)
            output += "\t[" + r.getName().replaceFirst("@", "") + "]\n";

        if (infoEmbed.getMessageContent().equalsIgnoreCase(Main.Prefix + "who_test")){
            infoEmbed.getChannel().sendMessage(output);

        }
        //register users here
        if (username.equalsIgnoreCase("430621525654241300")) {
            username = "Juan Miguel Soriano II";
            section = "Descartes";
            gender = "Male";
            userRoles = output;

        } else if (username.equalsIgnoreCase("414362560909934592")) {
            username = "Gian Carlo Sitchon";
            section = "Descartes";
            gender = "Male";
            userRoles = output;
        } else if (username.equalsIgnoreCase("252334016395476995")) {
            username = "Xandre Jover Duncan";
            section = "Ptolemy";
            gender = "Male";
            userRoles = output;
        } else if (username.equalsIgnoreCase("417281170494193665")) {
            username = "Miguel Pingol";
            section = "Ptolemy";
            gender = "Male";
            userRoles = output;
        } else if (username.equalsIgnoreCase("403690866507513876")) {
            username = "Tristan Santos AKA Bato | Bats";
            section = "Outsider (HAU)";
            gender = "N/A";
            userRoles = output;

        } else if (username.equalsIgnoreCase("399878841545392148")) {
            username = "Dean Andrei Palma";
            section = "Galilei";
            gender = "Male";
            userRoles = output;
        } else if (username.equalsIgnoreCase("582758619045691393")) {
            username = "Justine Torres Gueverra";
            section = "Descartes";
            gender = "Male";
            userRoles = output;

        } else {
            username = "I don't know you yet <(-_-)>";
        }

        //section if else statements



        EmbedBuilder embedGreen = new EmbedBuilder()
                .setTitle("Your Name is:")
                .setDescription(username)
                .setAuthor("Click me for fun!", "https://youtu.be/j8PxqgliIno", "https://cdn.discordapp.com/attachments/742762009778585631/824317577584836608/26220309_829115467259230_4833775892851768861_o.png")
                .addField("Roles", userRoles)
                .addInlineField("Gender", gender)
                .addInlineField("Section", section )
                .setColor(Color.GREEN)
                .setFooter("Now you know who you are...", "https://cdn.discordapp.com/attachments/771182740024328235/825321716418215966/latest.png")
                .setImage(new File("S:\\Documents\\Desktop Folder\\School Stuff\\Hope\\Event\\Lei\\Pto.png"))
                .setThumbnail(infoEmbed.getMessageAuthor().getAvatar());

        EmbedBuilder embedRed = new EmbedBuilder()
                .setTitle("Your Name is:")
                .setDescription(username)
                .setAuthor("Click me for fun!", "https://youtu.be/j8PxqgliIno", "https://cdn.discordapp.com/attachments/742762009778585631/824317577584836608/26220309_829115467259230_4833775892851768861_o.png")
                .addField("Roles", userRoles)
                .addInlineField("Gender", gender)
                .addInlineField("Section", section )
                .setColor(Color.RED)
                .setFooter("Now you know who you are...", "https://cdn.discordapp.com/attachments/771182740024328235/825321716418215966/latest.png")
                .setImage(new File("S:\\Downloads\\gal.png"))
                .setThumbnail(infoEmbed.getMessageAuthor().getAvatar());

        EmbedBuilder embedGray = new EmbedBuilder()
                .setTitle("Your Name is:")
                .setDescription(username)
                .setAuthor("Click me for fun!", "https://youtu.be/j8PxqgliIno", "https://cdn.discordapp.com/attachments/742762009778585631/824317577584836608/26220309_829115467259230_4833775892851768861_o.png")
                .addField("Roles", userRoles)
                .addInlineField("Gender", gender)
                .addInlineField("Section", section )
                .setColor(Color.GRAY)
                .setFooter("Now you know who you are...", "https://cdn.discordapp.com/attachments/771182740024328235/825321716418215966/latest.png")
                .setImage(new File("S:\\Pictures\\Pasted Image - 5.png"))
                .setThumbnail(infoEmbed.getMessageAuthor().getAvatar());

        EmbedBuilder embedBlack = new EmbedBuilder()
                .setTitle("Your Name is:")
                .setDescription(username)
                .setAuthor("Click me for fun!", "https://youtu.be/j8PxqgliIno", "https://cdn.discordapp.com/attachments/742762009778585631/824317577584836608/26220309_829115467259230_4833775892851768861_o.png")
                .addField("Roles", userRoles)
                .addInlineField("Gender", gender)
                .addInlineField("Section", section )
                .setColor(Color.BLACK)
                .setFooter("Now you know who you are...", "https://cdn.discordapp.com/attachments/771182740024328235/825321716418215966/latest.png")
                .setImage(new File("S:\\Documents\\Desktop Folder\\School Stuff\\Hope\\Event\\Lei\\notICT.png"))
                .setThumbnail(infoEmbed.getMessageAuthor().getAvatar());


        if (infoEmbed.getMessageContent().equals(Main.Prefix + "who am i?")) {
            infoEmbed.getChannel().type();
            infoEmbed.getChannel().sendMessage("idk :l");

        }
        if (infoEmbed.getMessageContent().equals(Main.Prefix + "WHO AM I?")) {
            //this next if statement is if the user have not registered yet
            if (username.equalsIgnoreCase(idkMsg)) {
                infoEmbed.getChannel().type();
                new MessageBuilder()
                        .append("Sorry, it seems like you haven't registered your ")
                        .append("Display ID", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                        .append(" to <@414362560909934592> yet.")
                        .appendCode("java", "Your current Display ID is: " + displayID)
                        .setEmbed(new EmbedBuilder()
                                .setTitle("Please send your Display ID to: ")
                                .setThumbnail(new File("S:\\Documents\\Desktop Folder\\School Stuff\\Hope\\Event\\Lei\\Discord.png"))
                                .setDescription("*Beep, bop, boop!*")
                                .addField(".", "*Sorry*, I'm just a bot missing some codes (|._.|)")
                                .setColor(Color.MAGENTA))
                        .send(infoEmbed.getChannel());
            // if he or she is registered, this code runs:
            } if (username != idkMsg) {
                if (section.equalsIgnoreCase("Descartes")) {

                    infoEmbed.getChannel().type();
                    infoEmbed.getChannel().sendMessage(embedGray); // Gray line
                    infoEmbed.getChannel().type();
                    new MessageBuilder()
                            .append("This is ")
                            .append("WHO", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                            .append(" you are... ( '-')")
                            .send(infoEmbed.getChannel());
                } if (section.equalsIgnoreCase("galilei")){
                    infoEmbed.getChannel().type();
                    infoEmbed.getChannel().sendMessage(embedRed); //Red line
                    infoEmbed.getChannel().type();
                    new MessageBuilder()
                            .append("This is ")
                            .append("WHO", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                            .append(" you are... ( '-')")
                            .send(infoEmbed.getChannel());
                } if (section.equalsIgnoreCase("PTOlemy")){
                    infoEmbed.getChannel().type();
                    infoEmbed.getChannel().sendMessage(embedGreen); //Blue line
                    infoEmbed.getChannel().type();
                    new MessageBuilder()
                            .append("This is ")
                            .append("WHO", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                            .append(" you are... ( '-')")
                            .send(infoEmbed.getChannel());
                } if (section.contains(z)){
                    infoEmbed.getChannel().type();
                    infoEmbed.getChannel().sendMessage(embedBlack);
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
