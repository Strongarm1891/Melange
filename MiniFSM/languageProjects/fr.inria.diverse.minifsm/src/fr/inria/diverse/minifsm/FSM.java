/**
 */
package fr.inria.diverse.minifsm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.minifsm.FSM#getStates <em>States</em>}</li>
 *   <li>{@link fr.inria.diverse.minifsm.FSM#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link fr.inria.diverse.minifsm.FSM#getInitialState <em>Initial State</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.minifsm.MinifsmPackage#getFSM()
 * @model
 * @generated
 */
public interface FSM extends EObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.diverse.minifsm.State}.
	 * It is bidirectional and its opposite is '{@link fr.inria.diverse.minifsm.State#getFsm <em>Fsm</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see fr.inria.diverse.minifsm.MinifsmPackage#getFSM_States()
	 * @see fr.inria.diverse.minifsm.State#getFsm
	 * @model opposite="fsm" containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.diverse.minifsm.Transition}.
	 * It is bidirectional and its opposite is '{@link fr.inria.diverse.minifsm.Transition#getFsm <em>Fsm</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see fr.inria.diverse.minifsm.MinifsmPackage#getFSM_Transitions()
	 * @see fr.inria.diverse.minifsm.Transition#getFsm
	 * @model opposite="fsm" containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see fr.inria.diverse.minifsm.MinifsmPackage#getFSM_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.minifsm.FSM#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

} // FSM
