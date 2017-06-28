package finitestatemachines.composite.uml

import FSM.interfaces.Context
import finitestatemachinescomposite.Action
import finitestatemachinescomposite.CompositeState
import finitestatemachinescomposite.FinitestatemachinescompositeFactory
import finitestatemachinescomposite.Fork
import finitestatemachinescomposite.InitialState
import finitestatemachinescomposite.Join
import finitestatemachinescomposite.State
import finitestatemachinescomposite.StateMachine
import finitestatemachinescomposite.Transition
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList

import static extension finitestatemachines.composite.uml.CompositeStateAspect.*
import static extension finitestatemachines.composite.uml.StateAspect.*
import static extension finitestatemachines.composite.uml.StateMachineAspect.*
import static extension finitestatemachines.composite.uml.TransitionAspect.*

//
// *.*
// ASPECT
/**
 * StateMachineAspect: Aspects for the State Machine meta-class
 * Serves as the interpreter of the state machine (the controller of the )
 */
@Aspect(className=StateMachine)
class StateMachineAspect {
	
	EList<State> currentState = null
	EList<Transition> currentTransitions = null
	
	/**
	 * Evaluates the input and sequentially executes the steps in the state machine. 
	 */
	 
	def public void eval (Context context, String filePath) {
		println("\nExecuting the state machine. Please wait for the results...\n")
		println(" ... executing input ...\n")
		
		var ArrayList<EList<String>> events = context.events
		
		_self.currentState = _self.getInitialState()
		_self.currentState.get(0).eval(context)
		
		for(EList<String> eventsGroup : events){
			println("  input item: " + eventsGroup + " time: " + (System.currentTimeMillis as int))
			_self.step(context, eventsGroup)
		}
		
		println("\n *.* Your results are ready! \n")
		(new Printer()).printFinalStateInConsole(_self)
		(new Printer()).printFinalStateInFile(_self, filePath)
	}
	
	/**
	 * Performs a step in the state machine i.e., reads an entry of the input stack and executes it.
	 * If there are several events in the same step they are executed sequentially.  
	 */
	def private void step(Context context, EList<String> eventsGroup){
		// In this case, the current transitions are local to the step. 
		_self.currentTransitions = new BasicEList<Transition>()
		
		for(String event : eventsGroup){
			for(State state : _self.getDeepestCurrent(event)){
				state.getActiveTransitions(event).forEach[fire(context)]
			}
		}
	}
	
	def public EList<State> getAllCurrentStates(){
		return _self.currentState
	}
	

	/*
	 * Get all states concerned by this event and remove those contained 
	 */
	def private EList<State> getHigherCurrent(String event){
		val res = new BasicEList<State>()
		
		val List<State> candidates = new ArrayList<State>()
		for(State state : _self.currentState){
			if(!state.getActiveTransitions(event).isEmpty){
				candidates.add(state)
			}
		}
		
		candidates.forEach[state |
			val parents = state.allParents
			//Check if state is a top element
			if(!candidates.exists[c | parents.contains(c)]){
				res.add(state)
			}
		]
		
		return res
	}
	
	/*
	 * Get all the deepest states concerned by this event
	 */
	def private EList<State> getDeepestCurrent(String event){
		val res = new BasicEList<State>()
		
		val List<State> candidates = new ArrayList<State>()
		for(State state : _self.currentState){
			if(!state.getActiveTransitions(event).isEmpty){
				candidates.add(state)
			}
		}
		
		candidates.forEach[state |
			val children = state.allChildren
			//Check if state has no candidate children 
			if(!candidates.exists[c | children.contains(c)]){
				res.add(state)
			}
		]
		
		return res
	}
	
	/**
	 * Returns the (unique?) initial state of the state machine. 
	 */
	def private EList<State> getInitialState(){
		var answer = new BasicEList<State>()
		for(State state : _self.states){
			if(state instanceof InitialState) answer.add(state)
		}
		return answer
	}
	
	/*
	 * Intended format for @expression:
	 * <String>=<true|false>
	 */
	def public boolean isValid(String expression){
		if(expression.contains("=")){
			val segments = expression.split("=")
			val varName = segments.get(0)
			val varValue = segments.get(1)
			
			var variable = _self.variables.findFirst[name == varName]
			if(variable != null){
				return variable.value == varValue
			}
		}
		else if(expression.startsWith("!")){
			val varName = expression.substring(1)
			var variable = _self.variables.findFirst[name == varName]
			if(variable != null){
				return !(variable.value)
			}
		}
		else{
			val varName = expression.substring(0)
			var variable = _self.variables.findFirst[name == varName]
			if(variable != null){
				return variable.value
			}
		}
		return false
	}
	
	/**
	 * Creates or update a variable
	 */
	def public void update(Action action){
		if(action != null){
			var variable = _self.variables.findFirst[name == action.variable]
			if(variable == null){
				variable = FinitestatemachinescompositeFactory.eINSTANCE.createVariable
				variable.name = action.variable
				_self.variables.add(variable)
			}
			variable.value = action.value
		}
	}
	
	def public void addCurrentState(State s){
		_self.currentState.add(s)
	}
	
	def public void removeCurrentState(State s){
		_self.currentState.remove(s)
	}
	
	def public boolean isCurrentState(State s){
		return _self.currentState.contains(s)
	}
	
}


