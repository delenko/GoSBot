package com.github.delenko.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.utils.cache.SnowflakeCacheView;
import static net.dv8tion.jda.api.Permission.MANAGE_ROLES;

public class Roles extends Command {
    public Roles(){
        this.name ="roles";
        this.aliases = new String[]{"role","Roles","Role"};
        this.help = "Displays all given roles in the guild\n";
        this.category = new Command.Category("admin");
        this.userPermissions = new Permission[]{MANAGE_ROLES};
        this.help = "Displays all given roles in the guild\n";

    }
    @Override
    public void execute(CommandEvent e){

        if(e.getAuthor().isBot())return;
        else if(e.getSelfMember().hasPermission()){
            SnowflakeCacheView<Role> roles = e.getGuild().getRoleCache();
            EmbedBuilder embed = new EmbedBuilder();
            embed.setAuthor(e.getAuthor().getName());
            embed.setColor(e.getMember().getColor());
            embed.setThumbnail(e.getAuthor().getAvatarUrl());
            String roleMembers = "";
            String roleNames = "";
            for (Role role : roles) {
                roleMembers = role.toString().replaceAll("\\D","");
                roleNames = role.toString().replaceAll("\\p{Punct}","");
                String roleName = roleNames.replaceAll("R","");
                String name = roleName.replaceAll("\\d","");
                embed.addField(name,roleMembers,true);

            }
            e.reply(embed.build());
        }else{
            e.reply("You do not have the permission to do that!");
        }
    }
}