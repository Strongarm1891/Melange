package fr.inria.diverse.iot2.iot2.aspects;

import fr.inria.diverse.iot2.iot2.iot2.Activity;
import fr.inria.diverse.iot2.iot2.iot2.Iot2Factory;
import fr.inria.diverse.iot2.iot2.iot2.BooleanValue;
import fr.inria.diverse.iot2.iot2.iot2.Expression;
import fr.inria.diverse.iot2.iot2.iot2.IntegerValue;
import fr.inria.diverse.iot2.iot2.iot2.IntegerVariable;
import fr.inria.diverse.iot2.iot2.iot2.OpaqueAction;
import fr.inria.diverse.iot2.iot2.iot2.Value;
import fr.inria.diverse.iot2.iot2.iot2.Variable;
import com.google.common.base.Objects;
import fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectProperties;
import fr.inria.diverse.iot2.iot2.aspects.OperationDefAspect;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import fr.inria.diverse.iot2.iot2.iot2.OperationDef;
import fr.inria.diverse.iot2.iot2.iot2.ParameterDef;
import fr.inria.diverse.iot2.iot2.iot2.ParameterMode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import fr.inria.diverse.iot2.iot2.aspects.ActivityExpressionAspect;
import fr.inria.diverse.iot2.iot2.aspects.ActivityNodeAspect;
import fr.inria.diverse.iot2.iot2.aspects.Context;
import fr.inria.diverse.iot2.iot2.aspects.Token;
import fr.inria.diverse.iot2.iot2.aspects.Environment;

@Aspect(className = OpaqueAction.class)
@SuppressWarnings("all")
public class OpaqueActionAspect extends ActivityNodeAspect {
  public static void execute(final OpaqueAction _self, final Context c) {
    fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectProperties _self_ = fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectContext.getSelf(_self);
    _privk3_execute(_self_, _self,c);
  }
  
  public static Object getValue(final OpaqueAction _self, final Value v) {
    fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectProperties _self_ = fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_getValue(_self_, _self,v);
    return (java.lang.Object)result;
  }
  
  public static OperationDef service(final OpaqueAction _self) {
    fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectProperties _self_ = fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_service(_self_, _self);
    return (fr.inria.diverse.iot2.iot2.iot2.OperationDef)result;
  }
  
  public static void service(final OpaqueAction _self, final OperationDef service) {
    fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectProperties _self_ = fr.inria.diverse.iot2.iot2.aspects.OpaqueActionAspectOpaqueActionAspectContext.getSelf(_self);
    _privk3_service(_self_, _self,service);
  }
  
