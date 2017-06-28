/**
 */
package fr.inria.diverse.minilang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print Var</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.minilang.PrintVar#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.minilang.MinilangPackage#getPrintVar()
 * @model
 * @generated
 */
public interface PrintVar extends Statement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see fr.inria.diverse.minilang.MinilangPackage#getPrintVar_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.minilang.PrintVar#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // PrintVar
