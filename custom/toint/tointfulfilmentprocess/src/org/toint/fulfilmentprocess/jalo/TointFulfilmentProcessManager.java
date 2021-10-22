/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.toint.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.toint.fulfilmentprocess.constants.TointFulfilmentProcessConstants;

public class TointFulfilmentProcessManager extends GeneratedTointFulfilmentProcessManager
{
	public static final TointFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (TointFulfilmentProcessManager) em.getExtension(TointFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
