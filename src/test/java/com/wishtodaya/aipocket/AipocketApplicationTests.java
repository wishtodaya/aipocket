package com.wishtodaya.aipocket;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wishtodaya.aipocket.model.Plugin;
import com.wishtodaya.aipocket.service.PluginServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AipocketApplicationTests {
	@Autowired
	private PluginServiceImpl pluginService;

	@Test
	void contextLoads() {
		QueryWrapper<Plugin> pluginQueryWrapper = new QueryWrapper<>();
	}

}
