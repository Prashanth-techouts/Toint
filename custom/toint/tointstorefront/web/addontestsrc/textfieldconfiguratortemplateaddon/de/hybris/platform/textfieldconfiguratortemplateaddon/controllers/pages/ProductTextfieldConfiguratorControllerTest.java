/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.textfieldconfiguratortemplateaddon.controllers.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.impl.ProductBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.forms.ConfigureForm;
import de.hybris.platform.catalog.enums.ConfiguratorType;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.servicelayer.services.CMSPageService;
import de.hybris.platform.cms2.servicelayer.services.CMSPreviewService;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.QuoteFacade;
import de.hybris.platform.commercefacades.order.SaveCartFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.CartModificationData;
import de.hybris.platform.commercefacades.order.data.CommerceSaveCartResultData;
import de.hybris.platform.commercefacades.order.data.ConfigurationInfoData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.quote.data.QuoteData;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.commerceservices.order.CommerceSaveCartException;
import de.hybris.platform.textfieldconfiguratortemplateaddon.forms.TextFieldConfigurationForm;
import de.hybris.platform.textfieldconfiguratortemplatefacades.TextFieldFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@UnitTest
public class ProductTextfieldConfiguratorControllerTest
{
	private static final String PRODUCT_CODE = "CODE1";
	private static final String REDIRECT_ADD_TO_CART_ERROR = "redirect:/p/" + PRODUCT_CODE + "/configuratorPage/TEXTFIELD";
	private static final String REDIRECT_ADD_TO_CART_SUCCESS = "redirect:/cart";
	private static final Long QUANTITY = Long.valueOf(23);
	private static final String DOCUMENT_CODE = "123";
	private static final int ENTRY_NUMBER = 4;
	private static final String ATTRIBUTE_KEY = "key";
	private static final String ATTRIBUTE_VALUE = "value";

	@Mock
	private TextFieldFacade textFieldFacade;
	@Mock
	private CartFacade cartFacade;
	@Mock
	private ProductFacade productFacade;

	@InjectMocks
	ProductTextfieldConfiguratorController classUnderTest;

	@Mock
	private Model model;
	@Mock
	private @Valid TextFieldConfigurationForm form;
	@Mock
	private ConfigureForm configureForm;
	@Mock
	private BindingResult bindingErrors;
	@Mock
	private HttpServletRequest request;
	@Mock
	private RedirectAttributes redirectModel;
	@Mock
	private ProductBreadcrumbBuilder productBreadcrumbBuilder;
	@Mock
	private CMSPageService cmsPageService;
	@Mock
	private CMSPreviewService cmsPreviewService;
	@Mock
	private OrderFacade orderFacade;
	@Mock
	private QuoteFacade quoteFacade;
	@Mock
	private SaveCartFacade saveCartFacade;

	private final CartModificationData cartModification = new CartModificationData();
	private final OrderEntryData entry = new OrderEntryData();
	private final OrderData order = new OrderData();
	private final ProductData productData = new ProductData();
	private final QuoteData quote = new QuoteData();
	private final CartData cart = new CartData();

	private final CommerceSaveCartResultData cartResultData = new CommerceSaveCartResultData();
	private final Map<ConfiguratorType, Map<String, String>> valueMap = new HashMap<ConfiguratorType, Map<String, String>>();
	private final Map<String, String> textFieldMap = new HashMap<String, String>();





	@Before
	public void initialize() throws CommerceCartModificationException, CommerceSaveCartException
	{
		MockitoAnnotations.initMocks(this);
		when(form.getQuantity()).thenReturn(QUANTITY);
		when(form.getConfigurationsKeyValueMap()).thenReturn(valueMap);
		when(cartFacade.addToCart(PRODUCT_CODE, QUANTITY)).thenReturn(cartModification);
		when(cartFacade.getSessionCart()).thenReturn(cart);
		when(orderFacade.getOrderDetailsForCode(DOCUMENT_CODE)).thenReturn(order);
		when(quoteFacade.getQuoteForCode(DOCUMENT_CODE)).thenReturn(quote);
		when(saveCartFacade.getCartForCodeAndCurrentUser(Mockito.any())).thenReturn(cartResultData);
		when(textFieldFacade.getAbstractOrderEntry(ENTRY_NUMBER, order)).thenReturn(entry);
		when(textFieldFacade.getAbstractOrderEntry(ENTRY_NUMBER, quote)).thenReturn(entry);
		when(textFieldFacade.getAbstractOrderEntry(ENTRY_NUMBER, cart)).thenReturn(entry);
		cartModification.setQuantityAdded(QUANTITY);
		cartModification.setEntry(entry);
		entry.setProduct(productData);
		cartResultData.setSavedCartData(cart);
		valueMap.put(ConfiguratorType.TEXTFIELD, textFieldMap);
		textFieldMap.put(ATTRIBUTE_KEY, ATTRIBUTE_VALUE);
	}

