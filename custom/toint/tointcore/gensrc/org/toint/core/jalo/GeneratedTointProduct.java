/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 12-Nov-2021, 5:24:36 PM                     ---
 * ----------------------------------------------------------------
 */
package org.toint.core.jalo;

import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.product.Product;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.toint.core.constants.TointCoreConstants;

/**
 * Generated class for type {@link org.toint.core.jalo.TointProduct TointProduct}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedTointProduct extends Product
{
	/** Qualifier of the <code>TointProduct.genders</code> attribute **/
	public static final String GENDERS = "genders";
	/** Qualifier of the <code>TointProduct.countryOrigin</code> attribute **/
	public static final String COUNTRYORIGIN = "countryOrigin";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Product.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(GENDERS, AttributeMode.INITIAL);
		tmp.put(COUNTRYORIGIN, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TointProduct.countryOrigin</code> attribute.
	 * @return the countryOrigin - product country origin
	 */
	public String getCountryOrigin(final SessionContext ctx)
	{
		return (String)getProperty( ctx, COUNTRYORIGIN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TointProduct.countryOrigin</code> attribute.
	 * @return the countryOrigin - product country origin
	 */
	public String getCountryOrigin()
	{
		return getCountryOrigin( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TointProduct.countryOrigin</code> attribute. 
	 * @param value the countryOrigin - product country origin
	 */
	public void setCountryOrigin(final SessionContext ctx, final String value)
	{
		setProperty(ctx, COUNTRYORIGIN,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TointProduct.countryOrigin</code> attribute. 
	 * @param value the countryOrigin - product country origin
	 */
	public void setCountryOrigin(final String value)
	{
		setCountryOrigin( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TointProduct.genders</code> attribute.
	 * @return the genders - List of genders that the ApparelProduct is designed for
	 */
	public List<EnumerationValue> getGenders(final SessionContext ctx)
	{
		List<EnumerationValue> coll = (List<EnumerationValue>)getProperty( ctx, GENDERS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TointProduct.genders</code> attribute.
	 * @return the genders - List of genders that the ApparelProduct is designed for
	 */
	public List<EnumerationValue> getGenders()
	{
		return getGenders( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TointProduct.genders</code> attribute. 
	 * @param value the genders - List of genders that the ApparelProduct is designed for
	 */
	public void setGenders(final SessionContext ctx, final List<EnumerationValue> value)
	{
		setProperty(ctx, GENDERS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TointProduct.genders</code> attribute. 
	 * @param value the genders - List of genders that the ApparelProduct is designed for
	 */
	public void setGenders(final List<EnumerationValue> value)
	{
		setGenders( getSession().getSessionContext(), value );
	}
	
}
