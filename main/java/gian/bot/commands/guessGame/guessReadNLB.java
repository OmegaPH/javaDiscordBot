package gian.bot.commands.guessGame;

import gian.bot.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class guessReadNLB implements MessageCreateListener {


    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        //reader
        File file = new File("S:\\Documents\\Program Files\\PC Softwares Files\\Java Projects\\Java Projects (IntelliJ)\\GuessLeadearboard.txt");
        Scanner scanscan;
        try {
            scanscan = new Scanner(file);
            //taga ayos ng 1st, 2nd, and 3rd
            int scoreA = Integer.parseInt(scanscan.nextLine());
            String userA = scanscan.nextLine();
            int scoreB = Integer.parseInt(scanscan.nextLine());
            String userB = scanscan.nextLine();
            int scoreC = Integer.parseInt(scanscan.nextLine());
            String userC = scanscan.nextLine();
            //end of 'taga ayos'

    //embed structures

    EmbedBuilder Ac = new EmbedBuilder()
            .setTitle("**GUESS GAME LEADERBOARD**")
            .setDescription("*Dis is still on beta so yeah, still testing...*")
            .addField("First", String.valueOf(scoreA) + userA)
            .addField("Second", String.valueOf(scoreB) + userB)
            .addField("Third", String.valueOf(scoreC) + userC)
            .setFooter("Did it work?");

    EmbedBuilder Bc = new EmbedBuilder()
            .setTitle("**GUESS GAME LEADERBOARD**")
            .setDescription("*Dis is still on beta so yeah, still testing...*")
            .addField("First", String.valueOf(scoreB) + userB)
            .addField("Second", String.valueOf(scoreA) + userA)
            .addField("Third", String.valueOf(scoreC) + userC)
            .setFooter("Did it work?");

    EmbedBuilder Ab = new EmbedBuilder()
            .setTitle("**GUESS GAME LEADERBOARD**")
            .setDescription("*Dis is still on beta so yeah, still testing...*")
            .addField("First", String.valueOf(scoreA) + userA)
            .addField("Second", String.valueOf(scoreC) + userC)
            .addField("Third", String.valueOf(scoreB) + userB)
            .setFooter("Did it work?");

    EmbedBuilder Cb = new EmbedBuilder()
            .setTitle("**GUESS GAME LEADERBOARD**")
            .setDescription("*Dis is still on beta so yeah, still testing...*")
            .addField("First", String.valueOf(scoreC) + userC)
            .addField("Second", String.valueOf(scoreA) + userA)
            .addField("Third", String.valueOf(scoreB) + userB)
            .setFooter("Did it work?");

    EmbedBuilder Ba = new EmbedBuilder()
            .setTitle("**GUESS GAME LEADERBOARD**")
            .setDescription("*Dis is still on beta so yeah, still testing...*")
            .addField("First", String.valueOf(scoreB) + userB)
            .addField("Second", String.valueOf(scoreC) + userC)
            .addField("Third", String.valueOf(scoreA) + userA)
            .setFooter("Did it work?");

    EmbedBuilder Ca = new EmbedBuilder()
            .setTitle("**GUESS GAME LEADERBOARD**")
            .setDescription("*Dis is still on beta so yeah, still testing...*")
            .addField("First", String.valueOf(scoreC) + userC)
            .addField("Second", String.valueOf(scoreB) + userB)
            .addField("Third", String.valueOf(scoreA) + userA)
            .setFooter("Did it work?");

    // end of embed structures

    if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "guess top"))
        if (scoreA > scoreB && scoreB > scoreC) {  //C is the least and A is max
            event.getChannel().sendMessage(Ac);
        }

        else if (scoreB > scoreA && scoreA > scoreC) { //C is the least and B is max
            event.getChannel().sendMessage(Bc);
        }

        else if (scoreA > scoreC && scoreC > scoreB) { //B is the least and A is max
            event.getChannel().sendMessage(Ab);
        }

        else if (scoreC > scoreB && scoreA > scoreB) { //B is the least and C is max
            event.getChannel().sendMessage(Cb);
        }

        else if (scoreB > scoreC && scoreC > scoreA) { //A is the least and B is max
            event.getChannel().sendMessage(Ba);
        }

        else { //A is the least and C is max
            event.getChannel().sendMessage(Ca);
        }
        //end of reader
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
