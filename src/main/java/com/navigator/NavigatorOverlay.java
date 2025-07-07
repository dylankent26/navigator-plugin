package com.navigator;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.shortestpath.ShortestPathService;

public class NavigatorOverlay extends Overlay
{
    private final Client client;
    private final NavigatorPlugin plugin;
    private final ShortestPathService shortestPathService;

    @Inject
    public NavigatorOverlay(Client client, NavigatorPlugin plugin, ShortestPathService shortestPathService)
    {
        this.client = client;
        this.plugin = plugin;
        this.shortestPathService = shortestPathService;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        WorldPoint target = plugin.getSelectedPoint();
        if (target != null)
        {
            shortestPathService.drawPath(client.getLocalPlayer().getWorldLocation(), target, graphics);
        }
        return null;
    }
}
