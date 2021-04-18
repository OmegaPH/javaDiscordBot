package gian.bot.commands.guessGame;

import gian.bot.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class guessingGame implements MessageCreateListener {


    public int Points(int c) {
        d = c;
        return c++;
    }
    int d;
    public int PointsB(int e){
        return e++;
    }

    int FFscore = guessScore.score;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String displayID = String.valueOf(event.getMessageAuthor().getId());
        Random option = new Random();
        int e = 0;
        final int[] pointsA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //random numbers prepared
        final int[] optionA = {option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1, option.nextInt(4) + 1};
        int f = e;
        final String[] names = {"Tristan", "Justine", "Miguel"};  //options
        //random numbers prepared
        final int[] nameR = {option.nextInt(3) + 1, option.nextInt(3) + 1, option.nextInt(3) + 1, option.nextInt(3) + 1, option.nextInt(3) + 1, option.nextInt(3) + 1, option.nextInt(3) + 1};



        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "guess")) { //global
                event.getChannel().type();
                //mark_3
                event.getChannel().sendMessage("<@" + displayID + ">,\n>>> __Guessing Game! Bot is generating a random number name__... **Justine, Miguel, or Tristan**.\nWait for the go signal and then guess a __name__! GLHF");
                event.getChannel().type();
                event.getChannel().sendMessage("Bot has generated a name! Enter your guess now...");

                event.getMessageAuthor().asUser().ifPresent(user -> {
                    final ListenerManager[] lm = new ListenerManager[1];
                    lm[0] = user.addMessageCreateListener(new MessageCreateListener() { //private

                        @Override
                        public void onMessageCreate(MessageCreateEvent event) {
                            optionA[0] = option.nextInt(4) + 1;
                            nameR[0] = option.nextInt(2) + 1;
                            String nameF = names[nameR[0]];
                            try {
                                event.getChannel().type();

                                TimeUnit.MILLISECONDS.sleep(50);

                                if (event.getMessageContent().equalsIgnoreCase(String.valueOf(nameF))) { //correct answer
                                    int FinalScore = guessScore.addScore(); //+1 to the score
                                    int FFscore = guessScore.score;
                                        optionA[0]++; //name generated
                                    event.getChannel().type();
                                    event.getChannel().sendMessage("Wow! <@"+displayID +"> \n You got it right! Current score: "+"__**"+pointsA[Points(0)]++ +"**__");
                                    try
                                        {
                                            event.getChannel().type();
                                            TimeUnit.SECONDS.sleep(1);
                                        } catch(
                                        InterruptedException e)
                                        {
                                            e.printStackTrace();
                                        }
                                    event.getChannel().sendMessage("Bot has generated a new name! Enter your guess now...");

                                    } else {                //final phase of the game (game over wrong answer)
                                        lm[0].remove();

                                         if (guessScore.score > 0) {

                                            event.getChannel().sendMessage("> Welp, nice try <@" + displayID + "> :c" + " It was " + "**" + nameF + "**\n" +
                                                    "> Your final score is " + "__**" + guessScore.score + "**__");

                                            //asks user if he or she wants to upload the score to the leaderboard
                                            event.getChannel().type();
                                            event.getChannel().sendMessage("> Do you want to upload your score to the *leaderboard*? Type [>Yes or >No]");
                                            lm[0].remove();


                                        } else {
                                            event.getChannel().sendMessage("> Welp, nice try <@" + displayID + "> :c" + " It was " + "**" + nameF + "**\n" +
                                                    "> Your final score is " + "__**" + guessScore.score + "**__");
                                            lm[0].remove();
                                        }
                                    }

                                } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            }
                });
                });
        }
    }
    }