	@Test
	public void testTextFieldFacade()
	{
		assertEquals(textFieldFacade, classUnderTest.getTextFieldFacade());
	}

	@Test
	public void testAddToCartSuccess()
	{
		final String addToCart = classUnderTest.addToCart(PRODUCT_CODE, model, form, bindingErrors, request, redirectModel);
		assertEquals(REDIRECT_ADD_TO_CART_SUCCESS, addToCart);

	}

	@Test
	public void testAddToCartHasBindingErrors()
	{
		when(bindingErrors.hasErrors()).thenReturn(true);
		final String addToCart = classUnderTest.addToCart(PRODUCT_CODE, model, form, bindingErrors, request, redirectModel);
		assertEquals(REDIRECT_ADD_TO_CART_ERROR, addToCart);
	}

	@Test
	public void testAddToCartAddToCartResultNull() throws CommerceCartModificationException
	{
		when(cartFacade.addToCart(PRODUCT_CODE, QUANTITY)).thenReturn(null);
		assertEquals(REDIRECT_ADD_TO_CART_ERROR,
				classUnderTest.addToCart(PRODUCT_CODE, model, form, bindingErrors, request, redirectModel));
	}

	@Test
	public void testAddToCartAddToCartNothingAdded() throws CommerceCartModificationException
	{
		cartModification.setQuantityAdded(0);
		assertEquals(REDIRECT_ADD_TO_CART_ERROR,
				classUnderTest.addToCart(PRODUCT_CODE, model, form, bindingErrors, request, redirectModel));
	}

	@Test
	public void testAddToCartAddToCartLessWasAdded() throws CommerceCartModificationException
	{
		cartModification.setQuantityAdded(QUANTITY - 1);
		assertEquals(REDIRECT_ADD_TO_CART_ERROR,
				classUnderTest.addToCart(PRODUCT_CODE, model, form, bindingErrors, request, redirectModel));
	}

	@Test
	public void testProductConfiguratorGet() throws CommerceCartModificationException, CMSItemNotFoundException
	{
		final String redirect = classUnderTest.productConfiguratorGet(PRODUCT_CODE, model, configureForm);
		assertEquals(ProductTextfieldConfiguratorController.PRODUCT_CONFIGURATOR_PAGE, redirect);
	}

	@Test
	public void testProductConfiguratorPost() throws CommerceCartModificationException, CMSItemNotFoundException
	{
		final String redirect = classUnderTest.productConfiguratorPost(PRODUCT_CODE, model, configureForm);
		assertEquals(ProductTextfieldConfiguratorController.PRODUCT_CONFIGURATOR_PAGE, redirect);
	}


	@Test
	public void testDisplayConfigurationInOrderEntry() throws CommerceCartModificationException, CMSItemNotFoundException
	{
		final String redirect = classUnderTest.displayConfigurationInOrderEntry(DOCUMENT_CODE, ENTRY_NUMBER, model);
		assertEquals(ProductTextfieldConfiguratorController.ENTRY_READ_ONLY_PAGE, redirect);
	}

	@Test
	public void testDisplayConfigurationInQuoteEntry() throws CommerceCartModificationException, CMSItemNotFoundException
	{
		final String redirect = classUnderTest.displayConfigurationInQuoteEntry(DOCUMENT_CODE, ENTRY_NUMBER, model);
		assertEquals(ProductTextfieldConfiguratorController.ENTRY_READ_ONLY_PAGE, redirect);
	}

	@Test
	public void testDisplayConfigurationInSavedCartEntry()
			throws CommerceCartModificationException, CMSItemNotFoundException, CommerceSaveCartException
	{
		final String redirect = classUnderTest.displayConfigurationInSavedCartEntry(DOCUMENT_CODE, ENTRY_NUMBER, model);
		assertEquals(ProductTextfieldConfiguratorController.ENTRY_READ_ONLY_PAGE, redirect);
	}

	@Test
	public void testEditConfigurationInEntry()
			throws CommerceCartModificationException, CMSItemNotFoundException, CommerceSaveCartException
	{
		final String redirect = classUnderTest.editConfigurationInEntry(ENTRY_NUMBER, model);
		assertEquals(ProductTextfieldConfiguratorController.ENTRY_CONFIGURATOR_PAGE, redirect);
	}

	@Test
	public void testEnrichOrderEntryWithConfigurationData()
	{
		final OrderEntryData entryAfterEnrichment = classUnderTest.enrichOrderEntryWithConfigurationData(form, entry);
		assertNotNull(entryAfterEnrichment);
		final List<ConfigurationInfoData> configurationInfos = entryAfterEnrichment.getConfigurationInfos();
		assertNotNull(configurationInfos);
		assertEquals(1, configurationInfos.size());
		final ConfigurationInfoData configurationInfoData = configurationInfos.get(0);
		assertEquals(ATTRIBUTE_KEY, configurationInfoData.getConfigurationLabel());
		assertEquals(ATTRIBUTE_VALUE, configurationInfoData.getConfigurationValue());
	}


}
