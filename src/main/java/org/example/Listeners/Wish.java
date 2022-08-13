package org.example.Listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.Main;

import java.awt.*;
import java.util.*;

public class Wish extends ListenerAdapter {
        Map<String, Thread> timers = new HashMap<>();
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getChannel().getType().equals(ChannelType.PRIVATE)) return;
        String[] args = e.getMessage().getContentRaw().split(" ");
        String userId = e.getAuthor().getId();
        switch (args[0].toLowerCase(Locale.ROOT)){
            case ".set":
            if(timers.containsKey(userId)){
                e.getMessage().reply("`A timer is already running! No need to reset it!, please do .stop to end the timer`").queue();
                return;
            }
                Runnable runnable = () -> {

                    EmbedBuilder wishBuilder = new EmbedBuilder()
                            .setColor(Color.BLACK);
                    wishBuilder.setTitle("Reminder set!");
                    wishBuilder.setDescription("**.wish / .work reminder set!** \n" +
                            "**Don't forget to do** `.wish! / .work!` **in** <#969147973210607626> \n" +
                            "**we will remind you every one hour!**");
                    e.getMessage().replyEmbeds(wishBuilder.build())
                            .mentionRepliedUser(false)
                            .queue();

                    Timer wishTimer = new Timer();
                    wishTimer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            EmbedBuilder wishReminder = new EmbedBuilder();

                            wishReminder.setTitle("Time for .wish! / .work!");
                            wishReminder.setColor(Color.WHITE);
                            wishReminder.setDescription("**goto** <#969147973210607626> **and do** `.wish` \n" +
                                    "**you can stop the timer by** `.stop`");
                            e.getMessage().replyEmbeds(wishReminder.build())
                                    .mentionRepliedUser(true)
                                    .queue();
                        }
                    }, 3600000,3600000 );
                };
                Thread thread = new Thread(runnable, userId);
                thread.start();
                timers.put(userId, thread);
                break;

            case ".stop":
                if(timers.containsKey(userId)){
                    timers.get(userId).interrupt();
                    timers.remove(userId);
                    e.getMessage().replyEmbeds(new EmbedBuilder()
                            .setTitle("Successfully cancelled the timer!")
                            .build()).queue();
                }else{
                    e.getMessage().reply("`you don't have a timer running!`").queue();
                    return;
                }
                break;

            case ".drink":
            case ".Drink":
                EmbedBuilder drinkBuilder = new EmbedBuilder();
                drinkBuilder.setTitle("Reminder set!");
                drinkBuilder.setDescription("**drink reminder set!** \n" +
                        "**:sweat_drops:Stay Hydrated!!:sweat_drops:**\n" +
                        "**we will remind you soon to drink water!**");
                e.getMessage().replyEmbeds(drinkBuilder.build())
                        .mentionRepliedUser(false)
                        .queue();

                Timer drinkTimer = new Timer();
                drinkTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        EmbedBuilder drinkReminder = new EmbedBuilder();
                        drinkReminder.setTitle("Time to get hydrated");
                        drinkReminder.setColor(Color.WHITE);
                        drinkReminder.setDescription("**give yourself a treat and drink some water :sweat_drops:**\n" +
                                "**Don't forget to set timer back!**");
                        e.getMessage().replyEmbeds(drinkReminder.build())
                                .mentionRepliedUser(true)
                                .queue();
                        Main.builder.openPrivateChannelById(userId).flatMap(privateChannel -> privateChannel.sendMessageEmbeds(drinkReminder.build())).queue();
                    }
                }, 2400000);
                break;


            case "froggy": 
            case "Froggy":
                EmbedBuilder froggyBuilder = new EmbedBuilder()
                        .setColor(Color.BLACK)
                        .setTitle("Froggy is Gay!!!")
                        .setImage("https://cdn.discordapp.com/attachments/986979518759718944/986983733649371256/unknown.png");
                e.getMessage().replyEmbeds(froggyBuilder.build())
                        .mentionRepliedUser(false)
                        .queue();
                break;

            case ".secret":
            case ".Secret":
                EmbedBuilder secretBuilder = new EmbedBuilder()
                        .setColor(Color.BLACK)
                        .setTitle("Super secret document of humanity")
                        .setDescription("**Don't click :flushed:** https://youtu.be/dQw4w9WgXcQ");
                e.getMessage().replyEmbeds(secretBuilder.build())
                        .mentionRepliedUser(false)
                        .queue();
                break;


                
            case ".help":
            case ".Help":
                EmbedBuilder helpBuilder = new EmbedBuilder();
                helpBuilder.setTitle("Help");
                helpBuilder.addField("Commands: ", "" +
                        "`.set` **set reminder for using** `.set` :timer: \n" +
                        "`.stop` **stop reminder by using** `.stop` :timer: \n" +
                        "`.drink` **set reminder to drink water by** `drink` :sweat_drops: \n" +
                        "ㅤㅤㅤㅤㅤㅤㅤㅤ\n" +
                        "`froggy` **bully froggy with** `froggy` :stuck_out_tongue_closed_eyes: \n" +
                        "`.secret` **know the secret of humanity by** `.secret` :flushed:" +
                        "ㅤㅤㅤㅤㅤㅤㅤㅤ", false);

                helpBuilder.addField("How to use?", " ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ\n" +
                        "**when you use** `.wish/.work` **command on <#969147973210607626> channel \n" +
                        "do it here too, it will remind you on the exact time when \n" +
                        "the cool down for those commands ends (one hour)** \n" +
                        "ㅤㅤㅤㅤㅤㅤㅤㅤ\n", false);

                helpBuilder.addField("About smile reminder", "" +
                        "ㅤㅤㅤㅤㅤㅤㅤㅤ\n" +
                        "```Smile reminder bot(v3) is a open source FREE bot made to remind users on .wish/.work command cooldown \n" +
                        "It's not backed or supervised by official kai's haven. every donation will go into bot hosting``` ", false);

                helpBuilder.setDescription("**Thank you for choosing Smile reminder bot, it's appreciated :heart:**");

                e.getMessage().replyEmbeds(helpBuilder.build())
                        .mentionRepliedUser(false)
                        .queue();
                break;
        }
    }

}
