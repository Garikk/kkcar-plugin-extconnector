package kkdev.kksystem.plugin.extconnector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.KKPluginBase;
import kkdev.kksystem.plugin.extconnector.exconnmanager.EXConnManager;
import kkdev.kksystem.base.interfaces.IPluginBaseConnection;

/**
 *
 * @author blinov_is
 */
public final class KKPlugin extends KKPluginBase {
    public KKPlugin() {
        super(new ECPluginInfo());
        Global.EM=new EXConnManager();
    }

    @Override
    public void pluginInit(IPluginBaseConnection BaseConnector, String GlobalConfUID) {
        super.pluginInit(BaseConnector, GlobalConfUID); 
        Global.EM.Init(this);
    }

   
    @Override
    public void executePin(PluginMessage Pin) {
        super.executePin(Pin);
        Global.EM.ReceivePin(Pin);

    }
}
