package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ProcedureExecutor {
	
	private final String procName;
	private final List<ProcedureArgs> args =  new ArrayList<>();


	public ProcedureExecutor(final String procName) {
		super();
		this.procName = procName;
	}
	
	public void runProcedure(Connection connection) {
		try (final CallableStatement callableStatement = prepareCallableStatement(connection)){
		if(callableStatement != null) {
			 String output =  null;
			callableStatement.execute();
		    output =	callableStatement.getString(2);
		    System.out.println(output);
			System.out.println("procedure executed successfully");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private CallableStatement prepareCallableStatement(Connection connection) {
		CallableStatement callable = null;
		try {

			final StringBuilder request = new StringBuilder();
			request.append("{call ");
			request.append(procName);

			// if procedure has input or out params
			if (args.size() > 0) {
				request.append("(");
				request.append(StringUtils.repeat("?", ",", args.size()));
				request.append(")");
			}
			request.append("}");

			callable = connection.prepareCall(request.toString());

			// adding parameters
			int i = 1;
			for (final ProcedureArgs procArgs : args) {

				if (procArgs.isOutParameter()) {
					callable.registerOutParameter(i, procArgs.getType());
				} else {
					switch (procArgs.getType()) {
					case java.sql.Types.INTEGER: {
						callable.setInt(i, procArgs.getValueInt());
						break;
					}
					case java.sql.Types.VARCHAR: {
						callable.setString(i, procArgs.getValueString());
						break;
					}
					default:
					}

				}
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return callable;
	}

	public void addArgument(int type, int value) {
		ProcedureArgs arg = new ProcedureArgs();
		arg.setType(type);
		arg.setValueInt(value);
		args.add(arg);
	}
	public void addArgument(int type, String value) {
		ProcedureArgs arg = new ProcedureArgs();
		arg.setType(type);
		arg.setValueString(value);
		args.add(arg);
	}

	public void addArgument(int type, String value, boolean out) {
		ProcedureArgs arg = new ProcedureArgs();
		arg.setType(type);
		arg.setValueString(value);
		arg.setOutParameter(out);
		args.add(arg);
		
	}
}
