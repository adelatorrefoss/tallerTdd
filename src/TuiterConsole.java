import rj.RegisterService;
import rj.Usuario;


public class TuiterConsole {
	
	public static void main(String[] args) {
		RegisterService rs = new RegisterService(true);

		String command = args[0];
		System.out.println(command);
		
		if (command.equals("register")) {
			String userName = args[1];
			try {
				Usuario user = rs.register(userName);
				System.out.println("Usuario creado: "+user.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
