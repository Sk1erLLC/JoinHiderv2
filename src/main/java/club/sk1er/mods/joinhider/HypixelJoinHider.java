package club.sk1er.mods.joinhider;

import club.sk1er.mods.joinhider.modcore.ModCoreInstaller;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Pattern;

@Mod(modid = HypixelJoinHider.MODID, version = HypixelJoinHider.VERSION)
public class HypixelJoinHider {
    public static final String MODID = "hypixel_join_hider_2";
    public static final String VERSION = "2.1";
    public static JoinConfig joinConfig;
    private final Pattern guildJoin = Pattern.compile("Guild > \\w{1,16} joined.");
    private final Pattern guildLeave = Pattern.compile("Guild > \\w{1,16} left.");
    private final Pattern friendJoin = Pattern.compile("Friend > \\w{1,16} joined.");
    private final Pattern friendLeave = Pattern.compile("Friend > \\w{1,16} left.");

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);

        joinConfig = new JoinConfig();
        joinConfig.preload();

        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new CommandJoinConfig());
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String chat = event.message.getUnformattedText();
        if (!event.isCanceled()) {
            event.setCanceled(
                JoinConfig.hideFriendJoin && friendJoin.matcher(chat).matches() ||
                    JoinConfig.hideFriendLeave && friendLeave.matcher(chat).matches() ||
                    JoinConfig.hideGuildJoin && guildJoin.matcher(chat).matches() ||
                    JoinConfig.hideGuildLeave && guildLeave.matcher(chat).matches()
            );
        }

    }
}
