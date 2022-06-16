package org.example.Listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.Main;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Wish extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getChannel().getType().equals(ChannelType.PRIVATE)) return;
        String[] args = e.getMessage().getContentRaw().split(" ");
        switch (args[0]){
            case ".wish":
            case ".Wish":
                EmbedBuilder wishBuilder = new EmbedBuilder()
                        .setColor(Color.BLACK);
                wishBuilder.setTitle("Reminder set!");
                wishBuilder.setDescription("**wish reminder set!** \n" +
                        "**Don't forget to do** `.wish` **in** <#969147973210607626> \n" +
                        "**we will remind you soon!**");
                e.getMessage().replyEmbeds(wishBuilder.build())
                        .mentionRepliedUser(false)
                        .queue();

                Timer wishTimer = new Timer();
                wishTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        EmbedBuilder wishReminder = new EmbedBuilder();

                        wishReminder.setTitle("Time for .wish!");
                        wishReminder.setColor(Color.WHITE);
                        wishReminder.setDescription("**goto** <#969147973210607626> **and do** `.wish` \n" +
                                "**Don't forget to set timer back!**");
                        e.getMessage().replyEmbeds(wishReminder.build())
                                .mentionRepliedUser(true)
                                .queue();
                        Main.builder.openPrivateChannelById(e.getAuthor().getId()).flatMap(privateChannel -> privateChannel.sendMessageEmbeds(wishReminder.build())).queue();
                    }
                }, 3600000);
                break;

            case ".work":
            case ".Work":
                EmbedBuilder workBuilder = new EmbedBuilder()
                        .setColor(Color.BLACK);
                workBuilder.setTitle("Reminder set!");
                workBuilder.setDescription("**work reminder set!** \n" +
                        "**Don't forget to do** `.work` **in** <#969147973210607626> \n" +
                        "**we will remind you soon!**");
                e.getMessage().replyEmbeds(workBuilder.build())
                        .mentionRepliedUser(false)
                        .queue();

                Timer workTimer = new Timer();
                workTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        EmbedBuilder workReminder = new EmbedBuilder();
                        workReminder.setTitle("Time for .work!");
                        workReminder.setColor(Color.WHITE);
                        workReminder.setDescription("**goto** <#969147973210607626> **and do** `.work` \n" +
                                "**Don't forget to set timer back!**");
                        e.getMessage().replyEmbeds(workReminder.build())
                                .mentionRepliedUser(true)
                                .queue();
                        Main.builder.openPrivateChannelById(e.getAuthor().getId()).flatMap(privateChannel -> privateChannel.sendMessageEmbeds(workReminder.build())).queue();
                    }
                }, 3600000);
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
                        Main.builder.openPrivateChannelById(e.getAuthor().getId()).flatMap(privateChannel -> privateChannel.sendMessageEmbeds(drinkReminder.build())).queue();
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
                        "`.wish` **set reminder for using** `.wish` :timer: \n" +
                        "`.work` **set reminder for using** `.work` :timer: \n" +
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
