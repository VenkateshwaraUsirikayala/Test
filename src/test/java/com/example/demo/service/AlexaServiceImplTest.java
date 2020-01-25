package com.example.demo.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.dao.Alexadao;
import com.example.demo.model.User;

@RunWith(value = MockitoJUnitRunner.class)
class AlexaServiceImplTest {

	@InjectMocks
	private AlexaServiceImpl alexaService = new AlexaServiceImpl();

	@Mock
	private User user = new User();

	@Mock
	private Alexadao alexaDao;

	@Test
	public void testSaveUser() {
		System.out.println(alexaService);
		when(alexaService.saveUser(user)).thenReturn(new User());
	}
}