@Aspect(className=State)
class StateAspect {
	
	def public void run(Context context) {
		_self.initialTime = (System.currentTimeMillis) as int
		Context.stateWorking(1000)
		_self.finalTime = (System.currentTimeMillis) as int
	}
	
	/**
	 * Get transitions that can be fired by this event
	 * If even is null all transitions without event are candidate 
	 */
	def public EList<Transition> getActiveTransitions(String event){
		val res = new BasicEList<Transition>();
		for(Transition transition : _self.outgoing){
			if( (event == null && transition.trigger == null) ||
				transition.trigger.expression.equals(event)
			){
				if(transition.guard == null ||
					_self.stateMachine.isValid(transition.guard.expression)
				){
					res.add(transition)
				}
			}
		}
		return res;
	}
	
	def public EList<State> getAllParents(){
		val res = new BasicEList<State>()
		
		if(_self.parentState != null){
			res.addAll(_self.parentState.allParents)
			res.add(_self.parentState)
		}
		
		return res
	}
	
	def public EList<State> getAllChildren(){
		val res = new BasicEList<State>()
	
		if(_self instanceof CompositeState){
			val composite = _self as CompositeState
			val subStates = composite.regions.map[states].flatten
			val allSubStates = subStates.map[s|s.getAllChildren].flatten
			res.addAll(subStates)
			res.addAll(allSubStates)
		}
	
		return res
	} 
	
	def public void eval (Context context){
		println(_self.name)
		val fsm = _self.stateMachine
		
		if(_self instanceof Fork){
				var ArrayList<ForkThread> threads = new ArrayList<ForkThread>()
				for(Transition _forkTransition : _self.outgoing){
					var ForkThread _forkThread = new ForkThread(_forkTransition.target, context);
					threads.add(_forkThread)
					_forkThread.start
				}
				
				var boolean threadsAlive = true
				while(threadsAlive){
					var int stillAlive = 0
					for(Thread _thread : threads){
						if(_thread.alive){stillAlive++}
					}
					if(stillAlive == 0)threadsAlive=false
				}
		}
		else if(_self instanceof Join){
			val join = _self as Join
			val sources = join.incoming.map[source]
			if(fsm.allCurrentStates.containsAll(sources)){
				
				sources.forEach[s |
					//TODO: copied from Transition.fire() 
					//Remove all sub states if we exit a composite
					if(s instanceof CompositeState){
						val composite = s as CompositeState
						composite.getAllStates.forEach[subS | fsm.removeCurrentState(subS)]
					}
					else{
						fsm.removeCurrentState(s)
					}
				]
				
				join.outgoing.forEach[out |
					out.fire(context)
				]
			}
		}
		else if (_self instanceof CompositeState){
			
			val nextTransitions = _self.getActiveTransitions(null)
			if(nextTransitions.isEmpty){
				fsm.addCurrentState(_self)
				
				val composite = _self as CompositeState
				//Get all init states from all regions
				val initStates = composite.regions.map[r | r.states].flatten.filter[s|s instanceof InitialState]
				
				val ArrayList<ForkThread> threads = new ArrayList<ForkThread>()
				initStates.forEach[init |
					var ForkThread _forkThread = new ForkThread(init, context);
					threads.add(_forkThread)
					_forkThread.start
				]
				
				var boolean threadsAlive = true
				while(threadsAlive){
					var int stillAlive = 0
					for(Thread _thread : threads){
						if(_thread.alive){stillAlive++}
					}
					if(stillAlive == 0)threadsAlive=false
				}
			}
			else{
				nextTransitions.forEach[ fire(context) ]
			}
		}
		else{
			// Simple state: If the transition goes to a simple state, evaluate the state and add it to the current states.
			_self.run(context)
			
			val nextTransitions = _self.getActiveTransitions(null)
			if(nextTransitions.isEmpty){
				fsm.addCurrentState(_self)
				//Add all containing states to current states
				var parent = _self.parentState
				while(parent != null && !fsm.isCurrentState(parent)){
					fsm.addCurrentState(parent)
					parent = parent.parentState
				}
			}
			else{
				nextTransitions.forEach[ fire(context) ]
			}
		}
	}
}

@Aspect(className=CompositeState)
class CompositeStateAspect extends StateAspect {
	
	/**
	 * Get all sub states
	 */
	def public EList<State> getAllStates(){
		var attendedStates = new BasicEList<State>()
		var subStates = _self.regions.map[r | r.states].flatten
		while(!subStates.isEmpty){
			attendedStates.addAll(subStates)
			
			//Get sub states of subStates 
			var subComposite = subStates.filter[s|s instanceof CompositeState].map[s | s as CompositeState]
			subStates = subComposite.map[c|c.regions.map[r | r.states].flatten].flatten
		}
		return attendedStates
	}
}

@Aspect(className=Transition)
class TransitionAspect {
	
	def public void fire(Context context){
		
		val fsm = _self.stateMachine
		val source = _self.source
		//Remove all sub states if we exit a composite
		if(source instanceof CompositeState){
			val composite = source as CompositeState
			composite.getAllStates.forEach[s | fsm.removeCurrentState(s)]
		}
		else{
			fsm.removeCurrentState(_self.source)
		}
		
		val target = _self.target
		target.eval(context)
		
		val Action action = _self.action
		_self.stateMachine.update(action)
		
	}
}
