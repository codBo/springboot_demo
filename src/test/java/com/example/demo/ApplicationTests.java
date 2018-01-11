package com.example.demo;

import com.example.demo.dto.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class ApplicationTests {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//	@Autowired
//	private RedisTemplate<String, User> redisTemplate;
    @Autowired
	private RedisTemplate<String, Integer> redisTemplate;
//	@Test
//	public void test() throws Exception {
//		// 保存字符串
//		stringRedisTemplate.opsForValue().set("aaa", "111");
//		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
//    }
    @Test
    public void test() throws Exception {
        // 保存字符串
        Long num = redisTemplate.opsForValue().increment("sdf", 1);
        System.out.print(num);
    }
//	@Test
//	public void testRedisObject() throws Exception {
//		// 保存对象
//		User user = new User("123123", 20);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//		user = new User("蝙蝠侠", 30);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//		user = new User("蜘蛛侠", 40);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
////		User user1 = redisTemplate.opsForValue().get("超人"); //		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue()); //		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
//	}
}