package com.navigator;

import javax.inject.Inject;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import net.runelite.client.ui.PluginPanel;

public class NavigatorPanel extends PluginPanel
{
    private final JCheckBox bankBox = new JCheckBox("Banks");
    private final JCheckBox anvilBox = new JCheckBox("Anvils");
    private final JCheckBox furnaceBox = new JCheckBox("Furnaces");

    @Inject
    public NavigatorPanel(NavigatorPlugin plugin)
    {
        add(bankBox);
        add(anvilBox);
        add(furnaceBox);

        bankBox.setSelected(plugin.getConfig().showBanks());
        anvilBox.setSelected(plugin.getConfig().showAnvils());
        furnaceBox.setSelected(plugin.getConfig().showFurnaces());

        bankBox.addActionListener(e -> plugin.updateShowBanks(bankBox.isSelected()));
        anvilBox.addActionListener(e -> plugin.updateShowAnvils(anvilBox.isSelected()));
        furnaceBox.addActionListener(e -> plugin.updateShowFurnaces(furnaceBox.isSelected()));
    }
}
