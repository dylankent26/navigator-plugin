package com.navigator;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("navigator")
public interface NavigatorConfig extends Config
{
    @ConfigItem(
            keyName = "showBanks",
            name = "Show Banks",
            description = "Display bank locations"
    )
    default boolean showBanks()
    {
        return true;
    }

    @ConfigItem(
            keyName = "showAnvils",
            name = "Show Anvils",
            description = "Display anvil locations"
    )
    default boolean showAnvils()
    {
        return true;
    }

    @ConfigItem(
            keyName = "showFurnaces",
            name = "Show Furnaces",
            description = "Display furnace locations"
    )
    default boolean showFurnaces()
    {
        return true;
    }
}
