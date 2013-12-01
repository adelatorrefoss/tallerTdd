package rj;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class RegistryTest {
	
	RegisterService registerService = new RegisterService();
	
	@Test
	public void registerOKTest() throws Exception {
		String userTest = "test";
		Usuario result = registerService.register(userTest);
		
		Assert.assertNotNull(result);
	}
	
	@Test(expected=Exception.class)
	public void registerExistsUserFail() throws Exception {
		// setup
		String userTest = "test";
		registerService.register(userTest);
		
		// when
		registerService.register(userTest);
		
		
	}
	
	@Test
	public void followUserAB() throws Exception{
		String src = "pepito";
		String dest = "juanito";
		
		registerService.register(src);
		registerService.register(dest);
		
		Boolean result = registerService.follow(src, dest);
		
		Assert.assertTrue(result);
	}

//	@Test
//	public void isfollowUserAB(){
//		String src = "pepito";
//		String dest = "juanito";
//		registerService.follow(src, dest);
//
//		Boolean result = registerService.isFollowing(src, dest);
//		Assert.assertTrue(result);
//	}
//
//	@Test
//	public void isNotfollowUserAB(){
//		String src = "pepito";
//		String dest = "juanito";
//		
//		Boolean result = registerService.isFollowing(src, dest);
//		Assert.assertFalse(result);
//	}

	@Test
	public void listUserFollowings() throws Exception{
		String src = "pepito";
		registerService.register(src);
		
		Usuario juanito = registerService.register("juanito");
		registerService.follow(src, juanito.getName());
		
		Usuario juanita = registerService.register("juanita");
		registerService.follow(src, juanita.getName());
		
		List<Usuario> expected = new ArrayList<Usuario>();
		expected.add(juanito);
		expected.add(juanita);
		List<Usuario> followings = registerService.followings(src); 
		Assert.assertEquals(expected, followings);
	}
}
