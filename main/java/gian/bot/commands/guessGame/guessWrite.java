package gian.bot.commands.guessGame;

import gian.bot.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//data writer
public class guessWrite implements MessageCreateListener {

            @Override
            public void onMessageCreate(MessageCreateEvent event) {

                if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "yes")) { //file writer

                    if (guessScore.score > 0) {

                        try {
                            File f = new File("GuessLeadearboard.txt");
                            PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
                            pw.append(guessScore.score + "\n" + String.valueOf(event.getMessageAuthor().getDisplayName()) + "\n");
                            pw.close();

                            event.getChannel().sendMessage("Score uploaded! View the *Leaderboard* by typing __>guess leaderboard__");

                            guessScore.score = guessScore.score - guessScore.score; // resets score to 0

                        } catch (Exception e) {
                            System.out.println("Highscore recording failed");
                        }
                    } else {
                        event.getChannel().type();
                        event.getChannel().sendMessage(">>> *Uh oh...*\n Play a game of >guess first before recording your score lmao.");
                    }

                } else if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "no")) {


                    if (guessScore.score > 0) {
                        guessScore.score = guessScore.score - guessScore.score; // resets score to 0
                        event.getChannel().sendMessage("Alrighty, **GAME OVER!**");
                    } else {
                        event.getChannel().type();
                        event.getChannel().sendMessage(">>> *Uh oh...*\n Play a game of >guess first before recording your score lmao.");
                    }
                }
            }
}
