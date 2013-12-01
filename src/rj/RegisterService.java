package rj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterService {
	UserStore userStore = new UserStore();
	
	public RegisterService() {}
	
	public RegisterService(Boolean persistent) {
		if (persistent) {
		try {
			userStore.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public Usuario register(String username) throws Exception {
		if ( userStore.findByUsername(username) != null) {
			throw new Exception("El usuario existe");
		}
		
		Usuario user = new Usuario();
		user.setName(username);
		
		return userStore.saveUser(user);
	}

	public Boolean follow(String src, String dest) {
		
		Usuario userSrc = userStore.findByUsername(src);
		Usuario userDest = userStore.findByUsername(dest);
			
		List<Usuario> followings = userSrc.getFollowings();
		
		if(followings == null){
			followings = new ArrayList<Usuario>();
		}
		
		followings.add(userDest);
		
		userSrc.setFollowings(followings);
		
		try {
			userStore.saveUser(userSrc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	//public Boolean isFollowing(String src, String dest) {
	//	return true;
	//}

	public List<Usuario> followings(String src) {
		
		Usuario userSrc = userStore.findByUsername(src);
		return userSrc.getFollowings();
	}

}
