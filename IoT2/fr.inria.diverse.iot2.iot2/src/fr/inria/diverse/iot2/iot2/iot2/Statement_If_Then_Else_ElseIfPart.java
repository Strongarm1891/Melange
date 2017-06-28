/**
 */
package fr.inria.diverse.iot2.iot2.iot2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement If Then Else Else If Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.iot2.iot2.iot2.Statement_If_Then_Else_ElseIfPart#getElseifExpression <em>Elseif Expression</em>}</li>
 *   <li>{@link fr.inria.diverse.iot2.iot2.iot2.Statement_If_Then_Else_ElseIfPart#getElseifBlock <em>Elseif Block</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.iot2.iot2.iot2.Iot2Package#getStatement_If_Then_Else_ElseIfPart()
 * @model
 * @generated
 */
public interface Statement_If_Then_Else_ElseIfPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Elseif Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elseif Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elseif Expression</em>' containment reference.
	 * @see #setElseifExpression(Expression)
	 * @see fr.inria.diverse.iot2.iot2.iot2.Iot2Package#getStatement_If_Then_Else_ElseIfPart_ElseifExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getElseifExpression();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.iot2.iot2.iot2.Statement_If_Then_Else_ElseIfPart#getElseifExpression <em>Elseif Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elseif Expression</em>' containment reference.
	 * @see #getElseifExpression()
	 * @generated
	 */
	void setElseifExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Elseif Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elseif Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elseif Block</em>' containment reference.
	 * @see #setElseifBlock(Block)
	 * @see fr.inria.diverse.iot2.iot2.iot2.Iot2Package#getStatement_If_Then_Else_ElseIfPart_ElseifBlock()
	 * @model containment="true"
	 * @generated
	 */
	Block getElseifBlock();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.iot2.iot2.iot2.Statement_If_Then_Else_ElseIfPart#getElseifBlock <em>Elseif Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elseif Block</em>' containment reference.
	 * @see #getElseifBlock()
	 * @generated
	 */
	void setElseifBlock(Block value);

} // Statement_If_Then_Else_ElseIfPart
