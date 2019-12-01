/*******************************************************************************
 * Copyhacked (H) 2012-2016.
 * This program and the accompanying materials
 * are made available under no term at all, use it like
 * you want, but share and discuss about it
 * every time possible with every body.
 * 
 * Contributors:
 *      ron190 at ymail dot com - initial implementation
 ******************************************************************************/
package com.jsql.view.terminal.interaction;

import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.jsql.model.MediatorModel;
import com.jsql.model.bean.util.Header;
import com.jsql.model.injection.strategy.StrategyInjection;
import com.jsql.model.injection.vendor.model.VendorXml;
import com.jsql.view.interaction.InteractionCommand;
import com.jsql.view.swing.MediatorGui;

/**
 * Mark the injection as vulnerable to a error-based injection.
 */
public class MarkErrorVulnerable implements InteractionCommand {
    
    private Map<Header, Object> mapHeader;
    private int indexMethodError;
	
    /**
     * @param interactionParams
     */
    @SuppressWarnings("unchecked")
    public MarkErrorVulnerable(Object[] interactionParams) {
        this.mapHeader = (Map<Header, Object>) interactionParams[0];
        this.indexMethodError = (int) this.mapHeader.get(Header.SOURCE);
    }

    @Override
    public void execute() {
        LOGGER.info(InteractionCommand.addGreenColor(MediatorModel.model().getVendor().instance().getXmlModel().getStrategy().getError().getMethod().get(this.indexMethodError).getName()));
    }
    
}
