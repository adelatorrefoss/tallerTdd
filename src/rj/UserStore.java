package rj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class UserStore {
	

	//private List<String> registeredUsers = new ArrayList<String>();
	
	private Map<String, Usuario> userStore = new HashMap<String, Usuario>();

	
	public Usuario saveUser(Usuario user) throws IOException {

		userStore.put(user.getName(),user);
		
		commit();
		
		return user;
	}
	
	public Usuario findByUsername(String username) {
		return userStore.get(username);
	}
	
	private void commit() throws IOException {
		FileOutputStream fout = new FileOutputStream("userStore.data");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(userStore);
		
		oos.close();
	}
	
	public void load() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("userStore.data");
		ObjectInputStream ois = new ObjectInputStream(fin);
		userStore = (Map<String,Usuario>) ois.readObject(); 
		
		ois.close();
	}

	
}
