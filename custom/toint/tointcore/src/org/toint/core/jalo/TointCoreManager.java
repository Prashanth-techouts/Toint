/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.toint.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.toint.core.constants.TointCoreConstants;
import org.toint.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class TointCoreManager extends GeneratedTointCoreManager
{
	public static final TointCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (TointCoreManager) em.getExtension(TointCoreConstants.EXTENSIONNAME);
	}
}
