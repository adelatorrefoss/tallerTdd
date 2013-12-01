package rj;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {
	
	private String name;
	private List<Usuario> followings;

	public List<Usuario> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Usuario> following) {
		this.followings = following;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
