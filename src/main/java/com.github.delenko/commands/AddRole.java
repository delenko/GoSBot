package com.github.delenko.commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.ArrayList;
import java.util.List;

import static net.dv8tion.jda.api.Permission.MANAGE_ROLES;


public class AddRole extends Command {

    public AddRole() {
        this.name = "addrole";
        this.aliases = new String[]{"addRole", "AddRole", "Addrole"};
        this.help = "This will give the user a specific role\n";
        this.arguments = "[userID][roleID]\n";
        this.category = new Command.Category("admin");
        this.userPermissions = new Permission[]{MANAGE_ROLES};
    }

    @Override
    public void execute(CommandEvent e) {
        String[] roles = e.getArgs().split(" ");
        List<Role> guildRoles = e.getGuild().getRoles();
        List<Long> roleID = new ArrayList<Long>();
        for (Role role : guildRoles) {
            String roleIDs = role.toString().replaceAll("\\D", "");
            Long rIDs = Long.parseLong(roleIDs);
            roleID.add(rIDs);

            if (roles.length<2) {
                e.reply("Your must enter 3 commands! prefix >>command userID roleID");
                return;
            }else if(roleIDs==roles[1]){
                e.reply("User has this role already!");
                return;
            }
        }
        if (roles.length != 2) {
            e.reply("Your must enter 3 commands! prefix >>command userID roleID");
            return;
        } else if (e.getAuthor().isBot()) return;
        else {
            Role guildRole = e.getGuild().getRoleById(roles[1]);
            Member user = e.getGuild().getMemberCache().getElementById(roles[0]);
            e.getGuild().addRoleToMember(user, guildRole).queue();
        }
    }
}

