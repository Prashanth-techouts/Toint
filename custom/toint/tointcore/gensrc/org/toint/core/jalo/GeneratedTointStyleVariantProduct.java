/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 08-Nov-2021, 10:38:55 AM                    ---
 * ----------------------------------------------------------------
 */
package org.toint.core.jalo;

import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.variants.jalo.VariantProduct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.toint.core.constants.TointCoreConstants;

/**
 * Generated class for type {@link org.toint.core.jalo.TointStyleVariantProduct TointStyleVariantProduct}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedTointStyleVariantProduct extends VariantProduct
{
	/** Qualifier of the <code>TointStyleVariantProduct.style</code> attribute **/
	public static final String STYLE = "style";
	/** Qualifier of the <code>TointStyleVariantProduct.swatchColors</code> attribute **/
	public static final String SWATCHCOLORS = "swatchColors";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(VariantProduct.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(STYLE, AttributeMode.INITIAL);
		tmp.put(SWATCHCOLORS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TointStyleVariantProduct.style</code> attribute.
	 * @return the style - Color/Pattern of the product.
	 */
	public String getStyle(final SessionContext ctx)
	{
		return (String)getProperty( ctx, STYLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TointStyleVariantProduct.style</code> attribute.
	 * @return the style - Color/Pattern of the product.
	 */
	public String getStyle()
	{
		return getStyle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TointStyleVariantProduct.style</code> attribute. 
	 * @param value the style - Color/Pattern of the product.
	 */
	public void setStyle(final SessionContext ctx, final String value)
	{
		setProperty(ctx, STYLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TointStyleVariantProduct.style</code> attribute. 
	 * @param value the style - Color/Pattern of the product.
	 */
	public void setStyle(final String value)
	{
		setStyle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TointStyleVariantProduct.swatchColors</code> attribute.
	 * @return the swatchColors - A normalized color mapping to a standardized front-end navigable name.
	 */
	public Set<EnumerationValue> getSwatchColors(final SessionContext ctx)
	{
		Set<EnumerationValue> coll = (Set<EnumerationValue>)getProperty( ctx, SWATCHCOLORS);
		return coll != null ? coll : Collections.EMPTY_SET;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TointStyleVariantProduct.swatchColors</code> attribute.
	 * @return the swatchColors - A normalized color mapping to a standardized front-end navigable name.
	 */
	public Set<EnumerationValue> getSwatchColors()
	{
		return getSwatchColors( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TointStyleVariantProduct.swatchColors</code> attribute. 
	 * @param value the swatchColors - A normalized color mapping to a standardized front-end navigable name.
	 */
	public void setSwatchColors(final SessionContext ctx, final Set<EnumerationValue> value)
	{
		setProperty(ctx, SWATCHCOLORS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TointStyleVariantProduct.swatchColors</code> attribute. 
	 * @param value the swatchColors - A normalized color mapping to a standardized front-end navigable name.
	 */
	public void setSwatchColors(final Set<EnumerationValue> value)
	{
		setSwatchColors( getSession().getSessionContext(), value );
	}
	
}
