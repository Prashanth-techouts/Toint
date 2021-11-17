/**
 *
 */
package org.toint.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author D1
 *
 */
@Controller
public class CustomHomePageController extends AbstractPageController
{
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel homePage = getContentPageForLabelOrId("tointhomepage");
		storeCmsPageInModel(model, homePage);
		setUpMetaDataForContentPage(model, homePage);
		return getViewForPage(model);
	}
}
