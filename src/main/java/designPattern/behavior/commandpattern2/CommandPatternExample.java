package designPattern.behavior.commandpattern2;

/**
 * @author zhailz
 *
 * @version 2018年9月29日 下午5:32:48
 */

interface Command{
	public void execute();
}
class Receive{
	public void action(){
		System.out.println("Receive action excute. ");
	}
}
class CommandImplement implements Command{
	Receive receive;
	public CommandImplement(Receive receive){
		this.receive = receive;
	}
	@Override
	public void execute() {
		this.receive.action();
	}
}
class Invoker {
	private Command command;
	
	public Invoker() {
	}

	public void action(){
		getCommand().execute();
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
}
public class CommandPatternExample {
	public static void main(String[] args) {
		Receive receive = new Receive();
		Command command = new CommandImplement(receive);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
	}
}