  protected static void _privk3_execute(final OpaqueActionAspectOpaqueActionAspectProperties _self_, final OpaqueAction _self, final Context c) {
    c.output.executedNodes.add(_self);
    final Iot2Factory fact = Iot2Factory.eINSTANCE;
    OperationDef _service = OpaqueActionAspect.service(_self);
    boolean _tripleNotEquals = (_service != null);
    if (_tripleNotEquals) {
      Environment _environment = new Environment();
      final Procedure1<Environment> _function = (Environment it) -> {
        OperationDef _service_1 = OpaqueActionAspect.service(_self);
        EList<ParameterDef> _parameters = _service_1.getParameters();
        final Function1<ParameterDef, Boolean> _function_1 = (ParameterDef it_1) -> {
          ParameterMode _direction = it_1.getDirection();
          return Boolean.valueOf(Collections.<ParameterMode>unmodifiableList(CollectionLiterals.<ParameterMode>newArrayList(ParameterMode.PARAM_IN, ParameterMode.PARAM_INOUT)).contains(_direction));
        };
        Iterable<ParameterDef> _filter = IterableExtensions.<ParameterDef>filter(_parameters, _function_1);
        final Consumer<ParameterDef> _function_2 = (ParameterDef p) -> {
          Activity _activity = _self.getActivity();
          EList<Variable> _locals = _activity.getLocals();
          final Function1<Variable, Boolean> _function_3 = (Variable it_1) -> {
            String _name = it_1.getName();
            String _identifier = p.getIdentifier();
            return Boolean.valueOf(Objects.equal(_name, _identifier));
          };
          final Variable find = IterableExtensions.<Variable>findFirst(_locals, _function_3);
          String _identifier = p.getIdentifier();
          Object _elvis = null;
          Value _currentValue = null;
          if (find!=null) {
            _currentValue=find.getCurrentValue();
          }
          Object _value = OpaqueActionAspect.getValue(_self, _currentValue);
          if (_value != null) {
            _elvis = _value;
          } else {
            _elvis = null;
          }
          it.putVariable(_identifier, _elvis);
        };
        _filter.forEach(_function_2);
      };
      final Environment wrappedEnv = ObjectExtensions.<Environment>operator_doubleArrow(_environment, _function);
      OperationDef _service_1 = OpaqueActionAspect.service(_self);
      OperationDefAspect.execute(_service_1, wrappedEnv);
      OperationDef _service_2 = OpaqueActionAspect.service(_self);
      EList<ParameterDef> _parameters = _service_2.getParameters();
      final Function1<ParameterDef, Boolean> _function_1 = (ParameterDef it) -> {
        ParameterMode _direction = it.getDirection();
        return Boolean.valueOf(Collections.<ParameterMode>unmodifiableList(CollectionLiterals.<ParameterMode>newArrayList(ParameterMode.PARAM_OUT, ParameterMode.PARAM_INOUT)).contains(_direction));
      };
      Iterable<ParameterDef> _filter = IterableExtensions.<ParameterDef>filter(_parameters, _function_1);
      final Consumer<ParameterDef> _function_2 = (ParameterDef p) -> {
        Activity _activity = _self.getActivity();
        EList<Variable> _locals = _activity.getLocals();
        final Function1<Variable, Boolean> _function_3 = (Variable it) -> {
          String _name = it.getName();
          String _identifier = p.getIdentifier();
          return Boolean.valueOf(Objects.equal(_name, _identifier));
        };
        final Variable updated = IterableExtensions.<Variable>findFirst(_locals, _function_3);
        String _identifier = p.getIdentifier();
        Object _variable = wrappedEnv.getVariable(_identifier);
        String _string = _variable.toString();
        double _parseDouble = Double.parseDouble(_string);
        final Integer retInteger = new Integer(((int) _parseDouble));
        if ((updated != null)) {
          IntegerValue _createIntegerValue = fact.createIntegerValue();
          final Procedure1<IntegerValue> _function_4 = (IntegerValue it) -> {
            it.setValue((retInteger).intValue());
          };
          IntegerValue _doubleArrow = ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function_4);
          updated.setCurrentValue(_doubleArrow);
        } else {
          Activity _activity_1 = _self.getActivity();
          EList<Variable> _locals_1 = _activity_1.getLocals();
          IntegerVariable _createIntegerVariable = fact.createIntegerVariable();
          final Procedure1<IntegerVariable> _function_5 = (IntegerVariable it) -> {
            String _identifier_1 = p.getIdentifier();
            it.setName(_identifier_1);
            IntegerValue _createIntegerValue_1 = fact.createIntegerValue();
            final Procedure1<IntegerValue> _function_6 = (IntegerValue it_1) -> {
              it_1.setValue((retInteger).intValue());
            };
            IntegerValue _doubleArrow_1 = ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue_1, _function_6);
            it.setCurrentValue(_doubleArrow_1);
          };
          IntegerVariable _doubleArrow_1 = ObjectExtensions.<IntegerVariable>operator_doubleArrow(_createIntegerVariable, _function_5);
          _locals_1.add(_doubleArrow_1);
        }
      };
      _filter.forEach(_function_2);
    }
    EList<Expression> _expressions = _self.getExpressions();
    final Consumer<Expression> _function_3 = (Expression e) -> {
      ActivityExpressionAspect.execute(e, c);
    };
    _expressions.forEach(_function_3);
    List<Token> _takeOfferdTokens = ActivityNodeAspect.takeOfferdTokens(_self);
    ActivityNodeAspect.sendOffers(_self, _takeOfferdTokens);
  }
  
  protected static Object _privk3_getValue(final OpaqueActionAspectOpaqueActionAspectProperties _self_, final OpaqueAction _self, final Value v) {
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (v instanceof IntegerValue) {
        _matched=true;
        int _value = ((IntegerValue)v).getValue();
        _switchResult = Double.valueOf(((double) _value));
      }
    }
    if (!_matched) {
      if (v instanceof BooleanValue) {
        _matched=true;
        _switchResult = Boolean.valueOf(((BooleanValue)v).isValue());
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return ((Comparable<?>)_switchResult);
  }
  
  protected static OperationDef _privk3_service(final OpaqueActionAspectOpaqueActionAspectProperties _self_, final OpaqueAction _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getService") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (fr.inria.diverse.iot2.iot2.iot2.OperationDef) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.service;
  }
  
  protected static void _privk3_service(final OpaqueActionAspectOpaqueActionAspectProperties _self_, final OpaqueAction _self, final OperationDef service) {
    _self_.service = service; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setService")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, service);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
