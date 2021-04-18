package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;
import org.javacord.api.util.logging.ExceptionLogger;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class notes implements MessageCreateListener {
    //global
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String[] options = {"1", "2", "contribute", "3"};
        String displayID = String.valueOf(event.getMessageAuthor().getId());
        String username = String.valueOf(event.getMessageAuthor().getDisplayName());
        //ignore this
        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "note")) {
            event.getChannel().type();
            event.getChannel().sendMessage("> You mean \">noteS\"?");
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/412710366062182421/743739082185900072/Hmm48.gif");

        }
        //ok continue now

        EmbedBuilder contribute = new EmbedBuilder() //dm to the user
                .setTitle("Send some notes! :nerd:")
                .setDescription(">>> *If you have some notes with you and you are **willing to share** them for everyone to enjoy, feel free to send them to me via email :D*")
                .setAuthor("SHING", "https://www.youtube.com/watch?v=WDhkKeS4NfI", "https://cdn.discordapp.com/attachments/698520297585770536/828952303578251264/unknown.png")
                .addField("Send it to this email:", "||ICTHSbot@gmail.com||")
                .addField("\n. ", " . ")
                .setImage("https://imgcp.aacdn.jp/img-a/1200/auto/global-aaj-front/article/2016/03/56e90fe8224a2_56e90fcdda973_894839597.jpg")
                .setColor(Color.blue)
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        EmbedBuilder message = new EmbedBuilder() //dm to the user
                .setTitle("Hello " + username + "! :)")
                .setDescription(">>> *You recently asked some notes from me, well those notes are there thanks to the people who have contributed for them.*\n If you have some notes in you and you are **willing to share** them for everyone to enjoy, feel free to send them to me via email :D")
                .setAuthor("SHING", "https://www.youtube.com/watch?v=WDhkKeS4NfI", "https://cdn.discordapp.com/attachments/698520297585770536/828952303578251264/unknown.png")
                .addField("Send it to this email:", "||ICTHSbot@gmail.com||")
                .addField("\n. ", " . ")
                .setImage("https://imgcp.aacdn.jp/img-a/1200/auto/global-aaj-front/article/2016/03/56e90fe8224a2_56e90fcdda973_894839597.jpg")
                .setColor(Color.blue)
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        EmbedBuilder KomPan = new EmbedBuilder()
                .setTitle("> KomPan Notes :notepad_spiral: ")
                .setDescription("Here are the available notes for the subject __KomPan__\n ||Updated 04/12/2021||")
                .setAuthor("SHING", "https://www.youtube.com/watch?v=WDhkKeS4NfI", "https://cdn.discordapp.com/attachments/698520297585770536/828952303578251264/unknown.png")
                .addField("__**1st & 2nd Week**__", "```https://docs.google.com/document/d/1w2WCGH8Y6UEVBDGcLuklKoy2SVR2unt3OBKU1GxQ1_M/edit``` [Click here for the alternative link](<https://docs.google.com/document/d/1w2WCGH8Y6UEVBDGcLuklKoy2SVR2unt3OBKU1GxQ1_M/edit>)\nCourtesy of: **Unknown o.o**")
                .addField("__**3rd Week (Baryti ng Wika)**__", "```https://drive.google.com/file/d/1598Bnlwc91ssFzn5z6D2gO42HU0ZEACV/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1598Bnlwc91ssFzn5z6D2gO42HU0ZEACV/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("\n. ", " . ")
                .setColor(Color.GREEN)
                .setFooter("Thanks to the people who have contributed! Sipag niyo ;)", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        EmbedBuilder OralCom = new EmbedBuilder()
                .setTitle("> Oral Communiation notes :notepad_spiral: ")
                .setDescription("Here are the available notes for the subject __Oral Communication__\n ||Updated 04/13/2021||")
                .setAuthor("SHING", "https://www.youtube.com/watch?v=WDhkKeS4NfI", "https://cdn.discordapp.com/attachments/698520297585770536/828952303578251264/unknown.png")
                .addField("__**1st Lesson**__", "```https://drive.google.com/file/d/1Sb3gr8AMr-csOfN3U41S7Su93g-bvRu8/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1Sb3gr8AMr-csOfN3U41S7Su93g-bvRu8/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("__**3rd Lesson (Communication Models)**__", "```https://drive.google.com/file/d/1U3KKKORrCMLG9-h753qccnBSeYGDfLUC/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1U3KKKORrCMLG9-h753qccnBSeYGDfLUC/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("\n. ", " . ")
                .setColor(Color.GREEN)
                .setFooter("Thanks to the people who have contributed! Sipag niyo ;)", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        EmbedBuilder Stat = new EmbedBuilder()
                .setTitle("> Prob & Stat Notes :notepad_spiral: ")
                .setDescription("Here are the available notes for the subject __Probabilty & Statistics__\n ||Updated 04/13/2021||")
                .setAuthor("SHING", "https://www.youtube.com/watch?v=WDhkKeS4NfI", "https://cdn.discordapp.com/attachments/698520297585770536/828952303578251264/unknown.png")
                .addField("__**1st & 2nd Lesson**__", "```https://drive.google.com/file/d/1sy42TH7SjngZjgVTpo1jHnZE7NTZ77X_/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1sy42TH7SjngZjgVTpo1jHnZE7NTZ77X_/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("__**3rd Lesson (Variance & Standard Deviation)**__", "```https://drive.google.com/file/d/1DHXvyZgCAQgcpKYbc9-iZPRklXv9woTZ/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1DHXvyZgCAQgcpKYbc9-iZPRklXv9woTZ/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("\n. ", " . ")
                .setColor(Color.cyan)
                .setFooter("Thanks to the people who have contributed! Sipag niyo ;)", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        EmbedBuilder UCSP = new EmbedBuilder()
                .setTitle("> UCSP :notepad_spiral: ")
                .setDescription("Here are the available notes for the subject __UCSP__\n ||Updated 04/15/2021||")
                .setAuthor("SHING", "https://www.youtube.com/watch?v=WDhkKeS4NfI", "https://cdn.discordapp.com/attachments/698520297585770536/828952303578251264/unknown.png")
                .addField("__**1st Week (Stuff that ends with 'logy' + Communication)**__", "```https://drive.google.com/file/d/1sjiGtMYkdVkB-FFjw-lgjyFjj8Y1871k/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1sjiGtMYkdVkB-FFjw-lgjyFjj8Y1871k/view?usp=sharing>)\nCourtesy of: **Wince**")
                .addField("__**3rd Week (Culture)**__","```https://drive.google.com/file/d/1n1GvcGFdpCDGDrNRyMhFUa9C550qPM7h/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1n1GvcGFdpCDGDrNRyMhFUa9C550qPM7h/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("\n. ", " . ")
                .setColor(Color.pink)
                .setFooter("Thanks to the people who have contributed! Sipag niyo ;)", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");

        EmbedBuilder GB2 = new EmbedBuilder()
                .setTitle("> General Biology **2** :notepad_spiral: ")
                .setDescription("Here are the available notes for the subject __General Biology 2__\n ||Updated 04/14/2021||")
                .setAuthor("SHING", "https://www.youtube.com/watch?v=WDhkKeS4NfI", "https://cdn.discordapp.com/attachments/698520297585770536/828952303578251264/unknown.png")
                .addField("__**1st Week (Genetic Engineering & Recombinant DNA)**__", "```https://drive.google.com/file/d/1UOVfKb03drOA9aPQtH4GlYjBjq2hq3Q1/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1UOVfKb03drOA9aPQtH4GlYjBjq2hq3Q1/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("__**2nd Week (Geology stuff)**__", "```https://drive.google.com/file/d/1rk2cnjZd0cFOd8y2iWw2oezL5fNkvCIF/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1rk2cnjZd0cFOd8y2iWw2oezL5fNkvCIF/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("__**3rd Week (Evolution)**__", "```https://drive.google.com/file/d/1_yPADdDC6DBiGnWzyFci76a9GhmF_LLq/view?usp=sharing``` [Click here for the alternative link](<https://drive.google.com/file/d/1_yPADdDC6DBiGnWzyFci76a9GhmF_LLq/view?usp=sharing>)\nCourtesy of: **blank**")
                .addField("\n. ", " . ")
                .setColor(Color.cyan)
                .setFooter("Thanks to the people who have contributed! Sipag niyo ;)", "https://cdn.discordapp.com/attachments/825351550545035285/826662170284392448/damnit.png")
                .setThumbnail("https://cdn.discordapp.com/attachments/825351550545035285/828886063036366888/18157340_1595761667102559_3991239694797473256_n.png");


        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "update")) {
            event.getChannel().sendMessage("***DATA UPDATED*** 1:15am 04/08/2021");
        }

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "notes")) {
            event.getChannel().type();
            event.getChannel().sendMessage(":notepad_spiral: ||Notes for the 2nd Sem of Grade 11 ICTHS Students...||");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getChannel().sendMessage(">>> *I have collected notes for the following subjects, pick one to study!*\n" +

                    // list of available subjects:
                    "```1) KomPan | Gng. Molines\n2) Probablity & Statistics | Sir Baking\n3) USCP | Ma'am Jennee Rose Urbano\n4) OralCom | Ma'am Rowela Basa\n5) General Biology 2 | Ma'am Minette Sajol```");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getChannel().type();
            event.getChannel().sendMessage("\nEnter the dedicated __*number*__ of the subject that you want to select after this message...");
            event.getChannel().type();
            event.getChannel().sendMessage("\nOr if you have notes to share with us, type \"***contribute***\" :thumbsup_tone2:");

            event.getMessageAuthor().asUser().ifPresent(user ->{ final ListenerManager[] lm = new ListenerManager[1];
                lm[0] = user.addMessageCreateListener(new MessageCreateListener() {
                    //private
                    @Override
                    public void onMessageCreate(MessageCreateEvent event) {

                        if (event.getMessageContent().equalsIgnoreCase("contribute")) {
                            event.getChannel().type();
                            event.getChannel().sendMessage(contribute);
                            event.getChannel().type();
                            event.getChannel().sendMessage("> This transaction will be deleted in __**30**__ seconds to avoid confusion for future updates on my data. <:PAMPANGASBEST:785916602277298187>");
                            try {
                                TimeUnit.SECONDS.sleep(30);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().sendMessage("> Conversation with <@" + displayID + "> have been swept under the rug :eyes:, if you too want to get notes, type >notes");
                            lm[0].remove();

                        } else if (event.getMessageContent().equalsIgnoreCase("1")) {
                            event.getChannel().type();
                            event.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617>");
                            event.getChannel().sendMessage(KomPan);
                            user.sendMessage(message);
                            event.getChannel().type();
                            event.getChannel().sendMessage("> This transaction will be deleted in __**30**__ seconds to avoid confusion for future updates on my data. <:PAMPANGASBEST:785916602277298187>");
                            try {
                                TimeUnit.SECONDS.sleep(30);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().sendMessage("> Conversation with <@" + displayID + "> have been swept under the rug :eyes:, if you too want to get notes, type >notes");
                            lm[0].remove();

                        } else if (event.getMessageContent().equalsIgnoreCase("2")) {
                            event.getChannel().type();
                            event.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617>");
                            event.getChannel().sendMessage(Stat);
                            user.sendMessage(message);
                            event.getChannel().sendMessage("> To avoid confusion. This message will be deleted in __**30**__ seconds just in case my database gets updated with more notes. <:PAMPANGASBEST:785916602277298187>");
                            event.getChannel().type();
                            try {
                                TimeUnit.SECONDS.sleep(30);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().sendMessage("> Conversation with <@" + displayID + "> have been swept under the rug :eyes:, if you too want to get notes, type >notes");
                            lm[0].remove();

                        } else if (event.getMessageContent().equalsIgnoreCase("3")) {
                            event.getChannel().type();
                            event.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617>");
                            event.getChannel().sendMessage(UCSP);
                            user.sendMessage(message);
                            event.getChannel().type();
                            event.getChannel().sendMessage("> This transaction will be deleted in __**30**__ seconds to avoid confusion for future updates on my data. <:PAMPANGASBEST:785916602277298187>");
                            try {
                                TimeUnit.SECONDS.sleep(30);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().sendMessage("> Conversation with <@" + displayID + "> have been swept under the rug :eyes:, if you too want to get notes, type >notes");
                            lm[0].remove();

                        } else if (event.getMessageContent().equalsIgnoreCase("4")) {
                            event.getChannel().type();
                            event.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617>");
                            event.getChannel().sendMessage(OralCom);
                            user.sendMessage(message);
                            event.getChannel().sendMessage("> To avoid confusion. This message will be deleted in __**30**__ seconds just in case my database gets updated with more notes. <:PAMPANGASBEST:785916602277298187>");
                            lm[0].remove();

                        } else if (event.getMessageContent().equalsIgnoreCase("5")) {
                            event.getChannel().type();
                            event.getChannel().sendMessage("Here you go <@" + displayID + ">, Study well! <:EZ:732907750949912617>");
                            event.getChannel().sendMessage(GB2);
                            user.sendMessage(message);
                            event.getChannel().sendMessage("> To avoid confusion. This message will be deleted in __**30**__ seconds just in case my database gets updated with more notes. <:PAMPANGASBEST:785916602277298187>");
                            lm[0].remove();
                            try {
                                TimeUnit.SECONDS.sleep(30);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().sendMessage("> Conversation with <@" + displayID + "> have been swept under the rug :eyes:, if you too want to get notes, type >notes");
                            lm[0].remove();

                        } else {
                            event.getChannel().type();
                            event.getChannel().sendMessage("> Option not found...\n>>> Please call the command >notes again and select a valid option." );
                            event.getChannel().type();
                            event.getChannel().sendMessage("This transaction will be deleted in __**30**__ seconds to avoid confusion for future updates on my data. <:PAMPANGASBEST:785916602277298187>");
                            try {
                                TimeUnit.SECONDS.sleep(30);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            event.getChannel().getMessages(7).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                            event.getChannel().sendMessage("> Conversation with <@" + displayID + "> have been swept under the rug :eyes:, if you too want to get notes, type >notes");
                            lm[0].remove();
                        }
                    }
                });
            });

        }
    }
}
