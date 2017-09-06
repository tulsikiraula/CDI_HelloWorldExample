package callableStatement;

import java.sql.Array;

public class ProcedureArgs {
	
	private String valueString = null;
	private int valueInt = 0;
	private boolean outParameter = false;
	private Array valueArray = null;             
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getValueString() {
		return valueString;
	}
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}
	public int getValueInt() {
		return valueInt;
	}
	public void setValueInt(int valueInt) {
		this.valueInt = valueInt;
	}
	public boolean isOutParameter() {
		return outParameter;
	}
	public void setOutParameter(boolean outParameter) {
		this.outParameter = outParameter;
	}
	public Array getValueArray() {
		return valueArray;
	}
	public void setValueArray(Array valueArray) {
		this.valueArray = valueArray;
	}

}
