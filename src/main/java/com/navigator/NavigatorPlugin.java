package com.navigator;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.shortestpath.ShortestPathService;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
        name = "Navigator"
)
public class NavigatorPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private NavigatorOverlay overlay;

    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private ShortestPathService shortestPathService;

    @Getter
    @Inject
    private NavigatorConfig config;

    private NavigationButton navButton;

    private WorldPoint selectedPoint;

    @Provides
    NavigatorConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(NavigatorConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
        navButton = NavigationButton.builder()
                .tooltip("Navigator")
                .priority(0)
                .panel(new NavigatorPanel(this))
                .build();
        clientToolbar.addNavigation(navButton);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
        clientToolbar.removeNavigation(navButton);
        selectedPoint = null;
    }

    public void updateShowBanks(boolean value)
    {
        // handle updating state
    }

    public void updateShowAnvils(boolean value)
    {
    }

    public void updateShowFurnaces(boolean value)
    {
    }

    public WorldPoint getSelectedPoint()
    {
        return selectedPoint;
    }
}
