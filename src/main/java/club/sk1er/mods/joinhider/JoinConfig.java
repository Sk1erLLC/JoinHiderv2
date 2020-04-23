package club.sk1er.mods.joinhider;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import club.sk1er.vigilance.data.PropertyType;

import java.io.File;

public class JoinConfig extends Vigilant {

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Friend Join Messages",
        description = "Hide Message In Chat Of Your Hypixel Friends Joining.",
        category = "General",
        subcategory = "General"
    )
    public static boolean hideFriendJoin = true;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Friend Leave Messages",
        description = "Hide Message In Chat Of Your Hypixel Friends Leaving.",
        category = "General",
        subcategory = "General"
    )
    public static boolean hideFriendLeave = true;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Guild Join Messages",
        description = "Hide Message In Chat Of Your Hypixel Guild's Members Joining.",
        category = "General",
        subcategory = "General"
    )
    public static boolean hideGuildJoin = true;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Guild Leave Messages",
        description = "Hide Message In Chat Of Your Hypixel Guild's Members Leaving.",
        category = "General",
        subcategory = "General"
    )
    public static boolean hideGuildLeave = true;

    public JoinConfig() {
        super(new File("./config/joinhider.toml"));
        initialize();
    }
}
