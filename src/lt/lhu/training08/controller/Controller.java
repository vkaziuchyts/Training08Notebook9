package lt.lhu.training08.controller;

public class Controller {
	private static final Controller instance = new Controller();

	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) {

		String[] params = request.split("\\s(?=(([^\']*\'){2})*[^\']*$)\\s*");
		String commandName = params[0];

		Command command = provider.getCommand(commandName);
		String response = command.execute(request);

		return response;
	}

	public static Controller getInstance() {
		return instance;
	}

}
